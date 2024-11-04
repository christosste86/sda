-- Create 'cars' table
CREATE TABLE cars(id int NOT NULL AUTO_INCREMENT primary key, model varchar(25), mileage bigint, license_plate varchar(7) UNIQUE, price float);

-- Insert data into 'cars'
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('BMW 530',90000,'AB123AA',20); 
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('BMW 530',99820,'IO258AA',20); 
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('BMW 530',79850,'IO813AA',30); 
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('AUDI A6',22985,'AB123AC',20); 
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('Skoda Octavia',159872,'AB123AD',15); 
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('Fiat Ducato',390200,'AC253CD',35);  
INSERT INTO cars (model,mileage,license_plate,price) VALUES ('Peugeot 208',22897,'GT259AT',15);

-- Create 'parking_slots' table with a foreign key to 'cars' ONE TO ONE relationships
CREATE TABLE parking_slots (id int NOT NULL UNIQUE primary key,description varchar(50), CarID int, FOREIGN KEY(CarID) REFERENCES cars(id));

-- Insert data into 'parking_slots'
INSERT INTO parking_slots VALUES (1,"right top corner",1); 
INSERT INTO parking_slots (id,description) VALUES (2,"left top corner"); 

-- Create 'maintenance_records' table with a foreign key to 'cars' MANY TO ONE relationships
CREATE TABLE maintenance_records (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, service_date DATE NOT NULL, service_type VARCHAR(50), cost FLOAT, car_id INT, FOREIGN KEY (car_id) REFERENCES cars(id));

-- Insert data into 'maintenance_records'
INSERT INTO maintenance_records (service_date, service_type, cost, car_id) VALUES ('2024-10-05', 'oil change', 120.50, (SELECT id FROM cars WHERE license_plate = 'AB123AA'));

-- Various JOIN queries same for onetoone & onetomany rel
SELECT cars.model, parking_slots.description from cars inner join parking_slots on parking_slots.carid=cars.id; 
SELECT cars.model, parking_slots.description from cars left join parking_slots on parking_slots.carid=cars.id; 
SELECT cars.model, parking_slots.description from cars right join parking_slots on parking_slots.carid=cars.id; 

-- Create 'rentals' join table with foreign keys to 'customers' and 'cars' MANY TO MANY relationships
CREATE TABLE rentals (id int NOT NULL UNIQUE AUTO_INCREMENT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, customer_id int not null, car_id int not null,FOREIGN KEY(car_id) REFERENCES cars(id), FOREIGN KEY(customer_id) REFERENCES customers(id));

-- Insert data into 'rentals'
INSERT INTO rentals(customer_id, car_id) VALUES ((SELECT id FROM Customers WHERE first_name='Lucia'),(SELECT id FROM cars WHERE license_plate='AB123AA')); 

-- Various JOIN queries for manytomany rel
SELECT Customers.last_name, cars.license_plate from rentals inner join Customers ON Customers.id = rentals.customer_id INNER JOIN cars on cars.id = rentals.car_id; 
SELECT Customers.last_name, cars.license_plate, cars.model from rentals inner join Customers ON Customers.id = rentals.customer_id INNER JOIN cars on cars.id = rentals.car_id;

-- Rename 'cars' table to 'vehicles'
ALTER TABLE cars RENAME TO vehicles;

-- Correct column name in 'rentals'
ALTER TABLE rentals RENAME COLUMN customer_id TO customer_id;


-- Add columns to 'vehicles'
ALTER TABLE vehicles ADD COLUMN color VARCHAR(20) default 'white';
ALTER TABLE vehicles ADD COLUMN vin VARCHAR(17) FIRST;
ALTER TABLE vehicles ADD COLUMN year INT AFTER model;


-- Modify 'price' column in 'vehicles'
ALTER TABLE vehicles MODIFY COLUMN price INT AFTER id;
ALTER TABLE vehicles MODIFY COLUMN price INT first;
ALTER TABLE vehicles MODIFY COLUMN price DECIMAL(10, 2);

-- Drop 'mileage' column from 'vehicles'
ALTER TABLE vehicles DROP COLUMN mileage;

-- Create and drop index on 'license_plate' in 'vehicles'
CREATE INDEX index_lp ON vehicles(license_plate);
SHOW INDEX FROM vehicles;
DROP INDEX index_lp ON vehicles;

