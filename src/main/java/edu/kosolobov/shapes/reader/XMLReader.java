package edu.kosolobov.shapes.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLReader {

    public XMLReader() {
    }

    public List<Map<String, String>> readXMLbyDOM(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Map<String, String>> parametersList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        //TODO

        return parametersList;
    }

    public List<Map<String, String>> readXMLbySAX(File file) throws ParserConfigurationException, SAXException, IOException {
        List<Map<String, String>> parametersList = new ArrayList<>();

        DefaultHandler handler = new DefaultHandler() {
            private Map<String, String> parameters = new HashMap<>();

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("Property")) {
                    parameters.put(attributes.getValue("name"), attributes.getValue("value"));
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (!parameters.isEmpty() && !qName.equals("Property")) {
                    parametersList.add(parameters);
                    parameters = new HashMap<>();
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, handler);

        return parametersList;
    }

}
