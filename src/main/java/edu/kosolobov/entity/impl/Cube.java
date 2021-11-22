package edu.kosolobov.entity.impl;

import edu.kosolobov.entity.Figure;
import edu.kosolobov.entity.Point;
import edu.kosolobov.util.UtilGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube implements Figure {
    private final long cubeId;
    private final List<Point> points;

    public Cube(List<Point> points) {
        cubeId = UtilGenerator.GenerateFigureId();
        this.points = points;

    }

    public Cube(Double length) {
        cubeId = UtilGenerator.GenerateFigureId();
        
        length/=2.0;

        List<Point> newPoints = new ArrayList<>(List.of());

        newPoints.add(new Point(-length, -length, -length));
        newPoints.add(new Point(length, -length, -length));
        newPoints.add(new Point(-length, length, -length));
        newPoints.add(new Point(length, length, -length));
        newPoints.add(new Point(-length, -length, length));
        newPoints.add(new Point(length, -length, length));
        newPoints.add(new Point(-length, length, length));
        newPoints.add(new Point(length, length, length));

        points = List.copyOf(newPoints);
    }

    @Override
    public long getId() {
        return cubeId;
    }

    public String getName() {
        return "cube";
    }

    public List<Point> getPoints() {
        return points;
    }

    public Cube copy() {
        return new Cube(this.getPoints());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return points.equals(cube.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubeId, points);
    }

    @Override
    public String toString() {
        return String.format("%s{%s}", info(), points);
    }
}
