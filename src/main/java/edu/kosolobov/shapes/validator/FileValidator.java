package edu.kosolobov.shapes.validator;

import edu.kosolobov.shapes.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class FileValidator {
    private static final FileReader reader = new FileReader();

    private FileValidator() {

    }

    public static boolean validateFile(String filePath) {
        URL fileUrl = FileReader.class
                .getClassLoader()
                .getResource(filePath);

        return fileUrl != null;
    }

    public static boolean validateFileURL(URL url) {
        return url != null;
    }
}
