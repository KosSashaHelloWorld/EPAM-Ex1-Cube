package edu.kosolobov.shapes.warehouse;

public interface Warehouse {
    static Warehouse getInstance() {
        return null;
    }

    void putParameters(int id, double area, double volume);

    CubeParameters getParameters(int id);

    void updateParameters(int id, double newArea, double newVolume);

    boolean hasParameters(int id);

    int size();
}
