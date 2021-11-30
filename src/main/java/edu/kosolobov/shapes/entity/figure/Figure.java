package edu.kosolobov.shapes.entity.figure;

import edu.kosolobov.shapes.entity.property.FigureProperty;
import edu.kosolobov.shapes.service.FigureService;

public interface Figure {

    FigureProperty getProperty();

    long getId();

    default String info() {
        return String.format("class: %s, id: %s}", this.getClass(), getId());
    }

    Figure copy();

    FigureService getService();
}
