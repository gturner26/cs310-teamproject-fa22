package edu.jsu.mcis.cs310.tas_fa22;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;



public class Punch {
    private Integer id;
    private Integer terminalID;
    private Badge badge;
    private EventType punchtype;
    private String AdjustmentType;
    
    private LocalDateTime originalTimeStamp;
    private LocalDateTime adjustedTimeStamp;
    private LocalDateTime dateTime;
    private int getPunchTypeID;
    
    
    public Punch(Integer terminalid, Badge badge, EventType punchtype){
        this.terminalID = terminalID;
        this.badge = badge;
        this.punchtype = punchtype;
        
        
    }
    
    public Punch(Integer id, int terminalid, Badge badge, LocalDateTime orginalTimeStamp, EventType punchtype){
        this.terminalID = terminalID;
        this.badge = badge;
        this.punchtype = punchtype;
        this.originalTimeStamp = LocalDateTime.now();
        this.adjustedTimeStamp = null;
        
    }
//New Punch will add id and timestamp as arguments
    
    public Integer getTerminalID() {
        return terminalID;
    }

    public Badge getBadgeID() {
        return badge;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public String getAdjustmentType() {
        return AdjustmentType;
    }

    public LocalDateTime getAdjustedTimeStamp() {
        return adjustedTimeStamp;
    }

    public LocalDateTime getOriginalTimeStamp() {
        return originalTimeStamp;
    }

    public EventType getPunchType() {
        return punchtype;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    
    
    public String printOriginal(){
        StringBuilder string = new StringBuilder();
        

        
        LocalDateTime calendar = null;
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        if(this.getPunchTypeID == 1){
            string.append("#" + this.getBadgeID() + " CLOCKED IN: " + formatter.format(calendar).toUpperCase());
        }
        
       //after code is finished, add a return statement to fix issue
    } 
    
    
    
    
}
