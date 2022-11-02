package edu.jsu.mcis.cs310.tas_fa22;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;



public class Punch {
    private Integer id, terminalID, getPunchTypeID;
    private Badge badge;
    private EventType punchtype;
    private PunchAdjustmentType AdjustmentType;
    private LocalDateTime originalTimeStamp, dateTime, adjustedTimeStamp;
    private String description;
   
    
    public Punch(Integer terminalid, Badge badge, EventType punchtype){
        this.id = null;
        this.terminalID = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;  
    }
    
    public Punch(Integer id, int terminalid, Badge badge, LocalDateTime orginalTimeStamp, EventType punchtype){
        this.id = id;
        this.terminalID = terminalID;
        this.badge = badge;
        this.punchtype = punchtype;
        this.originalTimeStamp = originalTimeStamp;
        
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

    public int getPunchTypeID() {
        return getPunchTypeID;
    }
    public String getdescription(){
        return description;
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
    }}