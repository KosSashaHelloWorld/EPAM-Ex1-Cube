package edu.kosolobov.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CubeFileValidatorTest {

    @Test
    void fileValidation() {
        CubeFileValidator validator = new CubeFileValidator();
        List<String> lines = validator.getValidLines("src/test/resources/example.txt");
        assertFalse(lines.isEmpty());
    }

}