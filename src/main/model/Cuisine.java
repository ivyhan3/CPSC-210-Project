package model;

public class Cuisine {

    private String cuisineType;

    // REQUIRES: cuisineType must be non-zero length
    // EFFECTS: creates cuisine with cuisine type
    public Cuisine(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getCuisineType() {
        return cuisineType;
    }

}
