CREATE TABLE Customers (
    id_customer INT PRIMARY KEY,
    name_customer VARCHAR(50),
    address_customer VARCHAR(100),
    phone_customer VARCHAR(20)
);

CREATE TABLE Vehicles (
    id_vehicle INT PRIMARY KEY,
    plate VARCHAR(15) UNIQUE,
    make VARCHAR(50),
    model VARCHAR(50),
    id_customer INT,
    FOREIGN KEY (id_customer) REFERENCES customers(id_customer)
);

CREATE TABLE Rates (
    id_rate INT PRIMARY KEY,
    type_vehicle VARCHAR(50),
    rate_hora DECIMAL(8, 2),
    rate_dia DECIMAL(8, 2)
);

CREATE TABLE Entrances (
    id_entrance INT PRIMARY KEY,
    id_vehicle INT,
    date_entrance DATETIME,
    FOREIGN KEY (id_vehicle) REFERENCES vehicles(id_vehicle)
);

CREATE TABLE Exits (
    id_exit INT PRIMARY KEY,
    id_entrance INT,
    date_exit DATETIME,
    total_pay DECIMAL(10, 2),
    FOREIGN KEY (id_entrance) REFERENCES Entrances(id_entrance)
);

CREATE TABLE Transactions (
    id_transaction INT PRIMARY KEY,
    id_vehicle INT,
    type_transaction ENUM('Entrance', 'Exit'),
    date_transaction DATETIME,
    time_elapsed INT, -- en minutos
    total_pay DECIMAL(10, 2),
    discount_applied DECIMAL(5, 2) DEFAULT 0.0,
    FOREIGN KEY (id_vehicle) REFERENCES vehicles(id_vehicle)
);

CREATE TABLE Discounts (
    id_discount INT PRIMARY KEY,
    name_discount VARCHAR(50),
    percentage DESCIMAL(5, 2)
);