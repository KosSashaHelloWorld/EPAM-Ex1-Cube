package edu.kosolobov.entity;

import edu.kosolobov.entity.impl.Cube;
import edu.kosolobov.entity.property.CubeProperty;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.reader.LineReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CubeTest extends Assertions {

    @Test
    void checkEqualsToStringHashCode(){
        CubeProperty p = null;
        try {
            p = new CubeProperty(12354.1231541, new Point3D(0.0,0.0,0.0));
        } catch (CubeException e) {
            e.printStackTrace();
        }
        Cube c1 = new Cube(p);
        Cube c2 = new Cube(p);
        assertNotNull(c1);
        assertNotEquals(c1, c1.copy());
        assertNotEquals(c1, c2);
        assertNotEquals(c1.hashCode(), c2.hashCode());
        assertEquals(c1.getProperty(), c2.getProperty());
    }
}
