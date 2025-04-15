package org.example.amazon.locker;

public class Package {
    private String packageId;
    private PackageSize size;

    public Package(String packageId, PackageSize size) {
        this.packageId = packageId;
        this.size = size;
    }
    public String getPackageId() {
        return packageId;
    }
    public PackageSize getSize() {
        return size;
    }
}
