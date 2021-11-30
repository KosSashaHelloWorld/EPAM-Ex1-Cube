package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;

public class FigureIdRange implements FigureSpecification {
    private final int idFrom;
    private final int idTo;

    public FigureIdRange(int idFrom, int idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Figure figure) {
        return figure.getId() >= idFrom && figure.getId() < idTo;
    }
}
