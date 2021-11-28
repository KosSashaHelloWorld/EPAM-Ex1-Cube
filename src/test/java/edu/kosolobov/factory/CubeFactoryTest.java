package edu.kosolobov.factory;

import edu.kosolobov.entity.figureImpl.Cube;
import edu.kosolobov.exception.CubeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

class CubeFactoryTest extends Assertions {
    CubeFactory factory = new CubeFactory();

    @Test
    void checkGetCube(){
        Cube cube = null;
        try {
            cube = factory.getCube(100.00123);
        } catch (CubeException e) {
            e.printStackTrace();
        }
        assertNotNull(cube);
        assertNotNull(factory.getCube(cube.getProperty()));
    }

    @Test
    void checkGetCubeFromFile() {
        URL fileUrl = CubeFactoryTest.class
                .getClassLoader()
                .getResource("files/example.txt");
        assertNotNull(fileUrl);
        File file = new File(fileUrl.getFile());
        String filePath = file.getAbsolutePath();
        List<Cube> cubes = null;
        try {
            cubes = factory.getCubes(filePath);
        } catch (CubeException e) {
            e.printStackTrace();
        }
        assertNotNull(cubes);
        assertFalse(cubes.isEmpty());
        assertEquals(9, cubes.size());
    }
}