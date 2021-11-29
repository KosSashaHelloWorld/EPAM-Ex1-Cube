package edu.kosolobov.shapes.factory;

import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.entity.property.impl.CubeProperty;
import edu.kosolobov.shapes.parser.LineParser;
import edu.kosolobov.shapes.reader.FileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CubeFactoryTest {
    private final CubeFactory factory = new CubeFactory();

    @Test
    void getCube() {
        assertNotNull(factory.getCube(1.0));
    }

    @Test
    void testGetCube() {
        FileReader reader = new FileReader();
        List<String> lines = reader.readFile("files/example.txt");
        List<Double> doubles = LineParser.parseToDouble(lines.get(1), 4);
        assertNotNull(factory.getCube(doubles));
    }

    @Test
    void testGetCube1() {
        Point3D point = new Point3D(0.0, 0.0, 0.0);
        CubeProperty property = new CubeProperty(1.0, point);
        assertNotNull(factory.getCube(property));
    }

    @Test
    void getCubes() {
        List<Cube> cubes = factory.getCubes("files/example.txt");
        assertFalse(cubes.isEmpty());
    }
}