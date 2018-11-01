package com.epam.geometry.generator;

public class IdGenerator {

    private static IdGenerator instance;
    private static long count = 1;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public long getCount() {
        return count++;
    }
}
