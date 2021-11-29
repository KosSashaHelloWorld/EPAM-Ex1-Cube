package edu.kosolobov.shapes.repository;

import edu.kosolobov.shapes.entity.figure.Figure;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FigureRepository {
    private List<Figure> repo = new ArrayList<>();

    public FigureRepository(List<Figure> repo) {
        this.repo = repo;
    }

    public FigureRepository() {
    }

    public int size() {
        return repo.size();
    }

    public boolean isEmpty() {
        return repo.isEmpty();
    }

    public boolean contains(Figure figure) {
        return repo.contains(figure);
    }

    public Iterator<Figure> iterator() {
        return repo.iterator();
    }

    public Object[] toArray() {
        return repo.toArray();
    }

    public boolean add(Figure figure) {
        return repo.add(figure);
    }

    public boolean remove(Figure figure) {
        return repo.remove(figure);
    }

    public boolean containsAll(List<Figure> figures) {
        return repo.containsAll(figures);
    }

    public boolean addAll(List<Figure> figures) {
        return repo.addAll(figures);
    }

    public boolean addAll(int index, List<Figure> figures) {
        return repo.addAll(index, figures);
    }

    public boolean removeAll(List<Figure> figures) {
        return repo.removeAll(figures);
    }

    public boolean retainAll(List<Figure> figures) {
        return repo.retainAll(figures);
    }

    public void replaceAll(UnaryOperator<Figure> operator) {
        repo.replaceAll(operator);
    }

    public void sort(Comparator<? super Figure> c) {
        repo.sort(c);
    }

    public void clear() {
        repo.clear();
    }

    public Figure get(int index) {
        return repo.get(index);
    }

    public Figure set(int index, Figure element) {
        return repo.set(index, element);
    }

    public void add(int index, Figure element) {
        repo.add(index, element);
    }

    public Figure remove(int index) {
        return repo.remove(index);
    }

    public int indexOf(Figure figure) {
        return repo.indexOf(figure);
    }

    public int lastIndexOf(Figure figure) {
        return repo.lastIndexOf(figure);
    }

    public ListIterator<Figure> listIterator() {
        return repo.listIterator();
    }

    public ListIterator<Figure> listIterator(int index) {
        return repo.listIterator(index);
    }

    public List<Figure> subList(int fromIndex, int toIndex) {
        return repo.subList(fromIndex, toIndex);
    }

    public Spliterator<Figure> spliterator() {
        return repo.spliterator();
    }

    public boolean removeIf(Predicate<? super Figure> filter) {
        return repo.removeIf(filter);
    }

    public Stream<Figure> stream() {
        return repo.stream();
    }

    public Stream<Figure> parallelStream() {
        return repo.parallelStream();
    }

    public void forEach(Consumer<? super Figure> action) {
        repo.forEach(action);
    }
}
