package caixa.api.repositories;

import java.util.List;
import java.util.Optional;

import caixa.api.entities.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // Query to find all employees
    @Query("SELECT * FROM employees")
    List<Employee> findAll();

    // Query to find an employee by ID
    @Query("SELECT * FROM employees WHERE employee_id = :id")
    Optional<Employee> findById(@Param("id") long id);

    // Query to find an employee by name
    @Query("SELECT * FROM employees WHERE employee_name = :name")
    Optional<Employee> findByEmployeeName(@Param("name") String name);

    // Query to find employees by role
    @Query("SELECT * FROM employees WHERE employee_role = :rol")
    List<Employee> findByRol(@Param("rol") String rol);

    // Query to find employees by department ID
    @Query("SELECT * FROM employees WHERE department_id = :departmentid")
    List<Employee> findByDepartmentid(@Param("departmentid") long departmentid);

    // Query to find employees by email
    @Query("SELECT * FROM employees WHERE employee_email = :email")
    List<Employee> findByEmail(@Param("email") String email);

    // Query to find employees by salary
    @Query("SELECT * FROM employees WHERE employee_salary = :salary")
    List<Employee> findBySalary(@Param("salary") int salary);

    Employee save(Employee employee);

    void delete(Employee employee);

    void deleteAll();
}
