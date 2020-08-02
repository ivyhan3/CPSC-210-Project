//package persistence;
//
//import model.CampusFoodPlace;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReaderCampusFoodPlace extends Reader {
//    public static final String DELIMITER = ";";
//
//    // EFFECTS: returns a list of campus food places parsed from file; throws
//    // IOException if an exception is raised when opening / reading from file
//    public static List<CampusFoodPlace> readCampusFoodPlace(File file) throws IOException {
//        List<String> fileContent = readFile(file);
//        return parseCampusFoodPlaces(fileContent);
//    }
//
//    // EFFECTS: returns a list of campus food places parsed from list of strings
//    // where each string contains data for one campus food place
//    static List<CampusFoodPlace> parseCampusFoodPlaces(List<String> fileContent) {
//        List<CampusFoodPlace> foodPlaces = new ArrayList<>();
//
//        for (String line : fileContent) {
//            ArrayList<String> lineComponents = (ArrayList<String>) splitString(line);
//            foodPlaces.add(parseCampusFoodPlace(lineComponents));
//        }
//
//        return foodPlaces;
//    }
//
//
//    // REQUIRES: components has size 5 where element 0 represents the
//    // name of campus food place, element 1 represents location, elements 2 represents the type of cuisine,
//    // element 3 represents whether the food place is vegan, and element 4 represents the rating of the food place
//    // EFFECTS: returns a campus food place constructed from components
//    public static CampusFoodPlace parseCampusFoodPlace(List<String> components) {
//        String name = components.get(0).trim();
//        String location = components.get(1).trim();
//        String cuisineType = components.get(2).trim();
//        Boolean veganOption = Boolean.parseBoolean(components.get(3).trim());
//        int rating = Integer.parseInt(components.get(4).trim());
//        return new CampusFoodPlace(name, location, cuisineType, veganOption, rating);
//    }
//
//}
