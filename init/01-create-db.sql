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

-- Create User Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100),
    address VARCHAR(255),
    publisher BOOLEAN,
    role VARCHAR(10) CHECK (role IN ('admin', 'user'))
);

-- Create Garment Table
CREATE TABLE garments (
    id SERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL CHECK (type IN ('SHIRT', 'PANTS', 'T_SHIRT', 'SHORTS', 'BLOUSE', 'COAT', 'JACKET', 'SHOES')),
    description TEXT,
    publisher_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    price DECIMAL(10, 2),
    size VARCHAR(10) CHECK (size IN ('XXS', 'XS', 'S', 'M', 'L', 'XL', 'XXL', 'XXXL'))
);

