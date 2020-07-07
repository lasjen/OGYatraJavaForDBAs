create or replace package body LIBRARIAN as

-------------------------------------------------------------------------------
-- Procedure: INSERT_BOOKS
-------------------------------------------------------------------------------
procedure insert_books(books_i in books_ct) is
begin
  merge into books b
    using ( select a.id atr_id, b.*
            from   authors a right join table( books_i) b on (a.name = b.author)
          ) newbook         
    on ( b.isbn = newbook.isbn or
         (b.title = newbook.title and b.fk_auts_id = newbook.atr_id)
       )
  when matched
    then update set b.year_of_publication = newbook.year_of_publication
  when not matched
    then insert ( b.id, b.title, b.isbn, b.year_of_publication, b.fk_auts_id)
       values ( books_seq.nextval
              , newbook.title, newbook.isbn, newbook.year_of_publication, newbook.atr_id
              );
              
end insert_books;

-------------------------------------------------------------------------------
-- Procedure: GET_BOOKS_BY_AUTHOR
-------------------------------------------------------------------------------  
function get_books_by_author(author_i in varchar2) return books_ct is
  l_books books_ct;
begin
  select cast ( collect( book_ot( b.title, a.name, b.isbn, b.year_of_publication)) as books_ct)
     into   l_books
  from   books b left outer join authors a on (b.fk_auts_id = a.id)
  where  lower(a.name) like lower(author_i)||'%';
  
  return l_books;         
end get_books_by_author;

end librarian;
/