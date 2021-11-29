package edu.kosolobov.shapes.reader;

import java.io.File;
import java.net.URL;

public class XMLReader {

    public XMLReader() {
    }

    public File readFile(String filePath) {
        URL fileUrl = XMLReader.class
                .getClassLoader()
                .getResource(filePath);
        return new File(fileUrl.getFile());
    }
}