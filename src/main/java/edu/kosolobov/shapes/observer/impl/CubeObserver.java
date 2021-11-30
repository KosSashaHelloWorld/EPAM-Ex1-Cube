package edu.kosolobov.shapes.observer.impl;

import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.observer.FigureEvent;
import edu.kosolobov.shapes.observer.FigureObserver;
import edu.kosolobov.shapes.service.FigureService;
import edu.kosolobov.shapes.service.impl.CubeService;
import edu.kosolobov.shapes.warehouse.Warehouse;
import edu.kosolobov.shapes.warehouse.impl.CubeWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements FigureObserver {
    private static final Logger log = LogManager.getLogger(CubeObserver.class);

    @Override
    public void updateParameters(FigureEvent event) {
        Cube cube = (Cube) event.getSource();
        int id = (int) cube.getId();
        Warehouse warehouse = CubeWarehouse.getInstance();
        FigureService service = new CubeService(cube);
        double area = service.getArea();
        double volume = service.getVolume();
        warehouse.updateParameters(id, area, volume);
        log.log(Level.INFO, "Observer updated parameters of {} in {}", cube, warehouse);
    }
}
