package edu.kosolobov.entity.impl;

import edu.kosolobov.entity.Figure;
import edu.kosolobov.entity.Point3D;
import edu.kosolobov.entity.property.CubeProperty;
import edu.kosolobov.util.UtilGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube implements Figure {
    private final long figureId;
    private final CubeProperty property;

    public Cube(CubeProperty property) {
        figureId = UtilGenerator.GenerateFigureId();
        this.property = property;
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

    public String getName() {
        return "cube";
    }

    public CubeProperty getProperty() {
        return property;
    }

    @Override
    public String info() {
        return String.format("cube{figureId:%d, sideLength:%.4f, zeroPoint:%s",
                figureId,
                property.getSideLength(),
                property.getZeroPoint());
    }

    @Override
    public Cube copy() {
        return new Cube(new CubeProperty(property.getZeroPoint().copy(), property.getSideLength()));
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
        return String.format("%s{%s}", info(), getPoints());
    }
}
