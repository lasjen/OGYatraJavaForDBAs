-------------------------------------------------------------------------------
-- Table: DEPT
-------------------------------------------------------------------------------
create table dept(  
  deptno     number(2,0),  
  dname      varchar2(14)  constraint dept_dname_nn not null,  
  loc        varchar2(13)
);

alter table dept add (
   constraint dept_pk primary key (deptno)
);

-------------------------------------------------------------------------------
-- Table: EMP
-------------------------------------------------------------------------------
create sequence emp_seq start with 1000 increment by 1 cache 100;

create table emp (
  empno    number(4,0)     DEFAULT emp_seq.nextval,
  ename    varchar2(10)    CONSTRAINT emp_ename_nn NOT NULL,
  job      varchar2(9)     CONSTRAINT emp_job_nn NOT NULL,
  mgr      number(4,0),
  hiredate date,
  sal      number(10,2),
  comm     number(7,2),
  deptno   number(2,0)
);

alter table emp add (
   constraint emp_pk primary key (empno),
   constraint emp_dept_fk foreign key (deptno) references dept (deptno)  
);

