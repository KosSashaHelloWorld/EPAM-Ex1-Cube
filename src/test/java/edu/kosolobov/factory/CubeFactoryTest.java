package edu.kosolobov.factory;

import edu.kosolobov.entity.impl.Cube;
import edu.kosolobov.factory.impl.CubeFactory;
import org.junit.jupiter.api.Test;

public class CubeFactoryTest {
    @Test
    void checkGetCube() {
        CubeFactory cb = new CubeFactory();
        Cube c1 = cb.getCube(10.0);
        Cube c2 = cb.getCube(c1.getPoints());
        assert c1.equals(c2);
    }
}
