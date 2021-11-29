package edu.kosolobov.shapes.regex;

public record RegexRecord() {
    public static final String REGEX_LINE_END = "\\s*\\n?";
    public static final String REGEX_DELIMITER = "\\s*[,]\\s*";
    public static final String REGEX_INTEGER = "[-]?\\d+";
    public static final String REGEX_DOUBLE = "[-]?\\d+\\.\\d+";
    public static final String REGEX_SOME_DOUBLES = "(" + REGEX_DOUBLE + REGEX_DELIMITER + "){%d}" + REGEX_DOUBLE + REGEX_LINE_END;
    public static final String REGEX_SOME_INTEGERS = "(" + REGEX_INTEGER + REGEX_DELIMITER + "){%d}" + REGEX_INTEGER + REGEX_LINE_END;
}
