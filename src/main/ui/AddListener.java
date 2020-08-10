package ui;

import model.CampusFoodPlace;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//adds new Campus Food Place when addBtn is pushed
class AddListener implements ActionListener {
    private final CampusFoodApp campusFoodApp;
    private boolean alreadyEnabled = false;

    //EFFECTS: initialize addListener
    public AddListener(CampusFoodApp campusFoodApp) {
        this.campusFoodApp = campusFoodApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = campusFoodApp.name.getText();
        String location = campusFoodApp.location.getText();
        String cuisineType = campusFoodApp.cuisineType.getText();
        Boolean veganOption = (Boolean) campusFoodApp.veganOption.getSelectedItem();
        int rating = (int) campusFoodApp.rating.getSelectedItem();
        campusFoodApp.setCampusFoodPlace(new CampusFoodPlace(name, location, cuisineType, veganOption, rating));
        playSound();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Name of food place cannot be empty.");
            return;
        }
        addToTable(name, location, cuisineType);
        addToTracker(name);
        resetFields();

    }

    //MODIFIES: CampusFoodApp
    //EFFECTS:add new value to tracker
    private void addToTracker(String name) {
        String location = campusFoodApp.location.getText();
        String cuisineType = campusFoodApp.cuisineType.getText();
        Boolean veganOption = (Boolean) campusFoodApp.veganOption.getSelectedItem();
        int rating = (int) campusFoodApp.rating.getSelectedItem();;
        CampusFoodPlace cfp = new CampusFoodPlace(name, location, cuisineType, veganOption, rating);
        campusFoodApp.tracker.addCampusFood(cfp);
    }

    //MODIFIES:CampusFoodApp
    //EFFECTS:add new values to table
    private void addToTable(String name, String location, String cuisineType) {
        campusFoodApp.tableModel.addRow(new Object[0]);
        campusFoodApp.tableModel.setValueAt(name, campusFoodApp.line,0);
        campusFoodApp.tableModel.setValueAt(location, campusFoodApp.line,1);
        campusFoodApp.tableModel.setValueAt(cuisineType, campusFoodApp.line,2);
        campusFoodApp.tableModel.setValueAt((Boolean) campusFoodApp.veganOption.getSelectedItem(), campusFoodApp.line,3);
        campusFoodApp.tableModel.setValueAt((int) campusFoodApp.rating.getSelectedItem(), campusFoodApp.line,4);
        campusFoodApp.table.setRowSelectionInterval(campusFoodApp.line, campusFoodApp.line);
        JOptionPane.showMessageDialog(null,name + " has been successfully added!");
        campusFoodApp.line = campusFoodApp.line + 1;
    }

    //MODIFIES:CampusFoodApp
    //EFFECTS: reset the text fields
    private void resetFields() {
        campusFoodApp.name.requestFocusInWindow();
        campusFoodApp.name.setText("");
        campusFoodApp.location.requestFocusInWindow();
        campusFoodApp.location.setText("");
        campusFoodApp.cuisineType.requestFocusInWindow();
        campusFoodApp.cuisineType.setText("");
    }



    // EFFECTS: plays a sound when user clicks addBtn
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("data/click.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }
    }
}

