CREATE TABLE first_letters(
first_letter_id DECIMAL(1) NOT NULL PRIMARY KEY,
first_letter CHAR(1) NOT NULL);

CREATE TABLE Words(
word VARCHAR(32) NOT NULL,
first_letter_id DECIMAL(1),
CONSTRAINT first_letter_fk
FOREIGN KEY (first_letter_id)
REFERENCES first_letters(first_letter_id));

INSERT INTO first_letters(first_letter_id, first_letter)
VALUES(1, 'A');
INSERT INTO first_letters(first_letter_id, first_letter)
VALUES(2, 'B');
INSERT INTO first_letters(first_letter_id, first_letter)
VALUES(3, 'C');
INSERT INTO first_letters(first_letter_id, first_letter)
VALUES(4, 'D');
INSERT INTO first_letters(first_letter_id, first_letter)
VALUES(5, 'E');

INSERT INTO Words(word, first_letter_id)
VALUES('Apple', 1);
INSERT INTO Words(word, first_letter_id)
VALUES('Cherry', 3);
INSERT INTO Words(word, first_letter_id)
VALUES('Elderberry', 5);
INSERT INTO Words(word, first_letter_id)
VALUES('Kiwi', null);

INSERT INTO Words(word, first_letter_id)
VALUES('Grapefruit', 7);

SELECT *
FROM   first_letters
JOIN   words ON words.first_letter_id = first_letters.first_letter_id;

SELECT *
FROM   first_letters
LEFT JOIN   words ON words.first_letter_id = first_letters.first_letter_id;

SELECT *
FROM   first_letters
RIGHT JOIN   words ON words.first_letter_id = first_letters.first_letter_id;

SELECT *
FROM   first_letters
FULL JOIN   words ON words.first_letter_id = first_letters.first_letter_id;

SELECT to_char(100, '$999.99');

SELECT 'The discounted price is ' || to_char(350-50, '$999.99');

SELECT CAST (1 AS VARCHAR(1))
        || ' at a time';
        
SELECT 93.00

CREATE TABLE Technologist (
technologist_id DECIMAL(12) PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL
);

CREATE TABLE MRI_machine (
machine_nr DECIMAL(12) NOT NULL,
description VARCHAR(255) NOT NULL,
date_serviced DATE NOT NULL,
technologist_id DECIMAL(12)
);

ALTER TABLE MRI_machine
ADD CONSTRAINT mri_machine_pk
PRIMARY KEY(machine_nr);

ALTER TABLE MRI_machine
ADD CONSTRAINT machine_technologist_fk
FOREIGN KEY(technologist_id)
REFERENCES Technologist(technologist_id);

INSERT INTO Technologist (technologist_id, first_name, last_name)
VALUES (31, 'Aadi', 'Mahawar');
INSERT INTO Technologist (technologist_id, first_name, last_name)
VALUES (32, 'Sandra', 'Clark');

INSERT INTO MRI_machine (machine_nr, description, date_serviced, technologist_id)
VALUES (101, 'Excellent for patient comfort', CAST('03-Jul-2012' AS DATE), 31);
INSERT INTO MRI_machine (machine_nr, description, date_serviced, technologist_id)
VALUES(102, 'Uses parallel imaging techniques', CAST('09-Jul-2012' AS DATE), 31);
INSERT INTO MRI_machine (machine_nr, description, date_serviced, technologist_id)
VALUES(103, 'High signal-to-noise ratio', CAST('13-Jul-2012' AS DATE), NULL);

SELECT first_name, last_name, description, date_serviced
FROM   technologist
JOIN   MRI_machine ON technologist.technologist_id = mri_machine.technologist_id
AND    last_name = 'Mahawar'
AND    date_serviced >= CAST('05-JUL-2012' AS DATE)
AND    date_serviced <= CAST('15-JUL-2012' AS DATE);

CREATE TABLE Subtraction (
x DECIMAL(4) NOT NULL,
y DECIMAL(4) NOT NULL,
subtraction DECIMAL(12)GENERATED ALWAYS AS (x-y) STORED);

-- automatcally calculate the generated column
INSERT INTO Subtraction(x, y)
VALUES(10, 5);

SELECT *
FROM Subtraction;

-- BOOLEAN exists in postgres