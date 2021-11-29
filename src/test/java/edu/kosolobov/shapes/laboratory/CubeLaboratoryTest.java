package edu.kosolobov.shapes.laboratory;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CubeLaboratoryTest {
    static CubeLaboratory lab = new CubeLaboratory();
    static CubeFactory factory = new CubeFactory();
    static Cube cube = factory.getCube(10.0);
    static List<Cube> cubes;
    static String filePath = "files/example.txt";

    @BeforeAll
    static void init() {
        cubes = factory.getCubes(filePath);
    }

    @Test
    void setCubeGetCube() {
        lab.setCube(cube);
        Assertions.assertEquals(lab.getCube(), cube);
    }

    @Test
    void calcArea() {
        assertEquals(600.0, lab.calcArea(cube));
    }

    @Test
    void calcVolume() {
        assertEquals(1000.0, lab.calcVolume(cube));
    }

    @Test
    void isOnCoordinatePlane() {
        assertTrue(lab.isOnCoordinatePlane(cube));
        assertFalse(lab.isOnCoordinatePlane(cubes.get(1)));
    }

    @Test
    void isCube() {
        Figure figure = factory.getCube(cube.getProperty());
        assertTrue(lab.isCube(figure));
    }

    @Test
    void dividedVolumesRelation() {
        Map<String, Double> map = lab.dividedVolumesRelation(factory.getCubes("files/CubeLabTestCubes.txt").get(0));
        assertEquals(1.0, map.get("byPlaneXY"));
        assertEquals(1.0, map.get("byPlaneXZ"));
        assertEquals(1.0, map.get("byPlaneYZ"));
    }
}