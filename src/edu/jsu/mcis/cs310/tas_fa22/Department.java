
package edu.jsu.mcis.cs310.tas_fa22;

import java.util.*;

public class Department {
    private final int id;
    private final int terminalID;
    private final String description;
    
    
    public Department(HashMap map){
        this.id = Integer.parseInt((String)map.get("id"));
        this.description = map.get("description").toString();
        this.terminalID = Integer.parseInt((String)map.get("terminalID"));
    }
    
    public Integer getTerminalID() {
        return terminalID;
    }

    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        
        StringBuilder s = new StringBuilder();
        
        s.append(description).append(": ");
        s.append(id).append(id);
        s.append(terminalID).append(terminalID);

        return(s.toString() );
        
    }

}
