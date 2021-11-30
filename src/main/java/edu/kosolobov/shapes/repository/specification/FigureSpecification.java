package edu.kosolobov.shapes.repository.specification;

import edu.kosolobov.shapes.entity.figure.Figure;

public interface FigureSpecification {
    boolean specify(Figure figure);
}
