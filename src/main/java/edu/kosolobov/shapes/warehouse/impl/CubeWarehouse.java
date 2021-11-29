package edu.kosolobov.shapes.warehouse.impl;

import edu.kosolobov.shapes.warehouse.CubeParameters;
import edu.kosolobov.shapes.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse implements Warehouse {
    private static final Logger log = LogManager.getLogger(CubeWarehouse.class);
    private static final CubeWarehouse instance = new CubeWarehouse();
    private final Map<Integer, CubeParameters> storage = new HashMap<>();

    private CubeWarehouse() {}

    public static CubeWarehouse getInstance() {
        return instance;
    }

    @Override
    public void putParameters(int id, double area, double volume) {
        CubeParameters parameters = new CubeParameters(area, volume);
        storage.put(id, parameters);
        log.log(Level.INFO, "{} added to warehouse", parameters);
    }

    @Override
    public CubeParameters getParameters(int id) {
        return storage.get(id);
    }

    @Override
    public void updateParameters(int id, double newArea, double newVolume) {
        storage.get(id).setArea(newArea);
        storage.get(id).setVolume(newVolume);
        log.log(Level.INFO, "Parameters with id={} were updated to {}", id, storage.get(id));
    }

    @Override
    public boolean hasParameters(int id) {
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
        return String.format("CubeWarehouse{size:%d}", size());
    }
}
