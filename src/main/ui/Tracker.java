package ui;

import javax.swing.*;
import java.awt.*;

// Creates the main food tracker viewing panel that consists of 2 panels
public class Tracker extends JPanel {
    private TrackerPanel tp;
    private JTextArea dp;
    private JButton saveBtn;

    public Tracker() {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("UBC CAMPUS FOOD PLACE TRACKER"));

        //creates the two main panels in the tracker panel
        tp = new TrackerPanel();
        dp = new JTextArea();
        dp.setEditable(false);

        Dimension minSize = new Dimension(600, 600);
        tp.setMinimumSize(minSize);
        dp.setMinimumSize(minSize);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tp, dp);
        splitPane.setOneTouchExpandable(false);
        splitPane.setDividerLocation(400);


        saveBtn = new JButton("SAVE");
        createComponents(splitPane, saveBtn);

    }


    public void createComponents(JSplitPane pane, JButton saveBtn) {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 0;
        gc.weightx = 0.1;

        gc.gridwidth = 5;
        gc.gridx = 3;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        add(pane, gc);

        gc.insets = new Insets(10, 100, 0, 0);
        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.WEST;
        add(saveBtn, gc);

    }
}
