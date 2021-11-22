package geometry;

import java.util.ArrayList;

public class CubeFactory {

    public Cube getCubeByLength(Double length){
        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0.0,0.0,0.0));
        points.add(new Point(length,0.0,0.0));
        points.add(new Point(0.0,length,0.0));
        points.add(new Point(length,length,0.0));
        points.add(new Point(0.0,0.0,length));
        points.add(new Point(length,0.0,length));
        points.add(new Point(0.0,length,length));
        points.add(new Point(length,length,length));

        return new Cube(points);
    }
}
