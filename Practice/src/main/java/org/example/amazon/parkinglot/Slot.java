package org.example.amazon.parkinglot;

public class Slot {
    private int slotNumber;
    private Vehicle vehicleParked;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
    }
    public boolean isOccupied(){
        return vehicleParked!= null;
    }
    public boolean park(Vehicle vehicle){
        if(isOccupied()) return false;
        this.vehicleParked = vehicle;
        return true;
    }
    public Vehicle removeVehicle(){
        Vehicle v = this.vehicleParked;
        this.vehicleParked = null;
        return v;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }
}
