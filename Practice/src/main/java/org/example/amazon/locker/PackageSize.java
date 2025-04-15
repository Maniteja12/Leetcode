package org.example.amazon.locker;

public enum PackageSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int value;

    PackageSize(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public boolean canFitInto(PackageSize lockerSize){
        return this.value <= lockerSize.value;
    }
}
