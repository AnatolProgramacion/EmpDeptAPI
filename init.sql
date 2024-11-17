--Create a DBs and info to test app
CREATE TABLE IF NOT EXISTS departments (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL,
    department_description VARCHAR(255)
);


INSERT INTO departments (department_name, department_description) VALUES ('IT', 'Information Technology');
INSERT INTO departments (department_name, department_description) VALUES ('HR', 'Human Resources');


CREATE TABLE IF NOT EXISTS employees (
    employee_id SERIAL PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    employee_email VARCHAR(255) NOT NULL,
    employee_role VARCHAR(100),
    employee_salary INT,
    department_id INT REFERENCES departments(department_id)
);

INSERT INTO employees (employee_name, employee_email, employee_role, employee_salary, department_id)
VALUES ('John Doe', 'john.doe@example.com', 'Developer', 60000, 1);
INSERT INTO employees (employee_name, employee_email, employee_role, employee_salary, department_id)
VALUES ('Jane Smith', 'jane.smith@example.com', 'HR Specialist', 50000, 2);
