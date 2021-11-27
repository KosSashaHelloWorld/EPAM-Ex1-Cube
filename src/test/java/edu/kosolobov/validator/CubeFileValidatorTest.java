package edu.kosolobov.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeFileValidatorTest {

    @Test
    void fileValidation() {
        CubeFileValidator val = new CubeFileValidator();
        assertTrue(val.fileIsValid("src/main/resources/example.txt"));
        assertFalse(val.fileIsValid("unknownfile.txt"));
    }

}