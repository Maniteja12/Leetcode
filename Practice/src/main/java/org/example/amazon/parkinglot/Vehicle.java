package org.example.amazon.parkinglot;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Vehicle {
    private String liscencePlate;
    private VehicleType vehicleType;
    private LocalDateTime timeOfEntry;

    public Vehicle(String liscencePlate, VehicleType vehicleType) {
        this.liscencePlate = liscencePlate;
        this.vehicleType = vehicleType;
        this.timeOfEntry = LocalDateTime.now();
    }

    public String getLiscencePlate() {
        return liscencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }
}
