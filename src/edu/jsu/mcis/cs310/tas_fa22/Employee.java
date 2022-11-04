package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class Employee {
    private String id;
    private String firstname, middlename, lastname;
    private Badge badge;
    private LocalDateTime active;
    private Department department; //if there is an error it doesn't exist yet
    private Employee employee;
    private Shift shift;

    public Employee(HashMap map) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.badge = badge;
        this.active = active;
        this.department = department;
        this.employee = employee;
        this.shift = shift;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public Badge getBadge() {
        return badge;
    }

    public LocalDateTime getActive() {
        return active;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public Shift getShift(){
        return shift;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstname=" + firstname + ", middlename=" 
                + middlename + ", lastname=" + lastname + ", badge=" + badge + ", active=" 
                + active + ", department=" + department + ", employee=" + employee+ ", shift=" 
                + shift + '}';
    }
    
    
}
