package ui;

import model.CampusFoodPlace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//adds new Campus Food Place when addBtn is pushed
class AddListener implements ActionListener {
    private final CampusFoodApp campusFoodApp;
    private SoundPlayer soundPlayer;

    //EFFECTS: initialize addListener
    public AddListener(CampusFoodApp campusFoodApp) {
        this.campusFoodApp = campusFoodApp;
        soundPlayer = new SoundPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = campusFoodApp.name.getText();
        String location = campusFoodApp.location.getText();
        String cuisineType = campusFoodApp.cuisineType.getText();
        Boolean veganOption = (Boolean) campusFoodApp.veganOption.getSelectedItem();
        int rating = (int) campusFoodApp.rating.getSelectedItem();
        campusFoodApp.setCampusFoodPlace(new CampusFoodPlace(name, location, cuisineType, veganOption, rating));
        soundPlayer.playSound();

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
        campusFoodApp.tableModel.setValueAt(name, campusFoodApp.row,0);
        campusFoodApp.tableModel.setValueAt(location, campusFoodApp.row,1);
        campusFoodApp.tableModel.setValueAt(cuisineType, campusFoodApp.row,2);
        campusFoodApp.tableModel.setValueAt(
                (Boolean) campusFoodApp.veganOption.getSelectedItem(), campusFoodApp.row,3);
        campusFoodApp.tableModel.setValueAt((int) campusFoodApp.rating.getSelectedItem(), campusFoodApp.row,4);
        campusFoodApp.table.setRowSelectionInterval(campusFoodApp.row, campusFoodApp.row);
        JOptionPane.showMessageDialog(null,name + " has been successfully added!");
        campusFoodApp.row = campusFoodApp.row + 1;
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


}

