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
