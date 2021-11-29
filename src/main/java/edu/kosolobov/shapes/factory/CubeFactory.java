package edu.kosolobov.shapes.factory;

import edu.kosolobov.shapes.entity.Point3D;
import edu.kosolobov.shapes.entity.figure.impl.Cube;
import edu.kosolobov.shapes.entity.property.impl.CubeProperty;
import edu.kosolobov.shapes.parser.LineParser;
import edu.kosolobov.shapes.reader.FileReader;
import edu.kosolobov.shapes.validator.LineValidator;

import java.util.ArrayList;
import java.util.List;

public class CubeFactory {
    private static final int PARAMETERS_AMOUNT = 4;

    public Cube getCube(Double length) {
        CubeProperty property = new CubeProperty(length, new Point3D(0.0,0.0,0.0));
        return new Cube(property);
    }

    public Cube getCube(CubeProperty property) {
        return new Cube(property);
    }

    public Cube getCube(List<Double> property) {
        Point3D point = new Point3D(property.get(1), property.get(2), property.get(3));
        return new Cube(new CubeProperty(property.get(0), point));
    }

    public List<Cube> getCubes(String filepath) {
        FileReader reader = new FileReader();
        List<String> lines = reader.readFile(filepath);
        List<String> newLines = getValidLines(lines);

        List<Cube> cubes = new ArrayList<>();

        for (String line : newLines) {
            List<Double> doubles = LineParser.parseToDouble(line, PARAMETERS_AMOUNT);
            cubes.add(getCube(doubles));
        }

        return cubes;
    }

    private List<String> getValidLines(List<String> lines) {
        List<String> newLines = new ArrayList<>();

        for (String line : lines) {
            if (LineValidator.validateDoubles(line, PARAMETERS_AMOUNT)) {
                newLines.add(line);
            }
        }

        return newLines;
    }
}
