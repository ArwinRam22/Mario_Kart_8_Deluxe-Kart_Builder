package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class individualPane extends JPanel implements ListSelectionListener {
    private JLabel picture;
    private JList list;
    private JSplitPane picture_listPane, picture_list_statsPane;
    private statPane statFields;

    private String[] imageList;
    private String[][] itemList;
    private String category;

    public individualPane(String[][] itemList, String category)
    {
        setImages(itemList);
        this.category = category;
        this.itemList = itemList;

        list  = new JList(imageList);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);

        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        JScrollPane pictureScrollPane = new JScrollPane(picture);

        statFields = new statPane("individual");
        JScrollPane statsScrollPane = new JScrollPane(statFields);

        picture_listPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pictureScrollPane, listScrollPane);
        picture_list_statsPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, picture_listPane, statsScrollPane);

        picture_listPane.setOneTouchExpandable(true);
        picture_list_statsPane.setOneTouchExpandable(true);

        picture_listPane.setDividerLocation(200);
        picture_list_statsPane.setDividerLocation(400);

        picture_listPane.setBorder(null);
        picture_list_statsPane.setBorder(null);

        Dimension minimumSize = new Dimension(500, 1000);
        listScrollPane.setMinimumSize((minimumSize));
        pictureScrollPane.setMinimumSize(minimumSize);

        picture_listPane.setPreferredSize(new Dimension(1000, 1000));
        picture_list_statsPane.setPreferredSize(new Dimension(1000, 1000));
        
        updateLabel(imageList[list.getSelectedIndex()]);
        setStats(getStats());
    }

    public void valueChanged(ListSelectionEvent e) 
    {
        // JList list = (JList)e.getSource();
        updateLabel(imageList[list.getSelectedIndex()]);
        setStats(getStats());
    }

    protected void updateLabel(String name) 
    {
        ImageIcon icon = createImageIcon("images/" + category + "/" + name.toLowerCase() + ".png");
        picture.setIcon(icon);
        if (icon != null) {
            picture.setText(null);
        }
        else {
            picture.setText("Image not found.");
        }
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = individualPane.class.getResource(path);
        try {
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            }
            else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }
        catch (Exception e) {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    protected JList getImageList() {
        return list;
    }

    protected JSplitPane getSplitPane() {
        return picture_list_statsPane;
    }

    protected String[] getStats() {
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i][0].equals(imageList[list.getSelectedIndex()])) {
                return itemList[i];
            }
        }
        return null;
    }
    
    protected void setImages(String[][] list) {
        imageList = new String[list.length];
        for (int c = 0; c < list.length; c++) {
            imageList[c] = list[c][0];
        }
    }

    protected void setStats(String[] current) {
        this.statFields.weightField.setText(current[1]);
        this.statFields.accelerationField.setText(current[2]);
        this.statFields.onRoadTractionField.setText(current[3]);
        this.statFields.offRoadTractionField.setText(current[4]);
        this.statFields.miniTurboField.setText(current[5]);
        this.statFields.groundSpeedField.setText(current[6]);
        this.statFields.waterSpeedField.setText(current[7]);
        this.statFields.antiGravitySpeedField.setText(current[8]);
        this.statFields.airSpeedField.setText(current[9]);
        this.statFields.groundHandlingField.setText(current[10]);
        this.statFields.waterHandlingField.setText(current[11]);
        this.statFields.antiGravityHandlingField.setText(current[12]);
        this.statFields.airHandlingField.setText(current[13]);
        this.statFields.invincibilityField.setText(current[14]);
    }

























































































































































































































































































































































































































































}