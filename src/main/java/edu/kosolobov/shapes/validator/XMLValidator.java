package edu.kosolobov.shapes.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLValidator {
    private static final Logger log = LogManager.getLogger(XMLValidator.class);

    public XMLValidator() {
    }

    public boolean isValid(File file) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        FileInputStream stream;
        XMLStreamReader reader;

        try {
            stream = new FileInputStream(file);
            reader = factory.createXMLStreamReader(stream);
        } catch (FileNotFoundException e) {
            log.log(Level.ERROR, "File {} not found: {}", file.getAbsolutePath(), e.getMessage());
            return false;
        }

        boolean hasFiguresList = false;
        boolean hasFigures = false;
        boolean hasProperties = false;

        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if (reader.getLocalName().equals("Figures")) {
                    hasFiguresList = true;
                }
                if (reader.getLocalName().equals("Figure")) {
                    hasFigures = true;
                }
                if (reader.getLocalName().equals("Property")) {
                    hasProperties = true;
                }
            }
        }

        return hasFiguresList && hasFigures && hasProperties;
    }
}
