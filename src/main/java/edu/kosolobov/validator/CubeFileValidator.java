package edu.kosolobov.validator;

import edu.kosolobov.reader.LineReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CubeFileValidator {
    private static final Logger log = LogManager.getLogger();
    private static final LineReader reader = new LineReader();

    public CubeFileValidator() {
        super();
    }

    public List<String> getValidLines(String filePath) {
        List<String> lines = new ArrayList<>();

        try {
            reader.readFile(filePath);
        } catch (IOException e) {
            log.log(Level.ERROR, "File is invalid: {}", e.toString());
            log.log(Level.WARN, "Lines list is empty");
            return lines;
        }

        String line;
        while (reader.hasNext()) {
            line = reader.readLine();
            if (!line.isBlank() && !line.isEmpty()) {
                lines.add(line);
            }
        }

        return lines;
    }
}
