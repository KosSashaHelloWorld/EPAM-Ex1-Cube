package edu.kosolobov.shapes.entity.property.impl;

import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.property.FigureProperty;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CubeProperty implements FigureProperty {
    private static final Logger log = LogManager.getLogger(CubeProperty.class);
    private static final Double DEFAULT_LENGTH = 10.0;
    private final Point3D zeroPoint3D;
    private final Double sideLength;
    public static final String LENGTH = "length";
    public static final String POINT_COORDINATE_X = "byPlaneYZ";
    public static final String POINT_COORDINATE_Y = "byPlaneXZ";
    public static final String POINT_COORDINATE_Z = "byPlaneXY";

    public CubeProperty(Double sideLength, Point3D centerPoint3D) {
        this.zeroPoint3D = centerPoint3D;
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else if (sideLength < 0){
            this.sideLength = -sideLength;
        } else {
            log.log(Level.ERROR, "Side length of cube can not be == 0. Set to DEFAULT_LENGTH = {}", DEFAULT_LENGTH);
            this.sideLength = DEFAULT_LENGTH;
        }
    }

    public CubeProperty(Map<String, Double> parameters) {
        double length = parameters.get(LENGTH);
        double x = parameters.get(POINT_COORDINATE_X);
        double y = parameters.get(POINT_COORDINATE_Y);
        double z = parameters.get(POINT_COORDINATE_Z);
        zeroPoint3D = new Point3D(x, y, z);
        if (length > 0) {
            sideLength = length;
        } else if (length< 0){
            sideLength = -length;
        } else {
            log.log(Level.ERROR, "Side length of cube can not be == 0. Set to DEFAULT_LENGTH = {}", DEFAULT_LENGTH);
            this.sideLength = DEFAULT_LENGTH;
        }
    }

    @Override
    public Point3D getZeroPoint() {
        return zeroPoint3D;
    }

    @Override
    public Map<String, Double> getParameters() {
        Map<String, Double> parameters = new HashMap<>();

        parameters.put(LENGTH, sideLength);
        parameters.put(POINT_COORDINATE_X, zeroPoint3D.getX());
        parameters.put(POINT_COORDINATE_Y, zeroPoint3D.getY());
        parameters.put(POINT_COORDINATE_Z, zeroPoint3D.getZ());

        return parameters;
    }

    public Double getSideLength() {
        return sideLength;
    }

    @Override
    public String toString() {
        return String.format("CubeProperty{sideLength=%.4f, %s}", sideLength, zeroPoint3D);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeProperty property = (CubeProperty) o;
        return property.sideLength.equals(sideLength) && property.zeroPoint3D.equals(zeroPoint3D);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zeroPoint3D, sideLength);
    }
}
