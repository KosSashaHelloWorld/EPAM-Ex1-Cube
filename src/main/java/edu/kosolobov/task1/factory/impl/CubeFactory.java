package edu.kosolobov.task1.factory.impl;

import edu.kosolobov.task1.entity.Point;
import edu.kosolobov.task1.entity.impl.Cube;
import edu.kosolobov.task1.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class CubeFactory implements FigureFactory {
    Logger log = LogManager.getLogger();

    public Cube getCube(Double length) {
        Cube cube = new Cube(length);
        log.info(String.format("Figure %s was created.", cube.info()));
        return cube;
    }

    public Cube getCube(List<Point> points) {
        Cube cube = new Cube(points);
        log.info(String.format("Figure %s was created.", cube.info()));
        return cube;
    }
}
