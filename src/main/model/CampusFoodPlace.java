package model;

import com.sun.org.apache.xpath.internal.operations.Bool;

// Represents a campus food place with a name, location, cuisine type, and whether there is a vegan option
public class CampusFoodPlace {

    private String name;
    private Location theNest;
    private Location theResCafeteria;
    private Location theLifeBuilding;
    private Location theLifeScienceBuilding;
    private Location theMainMall;
    private Location theWesbrookVillage;
    private Cuisine fastFood;
    private Cuisine asian;
    private Cuisine italian;
    private Cuisine healthy;
    private Cuisine dessert;
    private Boolean veganOption;


    // REQUIRES: name, location, and cuisine have a non-zero length
    // EFFECTS: constructs a food place on campus with
    public CampusFoodPlace(String name, Location location, Cuisine cuisine, Boolean veganOption) {
        this.name = name;
        this.location = location;
        this.veganOption = veganOption;
        initializeCuisine();
        for (Cuisine type: types) {
            setCuisine

        }
    }

    private void initializeCuisine() {
        this.fastFood = new Cuisine("Fast Food");
        this.asian = new Cuisine("Asian");
        this.italian = new Cuisine("Italian");
        this.healthy = new Cuisine("Healthy");
        this.dessert = new Cuisine("Dessert");
    }


    private void initializeLocation() {
        this.theNest = new Location("the Nest");
        this.theResCafeteria = new Location("the Res Cafeteria");
        this.theLifeBuilding = new Location("the Life Building");
        this.theLifeScienceBuilding = new Location("the Life Science Building");
        this.theWesbrookVillage = new Location("the Wesbrook Village");

    }



    // getters
    public String getName() {
        return name;
    }

    public Location getTheNest() {
        return theNest;
    }

    public Location getTheResCafeteria() {
        return theResCafeteria;
    }

    public Location getTheLifeBuilding() {
        return theLifeBuilding;
    }

    public Location getTheLifeScienceBuilding() {
        return theLifeScienceBuilding;
    }

    public Location getTheMainMall() {
        return theMainMall;
    }

    public Location getTheWesbrookVillage() {
        return theWesbrookVillage;
    }

    public Cuisine getFastFood() {
        return fastFood;
    }

    public Cuisine getAsian() {
        return asian;
    }

    public Cuisine getItalian() {
        return italian;
    }

    public Cuisine getHealthy() {
        return healthy;
    }

    public Cuisine getDessert() {
        return dessert;
    }


}
