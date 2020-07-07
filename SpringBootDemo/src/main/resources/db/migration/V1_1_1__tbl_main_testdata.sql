insert into dept (deptno, dname, loc) values (10, 'MANAGEMENT', 'CALIFORNIA');
insert into dept (deptno, dname, loc) values (20, 'IT', 'CALIFORNIA');
insert into dept (deptno, dname, loc) values (30, 'SALES', 'TEXAS');

insert into emp (ename, job, mgr, hiredate, sal, comm, deptno) values ('LARRY', 'CEO',   null, sysdate-4000, 10000, null, 10);
insert into emp (ename, job, mgr, hiredate, sal, comm, deptno) values ('KING',  'Sales', 1000, sysdate-3000,  5000, null, 30);
insert into emp (ename, job, mgr, hiredate, sal, comm, deptno) values ('LINDA', 'Dev',   1000, sysdate-2000,  6000, null, 30);
commit;