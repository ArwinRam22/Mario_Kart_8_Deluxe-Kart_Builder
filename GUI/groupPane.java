package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class groupPane extends JFrame implements ListSelectionListener {

    private String[][] characters = readFile(new File("GUI/Text Files/Characters.txt"));
    private String[][] karts = readFile(new File("GUI/Text Files/Karts.txt"));
    private String[][] wheels = readFile(new File("GUI/Text Files/Wheels.txt"));
    private String[][] gliders = readFile(new File("GUI/Text Files/Gliders.txt"));

    statPane totalStats;
    individualPane characterPane, kartPane, wheelPane, gliderPane;
    int dividerLocation = 225;

    public groupPane() {
        
        characterPane = new individualPane(characters, "Characters");
        JSplitPane character = characterPane.getSplitPane();
        characterPane.getImageList().addListSelectionListener(this);
        character.setBorder(null);
        character.setMinimumSize(new Dimension(100, 300));

        kartPane = new individualPane(karts, "Karts");
        JSplitPane kart = kartPane.getSplitPane();
        kartPane.getImageList().addListSelectionListener(this);
        kart.setBorder(null);
        kart.setMinimumSize(new Dimension(100, 300));

        wheelPane = new individualPane(wheels, "Wheels");
        JSplitPane wheel = wheelPane.getSplitPane();
        wheelPane.getImageList().addListSelectionListener(this);
        wheelPane.setBorder(null);
        wheel.setMinimumSize(new Dimension(100, 300));

        gliderPane = new individualPane(gliders, "Gliders");
        JSplitPane glider = gliderPane.getSplitPane();
        gliderPane.getImageList().addListSelectionListener(this);
        glider.setBorder(null);
        glider.setMinimumSize(new Dimension(100, 300));

        totalStats = new statPane("Group");

        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, character, kart);
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(dividerLocation);
        splitPane1.setBorder(null);

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, wheel);
        splitPane2.setOneTouchExpandable(true);
        splitPane2.setDividerLocation(dividerLocation*2);
        splitPane2.setBorder(null);

        JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane2, glider);
        splitPane3.setOneTouchExpandable(true);
        splitPane3.setDividerLocation(dividerLocation*3);
        splitPane3.setBorder(null);

        JSplitPane splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane3, totalStats);
        splitPane4.setOneTouchExpandable(true);
        splitPane4.setDividerLocation(dividerLocation*4);
        splitPane4.setBorder(null);

        getContentPane().add(splitPane4);
        setStats();
    }
    
    public void valueChanged(ListSelectionEvent e) {
        setStats();
    }

    protected void setStats() {
        String[] characterStats = characterPane.getStats();
        String[] kartStats = kartPane.getStats();
        String[] wheelStats = wheelPane.getStats();
        String[] gliderStats = gliderPane.getStats();

        int[] statSum = new int[characterStats.length];

        for (int i = 1; i < characterStats.length; i++)
        {
            statSum[i] = Integer.parseInt(characterStats[i]) + Integer.parseInt(kartStats[i]) + Integer.parseInt(wheelStats[i]) + Integer.parseInt(gliderStats[i]);
        }

        this.totalStats.weightField.setText(String.valueOf(statSum[1]));
        this.totalStats.accelerationField.setText(String.valueOf(statSum[2]));
        this.totalStats.onRoadTractionField.setText(String.valueOf(statSum[3]));
        this.totalStats.offRoadTractionField.setText(String.valueOf(statSum[4]));
        this.totalStats.miniTurboField.setText(String.valueOf(statSum[5]));
        this.totalStats.groundSpeedField.setText(String.valueOf(statSum[6]));
        this.totalStats.waterSpeedField.setText(String.valueOf(statSum[7]));
        this.totalStats.antiGravitySpeedField.setText(String.valueOf(statSum[8]));
        this.totalStats.airSpeedField.setText(String.valueOf(statSum[9]));
        this.totalStats.groundHandlingField.setText(String.valueOf(statSum[10]));
        this.totalStats.waterHandlingField.setText(String.valueOf(statSum[11]));
        this.totalStats.antiGravityHandlingField.setText(String.valueOf(statSum[12]));
        this.totalStats.airHandlingField.setText(String.valueOf(statSum[13]));
        this.totalStats.invincibilityField.setText(String.valueOf(statSum[14]));

        this.totalStats.weightBar.setValue(statSum[1]);
        this.totalStats.accelerationBar.setValue(statSum[2]);
        this.totalStats.onRoadTractionBar.setValue(statSum[3]);
        this.totalStats.offRoadTractionBar.setValue(statSum[4]);
        this.totalStats.miniTurboBar.setValue(statSum[5]);
        this.totalStats.groundSpeedBar.setValue(statSum[6]);
        this.totalStats.waterSpeedBar.setValue(statSum[7]);
        this.totalStats.antiGravitySpeedBar.setValue(statSum[8]);
        this.totalStats.airSpeedBar.setValue(statSum[9]);
        this.totalStats.groundHandlingBar.setValue(statSum[10]);
        this.totalStats.waterHandlingBar.setValue(statSum[11]);
        this.totalStats.antiGravityHandlingBar.setValue(statSum[12]);
        this.totalStats.airHandlingBar.setValue(statSum[13]);
        this.totalStats.invincibilityBar.setValue(statSum[14]);

        int total = 0;

        for (int i = 1; i < 15; i++)
        {
            total += statSum[i];
        }
        
        this.totalStats.totalField.setText(String.valueOf(total));
        this.totalStats.totalBar.setValue(total);
    }

    protected String[][] readFile(File file)
    {
        StringBuffer sbOfCharacters = new StringBuffer();
        String[] arr;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text = null;
            while ((text = reader.readLine()) != null) 
            {
                sbOfCharacters.append(text + "@");
            }

        }
        catch (Exception ex)
        {
            System.out.println("Error with file");
        }

        arr = sbOfCharacters.toString().split("@");
        String[][] listOfCharacters = new String[arr.length][10];
        for (int i = 0; i < arr.length; i++)
        {
            String[] stats = arr[i].split("#");
            listOfCharacters[i] = stats;
            // System.out.println(stats[0]);
        }
        return listOfCharacters;
    }
}
