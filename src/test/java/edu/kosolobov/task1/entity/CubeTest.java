package edu.kosolobov.task1.entity;

import edu.kosolobov.task1.entity.impl.Cube;
import org.junit.jupiter.api.Test;

public class CubeTest {
    @Test
    void checkInfo(){
        Cube c1 = new Cube(25.15);
        Cube c2 = new Cube(253.153);
        System.out.println(c1.info());
        System.out.println(c2.info());
    }

    @Test
    void checkToString(){
        Cube c = new Cube(51.12);
        System.out.println(c);
    }

    @Test
    void checkEquals(){
        Cube c1 = new Cube(10.0);
        Cube c2 = new Cube(10.0);
        assert c1.equals(c2);
        assert c1.equals(c1.copy());
        assert c1.equals(c2.copy());
    }
}
