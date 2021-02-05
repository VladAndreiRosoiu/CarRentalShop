DROP SCHEMA IF EXISTS rentalshopDB;
CREATE SCHEMA rentalshopDB;
USE rentalshopDB;

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
street_name VARCHAR (255) NOT NULL,
street_no VARCHAR (50) NOT NULL,
building VARCHAR (255) NOT NULL,
floor_no VARCHAR (50),
apartment_no VARCHAR (50),
city VARCHAR (255) NOT NULL,
country VARCHAR (255) NOT NULL);

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR (255) NOT NULL,
last_name VARCHAR (255) NOT NULL,
username VARCHAR(255) UNIQUE NOT NULL,
user_password VARCHAR (255) NOT NULL,
driving_licence_issue_date DATE,
driving_licence_expire_date DATE,
driving_licence_category ENUM ('A', 'B' , 'C', 'D' , 'E'),
user_type ENUM ('CLIENT', 'EMPLOYEE'),
birthdate DATE NOT NULL,
registered_on DATE NOT NULL,
deleted_on DATE,
id_address INT NOT NULL,
FOREIGN KEY (id_address) REFERENCES addresses (id),
CONSTRAINT client_constr UNIQUE (first_name, last_name, username, birthdate)
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
car_make VARCHAR (255) NOT NULL,
car_model VARCHAR (255) NOT NULL,
color VARCHAR (255) NOT NULL,
vin LONG NOT NULL,
rent_price_per_day INT NOT NULL,
deposit_required INT NOT NULL,
seat_number INT NOT NULL,
fuel_type ENUM ('DIESEL', 'GASOLINE' , 'LPG' , 'ELECTRIC' , 'HYBRID'),
rent_category ENUM ('STANDARD' , 'MEDIUM' , 'LUXURY', 'UTILITY')
);

CREATE TABLE rentals(
id INT PRIMARY KEY AUTO_INCREMENT,
id_car INT NOT NULL,
id_client INT NOT NULL,
rental_date DATE NOT NULL,
to_be_returned_date DATE NOT NULL,
return_date DATE,
rental_status ENUM ('APPROVED', 'DENIED'),
status_reason VARCHAR(255) NOT NULL,
id_employee INT NOT NULL,
status_on DATE NOT NULL,
FOREIGN KEY (id_car) REFERENCES cars(id),
FOREIGN KEY (id_client) REFERENCES users(id),
FOREIGN KEY (id_employee) REFERENCES users(id)
);

CREATE TABLE payments(
id INT PRIMARY KEY AUTO_INCREMENT,
id_rental INT NOT NULL,
amount_paid INT NOT NULL,
paid_on DATE NOT NULL
);

INSERT INTO rentalshopDB.addresses (street_name, street_no, building, floor_no, apartment_no, city, country)
VALUES
('First Street', 5 , 'A','-','-', 'Bucharest', 'Romania'),
('First Boulevard', 22 , 'D','-','-', 'Bucharest', 'Romania'),
('Second Street', 1 , 'C9','-','-', 'Bucharest', 'Romania'),
('First Boulevard', 22 , 'D12','-','-', 'Bucharest', 'Romania'),
('Third Street', 195 , 'B','-','-', 'Bucharest', 'Romania');

INSERT INTO rentalshopDB.users (first_name, last_name, username, user_password, driving_licence_issue_date, driving_licence_expire_date,
driving_licence_category, user_type, birthdate, registered_on, deleted_on, id_address)
VALUES
('Vlad', 'Rosoiu', 'vladrosoiu', '1234567', '2015-10-01', '2025-10-01', 'B' ,'CLIENT' ,'1990-10-01', '2019-01-01','9999-01-01', 1),
('Joey', 'Joe', 'jjoe', '12345678', '2020-11-30', '2030-11-30', 'B', 'CLIENT' ,'1995-10-01', '2020-12-01','9999-01-01', 2),
('Mark', 'Martin', 'mmartin', '123456789', '2017-11-11', '2027-11-11', 'E', 'CLIENT' , '1985-11-13', '2016-03-08','9999-01-01', 3);

