create or replace type BOOK_OT as object( 
  title               varchar2(200 char),
  author              varchar2(100 char),
  isbn                varchar2(20 char),
  year_of_publication number(4)
)
/

create type BOOKS_CT is table of BOOK_OT
/