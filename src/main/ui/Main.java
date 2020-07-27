package ui;

import model.CampusFoodPlace;

public class Main {
    public static void main(java.lang.String[] args) {
        new CampusFoodApp();

        CampusFoodPlace cfp1;
        CampusFoodPlace cfp2;
        CampusFoodPlace cfp3;
        CampusFoodPlace cfp4;
        CampusFoodPlace cfp5;
        CampusFoodPlace cfp6;

        cfp1 = new CampusFoodPlace("the Porch", "the Nest", "Healthy",
                true, 5);
        cfp2 = new CampusFoodPlace("PacificPoke", "ICICS", "Asian",
                true, 4);
        cfp3 = new CampusFoodPlace("Soup Kitchen", "the Nest", "Western",
                false, 2);
        cfp4 = new CampusFoodPlace("Tim Hortons", "Main Mall", "cafe",
                false, 3);
        cfp5 = new CampusFoodPlace("Starbucks", "Life Building", "cafe",
                true, 4);
        cfp6 = new CampusFoodPlace("Subway","Life Building", "fast food",
                true, 5);

    }
}
