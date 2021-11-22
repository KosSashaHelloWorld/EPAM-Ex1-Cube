package reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {
    private String filePath;
    Stream<String> stream;

    public Reader() {

    }

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public void openFile() throws IOException {
        stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public void openFile(String newFilePath) throws IOException {
        filePath = newFilePath;
        openFile();
    }

    public Double read() throws IOException {
        StringBuilder number = new StringBuilder();

        int ch;
    }
}
