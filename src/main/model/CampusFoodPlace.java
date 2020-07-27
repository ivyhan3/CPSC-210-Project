package model;

import com.sun.org.apache.xpath.internal.operations.Bool;

// Represents a campus food place with a name, location, cuisine type, and whether there is a vegan option
public class CampusFoodPlace {

    private String name;
    private Location campusLocation;
    private Cuisine cuisineType;
    private Boolean veganOption;


    // REQUIRES: name, location, and cuisine have a non-zero length
    // EFFECTS: constructs a food place on campus with
    public CampusFoodPlace(String name, Location campusLocation, Cuisine cuisineType, Boolean veganOption) {
        this.name = name;
        this.campusLocation = campusLocation;
        this.cuisineType = cuisineType;
        this.veganOption = veganOption;
    }

    // getters
    public String getName() {
        return name;
    }

    public Location getCampusLocation() {
        return campusLocation;
    }

    public Cuisine getCuisineType() {
        return cuisineType;
    }

    public  Boolean isVegan() {
        return veganOption; }

}
