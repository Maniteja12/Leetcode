package org.example.amazon.parkinglot;

import java.time.LocalTime;

public class Exit {
    private ParkingLot lot;
    public Exit(ParkingLot lot){
        this.lot = lot;
    }
    public void exitVehicle(String lisencePlate){
        Vehicle vehicle = lot.removeVehicle(lisencePlate);
        if(vehicle!= null){
            LocalTime exitTime = LocalTime.now();
            double fee = Payment.calculateFee(vehicle,exitTime);
            Payment.makePayment(fee);
            System.out.println("Vehicle " + lisencePlate + " exited. Fee : $" + fee);
        }else
            System.out.println("Vehicle not found");
    }
}
