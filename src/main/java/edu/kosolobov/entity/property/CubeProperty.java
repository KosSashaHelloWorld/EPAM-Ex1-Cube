package edu.kosolobov.entity.property;

import edu.kosolobov.entity.Point3D;
import edu.kosolobov.exception.CubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeProperty {
    private static final Logger log = LogManager.getLogger(CubeProperty.class);
    private final Point3D zeroPoint3D;
    private final Double sideLength;

    public CubeProperty(Double sideLength, Point3D centerPoint3D) throws CubeException {
        this.zeroPoint3D = centerPoint3D;
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else if (sideLength < 0){
            this.sideLength = -sideLength;
        } else {
            log.log(Level.ERROR, "Side length of cube can not be == 0");
            throw new CubeException();
        }
    }

    public Point3D getZeroPoint() {
        return zeroPoint3D;
    }

    public Double getSideLength() {
        return sideLength;
    }

    @Override
    public String toString() {
        return String.format("CubeProperty{sideLength=%.4f, %s}", sideLength, zeroPoint3D);
    }
}
