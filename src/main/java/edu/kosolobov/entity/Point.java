package edu.kosolobov.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;

public class Point {
    private static final Logger log = LogManager.getLogger();
    private final Double x;
    private final Double y;
    private final Double z;

    public Point(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        log.info("Point was created");
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y) && z.equals(point.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("\nPoint{X: %.4f, Y: %.4f, Z: %.4f}", x, y, z);
    }
}
