package edu.jsu.mcis.cs310.tas_fa22;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Punch {
    
    private final Integer id, terminalid;
    private final Badge badge;
    private final EventType eventtype;
    private final LocalDateTime originaltimestamp;
    
    private LocalDateTime adjustedtimestamp;
    private PunchAdjustmentType adjustmenttype;
    
    public Punch(Integer terminalid, Badge badge, EventType eventtype) {
        
        this.id = null;
        this.terminalid = terminalid;
        this.badge = badge;
        this.eventtype = eventtype;
        this.originaltimestamp = LocalDateTime.now().withNano(0);
        
    }
    
    public Punch(Integer id, int terminalid, Badge badge, LocalDateTime timestamp, EventType punchtype) {
        
        this.id = id;
        this.terminalid = terminalid;
        this.badge = badge;
        this.eventtype = punchtype;
        this.originaltimestamp = timestamp;
        
    }

    public int getId() {
        return id;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public Badge getBadge() {
        return badge;
    }

    public EventType getPunchtype() {
        return eventtype;
    }

    public LocalDateTime getOriginaltimestamp() {
        return originaltimestamp;
    }

    public LocalDateTime getAdjustedtimestamp() {
        return adjustedtimestamp;
    }

    public PunchAdjustmentType getAdjustmenttype() {
        return adjustmenttype;
    }
    
    
    
    
    public void adjust(Shift s) {
        
        //s.getLunchstart(); 
    
    }

    @Override
    public String toString() {
        return printOriginal();
    }
    
    public String printOriginal() {
        
        // "#D2C39273 CLOCK IN: WED 09/05/2018 07:00:07"
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(badge.getId()).append(' ').append(eventtype);
        s.append(": ").append(dtf.format(originaltimestamp).toUpperCase());
        
        return s.toString().trim();
        
    }
    
    public String printAdjusted() {
        
        // "#28DC3FB8 CLOCK IN: FRI 09/07/2018 07:00:00 (Shift Start)"
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(badge.getId()).append(' ').append(eventtype);
        s.append(": ").append(dtf.format(adjustedtimestamp).toUpperCase());
        s.append(" (").append(adjustmenttype).append(')');
        
        return s.toString().trim();
        
    }
    
    
    
}
