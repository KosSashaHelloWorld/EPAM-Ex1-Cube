package edu.kosolobov.shapes.service;

import edu.kosolobov.shapes.entity.figure.Figure;

public interface FigureService {
    Double getArea(Figure figure);

    Double getVolume(Figure figure);

    Double getArea();

    Double getVolume();
}
