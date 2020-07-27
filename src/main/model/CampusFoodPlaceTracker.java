package model;

import java.util.ArrayList;
import java.util.List;

public class CampusFoodPlaceTracker {
    private List<CampusFoodPlace> foodPlaces;
    CampusFoodPlace cfp1;
    CampusFoodPlace cfp2;
    CampusFoodPlace cfp3;
    CampusFoodPlace cfp4;
    CampusFoodPlace cfp5;
    CampusFoodPlace cfp6;

    // EFFECTS: constructs an empty list of visited food places
    public CampusFoodPlaceTracker() {
        foodPlaces = new ArrayList<>();
    }

    // getter
    public List<CampusFoodPlace> getCampusFoods() {
        return this.foodPlaces;
    }

    // EFFECTS: returns the length of the list
    public int size() {
        return foodPlaces.size();
    }

    // EFFECTS: returns true
    public boolean contains(CampusFoodPlace foodPlace) {
        return foodPlaces.contains(foodPlace);
    }


    // MODIFIES: this
    // EFFECTS: adds a campus food place to the list if it's not already in the CampusFoodTracker
    public void addCampusFood(CampusFoodPlace foodPlace) {
        if (!contains(foodPlace)) {
            foodPlaces.add(foodPlace);
        }
    }


    // REQUIRES: at least 1 CampusFoodPlace in the list
    // EFFECTS: returns the last visited campus food place in the list
    public CampusFoodPlace lastVisited() {
        //stub
        return foodPlaces.get(foodPlaces.size() - 1);
    }

    // EFFECTS: returns the names of all campus food places that have not been visited before
    public ArrayList<String> listOfNames() {
        ArrayList<String> str = new ArrayList<>();

        for (CampusFoodPlace cfp : this.getCampusFoods()) {
            str.add(cfp.getName());
        }
        return str;
    }


    // EFFECTS: returns the names of all campus food places that are vegan
    public ArrayList<String> listOfVeganPlaces() {
        ArrayList<String> veganPlaces = new ArrayList<>();

        for (CampusFoodPlace cfp : this.getCampusFoods()) {
            if (cfp.isVegan()) {
                veganPlaces.add(cfp.getName());
            }
        }
        return veganPlaces;
    }


}





