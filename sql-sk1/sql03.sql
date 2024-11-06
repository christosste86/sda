-- AND OR NOT
select * from cars where mileage > 100000;
select * from cars where mileage > 100000 and price > 20;
select * from cars where mileage > 100000 and price > 20 or price = 15;
select * from cars where mileage > 100000 and (price > 20 or price = 15);
select * from cars where not price = 15;

-- ORDER BY
-- Select all cars ordered by model in ascending order
SELECT * FROM cars ORDER BY model;
-- Select all cars ordered by model in descending order
SELECT * FROM cars ORDER BY model DESC;
SELECT * FROM cars ORDER BY model DESC , mileage DESC;

-- AGGREGATE FUNCTIONS
-- MIN
SELECT MIN(mileage) FROM cars;
select * from cars where mileage = (select min(mileage) from cars);
-- MAX
select max(mileage) from cars;
-- COUNT
select count(ID) from cars where price > 18;
-- AVG
select avg(mileage) from cars;
-- SUM
select sum(price) from cars;
 
 -- WILDCARDS
 -- Select cars where the model starts with "BMW"
select * from cars where model like "BMW%";
-- Case-sensitive selection
SELECT * FROM cars WHERE BINARY model LIKE 'bmw%';
-- Select cars where the license plate contains "123" anywhere in the plate
select * from cars where license_plate like "%123%";
-- Select cars where the license plate has "B" as the second character
select * from cars where license_plate like "_B%";

-- Create a function that returns a discount based on rating
delimiter //
create function getDiscount(rating int)
returns decimal(5, 2)
deterministic
begin
declare discount decimal(5, 2);
if rating >= 10 then
set discount = 15.00;
elseif rating >= 5 then 
set discount = 10.00;
else set discount = 5.00;
end if;
return discount;
end //
delimiter ;

alter table customers add column discount decimal(5,2);
-- Update discount values based on the rating using the getDiscount function
update customers set discount = getDiscount(rating);

CREATE TABLE mileage_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT,
    old_mileage BIGINT,
    new_mileage BIGINT,
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (car_id)
        REFERENCES cars (id)
);

-- Create a trigger to log mileage updates in mileage_log
delimiter //
create trigger mileageupdate2
after update on cars
for each row
begin
if old.mileage <> new.mileage
then
insert into mileage_log(car_id, old_mileage, new_mileage)
values (old.id, old.mileage, new.mileage);
end if;
end //
delimiter ;

-- Update the mileage for a specific car to test if the trigger executes
update cars set mileage = 109000 where id = 1;

-- Procedure to add a new rental record by linking a customer to a car based on name and license plate
delimiter //
create procedure addRental(
in customer_first_name varchar(25), 
in customer_last_name varchar(50),
in car_lincense_plate varchar(7))
begin
declare customer_id int;
declare car_id int;

SELECT 
    id
INTO customer_id FROM
    customers
WHERE
    first_name = customer_first_name
        AND last_name = customer_last_name;

SELECT 
    id
INTO car_id FROM
    cars
WHERE
    license_plate = car_lincense_plate;

if customer_id is not null and car_id is not null 
then 
insert into rentals (customer_id, car_id) 
values (customer_id, car_id);
else
signal sqlstate '45000'
set message_text = 'customer or car not found';
end if;
end //
delimiter ;

call addRental('Stefan', 'Fitera', 'AB123AC');
call addRental('Marek', 'Fitera', 'AB123AC');




