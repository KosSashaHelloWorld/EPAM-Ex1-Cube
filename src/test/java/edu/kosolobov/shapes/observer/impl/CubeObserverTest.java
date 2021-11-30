package edu.kosolobov.shapes.observer.impl;

import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.entity.property.impl.CubeProperty;
import edu.kosolobov.shapes.factory.CubeFactory;
import edu.kosolobov.shapes.warehouse.impl.CubeWarehouse;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static edu.kosolobov.shapes.entity.property.impl.CubeProperty.LENGTH;
import static org.junit.jupiter.api.Assertions.*;

class CubeObserverTest {
    private CubeFactory factory = new CubeFactory();

    @Test
    void updateParameters() {
        Cube cube = factory.getCube(10.0);
        CubeWarehouse cw = CubeWarehouse.getInstance();
        CubeObserver observer = new CubeObserver();
        cube.attach(observer);

        long id = cube.getId();
        double area = cube.getService().getArea();
        double volume = cube.getService().getVolume();
        cw.putParameters(cube.getId(), area, volume);

        Map<String, Double> parameters = cube.getProperty().getParameters();
        parameters.replace(LENGTH, 20.0);
        cube.setProperty(new CubeProperty(parameters));

        cube.notifyObservers();
        assertNotEquals(cw.getParameters(id).getArea(), area);
        assertNotEquals(cw.getParameters(id).getVolume(), volume);
    }
}