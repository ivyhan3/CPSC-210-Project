package persistence;

import model.CampusFoodPlace;
import model.CampusFoodPlaceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testCampusFoodPlace.txt";
    private Writer testWriter;
    private CampusFoodPlace cfp1;
    private CampusFoodPlace cfp2;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
//        campusFoodPlaceTracker = new CampusFoodPlaceTracker();
//        campusFoodPlaceTracker.addCampusFood(cfp1);
//        campusFoodPlaceTracker.addCampusFood(cfp2);
         cfp1 = new CampusFoodPlace("PacificPoke", "ICICS",
                "Asian", true, 5);
         cfp2 =  new CampusFoodPlace("Soup Kitchen", "the Nest", "Western",
                false, 2);

    }

    @Test
    void testWriteAccounts() {
        // save campus food places to file
        testWriter.write(cfp1);
        testWriter.write(cfp2);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
        try {
            List<CampusFoodPlace> foodPlaces = Reader.readCampusFoodPlace(new File(TEST_FILE));
            CampusFoodPlace cfp1 = foodPlaces.get(0);
            assertEquals("PacificPoke", cfp1.getName());
            assertEquals("ICICS", cfp1.getLocation());
            assertEquals("Asian", cfp1.getCuisineType());
            assertEquals(true, cfp1.isVegan());
            assertEquals(5, cfp1.getRating());

            CampusFoodPlace cfp2 = foodPlaces.get(1);
            assertEquals("Soup Kitchen", cfp2.getName());
            assertEquals("the Nest", cfp2.getLocation());
            assertEquals("Western", cfp2.getCuisineType());
            assertEquals(false, cfp2.isVegan());
            assertEquals(2, cfp2.getRating());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
