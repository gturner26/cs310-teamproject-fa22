
package edu.jsu.mcis.cs310.tas_fa22;

import java.util.*;

public class Department {
    
    private final int id;
    private final int terminalid;
    private final String description;
    
    public Department(Map map) {
        
        this.id = Integer.parseInt((String)map.get("id"));
        this.terminalid = Integer.parseInt((String)map.get("terminalid"));
        this.description = map.get("description").toString();

    }

    public int getId() {
        return id;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        
        // "#1 (Assembly), Terminal ID: 103"
        
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(id);
        s.append(" (").append(description).append("), Terminal ID: ");
        s.append(terminalid);

        return s.toString();
        
    }

}
