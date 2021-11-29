package edu.kosolobov.shapes.warehouse.impl;

import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import edu.kosolobov.shapes.service.CubeService;
import edu.kosolobov.shapes.warehouse.CubeParameters;
import edu.kosolobov.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeWarehouseTest {
    private static final Warehouse warehouse = CubeWarehouse.getInstance();
    private static final CubeService service = new CubeService();
    private static final CubeFactory factory = new CubeFactory();
    private static final int id = 0;

    @BeforeAll
    @Test
    static void getInstance() {
        assertNotNull(warehouse);
    }

    @Test
    void putParameters() {
        Cube cube = factory.getCube(10.0);
        double area = service.calcArea(cube);
        double volume = service.calcVolume(cube);
        warehouse.putParameters(id, area, volume);
        assertTrue(warehouse.hasParameters(id));
    }

    @Test
    void getParameters() {
        CubeParameters parameters = warehouse.getParameters(id);
        assertFalse(parameters.isEmpty());
    }

    @AfterAll
    @Test
    static void updateParameters() {
        Cube cube = factory.getCube(20.0);
        double area = service.calcArea(cube);
        double volume = service.calcVolume(cube);
        warehouse.updateParameters(id, area, volume);
        CubeParameters parameters = warehouse.getParameters(id);
        assertTrue(parameters.getArea() == area && parameters.getVolume() == volume);
    }
}