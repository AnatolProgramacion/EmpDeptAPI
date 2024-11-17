package caixa.api.controllers;

import caixa.api.entities.Employee;
import caixa.api.entities.Department;
import caixa.api.repositories.EmployeeRepository;
import caixa.api.repositories.DepartmentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    // Get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        // Return 204 No Content
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Return 200 OK
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get an employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        // Check if employee exists
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            // Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        try {
            // Check if the department ID provided exists
            Optional<Department> department = departmentRepository.findById(emp.getDepartmentId());
            if (!department.isPresent()) {
                // Return 404 Not Found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Save the new employee
            Employee newEmployee = employeeRepository.save(emp);

            // Return 201 Created
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        try {
            // Check if the employee exists
            if (employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
                // Return 200 OK
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // Return 404 Not Found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all employees (optional)
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            employeeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
