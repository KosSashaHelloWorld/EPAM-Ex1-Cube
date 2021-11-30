package edu.kosolobov.shapes.service.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.service.FigureService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static edu.kosolobov.shapes.entity.property.impl.CubeProperty.*;

public class CubeService implements FigureService {
    private static final Logger log = LogManager.getLogger(CubeService.class);
    private Cube cube;
    private static final String BY_COORDINATE_PLANE_YZ = "byPlaneYZ";
    private static final String BY_COORDINATE_PLANE_XZ = "byPlaneXZ";
    private static final String BY_COORDINATE_PLANE_XY = "byPlaneXY";

    public CubeService() {
    }

    public CubeService(Cube cube) {
        this.cube = cube;
    }

    @Override
    public Double getArea(Figure figure) {
        if (isCube(figure)) {
            cube = (Cube) figure;
            return (cube.getProperty().getSideLength() * cube.getProperty().getSideLength()) * 6;
        } else {
            return 0.0;
        }
    }

    @Override
    public Double getVolume(Figure figure) {
        if (isCube(figure)) {
            cube = (Cube) figure;
            return cube.getProperty().getSideLength() * cube.getProperty().getSideLength() * cube.getProperty().getSideLength();
        } else {
            return 0.0;
        }
    }

    @Override
    public Double getArea() {
        return getArea(cube);
    }

    @Override
    public Double getVolume() {
        return getVolume(cube);
    }

    public boolean isOnCoordinatePlane(Cube cube) {
        Point3D point = cube.getProperty().getZeroPoint();
        return point.getX() == 0.0 || point.getY() == 0.0 || point.getZ() == 0.0;
    }

    public boolean isCube(Figure figure) {
        Map<String, Double> parameters = figure.getProperty().getParameters();

        if (!parameters.isEmpty() && parameters.containsKey(LENGTH) && parameters.containsKey(POINT_COORDINATE_X)
                && parameters.containsKey(POINT_COORDINATE_Y) && parameters.containsKey(POINT_COORDINATE_Z)) {
            log.log(Level.INFO, "{} is a Cube", figure);
            return true;
        } else {
            log.log(Level.INFO, "{} is not a Cube", figure);
            return false;
        }
    }

        public Map<String, Double> dividedVolumesRelation(Cube cube) {
        Map<String, Double> result = new HashMap<>();

        result.put(BY_COORDINATE_PLANE_YZ, 0.0);
        result.put(BY_COORDINATE_PLANE_XZ, 0.0);
        result.put(BY_COORDINATE_PLANE_XY, 0.0);

        Point3D p = cube.getProperty().getZeroPoint();
        Double len = cube.getProperty().getSideLength();

        if (p.getX() < 0 && -len < p.getX()) {
            log.log(Level.INFO, "{} divides by coordinate plane YZ", cube);
            result.replace(BY_COORDINATE_PLANE_YZ, (len + p.getX()) / -p.getX());
        }

        if (p.getY() < 0 && -len < p.getY()) {
            log.log(Level.INFO, "{} divides by coordinate plane XZ", cube);
            result.replace(BY_COORDINATE_PLANE_XZ, (len + p.getY()) / -p.getY());
        }

        if (p.getZ() < 0 && -len < p.getZ()) {
            log.log(Level.INFO, "{} divides by coordinate plane XY", cube);
            result.replace(BY_COORDINATE_PLANE_XY, (len + p.getZ()) / -p.getZ());
        }

        if (result.get(BY_COORDINATE_PLANE_YZ).equals(0.0) &&
            result.get(BY_COORDINATE_PLANE_XZ).equals(0.0) &&
            result.get(BY_COORDINATE_PLANE_XY).equals(0.0)) {
            log.log(Level.INFO, "{} doesn`t divide by coordinate planes", cube);
        }

        return result;
    }
}
