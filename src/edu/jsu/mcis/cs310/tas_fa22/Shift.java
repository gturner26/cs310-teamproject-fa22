package edu.jsu.mcis.cs310.tas_fa22;

import java.util.*;
import java.time.LocalTime;
import java.time.temporal.*;

public class Shift {
    
    private int id;
    private int interval;
    private int graceperiod;
    private int lunchdeduct;
    private int dock;
    private int lunchduration;
    private int shiftduration;
    
    private String description;
    
    private LocalTime start;
    private LocalTime stop;
    private LocalTime lunchstart;
    private LocalTime lunchstop;
    
    
    public Shift(int id, int interval,int graceperiod,int lunchdeduct,int dock,int lunchduration,int shiftduration,String description,String start,String stop,String lunchstop,String lunchstart){
    
        this.id = id;
        this.interval = interval;
        this.graceperiod = graceperiod;
        this.lunchdeduct = lunchdeduct;
        this.dock = dock;
        this.lunchduration = lunchduration;
        this.shiftduration = shiftduration;
        
        this.description = description;
        
        this.start = LocalTime.parse(start);
        this.stop = LocalTime.parse(stop);
        
        this.lunchstop = LocalTime.parse(lunchstop);
        this.lunchstart = LocalTime.parse(lunchstart);
        
        GregorianCalendar stopCalendar = new GregorianCalendar();
        GregorianCalendar startCalendar = new GregorianCalendar();
        
        stopCalendar.set(0,0,0, this.lunchstop.getHour(),this.lunchstop.getMinute(), this.lunchstop.getSecond());
        startCalendar.set(0,0,0, this.lunchstart.getHour(),this.lunchstart.getMinute(), this.lunchstart.getSecond());
        
        this.lunchduration = (int) (stopCalendar.getTimeInMillis() - startCalendar.getTimeInMillis());
        this.lunchduration = this.lunchduration/60000;
        this.lunchdeduct = lunchdeduct;
    }
     
    public int getId(){
        return id;
    }
    public int getInterval(){
        return interval;
    }
    public int getGraceperiod(){
        return graceperiod;
    }
    public int getLunchdeduct(){
        return lunchdeduct;
    }
    public int geDock(){
        return dock;
    }
    public int getLunchduration(){
        return lunchduration;
    }
    public int getShiftduration(){
        return shiftduration;
    }
    public String getDescription(){
        return description;
    }
    public LocalTime getStart(){
        return start;
    }
    public LocalTime getStop(){
        return stop;
    }
    public LocalTime getLunchstop(){
        return lunchstop;
    }
    public LocalTime getLunchstart(){
        return lunchstart;
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append(description).append(": ").append(start).append(" - ").append(stop);
        s.append(" (").append(start.until(stop, ChronoUnit.MINUTES)).append(" minutes);");
        s.append(" Lunch: ").append(lunchstart).append(" - ").append(lunchstop);
        s.append(" (" ).append(lunchstart.until(lunchstop, ChronoUnit.MINUTES)).append(" minutes)");
        
        return(s.toString() );
    }
}
