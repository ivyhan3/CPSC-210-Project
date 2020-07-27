package ui;

import model.CampusFoodPlace;
import model.Cuisine;
import model.Location;

public class Main {
    public static void main(String[] args) {
        new CampusFoodApp();

        CampusFoodPlace cfp1;
        CampusFoodPlace cfp2;
        CampusFoodPlace cfp3;
        CampusFoodPlace cfp4;
        CampusFoodPlace cfp5;
        CampusFoodPlace cfp6;

        cfp1 = new CampusFoodPlace("the Porch", new Location("the Nest"), new Cuisine("Healthy"),
                true);
        cfp2 = new CampusFoodPlace("PacificPoke", new Location("ICICS"), new Cuisine("Asian"),
                true);
        cfp3 = new CampusFoodPlace("Soup Kitchen", new Location("the Nest"), new Cuisine("Western"),
                false);
        cfp4 = new CampusFoodPlace("Tim Hortons", new Location("Main Mall"), new Cuisine("cafe"),
                false);
        cfp5 = new CampusFoodPlace("Starbucks", new Location("Life Building"), new Cuisine("cafe"),
                true);
        cfp6 = new CampusFoodPlace("Subway", new Location("Life Building"), new Cuisine("fast food"),
                true);

    }
}
