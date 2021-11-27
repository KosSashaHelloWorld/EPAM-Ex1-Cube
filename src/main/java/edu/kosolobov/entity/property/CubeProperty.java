package edu.kosolobov.entity.property;

import edu.kosolobov.entity.Point3D;

public class CubeProperty {
    private final Point3D zeroPoint3D;
    private final Double sideLength;

    public CubeProperty(Point3D centerPoint3D, Double sideLength) {
        this.zeroPoint3D = centerPoint3D;
        this.sideLength = sideLength;
    }

    public Point3D getZeroPoint() {
        return zeroPoint3D;
    }

    public Double getSideLength() {
        return sideLength;
    }
}
