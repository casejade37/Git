CREATE DATABASE js_db

CREATE TABLE Person(
person_id DECIMAL(12),
first_name VARCHAR(32),
last_name VARCHAR(32)
);

insert into Person(person_id, first_name, last_name)
values(1, 'John', 'Smith');

select * from Person;

update Person
set last_name='Glass';

delete from Person;

drop table Person;

create table Person
(person_id DECIMAL(12) NOT NULL PRIMARY KEY,
first_name VARCHAR(256) NOT NULL,
last_name VARCHAR(256) NOT NULL);

create table my_dates
(my_id DECIMAL(12) PRIMARY KEY,
my_date DATE NOT NULL);

INSERT INTO my_dates(my_id, my_date)
VALUES(1, '2022-7-6')

-- select * from my_dates

SELECT first_name, last_name
FROM Person
WHERE person_id = 3;

UPDATE Person
SET last_name = 'Glass'
WHERE person_id = 1;

DELETE FROM Person
WHERE person_id = 2;