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
    
    
    public Punch(Integer terminalID, Badge badge, EventType punchtype){
        this.terminalID = terminalID;
        this.badge = badge;
        this.punchtype = punchtype;
        this.id = null;
        this.originalTimeStamp = LocalDateTime.now();
        this.adjustedTimeStamp = null;
        
    }
//New Punch will add id and timestamp as arguments
    
    public Integer getTerminalID() {
        return terminalID;
    }

    public Integer getID() {
        return id;
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

    public EventType getpunchtype() {
        return punchtype;
    }

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime;
    }
    
    
    
    public String printOriginal(){
        StringBuilder string = new StringBuilder();
        
        LocalDateTime calendar = new LocalDateTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        if(this.getPunchTypeID() == 1){
            string.append("#" + this.getBadgeID() + " CLOCKED IN: " + formatter.format(date).toUpperCase());
        }
        
       //after code is finished, add a return statement to fix issue
    }
    
    
    
    
}
