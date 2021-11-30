package edu.kosolobov.shapes.repository;

import edu.kosolobov.shapes.comparator.FigureComparator;
import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import edu.kosolobov.shapes.repository.specification.impl.AreaRange;
import edu.kosolobov.shapes.repository.specification.impl.FigureIdRange;
import edu.kosolobov.shapes.repository.specification.impl.VolumeRange;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FigureRepositoryTest {
    FigureRepository repo = FigureRepository.getInstance();
    CubeFactory factory = new CubeFactory();

    @Test
    void add_isEmpty_size_set_get_remove_clear() {
        repo.clear();

        Cube cube = factory.getCube(10.0);
        Cube cube1 = factory.getCube(20.0);

        repo.add(cube);
        assertFalse(repo.isEmpty());
        assertEquals(1, repo.size());

        repo.set(0, cube1);
        assertEquals(1, repo.size());

        Figure figure = repo.get(0);
        assertTrue(cube1.equals(figure));

        repo.remove(cube1);
        assertTrue(repo.isEmpty());

        repo.add(cube1);
        repo.add(cube);
        repo.clear();

        assertTrue(repo.isEmpty());
    }

    @Test
    void query() {
        repo.clear();

        for (int i = 10; i < 500; i += 10) {
            repo.add(factory.getCube((double) i));
        }

        List<Figure> list1 = repo.query(new AreaRange(500.0, 1000.0)); //1 cube: area=600.0
        List<Figure> list2 = repo.query(new VolumeRange(5000.0, 10000.0)); //1 cube: volume=8000.0

        assertFalse(list1.isEmpty());
        assertFalse(list2.isEmpty());

        repo.clear();
    }

    @Test
    void sort() {
        repo.clear();

        Random generator = new Random();
        List<Cube> cubes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Double> properties = new ArrayList<>();
            properties.add(generator.nextDouble(1.0, 100.0));
            properties.add(generator.nextDouble(-10000.0, 10000.0));
            properties.add(generator.nextDouble(-10000.0, 10000.0));
            properties.add(generator.nextDouble(-10000.0, 10000.0));
            cubes.add(factory.getCube(properties));
        }
        Collections.shuffle(cubes);

        cubes.forEach(repo::add);
        repo.sort(FigureComparator.ID);
        repo.sort(FigureComparator.X_COORDINATE);
        repo.sort(FigureComparator.Y_COORDINATE);
        repo.sort(FigureComparator.Z_COORDINATE);
        repo.sort(FigureComparator.AREA);
        repo.sort(FigureComparator.VOLUME);

        assertFalse(repo.isEmpty());
        repo.clear();
    }
}