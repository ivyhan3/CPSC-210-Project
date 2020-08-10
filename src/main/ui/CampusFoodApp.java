/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//some code copied from: https://codereview.stackexchange.com/questions/57502/using-sounds-in-java
//some code copied from: https://stackoverflow.com/questions/2550536/java-loop-for-a-certain-duration

package ui;

import model.CampusFoodPlace;
import model.CampusFoodPlaceTracker;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class CampusFoodApp extends JPanel {
    public DefaultTableModel tableModel;
    public JTable table;

    public static final String addString = "Add Food Place";
    public static final String saveString = "Save";
    public JButton saveBtn;
    public JButton addBtn;
    public JButton loadBtn;
    public AddListener addListener = new AddListener(this);
    public SaveListener saveListener = new SaveListener(this);
    public LoadListener loadListener = new LoadListener(this);

    public JTextField name;
    public JTextField location;
    public JTextField cuisineType;
    public JComboBox rating;
    public JComboBox veganOption;
    public CampusFoodPlace campusFoodPlace;
    public CampusFoodPlaceTracker tracker;
    public static final String TRACKER_FILE = "./data/tracker.txt";
    int line = 0;



    //MODIFIES: this
    //EFFECTS: start the program
    public CampusFoodApp() {
        super(new BorderLayout());

        table = initTable();
        JScrollPane tableScrollPane = new JScrollPane(table);

        addBtn = new JButton(addString);
        initButton(addBtn, addString, addListener);

        saveBtn = new JButton(saveString);
        initButton(saveBtn,saveString,saveListener);

        loadBtn = new JButton("Load");
        initButton(loadBtn,"Load",loadListener);

        name = initTextField(name);
        location = initTextField(location);
        cuisineType = initTextField(cuisineType);
        veganOption = initVeganBox(veganOption);
        rating = initRatingBox(rating);

        init();

        //Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel = addButtons(buttonPanel);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        add(tableScrollPane,BorderLayout.EAST);
        add(buttonPanel, BorderLayout.WEST);


        // Split panels
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, table);
//        splitPane.setOneTouchExpandable(false);
//        splitPane.setDividerLocation(400);
    }

    public void setCampusFoodPlace(CampusFoodPlace campusFoodPlace) {
        this.campusFoodPlace = campusFoodPlace;
    }

    //MODIFIES: panel
    //EFFECTS: add all the buttons to the panel
    private JPanel addButtons(JPanel panel) {
        panel.add(Box.createVerticalStrut(5));
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        panel.add(Box.createVerticalStrut(5));
        panel.add(new JLabel("Name of Food Place:"));
        panel.add(name);
        panel.add(new JLabel("Location:"));
        panel.add(location);
        panel.add(new JLabel("Cuisine:"));
        panel.add(cuisineType);
        panel.add(new JLabel("Vegan:"));
        panel.add(veganOption);
        panel.add(new JLabel("Rating:"));
        panel.add(rating);
        panel.add(addBtn);
        panel.add(saveBtn);
        panel.add(loadBtn);
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        return panel;
    }

    //MODIFIES: field
    //EFFECTS: initialize given JTextField
    private JTextField initTextField(JTextField field) {
        field = new JTextField(10);
        field.addActionListener(addListener);
//        field.getDocument().addDocumentListener(addListener);
        return field;
    }

    //MODIFIES: veganCombo
    //EFFECTS: initialize vegan JComboBox
    private JComboBox initVeganBox(JComboBox veganCombo) {
        veganCombo = new JComboBox<>();
        DefaultComboBoxModel<Boolean> veganModel = new DefaultComboBoxModel<>();
        veganModel.addElement(true);
        veganModel.addElement(false);
        veganCombo.setModel(veganModel);
        return veganCombo;
    }

    //MODIFIES: ratingCombo
    //EFFECTS: initialize vegan JComboBox
    private JComboBox initRatingBox(JComboBox ratingCombo) {
        ratingCombo = new JComboBox<>();
        DefaultComboBoxModel<Integer> ratingModel = new DefaultComboBoxModel<>();
        ratingModel.addElement(1);
        ratingModel.addElement(2);
        ratingModel.addElement(3);
        ratingModel.addElement(4);
        ratingModel.addElement(5);
        ratingCombo.setModel(ratingModel);
        return ratingCombo;
    }


    //MODIFIES: this
    //EFFECTS: initialize table
    private JTable initTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Location");
        tableModel.addColumn("Cuisine");
        tableModel.addColumn("Vegan Option");
        tableModel.addColumn("Rating");
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        return table;
    }

    //EFFECTS: initialize button
    private void initButton(JButton btnName, String cm, ActionListener listener) {
        btnName.setActionCommand(cm);
        btnName.addActionListener(listener);
    }


    //MODIFIES: this
    //EFFECTS: initialize campusFoodPlace
    public void init() {
        tracker = new CampusFoodPlaceTracker();
    }


    //EFFECTS: Create the GUI and show it
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("UBC Campus Food Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent mainPane = new CampusFoodApp();
        mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(mainPane);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}