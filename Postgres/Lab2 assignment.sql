CREATE TABLE Phone (
phone_id DECIMAL(12) NOT NULL PRIMARY KEY,
phone_model VARCHAR(32) NOT NULL,
phone_price DECIMAL(6,2) NOT NULL, 
release_date DATE NOT NULL
);

CREATE TABLE Customer (
customer_id DECIMAL(12) NOT NULL,
customer_email VARCHAR(64) NOT NULL,
customer_name VARCHAR(64) NOT NULL,
phone_id DECIMAL(12) NULL
);

ALTER TABLE Customer
ADD CONSTRAINT customer_pk
PRIMARY KEY(customer_id);

ALTER TABLE Customer
ADD CONSTRAINT customer_phone_fk
FOREIGN KEY(phone_id)
REFERENCES Phone(phone_id);

INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (1, 'Apple iPhone X', 379, CAST('11/03/2017' AS DATE));

INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (2, 'Galaxy S21+', 799, CAST('01/29/2021' AS DATE));

INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (3, 'Xenos 360', 1024, CAST('03/22/2021' AS DATE));

INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (4, 'Meridian Duplex', 462, CAST('05/15/2021' AS DATE));

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (101, 'mike@gmail.com', 'Mike', NULL);

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (102, 'nick@yahoo.com', 'Nike', 2);

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (103, 'venessa@bu.edu', 'Venessa', 3);

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (104, 'richard@hotmail.com', 'Richard', 4);

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (105, 'long@foxmail.com', 'Long', 2);

SELECT * FROM Phone;

SELECT * FROM Customer;

INSERT INTO  Customer(customer_id, customer_email, customer_name, phone_id)
VALUES (501, 'long@foxmail.com', 'Long', 57);

SELECT phone_model, customer_name
FROM Phone
JOIN Customer ON Phone.phone_id = Customer.phone_id;

SELECT phone_model, release_date, customer_name
FROM Phone
LEFT JOIN Customer ON Phone.phone_id = Customer.phone_id
ORDER BY release_date ASC;

SELECT phone_model, release_date, customer_name
FROM Customer
RIGHT JOIN Phone ON Customer.phone_id = Phone.phone_id
ORDER BY release_date ASC;

SELECT customer_name, phone_model
FROM Customer
LEFT JOIN Phone ON Customer.phone_id = Phone.phone_id
ORDER BY customer_email DESC;

SELECT customer_name, phone_model
FROM Phone
RIGHT JOIN Customer ON Phone.phone_id = Customer.phone_id
ORDER BY customer_email DESC;

SELECT phone_model, customer_email, customer_name
FROM Phone
FULL JOIN Customer ON Phone.phone_id = Customer.phone_id
ORDER BY phone_model, customer_name;

SELECT phone_model, to_char(phone_price, '$9999.99') as price
FROM Phone;

SELECT phone_model, to_char(phone_price - 50, '$9999.99') as discounted_price
FROM Phone;

SELECT customer_name || ' (' || phone_model || ' - ' || to_char(phone_price, '$9999.99') || ')' as list
FROM Phone
JOIN Customer ON Phone.phone_id = Customer.phone_id
ORDER BY customer_name;

SELECT phone_model AS high_end_phone, to_char(phone_price, '$9999.99') AS price 
FROM Phone
WHERE phone_price >= 900 AND 
    phone_model <> 'Apple iPhone X' AND 
    release_date >= CAST('05/01/2020' AS DATE);
    
INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (5, 'Xiaomi 12S Ultra', 1200, CAST('07/04/2022' AS DATE));

INSERT INTO Phone (phone_id, phone_model, phone_price, release_date)
VALUES (6, 'Galaxy Fold New', 2000, CAST('01/04/2022' AS DATE));
    
SELECT phone_model AS deluxe_phone, to_char(phone_price, '$9999.99') AS price 
FROM Phone
WHERE phone_price >= 1000 AND 
    phone_model <> 'Galaxy Fold New' AND 
    release_date >= CAST('01/01/2022' AS DATE);
    
SELECT phone_model, to_char(phone_price, '$9999.99') AS price, 
    to_char(phone_price * 0.8, '$9999.99') AS reduced_price
FROM Phone;

ALTER TABLE Phone
ADD high_end Boolean GENERATED ALWAYS AS
(CASE
   WHEN phone_model <> 'Apple iPhone X' AND
        phone_price >= 900 AND 
        release_date >= CAST('05/01/2020' AS DATE) THEN true
   ELSE false
END) STORED;

SELECT phone_model AS high_end_phone, to_char(phone_price, '$9999.99') AS price, release_date, high_end
FROM Phone
WHERE high_end = true;