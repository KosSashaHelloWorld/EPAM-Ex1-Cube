package edu.kosolobov.shapes.entity.property;

import edu.kosolobov.shapes.entity.Point3D;

import java.util.Map;

public interface FigureProperty {
    Point3D getZeroPoint();

    Map<String, Double> getParameters();
}
