package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for CampusFoodTracker class
class CampusFoodTrackerTest {
    private CampusFoodPlaceTracker foodPlaces;
    private CampusFoodPlace cfp1 = new CampusFoodPlace("the Porch", new java.lang.String("the Nest"),
            new String("Healthy"), true, -1);
    private CampusFoodPlace cfp2 = new CampusFoodPlace("PacificPoke", new java.lang.String("ICICS"),
            new String("Asian"), true, -1);
    private CampusFoodPlace cfp3 = new CampusFoodPlace("Soup Kitchen", new java.lang.String("the Nest"),
            new String("Western"), false, -1);


    @BeforeEach
    public void runBefore() {
        foodPlaces = new CampusFoodPlaceTracker();
    }

    @Test
    public void testCampusFoodPlaceTracker() {
        assertEquals(0, foodPlaces.size());
    }

    @Test
    public void testLength() {
        assertEquals(0, foodPlaces.size());

        foodPlaces.addCampusFood(cfp1);
        assertEquals(1, foodPlaces.size());
    }


    @Test
    public void testAddCampusFood() {
        foodPlaces.addCampusFood(cfp1);
        assertEquals(1, foodPlaces.size());
        assertEquals(cfp1, foodPlaces.lastVisited());
        foodPlaces.addCampusFood(cfp2);
        assertEquals(2, foodPlaces.size());
    }

    @Test
    public void testDuplicate() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp1);

        assertTrue(foodPlaces.contains(cfp1));
        assertEquals(1, foodPlaces.size());
    }

    @Test
    public void testLastVisited() {
        foodPlaces.addCampusFood(cfp1);
        assertEquals(cfp1, foodPlaces.lastVisited());
        foodPlaces.addCampusFood(cfp2);
        assertEquals(cfp2, foodPlaces.lastVisited());
    }

    @Test
    public void testListOfDifferentNames() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        foodPlaces.addCampusFood(cfp3);

        ArrayList<java.lang.String> str = new ArrayList<>();
        str.add("the Porch");
        str.add("PacificPoke");
        str.add("Soup Kitchen");

        assertEquals(str, foodPlaces.listOfNames());
    }

    @Test
    public void testListOfSameNames() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp1);

        ArrayList<java.lang.String> str = new ArrayList<>();
        str.add("the Porch");

        assertEquals(str, foodPlaces.listOfNames());
    }


    @Test
    public void testListOfVeganPlaces() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        foodPlaces.addCampusFood(cfp3);

        ArrayList<String> veganPlaces = new ArrayList<>();

        veganPlaces.add("the Porch");
        veganPlaces.add("PacificPoke");

       assertEquals(veganPlaces, foodPlaces.listOfVeganPlaces());

    }

    @Test
    public void testMakeRating() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        assertTrue(foodPlaces.makeRating(cfp2.getName(), 4));
        assertEquals(cfp2.getRating(), 4);
    }

    @Test
    public void testMakeRatingEmpty() {
        assertFalse(foodPlaces.makeRating(cfp2.getName(), 4));
    }

    @Test
    public void testGetCampusFoodPlace() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        assertEquals(cfp1, foodPlaces.getCampusFoodPlace(0));
        assertEquals(cfp2, foodPlaces.getCampusFoodPlace(1));
    }

}