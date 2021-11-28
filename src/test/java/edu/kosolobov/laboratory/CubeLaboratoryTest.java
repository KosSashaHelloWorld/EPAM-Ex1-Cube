package edu.kosolobov.laboratory;

import edu.kosolobov.entity.Figure;
import edu.kosolobov.entity.figureImpl.Cube;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.factory.CubeFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CubeLaboratoryTest {
    static CubeLaboratory lab = new CubeLaboratory();
    static CubeFactory factory = new CubeFactory();
    static Cube cube;
    static List<Cube> cubes;
    static String filePath;
    static {
        try {
            cube = factory.getCube(10.0);
        } catch (CubeException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    static void init() throws CubeException {
        URL fileUrl = CubeLaboratoryTest.class
                .getClassLoader()
                .getResource("files/example.txt");
        assertNotNull(fileUrl);
        File file = new File(fileUrl.getFile());
        filePath = file.getAbsolutePath();
        cubes = factory.getCubes(filePath);
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
        URL fileUrl = CubeLaboratoryTest.class
                .getClassLoader()
                .getResource("files/CubeLabTestCubes.txt");
        assertNotNull(fileUrl);
        File file = new File(fileUrl.getFile());
        filePath = file.getAbsolutePath();
        Map<String, Double> map = lab.dividedVolumesRelation(factory.getCubes(filePath).get(0));
        assertEquals(1.0, map.get("byPlaneXY"));
        assertEquals(1.0, map.get("byPlaneXZ"));
        assertEquals(1.0, map.get("byPlaneYZ"));
    }
}