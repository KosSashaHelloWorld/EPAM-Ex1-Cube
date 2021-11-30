package edu.kosolobov.shapes.warehouse.impl;

import edu.kosolobov.shapes.warehouse.Warehouse;
import edu.kosolobov.shapes.warehouse.parameters.FigureParameters;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class FigureWarehouse implements Warehouse {
    private static final Logger log = LogManager.getLogger(FigureWarehouse.class);
    private static final FigureWarehouse instance = new FigureWarehouse();
    private final Map<Long, FigureParameters> storage = new HashMap<>();
    private FigureWarehouse() {
    }

    public static FigureWarehouse getInstance() {
        return instance;
    }

    @Override
    public void putParameters(long id, double area, double volume) {
        FigureParameters parameters = new FigureParameters(area, volume);
        storage.put(id, parameters);
        log.log(Level.INFO, "{} added to warehouse", parameters);
    }

    @Override
    public FigureParameters getParameters(long id) {
        return storage.get(id);
    }

    @Override
    public void updateParameters(long id, double newArea, double newVolume) {
        storage.get(id).setArea(newArea);
        storage.get(id).setVolume(newVolume);
        log.log(Level.INFO, "Parameters with id={} were updated to {}", id, storage.get(id));
    }

    @Override
    public boolean hasParameters(long id) {
        if (storage.isEmpty()) {
            log.log(Level.ERROR, "Storage is empty");
            return false;
        } else if (storage.get(id) == null) {
            log.log(Level.ERROR, "There is no parameters with id = {}", id);
            return false;
        } else if (storage.get(id).isEmpty()) {
            log.log(Level.WARN, "{} is empty", storage.get(id));
        }

        return true;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public String toString() {
        return String.format("FigureWarehouse{size:%d}", size());
    }
}
