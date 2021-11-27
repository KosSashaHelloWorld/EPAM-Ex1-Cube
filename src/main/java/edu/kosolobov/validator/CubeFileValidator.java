package edu.kosolobov.validator;

import edu.kosolobov.reader.LineReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CubeFileValidator {
    private static final Logger log = LogManager.getLogger();
    private static final LineReader reader = new LineReader();
    private static final CubeLineValidator validator = new CubeLineValidator();

    public CubeFileValidator() {
        super();
    }

    public boolean fileIsValid(String filePath) {
        try {
            reader.readFile(filePath);
        } catch (IOException e) {
            log.log(Level.WARN, "File is invalid: {}", e.toString());
            return false;
        }

        while (reader.hasNext()) {
            if (!validator.lineIsValid(reader.readLine())) {
                log.log(Level.WARN, "Invalid line was found: {}", reader.readLine());
            }
        }

        return true;
    }
}
