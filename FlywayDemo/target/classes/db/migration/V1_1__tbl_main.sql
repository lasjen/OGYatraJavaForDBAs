-------------------------------------------------------------------------------
-- Table: AUTHORS (AUTS)
-------------------------------------------------------------------------------
create table authors ( 
  id     		number(10), 
  name 			varchar2(100 char)
);

alter table authors add (
   constraint auts_pk primary key (id)
);

-------------------------------------------------------------------------------
-- Table: BOOKS (BOOK)
-------------------------------------------------------------------------------
create sequence books_seq start with 1 increment by 1 cache 20;
create table books ( 
  id       				number(10)			default books_seq.nextval, -- PK
  title  				varchar2(200 char)	constraint book_title_nn not null,
  isbn 					varchar2(20 char)	constraint book_isbn_nn not null,
  year_of_publication 	number(4)			constraint book_yearofpubl_nn not null,
  fk_auts_id 			number(10)
);

alter table books add (
  constraint book_pk 		primary key (id),
  constraint book_auth_fk 	foreign key (fk_auts_id) references authors (id)
);