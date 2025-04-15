package org.example.amazon.parkinglot;

public class Dashboard {
    private ParkingLot lot;
    public Dashboard(ParkingLot lot){
        this.lot = lot;
    }
    public void showStatus(){
        System.out.println("\n Parking Lot Status");
        for(Level level: lot.getLevels()){
            long total = level.getSlots().size();
            long occupied = level.getSlots().stream().filter(Slot::isOccupied).count();
            System.out.printf("Level %d: Total = %d | Occupied = %d | Free = %d\n",
                    level.getLevelNumber(), total, occupied, total-occupied);
        }
    }
}
