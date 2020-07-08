create user appdata identified by app;
alter user appdata default tablespace users;
alter user appdata quota unlimited on users;
grant create session, alter session, create table, create view, create sequence, create procedure, create type, create trigger, create synonym to appdata;
