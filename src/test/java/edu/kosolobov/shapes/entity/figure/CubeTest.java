package edu.kosolobov.shapes.entity.figure;

import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {
    CubeFactory factory = new CubeFactory();
    Cube a = factory.getCube(10.0);
    Cube b = factory.getCube(10.0);

    @Test
    void testEquals() {
        assertTrue(a.equals(b));
    }

    @Test
    void testHashCode() {
        assertEquals(a.hashCode(), b.hashCode());
    }
}