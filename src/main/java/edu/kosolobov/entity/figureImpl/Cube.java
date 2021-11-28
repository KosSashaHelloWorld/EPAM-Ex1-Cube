package edu.kosolobov.entity.figureImpl;

import edu.kosolobov.entity.Figure;
import edu.kosolobov.entity.Point3D;
import edu.kosolobov.entity.propertyImpl.CubeProperty;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.util.UtilGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube implements Figure {
    private static final Logger log = LogManager.getLogger(Cube.class);
    private final long figureId;
    private final CubeProperty property;

    public Cube(CubeProperty property) {
        figureId = UtilGenerator.GenerateFigureId();
        this.property = property;
        log.log(Level.INFO, "{} was created", this);
    }

    public List<Point3D> getPoints() {
        List<Point3D> point3DS = new ArrayList<>();
        Point3D.PointBuilder pb = new Point3D.PointBuilder();

        pb.setZeroPoint(property.getZeroPoint());
        pb.setDelta(property.getSideLength());

        point3DS.add(pb.build());
        point3DS.add(pb.moveX().build());
        point3DS.add(pb.moveY().build());
        point3DS.add(pb.moveZ().build());
        point3DS.add(pb.moveX().moveY().build());
        point3DS.add(pb.moveX().moveZ().build());
        point3DS.add(pb.moveY().moveZ().build());
        point3DS.add(pb.moveX().moveY().moveZ().build());

        return List.copyOf(point3DS);
    }

    @Override
    public long getId() {
        return figureId;
    }

    public CubeProperty getProperty() {
        return property;
    }

    @Override
    public String info() {
        return String.format("Cube{figureId:%d, sideLength:%.4f, zeroPoint:%s",
                figureId,
                property.getSideLength(),
                property.getZeroPoint());
    }

    @Override
    public Cube copy() {
        Cube cube = null;
        try {
            cube = new Cube(new CubeProperty(property.getSideLength(), property.getZeroPoint().copy()));
        } catch (CubeException e) {
            log.log(Level.ERROR, "Copying cube failed");
        }
        return cube;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return figureId == cube.figureId && Objects.equals(property, cube.property);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(figureId);
    }

    @Override
    public String toString() {
        return info();
    }
}
