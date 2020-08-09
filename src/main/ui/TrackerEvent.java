package ui;

import model.CampusFoodPlace;

import java.util.EventObject;

public class TrackerEvent extends EventObject {

    private String name;
    private String location;
    private String cuisineType;
    private Boolean veganOption;
    private int rating;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TrackerEvent(Object source, String name, String location, String cuisineType, Boolean veganOption,
                        int rating) {
        super(source);
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
        this.veganOption = veganOption;
        this.rating = rating;
    }

    // Setters and getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Boolean getVeganOption() {
        return veganOption;
    }

    public void setVeganOption(Boolean veganOption) {
        this.veganOption = veganOption;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
