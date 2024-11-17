# 🖥️ Technical Solution Backend Java Spring ☕️

Category   ➡️   Software

Subcategory   ➡️   Java Spring Backend

Difficulty   ➡️   Mid

| ⚠️  Important Note  |
|:----------------------|
| **As this is a technical test, no assistance will be provided beyond what is outlined in this document.** The specific tests you will need to pass are not disclosed in advance; therefore, each objective is described in detail to guide you through the tasks. You are expected to rely solely on the information given here to complete the challenge. This document is designed to provide all necessary instructions and context, ensuring you have a clear understanding of the requirements and goals for each part of the test. |

---

## 🌐 Background

Welcome to the CaixaBank Tech coding challenge! In this challenge, you will demonstrate your ability to manage databases through a RESTful API and handle microservice-based infrastructure. This task will test your skills in API development, SQL querying, and containerization.

You are provided with two controllers, `DepartmentController.java` and `EmployeeController.java`, which outline the basic structure and endpoint declarations for managing departments and employees. Your task is to complete these controllers by implementing the necessary logic for each endpoint. This includes creating, retrieving, updating, and deleting resources while ensuring proper status codes and response bodies are returned for each operation.

This challenge is designed to evaluate your understanding of:

1. **RESTful API principles**: You will need to design and implement endpoints that adhere to REST standards, ensuring each operation is idempotent and stateless where appropriate.
2. **Database interactions using repositories**: You will interact with the database through repository interfaces, writing custom SQL queries, and handling database operations efficiently.
3. **Proficiency in Docker**: You will set up a Docker environment to run the API and database as microservices, ensuring the system can be easily deployed and scaled.

This exercise mimics real-world scenarios where you might need to build and maintain APIs for applications, handling various edge cases and validation checks appropriately. It will help you understand the importance of structuring your code for maintainability and scalability.

This is an excellent opportunity to showcase your ability to build robust, scalable, and maintainable software solutions. By the end of this task, you will have demonstrated your proficiency in key areas of modern software development, including API design, database management, and containerization.

Good luck, and happy coding!

## 📂 Repository Structure

A repository tree is provided below and should not be modified. Everything you need to develop the challenge is already included.
```bash
├── Dockerfile
├── docker-compose.yaml
├── task_three.json
├── mvnw
├── pom.xml
├── README.md
├── sql
│   └── init.sql
└── src
    ├── main
    │   ├── java
    │   │   └── caixa
    │   │       └── api
    │   │           ├── CaixaTechnicalSolutionApplication.java
    │   │           ├── controllers
    │   │           │   ├── DepartmentController.java
    │   │           │   └── EmployeeController.java
    │   │           ├── entities
    │   │           │   ├── Department.java
    │   │           │   └── Employee.java
    │   │           ├── JacksonConfiguration.java
    │   │           ├── repositories
    │   │           │   ├── DepartmentRepository.java
    │   │           │   └── EmployeeRepository.java
    │   │           └── ServletInitializer.java
```
**It is necessary to modify only the files proposed in the objectives.**

## 🎯 Tasks

This challenge is about implementing basic registration endpoints, protected endpoints whilst implementing the logic of a small codebase. 

1. **Task 1**: Dockerise the API created and create a docker-compose to have a microservices-based structure of both the API and the DB.
2. **Task 2**: Complete SQL queries in repositories and create a new one in `EmployeeRepository.java` to find employees by salary range and complete the required functions in the controllers to create the API endpoints.
3. **Task 3**: Complete the SQL quiz.

### 📑 Detailed information about tasks

#### Task 1

Task three aims to create a microservices-based structure. Therefore, two files will have to be created:

- **Dockerfile**: dockerises the Java app.
- **Docker-compose**: builds and connects the container containing the API with the DB and automates the deployment of all the necessary resources.

**Just create one Dockerfile. The database is created in the docker-compose. The credentials can be found in application.properties.**

#### Task 2

Task two aims to complete the repositories with the SQL queries to be able to interact with the DB and then create the endpoints using those files.

Complete the files:

- [DepartmentRepository.java](src/main/java/caixa/api/repositories/DepartmentRepository.java)
- [EmployeeRepository.java](src/main/java/caixa/api/repositories/EmployeeRepository.java)

