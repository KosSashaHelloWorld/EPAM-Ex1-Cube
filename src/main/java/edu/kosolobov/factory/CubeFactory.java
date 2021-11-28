package edu.kosolobov.factory;

import edu.kosolobov.entity.Point3D;
import edu.kosolobov.entity.impl.Cube;
import edu.kosolobov.entity.property.CubeProperty;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.parser.CubeFileParser;

import java.util.List;

public class CubeFactory {

    public Cube getCube(Double length) throws CubeException {
        CubeProperty property = new CubeProperty(length, new Point3D(0.0,0.0,0.0));
        return new Cube(property);
    }

    public Cube getCube(CubeProperty property) {
        return new Cube(property);
    }

    public List<Cube> getCubes(String filepath) throws CubeException {
        CubeFileParser parser = new CubeFileParser();
        return parser.getCubesFromFile(filepath);
    }
}
