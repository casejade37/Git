CREATE TABLE Cars(
CarBrand VARCHAR(64), 
CarModel VARCHAR(50),
AcquiredDate DATE,
Price DECIMAL(10, 2)
);

INSERT INTO Cars (CarBrand, CarModel, AcquiredDate, Price)
VALUES ('Ford', 'Econoline Full-Size Van', CAST('15-AUG-2021' AS DATE), 29995.00);

SELECT * 
FROM Cars;

UPDATE Cars
SET Price = 28000;

SELECT * 
FROM Cars;

DELETE FROM Cars;

SELECT * 
FROM Cars;

DROP TABLE Cars;

SELECT * 
FROM Cars;