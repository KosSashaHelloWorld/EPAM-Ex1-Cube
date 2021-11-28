package edu.kosolobov.entity;

import java.util.Map;

public interface FigureProperty {
    Point3D getZeroPoint();

    Map<String, Double> getParameters();
}
