package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * A Campus Food Tracker panel that lets the user add campus food places to the tracker
 */
public class TrackerPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel locationLabel;
    private JLabel cuisineTypeLabel;
    private JLabel veganOptionLabel;
    private JLabel ratingLabel;
    private JTextField nameField;
    private JTextField locationField;
    private JTextField cuisineTypeField;
    private JButton saveBtn;
    private JRadioButton trueButton;
    private JRadioButton falseButton;
    private JRadioButton ratingButton;
    private KeyListener keyListener;
    private JTextArea textArea;
    private JPanel panel;

    // EFFECTS: creates new tracker panel
    // MODIFIES: this
    public TrackerPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        panel = new JPanel();

        nameLabel = new JLabel("Food Place Name: ");
        nameField = new JTextField(10);

        locationLabel = new JLabel("Location: ");
        locationField = new JTextField(10);

        cuisineTypeLabel = new JLabel("Type of Cuisine: ");
        cuisineTypeField = new JTextField(10);

        veganOptionLabel = new JLabel("Vegan Option: ");

        ratingLabel = new JLabel("Rating: ");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(locationLabel);
        panel.add(locationField);


        // set up button to add campus food place to tracker
        setUpSaveButton();

//        // set up vegan option Radio Button
////        setUpVeganButton();
//
//        // set up rating Radio Button
//        setUpRatingButton();
//
//        setLayout(new GridBagLayout());
//        layoutComponents();

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
                textArea.append(nameField.getText());
//                if ("myButton".equals(e.getActionCommand())) {
//                    String name = nameField.getText() + ": ";
//                    String location = locationField.getText() + ": ";
//                    String cuisineType = cuisineTypeField.getText() + ": ";
//                    Boolean veganOption = Boolean.valueOf(veganButton.getText());
//                    int rating = Integer.valueOf(ratingButton.getText());
//                }
            }
        });
    }


    // MODIFIES: this
    // EFFECTS: set up radio button for  vegan option availability
//    public void setUpVeganButton() {
//        // create radio buttons
//        JRadioButton trueButton = new JRadioButton();
//        trueButton.setActionCommand(trueString);
//        trueButton.setSelected(true);
//
//        JRadioButton falseButton = new JRadioButton();
//        trueButton.setActionCommand(falseString);
//
//        // group radio buttons
//        ButtonGroup group = new ButtonGroup();
//        group.add(trueButton);
//        group.add(falseButton);
//
//        // add behaviour
//
//
//    }
//
//    // MODIFIES: this
//    // EFFECTS: set up radio button for 1-5 rating
//    public void setUpRatingButton() {
//        // create radio buttons
//        JRadioButton ratingButton = new JRadioButton();
//    }
//
//    // EFFECTS: lays out the components on the panel
//    // MODIFIES: this
//    public void layoutComponents() {
//    }



}