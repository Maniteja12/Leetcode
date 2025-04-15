package org.example.amazon.parkinglot;

public class Entrance {
    private ParkingLot parkingLot;

    public Entrance(ParkingLot lot){
        this.parkingLot = lot;
    }
    public void enterVehicle(Vehicle vehicle){
        boolean success = parkingLot.parkVehicle(vehicle);
        if(success)
            System.out.println("Vehicle " + vehicle.getLiscencePlate() + " parked successfully");
        else
            System.out.println("Parking is full for vehicle "+ vehicle.getLiscencePlate());
    }
}
