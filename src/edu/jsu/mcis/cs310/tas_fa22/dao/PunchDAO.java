package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;

public class PunchDAO {
        
    private static final String QUERY_FIND = "words";
    
    private final DAOFactory daoFactory;
    
    PunchDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Punch find(String id){
        
        Punch punch = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)){
                
                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, id);
                
                boolean hasresults = ps.execute();
                
                if (hasresults) {
                    
                    rs = ps.getResultSet();
                    
                    while (rs.next()){
                        
                        String description = rs.getString("description");
                        punch = new Punch(badge, punchtype);
                        
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
        
        return punch;
    }
}
