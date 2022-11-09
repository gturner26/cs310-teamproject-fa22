package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.util.*;


public class DepartmentDAO {
    
    private static final String QUERY_FIND = "SELECT * FROM department WHERE id = ?";
    
    private final DAOFactory daoFactory;
    
    DepartmentDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Department find(int id){
        
        Department department = null;
        
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
                        HashMap.put("description", rs.getString("description"));
                        HashMap.put("terminalid", rs.getString("terminalid"));
                        
                        department = new Department(HashMap);
                        
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

        return department;

    }
    

}


