package org.example.amazon.locker;

public class Locker {
    private String locekrId;
    private PackageSize size;
    private Package storedPackage;

    public Locker(String locekrId, PackageSize size) {
        this.locekrId = locekrId;
        this.size = size;
    }
    public boolean isAvailable(){
        return storedPackage == null;
    }
    public boolean canFit(Package pkg){
        return isAvailable() && pkg.getSize().canFitInto(size);
    }
    public boolean storePackage(Package pkg){
        if(canFit(pkg)){
            this.storedPackage=pkg;
            return true;
        }
        return false;
    }
    public Package retrievePackage(){
        Package pkg = this.storedPackage;
        this.storedPackage = null;
        return pkg;
    }

    public String getLocekrId() {
        return locekrId;
    }

    public PackageSize getSize() {
        return size;
    }
}
