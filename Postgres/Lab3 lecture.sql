CREATE TABLE Simple_product (
product_name VARCHAR(32) NOT NULL,
product_price DECIMAL(6,2) NOT NULL);

INSERT INTO Simple_product (product_name, product_price)
VALUES('Pencil', 0.3);
INSERT INTO Simple_product (product_name, product_price)
VALUES('Notebook', 1.99);
INSERT INTO Simple_product (product_name, product_price)
VALUES('Glue', 1.25);
INSERT INTO Simple_product (product_name, product_price)
VALUES('Scissors', 2.25);

SELECT COUNT(*) AS num_products
FROM Simple_product;

SELECT SUM(product_price) AS num_products
FROM Simple_product;

SELECT *
FROM   Simple_product;

SELECT product_name,
       round(product_price, 1) AS rounded_price
FROM   Simple_product; 

SELECT COUNT(*)
FROM   Simple_product
WHERE  product_price > 1.50;

SELECT MAX(product_price) AS highest, MIN(product_price) AS lowest
FROM   Simple_product
WHERE  product_price < 1.50;


CREATE TABLE Product (
product_name VARCHAR(32) NOT NULL,
product_price DECIMAL(6,2) NOT NULL,
number_available DECIMAL(4) NOT NULL);

INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.3, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Notebook', 1.99, 15);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Glue', 1.25, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Scissors', 2.25, 3);

SELECT number_available, Max(product_price) as max_price
FROM   Product
GROUP  BY number_available; 

SELECT number_available, MAX(product_price) as max_price
FROM   Product
GROUP  BY number_available
HAVING MAX(product_price) > 1.50;

SELECT SUM(product_price) AS total_price
FROM   Product
WHERE  number_available > 8;


DELETE FROM Product;

INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.3, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Notebook', 1.99, 15);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Glue', 1.25, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Scissors', 2.25, 3);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.45, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.49, 15);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.59, 9);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Pencil', 0.3, 10);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Notebook', 2.17, 25);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Glue', 1.10, 15);
INSERT INTO Product (product_name, product_price, number_available)
VALUES('Glue', 1.35, 5);

SELECT   product_name, SUM(number_available) AS total_available
FROM     Product
GROUP BY product_name
ORDER BY product_name;

SELECT   product_name, 
         SUM(number_available) AS total_available,
		 COUNT(*) AS different_brands
FROM     Product
GROUP BY product_name
ORDER BY product_name;


