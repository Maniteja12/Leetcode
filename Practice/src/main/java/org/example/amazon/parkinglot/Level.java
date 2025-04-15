package org.example.amazon.parkinglot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Level {
    private int levelNumber;
    private List<Slot> slots;
    public Level(int levelNumber, int slotCount){
        this.levelNumber = levelNumber;
        this.slots = new ArrayList<>();
        for(int i=0;i<slotCount;i++){
            slots.add(new Slot(i+1));
        }
    }
    public boolean hasAvailableSlot(){
        return slots.stream().anyMatch(slot-> !slot.isOccupied());
    }
    public Slot getAvailableSlot(){
        return slots.stream().filter(slot -> !slot.isOccupied()).findFirst().orElse(null);
    }
    public boolean parkVehicle(Vehicle vehicle){
        Slot slot = getAvailableSlot();
        return slot!= null && slot.park(vehicle);
    }
    public Vehicle removeVehicle(String liscencePlate){
        for(Slot s: slots){
            if(s.isOccupied() && s.getVehicleParked().getLiscencePlate().equals(liscencePlate))
                return s.removeVehicle();
        }
        return null;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
