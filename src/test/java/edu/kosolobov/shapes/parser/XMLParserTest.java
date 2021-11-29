package edu.kosolobov.shapes.parser;

import edu.kosolobov.shapes.reader.XMLReader;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class XMLParserTest {

    @Test
    void parseXMLbyDOM() throws ParserConfigurationException, IOException, SAXException {
        XMLReader reader = new XMLReader();
        File file = reader.readFile("files/testxml.tld");

        XMLParser parser = new XMLParser();

        var list = parser.parseXMLbyDOM(file);

        assertFalse(list.isEmpty());
    }

    @Test
    void parseXMLbySAX() throws ParserConfigurationException, IOException, SAXException {
        XMLReader reader = new XMLReader();
        File file = reader.readFile("files/testxml.tld");

        XMLParser parser = new XMLParser();

        var list = parser.parseXMLbySAX(file);

        assertFalse(list.isEmpty());
    }
}