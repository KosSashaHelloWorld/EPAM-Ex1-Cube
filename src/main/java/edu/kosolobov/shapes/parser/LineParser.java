package edu.kosolobov.shapes.parser;

import edu.kosolobov.shapes.validator.LineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static edu.kosolobov.shapes.regex.RegexRecord.*;

public class LineParser {
    private static final Logger log = LogManager.getLogger(LineParser.class);

    private LineParser() {

    }

    public static List<Double> parseToDouble(String line, int amount) {
        if (LineValidator.validateDoubles(line, amount)) {
            List<Double> doubles = new ArrayList<>();
            for (String str : line.split(REGEX_DELIMITER)) {
                doubles.add(Double.parseDouble(str));
            }
            return doubles;
        } else {
            log.log(Level.WARN, "Line {} is invalid for parsing doubles", line);
            return new ArrayList<>();
        }
    }

    public static List<Integer> parseToIntegers(String line, int amount) {
        if (LineValidator.validateDoubles(line, amount)) {
            List<Integer> integers = new ArrayList<>();
            for (String str : line.split(REGEX_DELIMITER)) {
                integers.add(Integer.parseInt(str));
            }
            return integers;
        } else {
            log.log(Level.WARN, "Line {} is invalid for parsing integers", line);
            return new ArrayList<>();
        }
    }
}


