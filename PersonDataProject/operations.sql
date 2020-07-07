CREATE TABLE PERSON(NAME VARCHAR(255) PRIMARY KEY,
	SEX VARCHAR(1),
	AGE INT,
	HEIGHT INT,
	WEIGHT INT
);

INSERT INTO PERSON VALUES('Quentin', 'M', 30, 70, 175);
INSERT INTO PERSON VALUES('Thomas', 'M', 34, 75, 165);
INSERT INTO PERSON VALUES('Alex', 'M', 41, 74, 170);
INSERT INTO PERSON VALUES('Bert', 'M', 42, 68, 166);
INSERT INTO PERSON VALUES('Carl', 'M', 32, 70, 155);
INSERT INTO PERSON VALUES('Dave', 'M', 39, 72, 167);
INSERT INTO PERSON VALUES('Elly', 'F', 30, 66, 124);
SELECT * FROM PERSON ORDER BY WEIGHT DESC;
SELECT * FROM PERSON WHERE NAME LIKE 'Q%'

select * from person;

select age as ages, count(*) as count from person group by age;