package edu.kosolobov.util;

public class UtilGenerator {
    private static long ID = 0;


    public static long GenerateFigureId() {
        return ID++;
    }
}
