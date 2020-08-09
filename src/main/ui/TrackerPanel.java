package ui;

import model.CampusFoodPlace;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;

/**
 * A Campus Food Tracker panel that lets the user add campus food places to the tracker
 */
public class TrackerPanel extends JPanel {
    private GridBagConstraints gc;
    private JLabel nameLabel;
    private JLabel locationLabel;
    private JLabel cuisineTypeLabel;
    private JLabel veganOptionLabel;
    private JLabel ratingLabel;
    private JLabel la;
    private JTextField nameField;
    private JTextField locationField;
    private JTextField cuisineTypeField;
    private JButton saveBtn;
    private JComboBox<Boolean> veganCombo;
    private JComboBox<Integer> ratingCombo;
    private EventListenerList listenerList = new EventListenerList();
    private JTextArea ta;

    // EFFECTS: creates new tracker panel
    // MODIFIES: this
    public TrackerPanel() {
        gc = new GridBagConstraints();
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);


        nameLabel = new JLabel("Food Place Name: ");
        nameField = new JTextField(10);

        locationLabel = new JLabel("Location: ");
        locationField = new JTextField(10);

        cuisineTypeLabel = new JLabel("Type of Cuisine: ");
        cuisineTypeField = new JTextField(10);

        veganOptionLabel = new JLabel("Vegan Option: ");

        ratingLabel = new JLabel("Rating: ");

        setLayout(new GridBagLayout());

        // set up button to add campus food place to tracker
        setUpSaveButton();

        // set up combo box for vegan options
        setUpVeganCombo();

        // set up combo box for rating options
        setUpRatingCombo();

        layoutComponents();

    }

    // EFFECTS: Sets up the save to tracker button
    public void setUpSaveButton() {
        saveBtn = new JButton("SAVE");
        saveBtn.setActionCommand("myButton");
        add(nameField);
        add(saveBtn);
        add(nameLabel);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("myButton".equals(e.getActionCommand())) {
                    String name = nameField.getText() + ": ";
                    String location = locationField.getText() + ": ";
                    String cuisineType = cuisineTypeField.getText() + ": ";
                    Boolean veganOption = (Boolean) veganCombo.getSelectedItem();
                    int rating = (int) ratingCombo.getSelectedItem();
                    CampusFoodPlace cfp = new CampusFoodPlace(name, location, cuisineType, veganOption, rating);

                    playSound();
                    final JTextArea ta = new JTextArea();
                    ta.setText(String.valueOf(cfp));

//                    fireTrackerEvent(new TrackerEvent(this, name, location, cuisineType, veganOption, rating));
                }
            }
        });
    }



    public void setUpVeganCombo() {
        veganCombo = new JComboBox<>();
        DefaultComboBoxModel<Boolean> veganModel = new DefaultComboBoxModel<>();
        veganModel.addElement(true);
        veganModel.addElement(false);
        veganCombo.setModel(veganModel);
    }

    public void setUpRatingCombo() {
        ratingCombo = new JComboBox<>();
        DefaultComboBoxModel<Integer> ratingModel = new DefaultComboBoxModel<>();
        ratingModel.addElement(1);
        ratingModel.addElement(2);
        ratingModel.addElement(3);
        ratingModel.addElement(4);
        ratingModel.addElement(5);
        ratingCombo.setModel(ratingModel);
    }


    // EFFECTS: lay out save button on panel
    // MODIFIES: this
    private void saveBtn() {
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(saveBtn, gc);
    }

    // EFFECTS: lay out name component on panel
    // MODIFIES: this
    private void nameInput() {
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(nameField, gc);
    }

    // EFFECTS: lay out location component on panel
    // MODIFIES: this
    private void locationInput() {
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(locationLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(locationField, gc);
    }

    // EFFECTS: lay out cuisineType component on panel
    // MODIFIES: this
    private void cuisineTypeInput() {
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(cuisineTypeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(cuisineTypeField, gc);
    }

    // EFFECTS: lay out veganOption component on panel
    // MODIFIES: this
    private void veganOptionInput() {
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(veganOptionLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(veganCombo, gc);
    }

    // EFFECTS: lay out rating component on panel
    // MODIFIES: this
    private void ratingInput() {
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(ratingLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ratingCombo, gc);
    }




    // EFFECTS: lays out the components on the panel
    // MODIFIES: this
    public void layoutComponents() {
        Border innerBorder = BorderFactory.createTitledBorder("Enter food place details here");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        // first row
        gc.gridy = 0;
        nameInput();

        // second row
        gc.gridy = 1;
        locationInput();

        // third row
        gc.gridy = 2;
        cuisineTypeInput();

        // fourth row
        gc.gridy = 3;
        veganOptionInput();

        // fifth row
        gc.gridy = 4;
        ratingInput();

        // sixth row
        gc.gridy = 5;
        saveBtn();

    }

    public void fireTrackerEvent(TrackerEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrackerListener.class) {
                ((TrackerListener)listeners[i + 1]).trackerEventOccurred(event);
            }
        }
    }

    public void addTrackerListener(TrackerListener listener) {
        listenerList.add(TrackerListener.class, listener);
    }

    // EFFECTS: plays a sound when user clicks saveBtn
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("data/saveButton.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }
    }
}