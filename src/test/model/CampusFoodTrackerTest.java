package model;

import exceptions.NotProperRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


// Unit tests for CampusFoodTracker class
class CampusFoodTrackerTest {
    private CampusFoodPlaceTracker foodPlaces;
    private CampusFoodPlace cfp1 = new CampusFoodPlace("the Porch", "the Nest",
           "Healthy", true, -1);
    private CampusFoodPlace cfp2 = new CampusFoodPlace("PacificPoke", "ICICS",
           "Asian", true, -1);
    private CampusFoodPlace cfp3 = new CampusFoodPlace("Soup Kitchen", "the Nest",
            "Western", false, -1);
    private PrintWriter printWriter;
    public static final String TRACKER_FILE = "./data/tracker.txt";


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
    public void testMakeProperRating() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        try {
            assertTrue(foodPlaces.makeRating(cfp2.getName(), 4));
        } catch (NotProperRatingException e) {
            fail();
        }
        assertEquals(cfp2.getRating(), 4);
    }

    @Test
    public void testMakeImproperRating() {
        try {
            assertFalse(foodPlaces.makeRating(cfp2.getName(), 8));
        } catch (NotProperRatingException e) {
            System.out.println("Invalid rating");
        }
    }

    @Test
    public void testGetCampusFoodPlace() {
        foodPlaces.addCampusFood(cfp1);
        foodPlaces.addCampusFood(cfp2);
        assertEquals(cfp1, foodPlaces.getCampusFoodPlace(0));
        assertEquals(cfp2, foodPlaces.getCampusFoodPlace(1));
    }

    @Test
    public void testSave() {
        try {
            printWriter = new PrintWriter(new File(TRACKER_FILE));
            cfp1.save(printWriter);
        } catch (FileNotFoundException e) {
            fail();
        }
    }

}