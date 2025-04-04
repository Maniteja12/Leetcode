package org.example.amazon.unixfilesystem;

public interface Filter {
    public abstract boolean match(File file);
}
