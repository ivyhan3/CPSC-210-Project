package persistence;

import model.CampusFoodPlace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Credit: TellerApp (AccountNotRobust) CPSC 210.
 */


// A reader that can read account data from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of campus food places parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<CampusFoodPlace> readCampusFoodPlace(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of campus food places parsed from list of strings
    // where each string contains data for one campus food place
    private static List<CampusFoodPlace> parseContent(List<String> fileContent) {
        List<CampusFoodPlace> foodPlaces = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            foodPlaces.add(parseCampusFoodPlace(lineComponents));
        }

        return foodPlaces;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 5 where element 0 represents the
    // name of campus food place, element 1 represents location, elements 2 represents the type of cuisine,
    // element 3 represents whether the food place is vegan, and element 4 represents the rating of the food place
    // EFFECTS: returns a campus food place constructed from components
    private static CampusFoodPlace parseCampusFoodPlace(List<String> components) {
        String name = components.get(0);
        String location = components.get(1);
        String cuisineType = components.get(2);
        Boolean veganOption = Boolean.parseBoolean(components.get(3));
        int rating = Integer.parseInt(components.get(4));
        return new CampusFoodPlace(name, location, cuisineType, veganOption, rating);
    }
}




