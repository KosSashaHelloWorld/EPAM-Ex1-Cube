package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;
import edu.kosolobov.shapes.repository.specification.ZeroPointPosition;

public class AboveZPlane extends ZeroPointPosition implements FigureSpecification {
    public AboveZPlane() {
        super();
    }

    @Override
    public boolean specify(Figure figure) {
        return isAboveZPlane(figure);
    }
}
