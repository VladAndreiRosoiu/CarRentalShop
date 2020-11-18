CREATE SCHEMA rentalshopDB;
USE rentalshopDB;

CREATE TABLE address(
id INT PRIMARY KEY AUTO_INCREMENT,
street_name VARCHAR (255) NOT NULL,
street_no INT NOT NULL,
building VARCHAR (255) NOT NULL,
floor_no INT,
apartment_no INT,
city VARCHAR (255) NOT NULL,
county VARCHAR (255) NOT NULL,
country VARCHAR (255) NOT NULL);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR (255) NOT NULL,
last_name VARCHAR (255) NOT NULL,
username VARCHAR(255) UNIQUE NOT NULL,
user_password VARCHAR (255) NOT NULL,
driving_licence_issue_date DATE,
birthdate DATE NOT NULL,
registered_on DATE NOT NULL,
deleted_on DATE,
id_address INT NOT NULL,
FOREIGN KEY (id_address) REFERENCES address(id),
CONSTRAINT client_constr UNIQUE (first_name, last_name, username, birthdate)
);

CREATE TABLE positions(
id INT PRIMARY KEY AUTO_INCREMENT,
position_name VARCHAR (255) NOT NULL,
start_date DATE NOT NULL,
end_date DATE,
access_level ENUM ('ONE', 'TWO', 'THREE'),
CONSTRAINT pos_constr UNIQUE (position_name, start_date, end_date)
);

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR (255) NOT NULL,
last_name VARCHAR (255) NOT NULL,
username VARCHAR(255) UNIQUE NOT NULL,
user_password VARCHAR (255) NOT NULL,
birthdate DATE NOT NULL,
responds_to INT NOT NULL,
id_position INT NOT NULL,
id_address INT NOT NULL,
FOREIGN KEY (responds_to) REFERENCES employees(id),
FOREIGN KEY (id_position) REFERENCES positions(id),
FOREIGN KEY (id_address) REFERENCES address(id),
CONSTRAINT emp_constr UNIQUE (first_name, last_name, birthdate)
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
car_make VARCHAR (255) NOT NULL,
car_model VARCHAR (255) NOT NULL,
colour VARCHAR (255) NOT NULL,
vin LONG NOT NULL,
rent_price_per_day INT NOT NULL,
seat_number INT NOT NULL,
fuel_type ENUM ('DIESEL', 'GASOLINE' , 'LPG' , 'ELECTRIC' , 'HYBRID'),
rent_category ENUM ('STANDARD' , 'MEDIUM' , 'LUXURY')
);


CREATE TABLE rented_cars(
id INT PRIMARY KEY AUTO_INCREMENT,
car_id INT NOT NULL,
client_id INT NOT NULL,
rented_on DATE NOT NULL,
returned_on DATE,
FOREIGN KEY (car_id) REFERENCES cars(id),
FOREIGN KEY (client_id) REFERENCES clients(id),
CONSTRAINT rent_constr UNIQUE (client_id, returned_on)
);

/*
Add prices table?
Add clients, employees, cars, mock rentals
*/

