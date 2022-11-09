package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PunchDAO {
        
 private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";
 private static final String QUERY_LIST = "SELECT * FROM event WHERE badgeid = ? ORDER BY timestamp";

    private final DAOFactory daoFactory;
    
    PunchDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Punch find(Integer id){
        
        Punch punch = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)){
                
                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, Integer.toString(id));
                
                boolean hasresults = ps.execute();
                
                if (hasresults) {
                    
                    rs = ps.getResultSet();
                    
                    while (rs.next()){
                        
                        Integer terminalid;
                        String badgeid;
                        EventType punchtype;
                        LocalDateTime originaltimestamp;
                        
                        terminalid = rs.getInt("terminalid");
                        
                        badgeid = rs.getString("badgeid");
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        Badge b = badgeDAO.find(badgeid);
                        
                        punchtype = EventType.values()[rs.getInt("eventtypeid")];
                        originaltimestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                        punch = new Punch(id, terminalid, b, originaltimestamp, punchtype);
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
