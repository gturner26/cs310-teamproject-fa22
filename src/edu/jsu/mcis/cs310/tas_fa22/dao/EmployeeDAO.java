package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class EmployeeDAO {
    
    private static final String QUERY_FIND_ID = "SELECT * FROM employee JOIN employeetype ON employee.employeetypeid = employeetype.id WHERE employee.id = ?";
    private static final String QUERY_FIND_BADGE = "SELECT * FROM employee WHERE badgeid = ?";
    
    private final DAOFactory daoFactory;
    
    EmployeeDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Employee find(int id) {
        
        Employee employee = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND_ID);
                ps.setInt(1, id);

                boolean hasresults = ps.execute();

                if (hasresults) {
                    
                    ShiftDAO shiftDAO = daoFactory.getShiftDAO();
                    BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                    DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();

                    rs = ps.getResultSet();

                     while (rs.next()) {
                        
                        HashMap<String, Object> params = new HashMap<>();
                        
                        params.put("id", rs.getString("id"));
                        params.put("firstname", rs.getString("firstname"));
                        params.put("employeetype", rs.getString("description"));
                        params.put("middlename", rs.getString("middlename"));
                        params.put("lastname", rs.getString("lastname"));
                        params.put("employeetypeid", rs.getString("employeetypeid"));
                        
                        params.put("active", rs.getTimestamp("active").toLocalDateTime());
                        params.put("inactive", null);
                        
                        params.put("badge", badgeDAO.find(rs.getString("badgeid")));
                        params.put("shift", shiftDAO.find(rs.getInt("shiftid")));
                        params.put("department", departmentDAO.find(rs.getInt("departmentid")));
                        
                        employee = new Employee(params);
                        
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
    
    public Employee find(Badge badge) {

        Employee employee = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND_BADGE);
                ps.setString(1, badge.getId());

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();
                    
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        employee = find(id);
                    }

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

   
