package org.example.amazon.locker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class LockerManager {
    private final Map<PackageSize, List<Locker>> lockers;

    public LockerManager() {
        lockers = new HashMap<>();
        for(PackageSize size: PackageSize.values()){
            lockers.put(size, new ArrayList<>());
        }
    }
    public void addLocker(Locker locker){
        lockers.get(locker.getSize()).add(locker);
    }
    public Locker findAvailableLocker(Package pkg){
        for(PackageSize size : PackageSize.values()){
            if(pkg.getSize().canFitInto(size)){
                for(Locker locker: lockers.get(size)){
                    if(locker.canFit(pkg))
                        return locker;
                }
            }
        }
        return null;
    }
    public String storePackage(Package pkg){
        Locker locker = findAvailableLocker(pkg);
        if(locker!= null && locker.storePackage(pkg))
            return locker.getLocekrId();
        return "No available locker for package " + pkg.getPackageId();
    }
    public Package retrievePackage(String lockerId){
        for(List<Locker> lockerList: lockers.values()){
            for(Locker locker : lockerList){
                if(locker.getLocekrId().equals(lockerId))
                    return locker.retrievePackage();
            }
        }
        return null;
    }
}
