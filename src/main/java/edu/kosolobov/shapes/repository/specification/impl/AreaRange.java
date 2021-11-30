package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;

public class AreaRange implements FigureSpecification {
    private final double areaFrom;
    private final double areaTo;

    public AreaRange(double areaFrom, double areaTo) {
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }


    @Override
    public boolean specify(Figure figure) {
        double area = figure.getService().getArea();
        return area >= areaFrom && area < areaTo;
    }
}
