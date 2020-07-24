package model;

public class Location {

    private String location;

    // REQUIRES: location must be non-zero length
    // EFFECTS: creates location
    public Location(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
