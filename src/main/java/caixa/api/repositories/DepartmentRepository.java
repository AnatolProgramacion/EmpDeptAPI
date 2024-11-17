package caixa.api.repositories;

import java.util.List;
import java.util.Optional;

import caixa.api.entities.Department;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    // Query to find all departments
    @Query("SELECT * FROM departments")
    List<Department> findAll();

    // Query to find a department by its ID
    @Query("SELECT * FROM departments WHERE department_id = :id")
    Optional<Department> findById(@Param("id") long id);

    // Query to find a department by its name
    @Query("SELECT * FROM departments WHERE department_name = :name")
    Optional<Department> findByName(@Param("name") String name);

    Department save(Department dept);

    void delete(Department dept);

    void deleteById(long id);
}
