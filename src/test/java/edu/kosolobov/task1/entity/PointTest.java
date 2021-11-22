package edu.kosolobov.task1.entity;

import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void checkToStringEqualsHashCode(){
        Point p1 = new Point(15.23141251234214, -15.1, 0.0);
        Point p2 = new Point(15.23141251234214, -15.1, 0.0);
        Point p3 = new Point(115.231515, -15.1, 0.0);

        System.out.println(p1);
        assert p1.equals(p2);
        assert !p1.equals(p3);
        assert p1.hashCode() == p2.hashCode();
    }


}
