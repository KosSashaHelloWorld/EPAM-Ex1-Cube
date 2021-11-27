package edu.kosolobov.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class CubeLineValidator {
    private static final Logger log = LogManager.getLogger(CubeLineValidator.class);
    private static final String REGEX_DOUBLE = "[-]?\\d*.?\\d*";
    private static final String REGEX_CUBE_LINE_FULL = REGEX_DOUBLE + REGEX_DOUBLE + REGEX_DOUBLE + REGEX_DOUBLE + "\\n?";
    private static final String REGEX_CUBE_LINE_LENGTH_ONLY = REGEX_DOUBLE + "\\n?";

    public CubeLineValidator() {
        super();
    }

    public boolean lineIsValid(String line) {
        boolean isValid = Pattern.matches(REGEX_CUBE_LINE_FULL, line) || Pattern.matches(REGEX_CUBE_LINE_LENGTH_ONLY, line);
        log.log(Level.INFO, "line [{}] is {} for cube", line, isValid ? "valid" : "not valid");
        return isValid;
    }
}
