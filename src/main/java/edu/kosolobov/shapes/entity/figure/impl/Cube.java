package edu.kosolobov.shapes.entity.figure.impl;

import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.property.impl.CubeProperty;
import edu.kosolobov.shapes.service.FigureService;
import edu.kosolobov.shapes.service.impl.CubeService;
import edu.kosolobov.shapes.util.UtilGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Figure {
    private static final Logger log = LogManager.getLogger(Cube.class);
    private final long figureId;
    private final CubeProperty property;

    public Cube(CubeProperty property) {
        figureId = UtilGenerator.generateFigureId();
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
        return String.format("Cube{figureId:%d, sideLength:%.2f, zeroPoint:%s",
                figureId,
                property.getSideLength(),
                property.getZeroPoint());
    }

    @Override
    public Cube copy() {
        Cube cube = new Cube(new CubeProperty(property.getSideLength(), property.getZeroPoint().copy()));
        log.log(Level.ERROR, "Copying cube failed");
        return cube;
    }

    @Override
    public FigureService getService() {
        return new CubeService(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return cube.property.equals(property);
    }

    @Override
    public int hashCode() {
        final double prime = 7.5;
        double hCode = 1.0;
        hCode = hCode * prime + property.getSideLength();
        hCode = hCode * prime + property.getZeroPoint().getX();
        hCode = hCode * prime + property.getZeroPoint().getY();
        hCode = hCode * prime + property.getZeroPoint().getZ();
        return (int) hCode;
    }

    @Override
    public String toString() {
        return info();
    }
}
