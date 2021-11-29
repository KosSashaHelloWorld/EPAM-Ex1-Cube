package edu.kosolobov.shapes.laboratory;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CubeLaboratory {
    private static final Logger log = LogManager.getLogger(CubeLaboratory.class);

    public CubeLaboratory() {
        super();
    }

    public Double calcArea(Cube cube) {
        return (cube.getProperty().getSideLength() * cube.getProperty().getSideLength()) * 6;
    }

    public Double calcVolume(Cube cube) {
        return cube.getProperty().getSideLength() * cube.getProperty().getSideLength() * cube.getProperty().getSideLength();
    }

    public boolean isOnCoordinatePlane(Cube cube) {
        Point3D point = cube.getProperty().getZeroPoint();
        return point.getX() == 0.0 || point.getY() == 0.0 || point.getZ() == 0.0;
    }

    public boolean isCube(Figure figure) {
        Map<String, Double> parameters = figure.getProperty().getParameters();

        if (!parameters.isEmpty() && parameters.containsKey("length") && parameters.containsKey("PointX")
                && parameters.containsKey("PointY") && parameters.containsKey("PointZ")) {
            log.log(Level.INFO, "{} is a Cube", figure);
            return true;
        } else {
            log.log(Level.INFO, "{} is not a Cube", figure);
            return false;
        }
    }

        public Map<String, Double> dividedVolumesRelation(Cube cube) {
        Map<String, Double> result = new HashMap<>();

        result.put("byPlaneYZ", 0.0);
        result.put("byPlaneXZ", 0.0);
        result.put("byPlaneXY", 0.0);

        Point3D p = cube.getProperty().getZeroPoint();
        Double len = cube.getProperty().getSideLength();

        if (p.getX() < 0 && -len < p.getX()) {
            log.log(Level.INFO, "{} divides by coordinate planes YZ", cube);
            result.replace("byPlaneYZ", (len + p.getX()) / -p.getX());
        }

        if (p.getY() < 0 && -len < p.getY()) {
            log.log(Level.INFO, "{} divides by coordinate planes XZ", cube);
            result.replace("byPlaneXZ", (len + p.getY()) / -p.getY());
        }

        if (p.getZ() < 0 && -len < p.getZ()) {
            log.log(Level.INFO, "{} divides by coordinate planes XY", cube);
            result.replace("byPlaneXY", (len + p.getZ()) / -p.getZ());
        }

        if (result.isEmpty()) {
            log.log(Level.INFO, "{} doesn`t divide by coordinate planes", cube);
        }

        return result;
    }
}
