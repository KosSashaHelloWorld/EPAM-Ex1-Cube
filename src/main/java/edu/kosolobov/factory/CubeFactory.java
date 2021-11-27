package edu.kosolobov.factory;

import edu.kosolobov.entity.Point3D;
import edu.kosolobov.entity.impl.Cube;
import edu.kosolobov.entity.property.CubeProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeFactory {
    Logger log = LogManager.getLogger();

    public Cube getCube(Double length) {
        CubeProperty property = new CubeProperty(new Point3D(0.0,0.0,0.0), length);
        Cube cube = new Cube(property);
        log.info(String.format("Cube %s was created.", cube.info()));
        return cube;
    }

    public Cube getCube(CubeProperty property) {
        Cube cube = new Cube(property);
        log.info(String.format("Cube %s was created.", cube.info()));
        return cube;
    }
}
