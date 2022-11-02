package edu.jsu.mcis.cs310.tas_fa22;

import java.time.Duration;
import java.util.*;
import java.time.LocalTime;
import java.time.temporal.*;

public class Shift {
    
    private final int id;
    //private final int roundinterval, graceperiod, lunchthreshold, dockpenalty;
    //private final int lunchduration, shiftduration;
    private final String description;
    private final long lunchtime, shifttime;
    
    private final LocalTime shiftstart, shiftstop, lunchstart, lunchstop;
    
    
    public Shift(HashMap map) {
        this.id = Integer.parseInt((String)map.get("id"));
        this.description = map.get("description").toString();
        this.shiftstart = LocalTime.parse((String)map.get("shiftstart"));
        this.shiftstop = LocalTime.parse((String)map.get("shiftstop"));
        this.lunchstart = LocalTime.parse((String)map.get("lunchstart"));
        this.lunchstop = LocalTime.parse((String)map.get("lunchStop"));
        this.lunchtime = Duration.between(lunchstart, lunchstop).toMinutes();
        this.shifttime = Duration.between(shiftstart, shiftstop).toMinutes();
    }


    public int getId() {
        return id;
    }
/*
    public int getRoundinterval() {
        return roundinterval;
    }

    public int getGraceperiod() {
        return graceperiod;
    }

    public int getLunchthreshold() {
        return lunchthreshold;
    }

    public int getDockpenalty() {
        return dockpenalty;
    }

    public int getLunchduration() {
        return lunchduration;
    }

    public int getShiftduration() {
        return shiftduration;
    }
*/
    public String getDescription() {
        return description;
    }

    public LocalTime getShiftstart() {
        return shiftstart;
    }

    public LocalTime getShiftstop() {
        return shiftstop;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }
    
    @Override
    public String toString(){
        
        StringBuilder s = new StringBuilder();
        
        s.append(description).append(": ").append(shiftstart).append(" - ").append(shiftstop);
        s.append(" (").append(shifttime).append(" minutes);");
        s.append(" Lunch: ").append(lunchstart).append(" - ").append(lunchstop);
        s.append(" (" ).append(lunchtime).append(" minutes)");
        
        return(s.toString() );
        
    }
    
}
