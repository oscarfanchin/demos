-- Schema
DROP TABLE IF EXISTS department;

CREATE TABLE department (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

-- Sample data
INSERT INTO department (id, name) VALUES 
    (1, 'Human Resources'),
    (2, 'Information Technology'),
    (3, 'Finance'),
    (4, 'Marketing'),
    (5, 'Research and Development');

