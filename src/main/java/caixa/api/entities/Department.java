package caixa.api.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="departments")
public class Department {

    @Id
    private long departmentId;

    private String departmentName;
    private String departmentDescription;

    public Department(){
        super();
    }
 
    public Department(String name, String description) {
        this.departmentName = name;
        this.departmentDescription = description;
    }

    public long getDepartmentId() {
        return this.departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentDescription() {
        return this.departmentDescription;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }
}
