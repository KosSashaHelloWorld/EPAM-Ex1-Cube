package edu.kosolobov.shapes.reader;

import edu.kosolobov.shapes.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger log = LogManager.getLogger();


    public FileReader() {
        super();
    }

    public List<String> readFile(String filePath) {
        String absolutePath;
        URL fileUrl = FileReader.class
                .getClassLoader()
                .getResource(filePath);

        if (FileValidator.validateFileURL(fileUrl)) {
            File file = new File(fileUrl.getFile());
            absolutePath = file.getAbsolutePath();
        } else {
            log.log(Level.ERROR, "File {} is invalid", filePath);
            return new ArrayList<>();
        }


        Stream<String> stream;
        try {
            stream = Files.lines(Paths.get(absolutePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.log(Level.ERROR, "File {} is invalid: {}", absolutePath, e.toString());
            return new ArrayList<>();
        }

        log.log(Level.INFO, "File {} opened.", absolutePath);
        List<String> lines = stream.toList();
        stream.close();

        return lines;
    }
}
