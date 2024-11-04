-- log to mysql 
-- mysql -u root -p
-- log to mysql windows 
-- winpty mysql -u root -p

-- create database 
-- CREATE DATABASE car_rental;

-- usw database 
USE car_rental;

-- create table 
CREATE TABLE IF NOT EXISTS customers(id int NOT NULL UNIQUE AUTO_INCREMENT primary key, first_name varchar(25), last_name varchar(50), rating int DEFAULT 0);

-- primary kye union of 2 or more cols
CREATE TABLE IF NOT EXISTS customers2(id int AUTO_INCREMENT, first_name varchar(25), last_name varchar(50), rating int, PRIMARY KEY (id , first_name, last_name));

-- check if exist 
SHOW tables; 
-- check properties 
DESCRIBE customers;

-- add data to table 
INSERT INTO customers (first_name,last_name) VALUES ('Lucia','Hadbavnikova'); 

INSERT INTO customers (first_name, last_name) VALUES
('Stefan', 'Fitera'),
('Paulína', 'Hercútová'),
('Tomás', 'Kubinec'),
('Petr', 'Urbancík'),
('Maxmilián', 'Havlík'),
('Milan', 'Backo'),
('Marko', 'Kmetko'),
('Marek', 'Jericha'),
('Matús', 'Machovic'),
('Eva', 'Kyselová'),
('Ján', 'Urica'),
('Zuzana', 'Knutova'),
('Marek', 'Krncok');

-- create new empty table as customers
CREATE TABLE IF NOT EXISTS customers3 LIKE customers;

-- create new table as customers with values
CREATE TABLE IF NOT EXISTS customers4 AS SELECT * FROM customers;

-- return all data 
SELECT * FROM customers; 

-- return specific columns 
SELECT first_name, last_name FROM customers;

-- return specific columns using where 
SELECT first_name, last_name FROM customers WHERE id>1;

-- update all rows 
UPDATE customers SET rating = 1; 

-- update specific rows 
UPDATE customers SET rating = 5 WHERE id=1;

-- update with math operation 
UPDATE customers SET rating = rating + 1 WHERE first_name = 'Jakub';

-- delete row 
DELETE FROM customers WHERE last_name='Hadbavnikova';

-- delete table 
DROP TABLE customers2;
