package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.util.*;

public class ShiftDAO {
    
    private static final String QUERY_FIND = "SELECT * FROM shift WHERE id = ?";
    private static final String QUERY_BADGE = "SELECT * FROM employee WHERE badgeid = ?";
    
    private final DAOFactory daoFactory;
    
    ShiftDAO(DAOFactory daoFactory){
        
        this.daoFactory = daoFactory;
        
    } 
    
    public Shift find(int id){
        
        Shift shift = null;
        
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
                        HashMap.put("shiftstart", rs.getString("shiftstart"));
                        HashMap.put("shiftstop", rs.getString("shiftstop"));
                        HashMap.put("lunchstart", rs.getString("lunchstart"));
                        HashMap.put("lunchstop", rs.getString("lunchstop"));
                        HashMap.put("roundinterval", rs.getString("roundinterval"));
                        HashMap.put("graceperiod", rs.getString("graceperiod"));
                        HashMap.put("dockpenalty", rs.getString("dockpenalty"));
                        HashMap.put("lunchthreshold", rs.getString("lunchthreshold"));
                        
                        shift = new Shift(HashMap);
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

        return shift;

    }
    
    public Shift find(Badge badge) {
        Shift shift = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_BADGE);
                ps.setString(1, badge.getId());

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();
                    rs.next();
                    int shiftid = rs.getInt("shiftid");
                    shift = find(shiftid);

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

        return shift;
    }
}

   
