package edu.kosolobov.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Point3DTest extends Assertions {
    @Test
    void checkToStringEqualsHashCode(){
        Point3D p1 = new Point3D(15.23141251234214, -15.1, 0.0);
        Point3D p2 = new Point3D(15.23141251234214, -15.1, 0.0);
        Point3D p3 = new Point3D(115.231515, -15.1, 0.0);
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
    }


}
