SET MODE PostgreSQL;
CREATE DATABASE organisational_news_portal;
\c organisational_news_portal

CREATE TABLE IF NOT EXISTS departments (
id SERIAL PRIMARY KEY,
name VARCHAR,
description VARCHAR,
size int
);

CREATE TABLE IF NOT EXISTS news (
id SERIAL PRIMARY KEY,
news_type VARCHAR,
department_id INT,
user_id INT,
title VARCHAR,
description VARCHAR
);

CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
name VARCHAR,
position VARCHAR,
department_id int,
role VARCHAR
);

CREATE TABLE IF NOT EXISTS users_departments (
id SERIAL PRIMARY KEY,
user_id INT,
department_id INT
);

CREATE DATABASE organisational_news_portal_test WITH TEMPLATE organisational_news_portal;