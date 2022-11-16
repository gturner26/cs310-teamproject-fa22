package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDateTime;

public class PunchDAO {
        
 private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";
 private static final String QUERY_LIST = "SELECT * FROM event WHERE badgeid = ? ORDER BY timestamp";
 private static final String QUERY_CREATE = "INSERT INTO event (badgeid, originaltimestamp, terminalid, eventtypeid) VALUES (?,?,?,?)";

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
                    
                    while (rs.next()) {
                        
                        int terminalid = rs.getInt("terminalid");
                        
                        String badgeid = rs.getString("badgeid");
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        Badge b = badgeDAO.find(badgeid);
                        
                        EventType eventtype = EventType.values()[rs.getInt("eventtypeid")];
                        LocalDateTime originaltimestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                        punch = new Punch(id, terminalid, b, originaltimestamp, eventtype);
                        
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

    public Integer create(Punch p){
        //getBadge()
        //getOriginaltimestamp()
        //getTerminalid()
        //getPunchtype()
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int key = 0, result = 0;
        
        try{
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)){
                ResultSet keys;

                ps = conn.prepareStatement(QUERY_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                
                boolean hasresults = ps.execute();
                
                if (hasresults) {
                    
                    
                    ps.setString(1, badgeid);
                    ps.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(originaltimestamp.getTime()));
                    ps.setInt(3, 101);
                    ps.setInt(4, 1);
                    
                    result = ps.executeUpdate();
                    if (result == 1) {
                        keys = ps.getGeneratedKeys();
                    if (keys.next()) { key = keys.getInt(1); }
                    }
                }
            }
            
        }
        catch (Exception e) {
            
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