package org.example.amazon.unixfilesystem;

public class SizeFilter implements Filter{
    private String operator;
    private int size;

    public SizeFilter(String operator, int size) {
        this.operator = operator;
        this.size = size;
    }

    @Override
    public boolean match(File file) {
        switch (operator){
            case ">":
                return file.getSize() > size;
            case ">=":
                return file.getSize() >= size;
            case "<":
                return file.getSize() < size;
            case "<=":
                return file.getSize() <= size;
            case "==":
                return file.getSize() == size;
            default:
                return false;
        }
    }
}
