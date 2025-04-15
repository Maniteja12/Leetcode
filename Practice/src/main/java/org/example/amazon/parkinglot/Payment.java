package org.example.amazon.parkinglot;

import java.time.Duration;
import java.time.LocalTime;

public class Payment {
    private static final double RATE_PER_HOUR=10.0;

    public static double calculateFee(Vehicle vehicle, LocalTime exitTime){
        long hours = Duration.between(vehicle.getTimeOfEntry(), exitTime).toHours();
        hours =  (hours == 0 ? 1: hours);
        double rate = switch (vehicle.getVehicleType()){
            case CAR -> 10.0;
            case BIKE -> 5.0;
            case TRUCK -> 15.0;
        };
        return rate * hours;
    }
    public static void makePayment(double amount){
        System.out.println("Payment of $" + amount + " made succesfully");
    }
}
