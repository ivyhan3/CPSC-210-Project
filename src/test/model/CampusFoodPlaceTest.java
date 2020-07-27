package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampusFoodPlaceTest {
    private CampusFoodPlace campusFoodPlace;

    @BeforeEach
    void runBefore() {
        campusFoodPlace = new CampusFoodPlace("Starbucks", new Location("Life Building"),
                new Cuisine("cafe"), true);
    }


//    @Test
//    void testConstructor() {
//        campusFoodPlace = new CampusFoodPlace("Starbucks", new Location("Life Building"),
//                new Cuisine("cafe"), true);
//
//        assertEquals("Starbucks", campusFoodPlace.getName());
//        assertEquals(new Location("Life Building"), campusFoodPlace.getCampusLocation());
//        assertEquals(new Cuisine("cafe"), campusFoodPlace.getCuisineType());
//        assertTrue(campusFoodPlace.isVegan());
//    }
}
