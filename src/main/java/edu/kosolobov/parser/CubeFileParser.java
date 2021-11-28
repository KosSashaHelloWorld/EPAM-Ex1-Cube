package edu.kosolobov.parser;

import edu.kosolobov.entity.Point3D;
import edu.kosolobov.entity.figureImpl.Cube;
import edu.kosolobov.entity.propertyImpl.CubeProperty;
import edu.kosolobov.exception.CubeException;
import edu.kosolobov.validator.CubeFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.kosolobov.regex.RegexRecord.*;

public class CubeFileParser {
    private static final Logger log = LogManager.getLogger(CubeFileParser.class);
    private static final CubeFileValidator validator = new CubeFileValidator();

    public CubeFileParser() {
        super();
    }

    private List<Double> parseLineToDoubles(String line) {
        List<String> numbers = Arrays.stream(line.split(REGEX_DELIMITER)).toList();
        List<Double> doubles = new ArrayList<>();

        for (String number : numbers) {
            if (number.matches(REGEX_DOUBLE) || number.matches(REGEX_INTEGER)) {
                doubles.add(Double.parseDouble(number));
            }
        }

        return doubles;
    }

    private CubeProperty parseDoublesToProperty(List<Double> doubles) throws CubeException {

        if (doubles.size() < 4) {
            return new CubeProperty(doubles.get(0), new Point3D(0.0, 0.0, 0.0));
        } else {
            return new CubeProperty(doubles.get(0), new Point3D(doubles.get(1), doubles.get(2), doubles.get(3)));
        }
    }

    public List<Cube> getCubesFromFile(String filepath) throws CubeException {
        List<Cube> cubes = new ArrayList<>();
        List<String> lines = validator.getValidLines(filepath);
        List<Double> doubles;
        CubeProperty property;

        for (String line : lines) {
            doubles = parseLineToDoubles(line);
            if (doubles.get(0) == 0) {
                log.log(Level.WARN, "Side length of cube can`t be zero! : {}", line);
                continue;
            }
            property = parseDoublesToProperty(doubles);
            cubes.add(new Cube(property));
        }

        log.log(Level.INFO, "List<Cube> was created. Totally {} cubes", cubes.size());

        return cubes;
    }
}






















