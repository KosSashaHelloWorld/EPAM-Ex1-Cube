package edu.kosolobov.regex;

public record RegexRecord() {
    public static final String REGEX_DELIMITER = "\\s*[,]\\s*";
    public static final String REGEX_INTEGER = "[-]?\\d+";
    public static final String REGEX_DOUBLE = "[-]?\\d+[.,]\\d+";
}
