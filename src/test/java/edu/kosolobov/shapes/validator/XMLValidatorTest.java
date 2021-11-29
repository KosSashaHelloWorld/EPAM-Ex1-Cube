package edu.kosolobov.shapes.validator;

import edu.kosolobov.shapes.reader.XMLReader;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class XMLValidatorTest {

    @Test
    void isValid() throws XMLStreamException {
        XMLReader reader = new XMLReader();
        File file = reader.readFile("files/testxml.tld");

        XMLValidator validator = new XMLValidator();

        assertTrue(validator.isValid(file));
    }
}