package edu.kosolobov.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LineReader {
    private static final Logger log = LogManager.getLogger();
    private List<String> lines;
    int count = -1;


    public LineReader() {
        super();
    }

    public void readFile(String filePath) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
        log.log(Level.INFO, "File {} opened.", filePath);
        lines = stream.toList();
        stream.close();
    }

    public boolean hasNext() {
        if(++count < lines.size()) {
            return true;
        }
        log.log(Level.INFO, "File ended. {} lines summary", count);
        count = -1;
        return false;
    }

    public String readLine() {
        return lines.get(count);
    }
}
