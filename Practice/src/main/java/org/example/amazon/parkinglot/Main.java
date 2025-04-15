package org.example.amazon.parkinglot;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot(2, 3);
        Entrance entrance = new Entrance(lot);
        Exit exit = new Exit(lot);
        Dashboard dashboard = new Dashboard(lot);

        Vehicle car = new Vehicle("CAR123", VehicleType.CAR);
        Vehicle bike = new Vehicle("BIKE456", VehicleType.BIKE);
        Vehicle truck = new Vehicle("TRUCK789", VehicleType.TRUCK);

        entrance.enterVehicle(car);
        entrance.enterVehicle(bike);
        entrance.enterVehicle(truck);

        dashboard.showStatus();

        Thread.sleep(2000); // simulate time passing

        exit.exitVehicle("BIKE456");

        dashboard.showStatus();
    }
}
