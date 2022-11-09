package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


public class Employee {
    
    private final int id;
    private final String firstname, middlename, lastname, employeetype;
    private final LocalDateTime active, inactive;
    
    private Badge badge;
    private Department department;
    private Shift shift;

    public Employee(Map params) {
        
        this.id = Integer.parseInt(params.get("id").toString());
        this.firstname = params.get("firstname").toString();
        this.middlename = params.get("middlename").toString();
        this.lastname = params.get("lastname").toString();
        
        String e = params.get("employeetype").toString();
        e = e.substring(0, (e.length() - 8)).trim();
        this.employeetype = e;
        
        this.active = (LocalDateTime)(params.get("active"));
        this.inactive = null;
        
        this.badge = (Badge)(params.get("badge"));
        this.department = (Department)(params.get("department"));
        this.shift = (Shift)(params.get("shift"));
        
    }
    
    

    @Override
    public String toString() {
        
        // "ID #14: Donaldson, Kathleen C (#229324A4), Type: Full-Time, Department: Press, Active: 02/02/2017"
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        StringBuilder s = new StringBuilder();
        
        s.append("ID #").append(id).append(": ").append(badge.getDescription());
        s.append(" (#").append(badge.getId()).append("), ");
        s.append("Type: ").append(employeetype).append(", ");
        s.append("Department: ").append(department.getDescription()).append(", ");
        s.append("Active: ").append(dtf.format(active));
        
        return s.toString();
        
    }
    
    
}
