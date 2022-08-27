CREATE TABLE Apartments(
AparmentNum DECIMAL PRIMARY KEY, 
ApartmentName VARCHAR(64) NOT NULL,
Description VARCHAR(64) NULL,
CleanedDate DATE NOT NULL,
AvailableDate DATE NOT NULL
);

INSERT INTO Apartments (AparmentNum, ApartmentName, Description, CleanedDate, AvailableDate)
VALUES (498, 'Deer Creek Crossing', 'Great view of Riverwalk', CAST('19-APR-2022' AS DATE), CAST('25-APR-2022' AS DATE));

INSERT INTO Apartments (AparmentNum, ApartmentName, Description, CleanedDate, AvailableDate)
VALUES (128, 'Town Place Apartments', 'Convenient walk to Parking', CAST('20-MAY-2022' AS DATE), CAST('25-MAY-2022' AS DATE));

INSERT INTO Apartments (AparmentNum, ApartmentName, Description, CleanedDate, AvailableDate)
VALUES (316, 'Paradise Palms', NULL, CAST('19-APR-2022' AS DATE), CAST('25-APR-2022' AS DATE));

SELECT * FROM Apartments;

INSERT INTO Apartments (AparmentNum, ApartmentName, Description, CleanedDate, AvailableDate)
VALUES (252, NULL, 'Close to Downtown shops', CAST('17-JUL-2020' AS DATE), CAST('13-JUL-2020' AS DATE));

INSERT INTO Apartments (AparmentNum, ApartmentName, Description, CleanedDate, AvailableDate)
VALUES (252, 'The Glenn', 'Close to Downtown shops', CAST('17-JUL-2020' AS DATE), CAST('13-JUL-2020' AS DATE));

SELECT ApartmentName, Description
FROM Apartments
WHERE ApartmentName = 'Deer Creek Crossing';

UPDATE Apartments
SET description = 'A mile walk to the beach'
WHERE ApartmentName = 'Paradise Palms';

SELECT *
FROM Apartments;

UPDATE Apartments
SET description = NULL
WHERE ApartmentName = 'Town Place Apartments';

SELECT *
FROM Apartments;

DELETE FROM Apartments
WHERE CleanedDate > '2022-04-01';

SELECT *
FROM Apartments;