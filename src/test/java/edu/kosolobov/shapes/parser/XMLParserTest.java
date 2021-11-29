package edu.kosolobov.shapes.parser;

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
        URL fileUrl = XMLParserTest.class
                .getClassLoader()
                .getResource("files/testxml.tld");
        File file = new File(fileUrl.getFile());

        XMLParser parser = new XMLParser();

        var list = parser.parseXMLbyDOM(file);

        System.out.println(list);
    }

    @Test
    void parseXMLbySAX() throws ParserConfigurationException, IOException, SAXException {
        URL fileUrl = XMLParserTest.class
                .getClassLoader()
                .getResource("files/testxml.tld");
        File file = new File(fileUrl.getFile());

        XMLParser parser = new XMLParser();

        var list = parser.parseXMLbySAX(file);

        System.out.println(list);
    }
}