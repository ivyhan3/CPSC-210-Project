package ui;

import model.CampusFoodPlace;
import model.CampusFoodPlaceTracker;

import java.util.ArrayList;
import java.util.Scanner;


// campus food application
public class CampusFoodApp {
    private Scanner input;
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
                chooseOption(entry);
            }

        }
    }

    // EFFECTS: displays the menu
    private void run() {

        boolean continueOn = true;
        String entry = null;
        input = new Scanner(System.in);

        while (continueOn) {
            displayMenu();
            entry = input.next();

            if (entry.equals("e")) {
                continueOn = false;
                closeApp();
            } else {
                chooseOption(entry);
            }

        }
    }


    // MODIFIES: this
    // EFFECTS: processes user entry
    private void chooseOption(String entry) {

        if (entry.equals("a")) {
            logFoodPlace();
            rePrompt(PROMPT);

        } else if (entry.equals("p")) {
            printNames();
            rePrompt(PROMPT);

        } else if (entry.equals("v")) {
            printVeganNames();
            rePrompt(PROMPT);

        } else if (entry.equals("i")) {
            printInfo();
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
        System.out.println("\tp -> Print list of visited campus food place names");
        System.out.println("\tv -> Print list of vegan campus food places");
        System.out.println("\ti -> Print list of visited campus food place info");
        System.out.println("\te -> Exit");
    }


    // EFFECTS: prompts user to enter name, location, cuisine type, and vegan option of food place
    private void logFoodPlace() {

        input = new Scanner(System.in);

        System.out.println("Enter the name of food place");
        String name = input.nextLine();

        System.out.println("Enter the location of food place");
        String location = input.nextLine();

        System.out.println("Enter the cuisine type of food place");
        String cuisineType = input.nextLine();

        System.out.println("Does this food place carry vegan options? (Type True = yes False = no)");
        Boolean veganOption = input.nextBoolean();

        System.out.println("What rating would you give out of 5?");
        Integer rating = input.nextInt();


        CampusFoodPlace campusFoodPlace = new CampusFoodPlace(name, location, cuisineType, veganOption,
                rating);

        // Adds campus food place to the tracker
        campusFoodPlaceTracker.addCampusFood(campusFoodPlace);

        System.out.println("\"" + campusFoodPlace.getName() + "\"" + " has been added to the tracker");
    }

    // EFFECTS: prints list of visited campus food places on screen
    private void printNames() {
        System.out.println(campusFoodPlaceTracker.listOfNames());
    }

    // EFFECTS: prints list of visited campus food places that are vegan
    private void printVeganNames() {
        System.out.println(campusFoodPlaceTracker.listOfVeganPlaces());
    }

    // EFFECTS: prints info of all visited campus food places
    private void printInfo() {
        System.out.println(campusFoodPlaceTracker.getCampusFoods());
    }


    private void rePrompt(String prompt) {
        String entry = null;
        System.out.println(prompt);
        run();
    }

    private void closeApp() {
        System.out.println("Thank you for using the UBC Food App.");
        System.out.println("See you next time!");
        System.exit(0);
    }


}



