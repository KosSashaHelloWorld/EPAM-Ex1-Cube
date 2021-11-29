package edu.kosolobov.shapes.util;

public class UtilGenerator {
    private static long id = 0;

    private UtilGenerator() {
    }

    public static long generateFigureId() {
        return id++;
    }
}
