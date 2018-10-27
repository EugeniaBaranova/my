package com.epam.geometry.generator;

public class IDGenerator {

    private static IDGenerator instance;
    private long count = 1;

    private IDGenerator() {
    }

    public static IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public long getCount() {
        return count++;
    }
}
