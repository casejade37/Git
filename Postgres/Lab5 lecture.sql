CREATE TABLE Rentable (
rentable_name VARCHAR(32) NOT NULL,
description VARCHAR(255) NOT NULL,
standard_hours DECIMAL(3,1) NOT NULL);

CREATE TABLE Rental_plan (
plan_name VARCHAR(32) NOT NULL,
description VARCHAR(255) NOT NULL,
additional_hours DECIMAL(3,1) NOT NULL);

INSERT INTO Rentable(rentable_name, description, standard_hours)
VALUES('Bicycle', 'Rent a mountain bike for a fun adventure.', 8);
INSERT INTO Rentable(rentable_name, description, standard_hours)
VALUES('Canoe', 'Explore the lake with a canoe.', 4);
INSERT INTO Rentable(rentable_name, description, standard_hours)
VALUES('Roller Blades', 'Speed through the park with these.', 2);
INSERT INTO Rentable(rentable_name, description, standard_hours)
VALUES('Hoverboard', 'Relax while viewing beautiful scenery.', 3);

INSERT INTO Rental_plan(plan_name, description, additional_hours)
VALUES('Budget', 'This no cost plan is for those on a budget.', 0);
INSERT INTO Rental_plan(plan_name, description, additional_hours)
VALUES('Bronze', 'This plan gives you some extra time.', 1);
INSERT INTO Rental_plan(plan_name, description, additional_hours)
VALUES('Silver', 'This plan gives you more time.', 2);
INSERT INTO Rental_plan(plan_name, description, additional_hours)
VALUES('Gold', 'This plan gives you priority with a lot of extra time.', 5);

CREATE TABLE Rental_history (
rentable_name VARCHAR(32) NOT NULL,
rented_date DATE NOT NULL);

INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Bicycle', '04-AUG-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Bicycle', '03-MAY-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Bicycle', '13-JAN-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Bicycle', '27-FEB-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Canoe', '10-SEP-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Canoe', '23-MAY-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Canoe', '07-JAN-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Canoe', '23-FEB-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Roller Blades', '04-SEP-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Roller Blades', '29-MAY-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Hoverboard', '10-AUG-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Hoverboard', '20-MAY-2021');
INSERT INTO Rental_history (rentable_name, rented_date)
VALUES('Hoverboard', '30-JAN-2021');

SELECT rentable_name, 
       plan_name,
	standard_hours + additional_hours as rental_hours
FROM   Rentable
CROSS JOIN Rental_plan
ORDER BY rentable_name, plan_name;

SELECT rentable_name, 
	standard_hours + 
	(SELECT additional_hours
	 FROM   Rental_plan
	 WHERE  plan_name = 'Gold') AS rentable_hours
FROM   Rentable
ORDER BY rentable_name;

SELECT rentable_name, 
	   standard_hours + 
	   (SELECT additional_hours
	    FROM   Rental_plan
		WHERE  plan_name = 'Silver') AS rentable_hours
FROM   Rentable
WHERE  standard_hours +
       (SELECT additional_hours
        FROM   Rental_plan
	 WHERE  plan_name = 'Silver') >= 6
ORDER BY rentable_name;

SELECT rentable_name, description
FROM   Rentable
WHERE  Rentable.rentable_name IN
       (SELECT rentable_name
	  FROM   Rental_history
	  GROUP BY rentable_name
	  HAVING COUNT(*) >= 4);

SELECT rentable_name,
       description,
	standard_hours +
	(SELECT additional_hours
	 FROM   Rental_plan
	 WHERE  plan_name = 'Bronze') AS rentable_hours
FROM   Rentable
WHERE  Rentable.rentable_name IN
       (SELECT rentable_name
	  FROM   Rental_history
	  GROUP BY rentable_name
	  HAVING COUNT(*) >= 4);

SELECT Rentable.rentable_name,
       description,
	standard_hours +
	(SELECT additional_hours
	 FROM   Rental_plan
	 WHERE  plan_name = 'Bronze') AS rentable_hours
FROM   Rentable 
JOIN   (SELECT rentable_name
	 FROM   Rental_history
	 GROUP BY rentable_name
	 HAVING COUNT(*) >= 4) popular_rentable 
	 ON popular_rentable.rentable_name = Rentable.rentable_name;

SELECT rentable_name,
       description,
	 standard_hours +
	 (SELECT additional_hours
	  FROM   Rental_plan
	  WHERE  plan_name = 'Bronze') AS rentable_hours
FROM   Rentable
WHERE  EXISTS
       (SELECT 1
	  FROM   Rental_history
	  WHERE  Rental_history.rentable_name = Rentable.rentable_name
	  GROUP BY rentable_name
	  HAVING COUNT(*) >= 4);

CREATE OR REPLACE VIEW Popular_rentable AS 
SELECT rentable_name
FROM   Rental_history
GROUP BY rentable_name
HAVING COUNT(*) >= 4;

SELECT Rentable.rentable_name,
       description,
	standard_hours +
	(SELECT additional_hours
	 FROM   Rental_plan
	 WHERE  plan_name = 'Bronze') AS rentable_hours
FROM   Rentable
JOIN   Popular_rentable 
       ON Popular_rentable.rentable_name = Rentable.rentable_name;
