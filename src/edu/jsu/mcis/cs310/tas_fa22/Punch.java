package edu.jsu.mcis.cs310.tas_fa22;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;



public class Punch {
    private Integer id;
    private Integer terminalID;
    private Badge badge;
    private EventType punchtype;
    private PunchAdjustmentType AdjustmentType;
    
    private LocalDateTime originalTimeStamp;
    private LocalDateTime adjustedTimeStamp;
    private LocalDateTime dateTime;
    private int getPunchTypeID;
    
    
    public Punch(Integer terminalid, Badge badge, EventType punchtype){
        this.terminalID = terminalID;
        this.badge = badge;
        this.punchtype = punchtype;
        id = null;
        adjustedTimeStamp = null;
        
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

    public Integer getID() {
        return id;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public PunchAdjustmentType getAdjustmentType() {
        return AdjustmentType;
    }

    public LocalDateTime getAdjustedTimeStamp() {
        return adjustedTimeStamp;
    }

    public EventType getpunchtype() {
        return punchtype;
    }

    public Integer getId() {
        return id;
    }

    public Badge getBadge() {
        return badge;
    }

    public LocalDateTime getOriginalTimeStamp() {
        return originalTimeStamp;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getGetPunchTypeID() {
        return getPunchTypeID;
    }
    
    public void adjust(Shift s){
        
    
    }
    
    
    
    public StringBuilder printOriginal(){
        StringBuilder string = new StringBuilder();
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        if(this.getPunchTypeID == 1){
            string.append("#" + this.getPunchTypeID + " CLOCKED IN: " +
                formatter.format(LocalDateTime.now()).toUpperCase());
        }
        
        if(this.getPunchTypeID == 0){
            string.append("#" + this.getPunchTypeID + " CLOCKED OUT: " +
                formatter.format(LocalDateTime.now()).toUpperCase());
        }
        
       //after code is finished, add a return statement to fix issue
        return string;
    } 
    
    
    
    
    
}
