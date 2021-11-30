package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;
import edu.kosolobov.shapes.repository.specification.ZeroPointPosition;

public class AboveXPlane extends ZeroPointPosition implements FigureSpecification {
    public AboveXPlane() {
        super();
    }

    @Override
    public boolean specify(Figure figure) {
        return isAboveXPlane(figure);
    }
}
