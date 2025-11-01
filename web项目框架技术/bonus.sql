select * from emp;
select * from emp.bonus;
select * from bonus;
insert into bonus
        select ename,job,sal,comm from emp;