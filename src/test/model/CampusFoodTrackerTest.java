package model;

import exceptions.NotProperRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Unit tests for CampusFoodTracker class
class CampusFoodTrackerTest {
    private CampusFoodPlaceTracker tracker;
    private List<CampusFoodPlace> foodPlaces;
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
        tracker = new CampusFoodPlaceTracker();
        foodPlaces = new ArrayList<>();
    }

    @Test
    public void testCampusFoodPlaceTracker() {
        assertEquals(0, tracker.size());
    }

    @Test
    public void testLength() {
        assertEquals(0, tracker.size());

        tracker.addCampusFood(cfp1);
        assertEquals(1, tracker.size());
    }


    @Test
    public void testAddCampusFood() {
        tracker.addCampusFood(cfp1);
        assertEquals(1, tracker.size());
        assertEquals(cfp1, tracker.lastVisited());
        tracker.addCampusFood(cfp2);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testDuplicate() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp1);

        assertTrue(tracker.contains(cfp1));
        assertEquals(1, tracker.size());
    }

    @Test
    public void testLastVisited() {
        tracker.addCampusFood(cfp1);
        assertEquals(cfp1, tracker.lastVisited());
        tracker.addCampusFood(cfp2);
        assertEquals(cfp2, tracker.lastVisited());
    }

    @Test
    public void testListOfDifferentNames() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp2);
        tracker.addCampusFood(cfp3);

        ArrayList<java.lang.String> str = new ArrayList<>();
        str.add("the Porch");
        str.add("PacificPoke");
        str.add("Soup Kitchen");

        assertEquals(str, tracker.listOfNames());
    }

    @Test
    public void testListOfSameNames() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp1);

        ArrayList<java.lang.String> str = new ArrayList<>();
        str.add("the Porch");

        assertEquals(str, tracker.listOfNames());
    }


    @Test
    public void testListOfVeganPlaces() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp2);
        tracker.addCampusFood(cfp3);

        ArrayList<String> veganPlaces = new ArrayList<>();

        veganPlaces.add("the Porch");
        veganPlaces.add("PacificPoke");

        assertEquals(veganPlaces, tracker.listOfVeganPlaces());

    }

    @Test
    public void testMakeProperRating() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp2);
        try {
            assertTrue(tracker.makeRating(cfp2.getName(), 4));
        } catch (NotProperRatingException e) {
            fail();
        }
        assertEquals(cfp2.getRating(), 4);
    }

    @Test
    public void testMakeImproperRating() {
        try {
            assertFalse(tracker.makeRating(cfp2.getName(), 8));
        } catch (NotProperRatingException e) {
            System.out.println("Invalid rating");
        }
    }

    @Test
    public void testGetCampusFoodPlace() {
        tracker.addCampusFood(cfp1);
        tracker.addCampusFood(cfp2);
        assertEquals(cfp1, tracker.getCampusFoodPlace(0));
        assertEquals(cfp2, tracker.getCampusFoodPlace(1));
    }

    @Test
    public void testSave() {
        try {
            printWriter = new PrintWriter(new File(TRACKER_FILE));
            foodPlaces.add(cfp1);
            foodPlaces.add(cfp2);
            for (CampusFoodPlace cfp : foodPlaces) {
                cfp.save(printWriter);
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }

}
