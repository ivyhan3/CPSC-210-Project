package persistence;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representation of Reader
 */


public abstract class Reader {
    public static final String DELIMITER = ";";

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    public static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    public static List<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }
}




