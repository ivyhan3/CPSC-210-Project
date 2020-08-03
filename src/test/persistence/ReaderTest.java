package persistence;

import model.CampusFoodPlace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ReaderTest {

    private Reader testReader;

    @BeforeEach
    void runBefore() {
        testReader = new Reader();
    }

    @Test
    void testParseCampusFoodPlaceFile1() {
        try {
            List<CampusFoodPlace> foodPlaces = Reader.readCampusFoodPlace
                    (new File("./data/testCampusFoodPlaceTrackerFile1.txt"));
            CampusFoodPlace cfp1 = foodPlaces.get(0);
            assertEquals("the Porch", cfp1.getName());
            assertEquals("the Nest", cfp1.getLocation());
            assertEquals("healthy", cfp1.getCuisineType());
            assertEquals(true, cfp1.isVegan());
            assertEquals(5, cfp1.getRating());

            CampusFoodPlace cfp2 = foodPlaces.get(1);
            assertEquals("Subway", cfp2.getName());
            assertEquals("Life Building", cfp2.getLocation());
            assertEquals("fast food", cfp2.getCuisineType());
            assertEquals(false, cfp2.isVegan());
            assertEquals(1, cfp2.getRating());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseAccountsFile2() {
        try {
            List<CampusFoodPlace> foodPlaces = Reader.readCampusFoodPlace
                    (new File("./data/testCampusFoodPlaceTrackerFile2.txt"));
            CampusFoodPlace cfp1 = foodPlaces.get(0);
            assertEquals("the Point", cfp1.getName());
            assertEquals("Marine Dr", cfp1.getLocation());
            assertEquals("comfort food", cfp1.getCuisineType());
            assertEquals(false, cfp1.isVegan());
            assertEquals(3, cfp1.getRating());

            CampusFoodPlace cfp2 = foodPlaces.get(1);
            assertEquals("JamJar", cfp2.getName());
            assertEquals("Bus Loop", cfp2.getLocation());
            assertEquals("Lebanese", cfp2.getCuisineType());
            assertEquals(true, cfp2.isVegan());
            assertEquals(5, cfp2.getRating());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readCampusFoodPlace(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }

}
