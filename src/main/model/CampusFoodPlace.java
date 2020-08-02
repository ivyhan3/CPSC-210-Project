package model;

import exceptions.NotProperRating;
import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

// Represents a campus food place with a name, location, cuisine type, and whether there is a vegan option
public class CampusFoodPlace implements Saveable {

    private String name;
    private String location;
    private String cuisineType;
    private Boolean veganOption;
    private Integer rating;


    // REQUIRES: name, location, and cuisine have a non-zero length
    // EFFECTS: constructs a food place on campus with a name, location, cuisine type, whether there's a
    // vegan option available, and a rating out of 5
    public CampusFoodPlace(String name, String location, String cuisineType, Boolean veganOption, Integer rating) {
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
        this.veganOption = veganOption;
        this.rating = rating;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    @Override
    public String toString() {
        return "CampusFoodPlace{"
                +
                "name='"
                + name
                + '\''
                +
                ", location='"
                + location
                + '\''
                + ", cuisineType='"
                + cuisineType
                + '\''
                + ", veganOption="
                + veganOption
                + ", rating="
                + rating + '}';
    }

    public Boolean isVegan() {
        return veganOption;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) throws NotProperRating {
        if (rating < 0 || rating > 5) {
            throw new NotProperRating();
        }
        this.rating = rating;
    }


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(name);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(location);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(cuisineType);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(veganOption);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(rating);
    }
}
