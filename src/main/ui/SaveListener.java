package ui;

import persistence.Writer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

//represent saving of food place when saveBtn is clicked
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
            Writer writer = new Writer(new File(CampusFoodApp.TRACKER_FILE));
            writer.write(campusFoodApp.campusFoodPlace);
            writer.close();
            JOptionPane.showMessageDialog(null,"Food Place saved to file " + CampusFoodApp.TRACKER_FILE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Unable to save accounts to " + CampusFoodApp.TRACKER_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }
}
