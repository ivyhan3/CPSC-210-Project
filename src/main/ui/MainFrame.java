package ui;

import model.CampusFoodPlace;

import javax.swing.*;
import java.awt.*;

//Creates the main screen for the application
public class MainFrame extends JFrame {
    private TrackerPanel trackerPanel;

    public MainFrame(String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        trackerPanel = new TrackerPanel();

        trackerPanel.addTrackerListener(new TrackerListener() {
            public void trackerEventOccurred(TrackerEvent event) {
                String name = event.getName();
                String location = event.getLocation();
                String cuisineType = event.getCuisineType();

                textArea.append(name + location + cuisineType);
            }
        });

        // Add swing components to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(trackerPanel, BorderLayout.WEST);

    }
}
