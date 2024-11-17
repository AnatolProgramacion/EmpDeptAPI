package caixa.api.controllers;

import caixa.api.entities.Department;
import caixa.api.repositories.DepartmentRepository;
import caixa.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        // Return 204 No Content if no departments are found
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Return 200 OK
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Get a department by ID
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
        Optional<Department> department = departmentRepository.findById(id);

        // Return 404 Not Found
        if (!department.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return 200 OK
        return new ResponseEntity<>(department.get(), HttpStatus.OK);
    }

    // Create a new department
    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department dpt) {
        try {
            Department newDepartment = departmentRepository.save(dpt);

            // Return 201
            return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing department
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> modifyDepartment(@PathVariable("id") long id, @RequestBody Department dpt) {
        Optional<Department> departmentData = departmentRepository.findById(id);

        if (departmentData.isPresent()) {
            Department department = departmentData.get();
            department.setDepartmentName(dpt.getDepartmentName());
            department.setDepartmentDescription(dpt.getDepartmentDescription());

            //return 201 Created
            return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
        } else {
            // Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a department by ID
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") long id) {
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()) {
            // Delete all employees related to this department
            employeeRepository.deleteAll(employeeRepository.findByDepartmentid(id));

            // Delete the department
            departmentRepository.deleteById(id);

            // Return 200 OK
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            // Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete all departments and employees
    @DeleteMapping("/departments/all")
    public ResponseEntity<HttpStatus> deleteAllDepartments() {
        try {
            employeeRepository.deleteAll();
            departmentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
