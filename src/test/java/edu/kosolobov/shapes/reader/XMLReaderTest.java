package edu.kosolobov.shapes.reader;

import edu.kosolobov.shapes.validator.FileValidator;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class XMLReaderTest {

    @Test
    void readXMLbySAX() throws ParserConfigurationException, IOException, SAXException {
        URL fileUrl = FileReader.class
                .getClassLoader()
                .getResource("files/testxml.tld");

        File file = new File(fileUrl.getFile());

        XMLReader reader = new XMLReader();
        reader.readXMLbySAX(file);
    }
}