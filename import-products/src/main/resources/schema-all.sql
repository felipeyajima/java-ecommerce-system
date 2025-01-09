DROP TABLE IF EXISTS products;

create table products
(
    id VARCHAR(240),
    name VARCHAR(240),
    description VARCHAR(240),
    price DOUBLE PRECISION,
    category VARCHAR(240),
    imageUrl VARCHAR(240),
    sku VARCHAR(240),
    brand VARCHAR(240),
    weight DOUBLE PRECISION,
    available BOOLEAN,
    stockLevel INTEGER
);