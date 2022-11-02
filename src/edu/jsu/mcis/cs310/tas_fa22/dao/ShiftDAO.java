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
                        
                        Hashmap<String, String> HashMap = new map<>();
                        hashmap.put("id", rs.getString("id"));
                        hashmap.put("description", rs.getString("description"));
                        hashmap.put("startTime", rs.getString("shiftstart"));
                        hashmap.put("stopTime", rs.getString("shiftstop"));
                        hashmap.put("lunchStart", rs.getString("lunchstart"));
                        hashmap.put("lunchStop", rs.getString("lunchstop"));
                        shift = new Shift(hashmap);
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

   
