package model;

// Represents a campus food place with a name, location, cuisine type, and whether there is a vegan option
public class CampusFoodPlace {

    public String name;
    public String location;
    public String cuisineType;
    public Boolean veganOption;
    public Integer rating;


    public CampusFoodPlace() {
    }

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

    public Boolean isVegan() {
        return veganOption;
    }

    public Integer getRating() {
        return rating;
    }

}
