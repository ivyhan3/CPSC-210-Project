package ui;

import model.CampusFoodPlace;
import model.CampusFoodPlaceTracker;

import java.util.ArrayList;
import java.util.Scanner;


// campus food application
public class CampusFoodApp {
    private ArrayList<CampusFoodPlaceTracker> trackerLog;
    private Scanner input;
    private CampusFoodPlace campusFoodPlace;
    private CampusFoodPlaceTracker campusFoodPlaceTracker = new CampusFoodPlaceTracker();
    private static final String PROMPT = "\nWhat else would you like to do?";

    // EFFECTS: runs the food application
    public CampusFoodApp() {
        runGreeter();
    }

    // EFFECTS: greets the user and displays menu
    private void runGreeter() {

        boolean continueOn = true;
        String entry = null;
        input = new Scanner(System.in);

        System.out.println("Welcome to the UBC Campus Food App! ");
        System.out.println("What would you like to do today?");

        while (continueOn) {
            displayMenu();
            entry = input.next();

            if (entry.equals("e")) {
                continueOn = false;
                closeApp();
            } else {
                chooseOption();
            }

        }
    }


    // MODIFIES: this
    // EFFECTS: processes user entry
    private void chooseOption() {
        String entry = input.nextLine();

        if (entry.equals("a")) {
            logFoodPlace(campusFoodPlace);
            rePrompt(PROMPT);

        } else if (entry.equals("p")) {
            printNames();
            rePrompt(PROMPT);

        } else if (entry.equals("e")) {
            closeApp();

        } else {
            rePrompt("Invalid selection");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Log food place");
        System.out.println("\tp -> Print list of visited campus food places");
        System.out.println("\te -> Exit");
    }


    // EFFECTS: prompts user to enter name, location, cuisine type, and vegan option of food place
    private void logFoodPlace(CampusFoodPlace campusFoodPlace) {

        System.out.println("Enter the name of food place");
        String name = input.nextLine();

        System.out.println("Enter the location of food place");
        String location = input.nextLine();

        System.out.println("Enter the cuisine type of food place");
        String cuisineType = input.nextLine();

        System.out.println("Does this food place carry vegan options");
        Boolean veganOption = input.nextBoolean();

        // Adds campus food place to the tracker
        campusFoodPlaceTracker.addCampusFood(campusFoodPlace);

        System.out.println("\"" + campusFoodPlace + "\"" + " has been added to the tracker");
    }

    // EFFECTS: prints list of visited campus food places on screen
    private void printNames() {
        System.out.println(campusFoodPlaceTracker.listOfNames());
    }

    private void rePrompt(String prompt) {
        System.out.println(prompt);
        displayMenu();
        chooseOption();
    }

    private void closeApp() {
        System.out.println("Thank you for using the UBC Food App.");
        System.out.println("See you next time!");
        System.exit(0);
    }


}



