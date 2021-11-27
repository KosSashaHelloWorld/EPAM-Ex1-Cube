package edu.kosolobov.factory;

import edu.kosolobov.entity.impl.Cube;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CubeFactoryTest extends Assertions {

    @Test
    void checkGetCube(){
        CubeFactory factory = new CubeFactory();
        Cube cube = factory.getCube(100.00123);
        assertNotNull(cube);
        assertNotNull(factory.getCube(cube.getProperty()));
    }
}