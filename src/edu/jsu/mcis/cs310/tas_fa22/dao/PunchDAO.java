package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;

public class PunchDAO {
        
    private static final String QUERY_FIND = "words";
    
    private final DAOFactory daoFactory;
    
    PunchDAO(DAOFactory daofactory) {
        
        this.daoFactory = daoFactory;
    } 
}