Add a new function in `EmployeeRepository.java` where an employee can be found by salary range.

This task also aims to complete the missing API endpoints using the previously completed repositories. 

Complete the following functions:

- **DepartmentController.java**

    - **getAllDepartments**
        - **Description**: Retrieves all departments from the database.
        - **Request**: No request body required.
        - **Response**: A list of all departments. If no departments are found, it returns a status code 204 (No Content).
        - **Instructions**: Implement a method that fetches all departments from the `departmentRepository`. If the list is empty, return a response with status 204 (No Content). Otherwise, return the list of departments with status 200 (OK).
        - **Status Codes**: 200 OK, 204 No Content
    
    - **getDepartmentById**
        - **Description**: Retrieves a specific department by its ID.
        - **Request**: No request body required. Path variable `id` is required.
        - **Response**: The department details if found. If the department is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that fetches a department by its ID from the `departmentRepository`. If the department is not found, return a response with status 404 (Not Found). Otherwise, return the department details with status 200 (OK).
        - **Status Codes**: 200 OK, 404 Not Found

    - **createDepartment**
        - **Description**: Creates a new department.
        - **Request**: JSON payload with department details (nombre, descripcion) is required.
        - **Response**: The created department details.
        - **Instructions**: Implement a method that creates a new department using the data provided in the request body. Save the new department to the `departmentRepository` and return the created department details with status 201 (Created).
        - **Status Codes**: 201 Created

    - **modifyDepartment**
        - **Description**: Updates an existing department by its ID.
        - **Request**: JSON payload with updated department details (nombre, descripcion). Path variable `id` is required.
        - **Response**: The updated department details. If the department is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that updates an existing department using the data provided in the request body and the ID provided in the path variable. Fetch the department by its ID from the `departmentRepository`. If the department is not found, return a response with status 404 (Not Found). Otherwise, update the department details and save the changes to the `departmentRepository`. Return the updated department details with status 201 (Created).
        - **Status Codes**: 201 Created, 404 Not Found

    - **deleteDepartment**
        - **Description**: Deletes a specific department by its ID. It also deletes all employees associated with the department.
        - **Request**: No request body required. Path variable `id` is required.
        - **Response**: Status message indicating the result. If the department is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that deletes a department by its ID. Fetch the department by its ID from the `departmentRepository`. If the department is not found, return a response with status 404 (Not Found). Otherwise, delete all employees associated with the department and then delete the department from the `departmentRepository`. Return a response with status 200 (OK).
        - **Status Codes**: 200 OK, 404 Not Found

- **EmployeeController.java**

    - **getAllEmployees**
        - **Description**: Retrieves all employees from the database.
        - **Request**: No request body required.
        - **Response**: A list of all employees. If no employees are found, it returns a status code 204 (No Content).
        - **Instructions**: Implement a method that fetches all employees from the `employeeRepository`. If the list is empty, return a response with status 204 (No Content). Otherwise, return the list of employees with status 200 (OK).
        - **Status Codes**: 200 OK, 204 No Content

    - **getEmployeeById**
        - **Description**: Retrieves a specific employee by their ID.
        - **Request**: No request body required. Path variable `id` is required.
        - **Response**: The employee details if found. If the employee is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that fetches an employee by their ID from the `employeeRepository`. If the employee is not found, return a response with status 404 (Not Found). Otherwise, return the employee details with status 200 (OK).
        - **Status Codes**: 200 OK, 404 Not Found

    - **createEmployee**
        - **Description**: Creates a new employee. It checks if the department ID provided in the request body exists.
        - **Request**: JSON payload with employee details (nombre, email, rol, departmentid, salario) is required.
        - **Response**: The created employee details. If the department ID is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that creates a new employee using the data provided in the request body. Check if the department ID provided exists in the `departmentRepository`. If the department ID is not found, return a response with status 404 (Not Found). Otherwise, save the new employee to the `employeeRepository` and return the created employee details with status 201 (Created).
        - **Status Codes**: 201 Created, 404 Not Found

    - **deleteEmployee**
        - **Description**: Deletes a specific employee by their ID.
        - **Request**: No request body required. Path variable `id` is required.
        - **Response**: Status message indicating the result. If the employee is not found, it returns a status code 404 (Not Found).
        - **Instructions**: Implement a method that deletes an employee by their ID. Fetch the employee by their ID from the `employeeRepository`. If the employee is not found, return a response with status 404 (Not Found). Otherwise, delete the employee from the `employeeRepository` and return a response with status 200 (OK).
        - **Status Codes**: 200 OK, 404 Not Found


