package edu.kosolobov.shapes.service;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CubeServiceTest {
    static CubeService cubeService = new CubeService();
    static CubeFactory factory = new CubeFactory();
    static Cube cube = factory.getCube(10.0);
    static List<Cube> cubes;
    static String filePath = "files/example.txt";

    @BeforeAll
    static void init() {
        cubes = factory.getCubes(filePath);
    }

    @Test
    void calcArea() {
        assertEquals(600.0, cubeService.calcArea(cube));
    }

    @Test
    void calcVolume() {
        assertEquals(1000.0, cubeService.calcVolume(cube));
    }

    @Test
    void isOnCoordinatePlane() {
        assertTrue(cubeService.isOnCoordinatePlane(cube));
        assertFalse(cubeService.isOnCoordinatePlane(cubes.get(1)));
    }

    @Test
    void isCube() {
        Figure figure = factory.getCube(cube.getProperty());
        assertTrue(cubeService.isCube(figure));
    }

    @Test
    void dividedVolumesRelation() {
        Map<String, Double> map = cubeService.dividedVolumesRelation(factory.getCubes("files/CubeLabTestCubes.txt").get(0));
        assertEquals(1.0, map.get("byPlaneXY"));
        assertEquals(1.0, map.get("byPlaneXZ"));
        assertEquals(1.0, map.get("byPlaneYZ"));
    }
}