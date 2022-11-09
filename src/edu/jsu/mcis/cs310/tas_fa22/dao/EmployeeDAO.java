package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    
    private static final String QUERY_FIND = "SELECT * FROM shift WHERE id = ?";
    private static final String QUERY_BADGE = "SELECT * FROM employee WHERE badgeid = ?";
    
    private final DAOFactory daoFactory;
    
    EmployeeDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Employee find(int id){
        
        Employee employee = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setInt(1, id);

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                     while (rs.next()) {
                        
                        HashMap<String, String> HashMap = new HashMap<>();
                        HashMap.put("id", rs.getString("id"));
                        HashMap.put("firstname", rs.getString("firstname"));
                        HashMap.put("middlename", rs.getString("middlename"));
                        HashMap.put("lastname", rs.getString("lastname"));
                        HashMap.put("badge", rs.getString("badge"));
                        HashMap.put("active", rs.getString("active"));
                        HashMap.put("department", rs.getString("department"));
                        HashMap.put("shift", rs.getString("shift"));
                        HashMap.put("employee", rs.getString("employee"));
                        employee = new Employee(HashMap);
                    }
                }
            }
        }
        
                  catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }

        return employee;

    }
    
    public Employee find(String id) {
        Employee employee = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_BADGE);
                ps.setString(1, employee.getId());

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();
                    rs.next();
                    id = rs.getString("id");
                    employee = find(id);

                }

            }

        } 
        catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } 
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }

        return employee;
    }
}

   
