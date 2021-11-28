package edu.kosolobov.validator;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CubeFileValidatorTest {

    @Test
    void fileValidation() {
        URL fileUrl = CubeFileValidatorTest.class
                .getClassLoader()
                .getResource("files/example.txt");
        assertNotNull(fileUrl);
        File file = new File(fileUrl.getFile());
        String filePath = file.getAbsolutePath();
        CubeFileValidator validator = new CubeFileValidator();
        List<String> lines = validator.getValidLines(filePath);
        assertFalse(lines.isEmpty());
    }

}