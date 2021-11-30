package edu.kosolobov.shapes.repository.specification.impl;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.repository.specification.FigureSpecification;

public class VolumeRange implements FigureSpecification {
    private final double volumeFrom;
    private final double volumeTo;

    public VolumeRange(double volumeFrom, double volumeTo) {
        this.volumeFrom = volumeFrom;
        this.volumeTo = volumeTo;
    }

    @Override
    public boolean specify(Figure figure) {
        double volume = figure.getService().getVolume();
        return volume >= volumeFrom && volume < volumeTo;
    }
}
