package org.example.amazon.locker;

public class Main {
    public static void main(String[] args) {
        LockerManager manager = new LockerManager();

        // Add lockers
        manager.addLocker(new Locker("L1", PackageSize.SMALL));
        manager.addLocker(new Locker("L2", PackageSize.MEDIUM));
        manager.addLocker(new Locker("L3", PackageSize.LARGE));

        // Create packages
        Package smallPackage = new Package("PKG1", PackageSize.SMALL);
        Package largePackage = new Package("PKG2", PackageSize.LARGE);

        // Store packages
        System.out.println("Stored small package in: " + manager.storePackage(smallPackage));
        System.out.println("Stored large package in: " + manager.storePackage(largePackage));

        // Retrieve
        Package retrieved = manager.retrievePackage("L1");
        if (retrieved != null) {
            System.out.println("Retrieved from L1: " + retrieved.getPackageId());
        } else {
            System.out.println("Locker L1 is empty.");
        }
    }
}

