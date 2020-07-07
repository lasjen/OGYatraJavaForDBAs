create or replace package librarian as
  procedure insert_books(books_i in books_ct);
  
  function get_books_by_author (author_i in varchar2) return books_ct;

end librarian;
/