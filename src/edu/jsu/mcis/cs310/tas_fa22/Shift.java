package edu.jsu.mcis.cs310.tas_fa22;

import java.util.*;
import java.time.LocalTime;
import java.time.temporal.*;

public class Shift {
    
    private final int id, roundinterval, graceperiod, lunchthreshold, dockpenalty;
    private final int lunchduration, shiftduration;
    private final String description;
    
    private final LocalTime shiftstart, shiftstop, lunchstart, lunchstop;
    
    
    public Shift(Map<String, String> p) {
    
        this.id = Integer.parseInt(p.get("id"));
        this.roundinterval = Integer.parseInt(p.get("roundinterval"));
        this.graceperiod = Integer.parseInt(p.get("graceperiod"));
        this.lunchthreshold = Integer.parseInt(p.get("lunchthreshold"));
        this.dockpenalty = Integer.parseInt(p.get("dockpenalty"));
        
        this.description = p.get("description");
        
        this.shiftstart = LocalTime.parse(p.get("shiftstart"));
        this.shiftstop = LocalTime.parse(p.get("shiftstop"));
        
        this.lunchstart = LocalTime.parse(p.get("lunchstart"));
        this.lunchstop = LocalTime.parse(p.get("lunchstop"));
        
        this.lunchduration = (int)ChronoUnit.MINUTES.between(lunchstart, lunchstop);
        this.shiftduration = (int)ChronoUnit.MINUTES.between(shiftstart, shiftstop);
        
    }

    public int getId() {
        return id;
    }

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
        s.append(" (").append(shiftduration).append(" minutes);");
        s.append(" Lunch: ").append(lunchstart).append(" - ").append(lunchstop);
        s.append(" (" ).append(lunchduration).append(" minutes)");
        
        return(s.toString() );
        
    }
    
}
