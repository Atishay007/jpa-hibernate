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

--Inserting values in Passport Table.
insert into Passport(id,Number)
values(4001,'B120478DF');
insert into Passport(id,Number)
values(4002,'B12047DFGT');
insert into Passport(id,Number)
values(4003,'B120478QA');
insert into Passport(id,Number)
values(4004,'OOP20478DF');
insert into Passport(id,Number)
values(4005,'YTHSM5879');

--Inserting values in Student Table.
insert into Student(id,Name,passport_id)
values(2001,'Atishay',4001);
insert into Student(id,Name,passport_id)
values(2002,'Joshua',4002);
insert into Student(id,Name,passport_id)
values(2003,'Ghanshyam',4003);
insert into Student(id,Name,passport_id)
values(2004,'Ajinkya',4004);
insert into Student(id,Name,passport_id)
values(2005,'Amit',4005);

--Inserting values in Review Table.
insert into Review(id,Rating,Description,course_id)
values(8001,'4','Good',1001);
insert into Review(id,Rating,Description,course_id)
values(8002,'5','Awesome',1002);
insert into Review(id,Rating,Description,course_id)
values(8003,'1','Poor',1003);
insert into Review(id,Rating,Description,course_id)
values(8004,'3.8','Good',1002);
insert into Review(id,Rating,Description,course_id)
values(8005,'4.6','Awesome',1002);


