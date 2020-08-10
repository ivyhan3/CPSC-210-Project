//package ui;
//
//import model.CampusFoodPlace;
//import model.CampusFoodPlaceTracker;
//import persistence.Reader;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import static ui.CampusFoodApp.TRACKER_FILE;
//
//class LoadListener implements ActionListener {
//    private final CampusFoodApp campusFoodApp;
//
//    public LoadListener(CampusFoodApp campusFoodApp) {
//        this.campusFoodApp = campusFoodApp;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        loadCampusFoodPlace();
//
//    }
//
//    // MODIFIES: CampusFoodApp
//    // EFFECTS: load saved campus food places and display in table
//    private void loadCampusFoodPlace() {
//        try {
//            campusFoodApp.tracker = (CampusFoodPlaceTracker) Reader.readCampusFoodPlace(new File(TRACKER_FILE));
//
//            for (int i = 0; i < campusFoodApp.tracker.size(); i++) {
//                CampusFoodPlace campusFoodPlace = campusFoodApp.tracker.lastVisited();
//                campusFoodApp.tableModel.addRow(new Object[0]);
//                campusFoodApp.tableModel.setValueAt(campusFoodPlace.getName(), campusFoodApp.line, 0);
//                campusFoodApp.tableModel.setValueAt(campusFoodPlace.getLocation(), campusFoodApp.line, 1);
//                campusFoodApp.tableModel.setValueAt(campusFoodPlace.getCuisineType(), campusFoodApp.line, 2);
//                campusFoodApp.tableModel.setValueAt(campusFoodPlace.isVegan(), campusFoodApp.line, 3);
//                campusFoodApp.tableModel.setValueAt(campusFoodPlace.getRating(), campusFoodApp.line, 4);
//                campusFoodApp.line = campusFoodApp.line + 1;
//                JOptionPane.showMessageDialog(null, "File successfully loaded!");
//            }
//        } catch (IOException e) {
//            campusFoodApp.init();
//        }
//    }
//}
//
