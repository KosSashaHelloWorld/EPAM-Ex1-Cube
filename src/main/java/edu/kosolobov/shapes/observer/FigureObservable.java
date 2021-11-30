package edu.kosolobov.shapes.observer;

public interface FigureObservable {
    void attach(FigureObserver observer);

    void detach(FigureObserver observer);

    void notifyObservers();
}
