package ui;

import persistence.Writer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//saves Campus food place when saveBtn is clicked
class SaveListener implements ActionListener {
    private final CampusFoodApp campusFoodApp;

    //EFFECTS: initialize saveListener
    public SaveListener(CampusFoodApp campusFoodApp) {
        this.campusFoodApp = campusFoodApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveFoodPlace();
    }

    //EFFECTS: saves the new food place to file
    private void saveFoodPlace() {
        try {
            PrintWriter printWriter = new PrintWriter(new File(CampusFoodApp.TRACKER_FILE));
            campusFoodApp.tracker.save(printWriter);
            printWriter.flush();
            printWriter.close();
            JOptionPane.showMessageDialog(null,"Food Place saved to file " + CampusFoodApp.TRACKER_FILE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Unable to save food place to " + CampusFoodApp.TRACKER_FILE);
        }
    }
}
