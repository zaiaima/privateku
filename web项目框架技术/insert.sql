use emp;
select * from emp;
insert into emp
	select empno+10,ename,job,mgr,hiredate,sal,comm,deptno from emp;