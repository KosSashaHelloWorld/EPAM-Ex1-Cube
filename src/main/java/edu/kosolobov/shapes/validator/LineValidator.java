package edu.kosolobov.shapes.validator;

import static edu.kosolobov.shapes.regex.RegexRecord.REGEX_SOME_DOUBLES;
import static edu.kosolobov.shapes.regex.RegexRecord.REGEX_SOME_INTEGERS;

public class LineValidator {

    private LineValidator() {
    }

    public static boolean validateDoubles(String line, int amount) {
        return line.matches(String.format(REGEX_SOME_DOUBLES, amount - 1));
    }

    public static boolean validateIntegers(String line, int amount) {
        return line.matches(String.format(REGEX_SOME_INTEGERS, amount - 1));
    }
}
