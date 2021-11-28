package edu.kosolobov.labaratory;

import edu.kosolobov.entity.Figure;
import edu.kosolobov.entity.figureImpl.Cube;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.factory.CubeFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CubeLaboratoryTest {
    CubeLaboratory lab = new CubeLaboratory();
    CubeFactory factory = new CubeFactory();
    Cube cube = factory.getCube(10.0);
    List<Cube> cubes = factory.getCubes("src/test/resources/example.txt");

    CubeLaboratoryTest() throws CubeException {
    }

    @Test
    void setCubeGetCube() {
        lab.setCube(cube);
        assertEquals(lab.getCube(), cube);
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
    void dividedVolumesRelation() throws CubeException {
        Map<String, Double> map = lab.dividedVolumesRelation(factory.getCubes("src/test/resources/CubeLabTestCubes.txt").get(0));
        assertEquals(1.0, map.get("byPlaneXY"));
        assertEquals(1.0, map.get("byPlaneXZ"));
        assertEquals(1.0, map.get("byPlaneYZ"));
    }
}