--Id are starting from 1001 so that when we insert/save new course record, hibernate will use its on @Generated annotation to generate new id, if that is same to record we have created here
--we will get DataIntegrityConstant Violation.

insert into Course(id,Name)
values(1001,'Maths');

insert into Course(id,Name)
values(1002,'Science');
insert into Course(id,Name)
values(1003,'Commerce');
insert into Course(id,Name)
values(1004,'IP');
insert into Course(id,Name)
values(1005,'History');

--Inserting values in Student Table.

insert into Student(id,Name)
values(1001,'Atishay');
insert into Student(id,Name)
values(1002,'Joshua');
insert into Student(id,Name)
values(1003,'Barbie');
insert into Student(id,Name)
values(1004,'Ajinkya');
insert into Student(id,Name)
values(1005,'Amit');