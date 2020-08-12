
package ui;

import model.CampusFoodPlace;
import model.CampusFoodPlaceTracker;
import persistence.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class CampusFoodApp extends JPanel {
    public DefaultTableModel tableModel;
    public JTable table;

    public static final String addString = "Add Food Place";
    public static final String saveString = "Save";
    public JButton saveBtn;
    public JButton addBtn;
    public AddListener addListener;
    public SaveListener saveListener;
    int row = 0;
    public JTextField name;
    public JTextField location;
    public JTextField cuisineType;
    public JComboBox rating;
    public JComboBox veganOption;
    public CampusFoodPlace campusFoodPlace;
    public CampusFoodPlaceTracker tracker;
    public static final String TRACKER_FILE = "./data/tracker.txt";


    //MODIFIES: this
    //EFFECTS: start the program
    public CampusFoodApp() {
        super(new BorderLayout());

        table = initTable();
        JScrollPane tableScrollPane = new JScrollPane(table);

        addListener = new AddListener(this);
        saveListener = new SaveListener(this);

        addBtn = new JButton(addString);
        initButton(addBtn, addString, addListener);

        saveBtn = new JButton(saveString);
        initButton(saveBtn, saveString, saveListener);

        initInput();
        init();

        createButtonPanel(tableScrollPane);

    }

    private void createButtonPanel(JScrollPane tableScrollPane) {
        JPanel buttonPanel = new JPanel();
        buttonPanel = addButtons(buttonPanel);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        add(tableScrollPane, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.WEST);
    }

    private void initInput() {
        name = initTextField(name);
        location = initTextField(location);
        cuisineType = initTextField(cuisineType);
        veganOption = initVeganBox(veganOption);
        rating = initRatingBox(rating);
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
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return panel;
    }

    //MODIFIES: field
    //EFFECTS: initialize given JTextField
    private JTextField initTextField(JTextField field) {
        field = new JTextField(10);
        field.addActionListener(addListener);
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
        loadFoodPlaces();
    }

    //MODIFIES: this
    //EFFECTS: loads all saved campusFoodPlaces to table
    public void loadFoodPlaces() {
        try {
            List<CampusFoodPlace> foodPlaces = Reader.readCampusFoodPlace(new File(TRACKER_FILE));
            addFoodPlacesToTracker(foodPlaces);
            loadFoodPlacesToTable();
        } catch (IOException e) {
            init();
        }
    }

    private void addFoodPlacesToTracker(List<CampusFoodPlace> foodPlaces) {
        for (int i = 0; i < foodPlaces.size(); i++) {
            tracker.addCampusFood(foodPlaces.get(i));
        }
    }

    private void loadFoodPlacesToTable() {
        for (int i = 0; i < tracker.size(); i++) {
            CampusFoodPlace cfp = tracker.getCampusFoodPlace(i);
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(cfp.getName(), row, 0);
            tableModel.setValueAt(cfp.getLocation(), row, 1);
            tableModel.setValueAt(cfp.getCuisineType(), row, 2);
            tableModel.setValueAt(cfp.isVegan(), row, 3);
            tableModel.setValueAt(cfp.getRating(), row, 4);
            row = row + 1;
        }
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

    public void setCampusFoodPlace(CampusFoodPlace campusFoodPlace) {
        this.campusFoodPlace = campusFoodPlace;
    }

    public static void main(String[] args) {
        //creating and showing app's GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }



}