package geometry;

import java.util.ArrayList;

public class Cube {
    private static int ID = 0;
    private final String name = "cube";
    private final int id;
    private Point[] points = new Point[8];

    public Cube(Point[] points) {
        id = ID++;
        this.points = points;
    }

    public Cube(ArrayList<Point> points) {
        id = ID++;
        for (int i = 0; i < 8; i++) {
            this.points[i] = points.get(i);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Point[] getPoints() {
        return points;
    }
}
