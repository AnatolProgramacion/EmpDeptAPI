CREATE DATABASE caixatech;

USE caixatech;

INSERT INTO departments(department_name, department_description) VALUES
    ('HR', 'HR'),
    ('Finanzas', 'Finanzas'),
    ('IT', 'IT');

INSERT INTO employees(department_id, employee_name, employee_email, employee_role, employee_salary) VALUES 
    (1, 'Hector', 'hector@caixabanktech.com', 'Recruiter', 200),
    (2, 'Marta', 'marta@caixabanktech.com', 'Manager', 400),
    (3, 'Laura', 'laura@caixabanktech.com', 'CTO', 1200);