INSERT INTO rentalshopDB.users (first_name, last_name, username, user_password, user_type, birthdate, registered_on, deleted_on, id_address)
VALUES
('Andrei', 'Rosoiu', 'andreirosoiu', 'emplandrei', 'EMPLOYEE', '1990-12-12', '2015-01-01','9999-01-01', 1),
('Pop', 'Popescu', 'poppopescu', 'emplpopescu', 'EMPLOYEE','1991-11-30', '2012-05-05','9999-01-01', 2);

INSERT INTO rentalshopDB.cars (car_make, car_model, color, vin, rent_price_per_day, deposit_required, seat_number, fuel_type, rent_category)
VALUES
('Dacia', 'Logan' , 'Red', 1234567890, 10 , 50, 5, 'DIESEL' , 'STANDARD'),
('Dacia', 'Logan' , 'Blue', 1234567891, 15 , 60, 5, 'LPG' , 'MEDIUM'),
('Dacia', 'MCV' , 'White', 1234567892, 13 , 55, 5, 'DIESEL' , 'STANDARD'),
('Volkswagen', 'Golf' , 'Black', 1234567893, 20 , 80, 5, 'DIESEL' , 'MEDIUM'),
('Volkswagen', 'Golf' , 'Black', 1234567893, 20 , 80, 5, 'DIESEL' , 'MEDIUM'),
('Volkswagen', 'Pasat' , 'Black', 1234567894, 25 , 90, 5, 'DIESEL' , 'LUXURY'),
('Volkswagen', 'Pasat' , 'Black', 1234567894, 25 , 90, 5, 'DIESEL' , 'LUXURY'),
('Volkswagen', 'Van' , 'Black', 1234567895, 30 , 100, 8, 'DIESEL' , 'UTILITY'),
('Volkswagen', 'Van' , 'Black', 1234567896, 30 , 100, 8, 'DIESEL' , 'UTILITY'),
('Mercedes', 'E Class' , 'Grey', 1234567897, 50 , 150, 5, 'DIESEL' , 'LUXURY'),
('Mercedes', 'Van' , 'Black', 1234567898, 35 , 100, 8, 'DIESEL' , 'UTILITY'),
('Dacia', 'Logan' , 'White', 1234567890, 10 , 50, 5, 'DIESEL' , 'STANDARD'),
('Dacia', 'Logan' , 'White', 1234567890, 10 , 50, 5, 'DIESEL' , 'STANDARD'),
('Dacia', 'Logan' , 'White', 1234567890, 10 , 50, 5, 'DIESEL' , 'STANDARD'),
('Dacia', 'Logan' , 'Blue', 1234567891, 15 , 60, 5, 'LPG' , 'MEDIUM'),
('Dacia', 'Logan' , 'Blue', 1234567891, 15 , 60, 5, 'LPG' , 'MEDIUM');

INSERT INTO rentalshopDB.rentals (id_car, id_client, rental_date, to_be_returned_date, return_date, rental_status, status_reason, id_employee, status_on)
VALUES
(2, 3, '2020-01-01', '2020-01-15','2020-01-15', 'APPROVED', 'OK!', 2, '2020-01-01'),
(2, 3, '2020-08-01', '2020-09-15','2020-09-15', 'APPROVED', 'OK!', 2, '2020-10-01'),
(2, 3, '2020-10-01', '2020-11-15','2020-11-15', 'APPROVED', 'OK!', 1, '2020-10-01');

INSERT INTO rentalshopDB.rentals (id_car, id_client, rental_date, to_be_returned_date, rental_status, status_reason, id_employee, status_on)
VALUES
(3, 2, '2020-12-01', '2020-12-29', 'DENIED', 'LICENCE OBTAINED TOO SOON', 2, '2020-12-01');

INSERT INTO rentalshopDB.rentals (id_car, id_client, rental_date, to_be_returned_date, rental_status, status_reason, id_employee, status_on)
VALUES
(1, 1, '2021-01-01', '2021-01-29', 'APPROVED', 'OK!', 1, '2021-01-01');

INSERT INTO rentalshopDB.payments (id_rental, amount_paid, paid_on)
VALUES
(1,225,'2020-01-16'),
(2,225,'2020-09-16'),
(3,675,'2020-11-16');
