package persistence;

import model.CampusFoodPlace;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCampusFoodPlace extends Reader {
    public static final String DELIMITER = ";";

    // EFFECTS: returns a list of campus food places parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<CampusFoodPlace> readCampusFoodPlace(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseCampusFoodPlaces(fileContent);
    }

    // EFFECTS: returns a list of campus food places parsed from list of strings
    // where each string contains data for one campus food place
    static List<CampusFoodPlace> parseCampusFoodPlaces(List<String> fileContent) {
        List<CampusFoodPlace> foodPlaces = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = (ArrayList<String>) splitString(line);
            foodPlaces.add(parseCampusFoodPlace(lineComponents));
        }

        return foodPlaces;
    }


    // REQUIRES: components has size 7 where element 0 represents the
    // name of food, element 1 represents amount, elements 2 represents the serving and
    // element 3 represents description, element 4 represents the date bought,
    // element 5 represents the date expired, and last is category
    // EFFECTS: if length is 6 elements , returns fridge food constructed from components
    //          otherwise throw not enough arguments error
    public static CampusFoodPlace parseCampusFoodPlace(List<String> components) {
        String name = components.get(0).trim();
        String location = components.get(1).trim();
        String cuisineType = components.get(2).trim();
        Boolean veganOption = Boolean.parseBoolean(components.get(3).trim());
        int rating = Integer.parseInt(components.get(4).trim());
        return new CampusFoodPlace(name, location, cuisineType, veganOption, rating);
    }

}
