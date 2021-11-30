package edu.kosolobov.shapes.warehouse;

import edu.kosolobov.shapes.warehouse.impl.FigureWarehouse;

public interface Warehouse {
    static Warehouse getInstance() {
        return FigureWarehouse.getInstance();
    }

    void putParameters(long id, double area, double volume);

    Parameters getParameters(long id);

    void updateParameters(long id, double newArea, double newVolume);

    boolean hasParameters(long id);

    int size();
}
