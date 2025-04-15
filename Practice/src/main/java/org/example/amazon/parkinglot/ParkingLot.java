package org.example.amazon.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    public ParkingLot(int numberOfLevels, int slotsPerLevel){
        this.levels = new ArrayList<>();
        for(int i=0;i<numberOfLevels;i++){
            levels.add(new Level(i+1,slotsPerLevel));
        }
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.hasAvailableSlot())
                return level.parkVehicle(vehicle);
        }
        return false;
    }
    public Vehicle removeVehicle(String plateNumber){
        for(Level level : levels){
            Vehicle v = level.removeVehicle(plateNumber);
            if(v!= null)
                return v;
        }
        return null;
    }

    public List<Level> getLevels() {
        return levels;
    }
}
