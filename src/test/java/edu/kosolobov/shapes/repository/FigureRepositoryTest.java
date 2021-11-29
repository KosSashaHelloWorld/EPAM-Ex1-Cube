package edu.kosolobov.shapes.repository;

import edu.kosolobov.shapes.entity.figure.Figure;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.factory.CubeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureRepositoryTest {
    FigureRepository repo = FigureRepository.getInstance();
    CubeFactory factory = new CubeFactory();
    Cube cube = factory.getCube(10.0);
    Cube cube1 = factory.getCube(20.0);

    @Test
    void add_isEmpty_size_set_get_remove_clear() {
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
}