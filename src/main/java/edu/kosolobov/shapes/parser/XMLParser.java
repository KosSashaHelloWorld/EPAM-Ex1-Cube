package edu.kosolobov.shapes.parser;

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

public class XMLParser {
    private List<Map<String, String>> parametersList = new ArrayList<>();
    private Map<String, String> parameters = new HashMap<>();

    public XMLParser() {
    }

    public List<Map<String, String>> parseXMLbyDOM(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        deepParseNodeList(nodeList);

        return parametersList;
    }

    private void deepParseNodeList(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element element) {
                if (element.getNodeName().equals("Property"))
                {
                    String name = element.getAttribute("name");
                    String value = element.getAttribute("value");
                    parameters.put(name, value);

                }
                else if (!parameters.isEmpty())
                {
                    parametersList.add(parameters);
                    parameters = new HashMap<>();
                }

                if (element.hasChildNodes())
                {
                    deepParseNodeList(element.getChildNodes());
                }
            }
        }
        if (!parameters.isEmpty())
        {
            parametersList.add(parameters);
            parameters = new HashMap<>();
        }
    }

    public List<Map<String, String>> parseXMLbySAX(File file) throws ParserConfigurationException, SAXException, IOException {
        parametersList = new ArrayList<>();

        DefaultHandler handler = new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("Property")) {
                    parameters.put(attributes.getValue("name"), attributes.getValue("value"));
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
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
