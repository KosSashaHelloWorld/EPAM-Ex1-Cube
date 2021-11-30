package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;
import edu.kosolobov.shapes.repository.specification.ZeroPointPosition;

public class AboveYPlane extends ZeroPointPosition implements FigureSpecification {
    public AboveYPlane() {
        super();
    }

    @Override
    public boolean specify(Figure figure) {
        return isAboveYPlane(figure);
    }
}
