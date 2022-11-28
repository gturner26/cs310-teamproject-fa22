//Zach is here and able to edit
//WIlliam was here
//Georgia wuz here!!
//My name is Amelia and I like Chinese food.
//Ethan was here
//Test Test
package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.json.simple.*;

public class Main {

    public static void main(String[] args) {
        
        BigDecimal o1 = new BigDecimal("0.1");
        BigDecimal o2 = new BigDecimal("0.2");
        
        System.out.println(o1.add(o2));
        
        /*// test database connectivity; get DAOs

        DAOFactory daoFactory = new DAOFactory("tas.jdbc");
        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        
        // find badge

        Badge b = badgeDAO.find("31A25435");
        
        // output should be "Test Badge: #31A25435 (Munday, Paul J)"
        
        System.err.println("Test Badge: " + b.toString());*/

        
    }
    public enum EmployeeType {
       PART_TIME("Temporary / Part-Time"),
       FULL_TIME("Full-Time");
       private final String description;
       private EmployeeType(String d) {
          description = d;
       }
       @Override
       public String toString() {
          return description;
       }
    }
}
