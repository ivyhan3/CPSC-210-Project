# UBC Campus Food Tracker

### What will the application do?
This application will allow the user to keep track of all the UBC food places they
have been to. They can add new food places they've visited or add the pre-existing 
food places on the app. Additionally, users can add comments to the places they've been
to and view food places based on a certain string or cuisine.

### Who will use it?
This application is made for UBC students and staff who wish to keep track of the food places
they have visited or are searching for a food place to visit based on their preferences. 

### User Stories
- As a user, I want to add a campus food place to my tracker.
- As a user, I want to view a list of all the visited campus food places.
- As a user, I want to view a list of names of all the vegan campus food places that I've visited. 
- As a user, I want to select a campus food place and leave a rating out of 5.
- As a user, I want to be able to save my CampusFoodPlaceTracker to file.
- As a user, I want to be able to load my CampusFoodPlaceTracker from file when program starts and have
all my lists saved.

### Instructions for Grader:

- You can generate the first required event by clicking the button labelled "Add Food Place" to input and add a new Campus Food Place
to the tracker.
- You can generate the second required event by clicking the button labelled "Save" to save the new Campus Food Place to the tracker.
- You can trigger my audio component by  clicking the "Add Food Place" button. 
- You can save the state of my application by clicking the "Save" button.
- You can load the state of my application automatically upon opening the app.

### Phase 4: Task 2:
- To make the CampusFoodPlace class robust, I added a NotProperRatingException checked exception to the 
setRating() method. This exception is thrown if a rating is not in the range 0-5.
-In the CampusFoodPlaceTest class, I added two Tests for when the rating is proper and exception is 
not expected as well as for when the rating is improper and exception is expected.

### Phase 4: Task 3:
1. Refactored two for-loops in loadFoodPlaces() to increase readability and improve cohesion as it was difficult
to understand the function of the for-loops inside the method. Also refactored the CampusFoodApp constructor to 
make a new method called initInput which initializes the five input fields of the tracker as well as a createButtonPanel 
method which groups all the code related to making a button panel. This reduced the crowding of code within my constructor 
and increases readability.

2. Made a new class called SoundPlayer and removed the playSound() method in AddListener class to 
improve cohesion of the AddListener class and to follow the Single Responsibility Principle. Since this class is composed of methods that deals with adding 
campus food places to the tracker, the playSound() lowered cohesion by diverting focus to two different tasks. AddListener 
now calls the SoundPlayer within ActionPerformed whenever the Add button is pressed.
~~~~ 