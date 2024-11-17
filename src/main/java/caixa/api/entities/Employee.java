package caixa.api.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="employees")
public class Employee{

    @Id
    private Long employeeId;
    
    private Long departmentId;
    private String employeeName;
    private String employeeEmail;
    private String employeeRole;
    private int employeeSalary;

    public Employee(){
        super();
    }
 
    public Employee(String name, String email, String role, long departmentId, int salary) {
        setEmployeeName(name);
        setEmployeeEmail(email);
        setEmployeeRole(role);
        setDepartmentId(departmentId);
        setEmployeeSalary(salary);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public String getEmployeeRole() {
        return this.employeeRole;
    }

    public int getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
