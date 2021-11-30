package edu.kosolobov.shapes.comparator;

import edu.kosolobov.shapes.entity.figure.Figure;

import java.util.Comparator;

public enum FigureComparator implements Comparator<Figure> {
    ID {
        @Override
        public int compare(Figure o1, Figure o2) {
            return (int) (o1.getId() - o2.getId());
        }
    },
    X_COORDINATE {
        @Override
        public int compare(Figure o1, Figure o2) {
            double x1 = o1.getProperty().getZeroPoint().getX();
            double x2 = o2.getProperty().getZeroPoint().getX();
            return Double.compare(x1, x2);
        }
    },
    Y_COORDINATE {
        @Override
        public int compare(Figure o1, Figure o2) {
            double y1 = o1.getProperty().getZeroPoint().getY();
            double y2 = o2.getProperty().getZeroPoint().getY();
            return Double.compare(y1, y2);
        }
    },
    Z_COORDINATE {
        @Override
        public int compare(Figure o1, Figure o2) {
            double z1 = o1.getProperty().getZeroPoint().getZ();
            double z2 = o2.getProperty().getZeroPoint().getZ();
            return Double.compare(z1, z2);
        }
    },
    AREA {
        @Override
        public int compare(Figure o1, Figure o2) {
            double area1 = o1.getService().getArea();
            double area2 = o2.getService().getArea();
            return Double.compare(area1, area2);
        }
    },
    VOLUME {
        @Override
        public int compare(Figure o1, Figure o2) {
            double volume1 = o1.getService().getVolume();
            double volume2 = o2.getService().getVolume();
            return Double.compare(volume1, volume2);
        }
    }
}
