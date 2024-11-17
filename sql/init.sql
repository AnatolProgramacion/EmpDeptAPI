CREATE TABLE IF NOT EXISTS departments(
    department_id integer PRIMARY KEY GENERATED always AS IDENTITY,
    department_name varchar(255) NOT NULL,
    department_description varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employees(
    employee_id integer PRIMARY KEY GENERATED always AS IDENTITY,
    department_id integer,
    employee_name VARCHAR(255) NOT NULL,
    employee_email VARCHAR(255) NOT NULL,
    employee_role VARCHAR(255) NOT NULL,
    employee_salary INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO departments(department_name, department_description) VALUES
    ('HR', 'HR'),
    ('Finances', 'Finances'),
    ('IT', 'IT');

INSERT INTO employees(department_id, employee_name, employee_email, employee_role, employee_salary) VALUES 
    (1, 'Peter', 'peter@caixabanktech.com', 'Recruiter', 200),
    (2, 'Mara', 'mara@caixabanktech.com', 'Manager', 400),
    (3, 'Marie', 'marie@caixabanktech.com', 'CTO', 1200);