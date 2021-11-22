package edu.kosolobov.task1.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {
    private static final Logger log = LogManager.getLogger();
    private String filePath;
    Stream<String> stream;

    public Reader() {
        log.info("Empty Reader created.");
    }

    public Reader(String filePath) {
        this.filePath = filePath;
        log.info("Reader created.");
    }

    public void openFile() throws IOException {
        stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public void openFile(String newFilePath) throws IOException {
        filePath = newFilePath;
        openFile();
    }

    public Double readCubeLine() {
        return null;
    }
}
