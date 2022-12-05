package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import java.time.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;



public class PunchListRangeTest {
    private DAOFactory daoFactory;



   @Before
    public void setup() {



       daoFactory = new DAOFactory("tas.jdbc");



   }



   @Test
    public void PunchListRangeTest1(){
        
    }
        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();


       /* Create StringBuilders for Test Output */
        
        StringBuilder s1 = new StringBuilder();
        
        /* Create Timestamp and Badge Objects for Punch List */
        
        LocalDate ts = LocalDate.of(2018, Month.SEPTEMBER, 17);



       Badge b = badgeDAO.find("67637925");



       /* Retrieve Punch List #1 (created by DAO) */
        
        ArrayList<Punch> p1 = punchDAO.list(b, ts);
        
        /* Export Punch List #1 Contents to StringBuilder */
        
        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }



   }
