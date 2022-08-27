CREATE TABLE Location (
location_id DECIMAL(12) NOT NULL PRIMARY KEY,
location_name VARCHAR(64) NOT NULL);

CREATE TABLE Dig_site (
dig_site_id DECIMAL(12) NOT NULL PRIMARY KEY,
location_id DECIMAL(12) NOT NULL,
dig_name VARCHAR(32) NOT NULL, 
dig_cost DECIMAL(8,2) NULL,
FOREIGN KEY (location_id) REFERENCES Location(location_id));

CREATE TABLE Paleontologist (
Paleontologist_id DECIMAL(12) NOT NULL PRIMARY KEY,
first_name VARCHAR(32) NOT NULL,
last_name VARCHAR(32) NOT NULL);

CREATE TABLE Dinosaur_discovery (
dinosaur_discovery_id DECIMAL(12) NOT NULL PRIMARY KEY,
dig_site_id DECIMAL(12) NOT NULL,
Paleontologist_id DECIMAL(12) NOT NULL, 
common_name VARCHAR(64) NOT NULL,
fossil_weight DECIMAL(6) NOT NULL,
FOREIGN KEY (dig_site_id) REFERENCES Dig_site(dig_site_id),
FOREIGN KEY (Paleontologist_id) REFERENCES Paleontologist(Paleontologist_id));

INSERT INTO Location(location_id, location_name)
VALUES(101, 'Stonesfield'); 
INSERT INTO Location(location_id, location_name)
VALUES(102, 'Utah'); 
INSERT INTO Location(location_id, location_name)
VALUES(103, 'Arizona'); 

INSERT INTO Dig_site(dig_site_id, location_id, dig_name, dig_cost)
VALUES(1001, 101, 'Great British Dig', 8000); 
INSERT INTO Dig_site(dig_site_id, location_id, dig_name, dig_cost)
VALUES(1002, 102, 'Parowan Dinosaur Tracks', 10000); 
INSERT INTO Dig_site(dig_site_id, location_id, dig_name, dig_cost)
VALUES(1003, 103, 'Dynamic Desert Dig', 3500); 
INSERT INTO Dig_site(dig_site_id, location_id, dig_name, dig_cost)
VALUES(1004, 101, 'Mission Jurassic Dig', NULL); 
INSERT INTO Dig_site(dig_site_id, location_id, dig_name, dig_cost)
VALUES(1005, 101, 'Ancient Site Dig', 5500); 

INSERT INTO Paleontologist(Paleontologist_id, first_name, last_name)
VALUES(1, 'William', 'Buckland'); 
INSERT INTO Paleontologist(Paleontologist_id, first_name, last_name)
VALUES(2, 'John', 'Ostrom'); 
INSERT INTO Paleontologist(Paleontologist_id, first_name, last_name)
VALUES(3, 'Henry', 'Osborn'); 

INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(11, 1001, 1, 'Megalosaurus', 3000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(12, 1001, 1, 'Apatosaurus', 4000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(13, 1001, 1, 'Triceratops', 4500); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(14, 1001, 1, 'Stegosaurus', 3500); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(15, 1002, 2, 'Parasaurolophus', 6000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(16, 1002, 2, 'Tyrannosaurus Rex', 5000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(17, 1002, 2, 'Velociraptor', 7000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(18, 1003, 2, 'Tyrannosaurus Rex', 6000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(19, 1004, 3, 'Spinosaurus', 8000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(20, 1004, 3, 'Diplodocus', 9000); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(21, 1005, 3, 'Tyrannosaurus Rex', 7500); 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(22, 1003, 2, 'Sword Dragon', 10500); --Additional dinosaur discovery of my choosing. 

SELECT * FROM Location;
SELECT * FROM Dig_site;
SELECT * FROM Paleontologist;
SELECT * FROM Dinosaur_discovery;

SELECT location_name, dig_name, TO_CHAR(dig_cost, '$99,999') AS dig_cost, common_name, fossil_weight, (first_name || ' ' || last_name) AS Paleontologist
FROM Location 
JOIN Dig_site ON Location.location_id = Dig_site.location_id
JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
JOIN Paleontologist ON Dinosaur_discovery.Paleontologist_id = Paleontologist.Paleontologist_id

SELECT COUNT(dinosaur_discovery_id)
FROM Dinosaur_discovery
WHERE fossil_weight >= 4200;

SELECT MIN(dig_cost) AS least_expensive, MAX(dig_cost) AS most_expensive
FROM Dig_site;

SELECT dig_name, dig_cost, COUNT(dinosaur_discovery_id) AS num_discovery
FROM Dig_site JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
GROUP BY dig_name, dig_cost

SELECT location_name, COUNT(dinosaur_discovery_id) AS num_discovery
FROM Location 
JOIN Dig_site ON Location.location_id = Dig_site.location_id
JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
GROUP BY location_name
HAVING COUNT(location_name) >= 6;

SELECT dig_name, SUM(fossil_weight) AS total_weight
FROM   Dig_site JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
GROUP BY dig_name
HAVING SUM(fossil_weight) >= 15000;

SELECT (first_name || ' ' || last_name) AS Paleontologist, COUNT(dinosaur_discovery_id) AS dig_number
FROM Location
JOIN Dig_site ON Location.location_id = Dig_site.location_id
              AND location_name = 'Stonesfield'
JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
RIGHT JOIN Paleontologist ON Dinosaur_discovery.Paleontologist_id = Paleontologist.Paleontologist_id
GROUP BY   Paleontologist
ORDER BY   dig_number DESC;

INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(23, 1003, 1, 'Terrifying Dragon', 2500); --Additional dinosaur discovery of my choosing. 
INSERT INTO Dinosaur_discovery(dinosaur_discovery_id, dig_site_id, Paleontologist_id, common_name, fossil_weight)
VALUES(24, 1003, 3, 'Timid Dragon', 1500); --Additional dinosaur discovery of my choosing. 

SELECT location_name, TO_CHAR(AVG(fossil_weight / dig_cost), '99.99') AS weight_per_cost
FROM Location 
JOIN Dig_site ON Location.location_id = Dig_site.location_id
              AND dig_cost IS NOT NULL
JOIN Dinosaur_discovery ON Dig_site.dig_site_id = Dinosaur_discovery.dig_site_id
GROUP BY location_name
ORDER BY weight_per_cost DESC;