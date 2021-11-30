package edu.kosolobov.shapes.repository.specification;

import edu.kosolobov.shapes.entity.figure.Figure;

public class ZeroPointPosition{
    public ZeroPointPosition() {
        super();
    }

    public boolean isAboveXPlane(Figure figure) {
        return figure.getProperty().getZeroPoint().getX() >= 0.0;
    }

    public boolean isAboveYPlane(Figure figure) {
        return figure.getProperty().getZeroPoint().getY() >= 0.0;
    }

    public boolean isAboveZPlane(Figure figure) {
        return figure.getProperty().getZeroPoint().getZ() >= 0.0;
    }
}
