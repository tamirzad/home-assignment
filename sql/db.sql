-- Create database
CREATE DATABASE microservice;

-- Connect to the new database
\c microservice;

-- Create UserRole enum type (you can adjust values based on your actual roles)
CREATE TYPE user_role AS ENUM ('ADMIN', 'USER');

-- Create GarmentType enum type (you can adjust values based on your actual garment types)
CREATE TYPE garment_type AS ENUM ('SHIRT', 'PANTS', 'DRESS', 'OUTERWEAR');

-- Create GarmentSize enum type (you can adjust values based on your actual garment sizes)
CREATE TYPE garment_size AS ENUM ('XS','S', 'M', 'L', 'XL','XXL', 'XXXL');

-- Create User table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    publisher BOOLEAN DEFAULT FALSE,
    role user_role NOT NULL
);

-- Create Garment table
CREATE TABLE garments (
    id SERIAL PRIMARY KEY,
    type garment_type NOT NULL,
    description TEXT,
    publisher_id BIGINT,
    price DECIMAL(10, 2) NOT NULL,
    size garment_size NOT NULL,
    FOREIGN KEY (publisher_id) REFERENCES users(id) ON DELETE SET NULL
);
