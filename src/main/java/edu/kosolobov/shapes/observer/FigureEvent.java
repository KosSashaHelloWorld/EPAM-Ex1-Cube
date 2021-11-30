package edu.kosolobov.shapes.observer;

import edu.kosolobov.shapes.entity.figure.Figure;

import java.util.EventObject;

public class FigureEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FigureEvent(Object source) {
        super(source);
    }

    @Override
    public Figure getSource() {
        return (Figure) super.getSource();
    }
}
