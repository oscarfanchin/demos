-- Schema
DROP TABLE IF EXISTS department cascade;

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

DROP TABLE IF EXISTS employee cascade;

CREATE TABLE employee (
    id_employee BIGINT PRIMARY KEY,
    name_employee VARCHAR(100) NOT NULL,
    fk_department BIGINT NOT NULL,
    CONSTRAINT fk_department FOREIGN KEY (fk_department) REFERENCES department(id)
);

-- Dati di esempio
INSERT INTO employee (id_employee, name_employee, fk_department) VALUES
    (1, 'Alice Rossi', 1),
    (2, 'Bob Bianchi', 2),
    (3, 'Carla Verdi', 2),
    (4, 'David Neri', 3),
    (5, 'Eva Gialli', 3),
    (6, 'Franco Blu', 4),
    (7, 'Giulia Marrone', 4),
    (8, 'Hassan Grigio', 5),
    (9, 'Isabella Viola', 5),
    (10, 'Luca Rosso', 5);