package edu.jsu.mcis.cs310.tas_fa22;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class Punch {
    private Integer TerminalID;
    private String badgeID;
    private EventType punchtype;
    private String AdjustmentType;
    private long adjustedTimeStamp;
    private long ogTime;
    private Integer punchTypeID;
    
    
    public Punch(Integer TerminalID, Badge badge, EventType punchtype){
        this.TerminalID = TerminalID;
        this.badgeID = badge.getId();
        this.punchtype = punchtype;
        
        
        //AdjustmentType = null;
        //id needs to be null
        this.adjustedTimeStamp = 0;
        
    }

    public Integer getTerminalID() {
        return TerminalID;
    }

    public String getBadgeID() {
        return badgeID;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public String getAdjustmentType() {
        return AdjustmentType;
    }

    public long getAdjustedTimeStamp() {
        return adjustedTimeStamp;
    }

    public long getOgTime() {
        return ogTime;
    }

    public Integer getPunchTypeID() {
        return punchTypeID;
    }
    
    
    public String printOriginal(){
        StringBuilder string = new StringBuilder();
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(this.ogTime);
        
        Date date = calendar.getTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss");
        
        if(this.getPunchTypeID() == 1){
            string.append("#" + this.getBadgeID() + " CLOCKED IN: " + formatter.format(date).toUpperCase());
        }
        
       //after code is finished, add a return statement to fix issue
    }
    
    
    
    
}