#### Task 3

Task 3 aims to answer a questionnaire called `postgresql-challenge.pdf`. 

In this file you can see the design of the database. Given this information, you will have to select the correct option from each question. 

You will have to select one option among the three given for each question.

The answers will be inserted in the file `task_three.json` which has the following format:

```json
{
    "answer1": "",
    "answer2": "",
    .
    .
    .
}
```

The correct answer has to be inserted as follows, always in capital letters:

```json
{
    "answer1": "A",
    "answer2": "B"
}
```

## 💫 Guides

**Endpoint table**:

### DepartmentController.java

| HTTP Method | Endpoint                  | Description                               | Request Body          | Response Body            | Status Codes                    |
|-------------|----------------------------|-------------------------------------------|-----------------------|--------------------------|----------------------------------|
| GET         | /api/departments           | Get all departments                       | None                  | List of Department       | 200 OK, 204 No Content           |
| GET         | /api/departments/{id}      | Get department by ID                      | None                  | Department               | 200 OK, 404 Not Found            |
| POST        | /api/departments           | Create a new department                   | Department JSON       | Department               | 201 Created                      |
| PUT         | /api/departments/{id}      | Modify an existing department by ID       | Department JSON       | Department               | 201 Created, 404 Not Found       |
| DELETE      | /api/departments/{id}      | Delete a department by ID                 | None                  | None                     | 200 OK, 404 Not Found            |
| DELETE      | /api/departments/all       | Delete all departments                    | None                  | None                     | 200 OK                           |

### EmployeeController.java

| HTTP Method | Endpoint                  | Description                               | Request Body          | Response Body            | Status Codes                    |
|-------------|----------------------------|-------------------------------------------|-----------------------|--------------------------|----------------------------------|
| GET         | /api/employees             | Get all employees                         | None                  | List of Employee         | 200 OK, 204 No Content           |
| GET         | /api/employees/{id}        | Get employee by ID                        | None                  | Employee                 | 200 OK, 404 Not Found            |
| POST        | /api/employee              | Create a new employee                     | Employee JSON         | Employee                 | 201 Created, 404 Not Found       |
| PUT         | /api/employees/{id}        | Modify an existing employee by ID         | Employee JSON         | Employee                 | 201 Created, 404 Not Found       |
| DELETE      | /api/employees/{id}        | Delete an employee by ID                  | None                  | None                     | 200 OK, 404 Not Found            |
| DELETE      | /api/employees             | Delete all employees                      | None                  | None                     | 200 OK                           |

In the [application.properties](src/main/resources/application.properties) file, the connection to the database has been configured. The best option to test the operation of the app is to deploy PostgreSQL in a container. It is also a good option to create the files requested in **Task 1** once they are needed to facilitate the deployment.

**The tests will simulate the interaction of a user directly with the API running in a container and exposed on port 3000. It is for this reason that you are asked to create the necessary files in task 1.**

**⚠️ ATTENTION**: You are not allowed to install 3rd party modules.

## 📤 Submission

1. Solve the proposed tasks.
2. Continuously push the changes you have made.
3. Wait for the results.
4. Click submit challenge when you have reached your maximum score.

## 📊 Evaluation

The final score will be given according to whether or not the objectives have been met.

In this case, the challenge will be evaluated on 1200 points which are distributed as follows:

- Task 1: 300 points
- Task 2: 300 points
- Task 3: 300 points
- Code quality: 300 points

## ❓ Additional information

Only the files proposed in the objectives should be modified. You are not allowed to modify anything other than the proposed files.

**Q1: What happens if I modify files that are not in scope?**

A1: The correction will fail because those changes will not be taken into account.

**Q2: Can I add resources that are not in pom.xml?**

A2: No, everything needed to complete the challenge is included.
