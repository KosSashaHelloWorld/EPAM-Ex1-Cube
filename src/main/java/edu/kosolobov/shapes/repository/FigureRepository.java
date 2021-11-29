package edu.kosolobov.shapes.repository;

import edu.kosolobov.shapes.entity.figure.Figure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class FigureRepository {
    private static final Logger log = LogManager.getLogger(FigureRepository.class);
    private static final FigureRepository instance = new FigureRepository();
    private final List<Figure> figures;

    private FigureRepository() {
        figures = new ArrayList<>();
    }

    public static FigureRepository getInstance() {
        log.log(Level.INFO, "Initialization of repository");
        return instance;
    }

    public int size() {
        return figures.size();
    }

    public void add(Figure figure) {
        figures.add(figure);
        log.log(Level.INFO, "{} added to repository", figure);
    }

    public void set(int index, Figure figure) {
        figures.set(index, figure);
        log.log(Level.INFO, "{} replaced {} position in repository", figure, index);
    }

    public Figure get(int index) {
        return figures.get(index);
    }

    public boolean remove(Figure figure) {
        log.log(Level.INFO, "Removing {} from repository...", figure);
        return figures.remove(figure);
    }

    public void clear() {
        figures.clear();
        log.log(Level.INFO, "Repository cleared");
    }

    public boolean isEmpty() {
        return figures.isEmpty();
    }
}
