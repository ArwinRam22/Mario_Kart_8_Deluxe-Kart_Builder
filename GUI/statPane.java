package GUI;

import javax.swing.*;
import java.awt.*;

public class statPane extends JPanel {
    JTextField  weightField, accelerationField,
                onRoadTractionField, offRoadTractionField,
                miniTurboField,
                groundSpeedField, waterSpeedField, antiGravitySpeedField, airSpeedField,
                groundHandlingField, waterHandlingField, antiGravityHandlingField, airHandlingField,
                invincibilityField,
                totalField;
    JProgressBar    weightBar, accelerationBar,
                    onRoadTractionBar, offRoadTractionBar,
                    miniTurboBar,
                    groundSpeedBar, waterSpeedBar, antiGravitySpeedBar, airSpeedBar,
                    groundHandlingBar, waterHandlingBar, antiGravityHandlingBar, airHandlingBar,
                    invincibilityBar,
                    totalBar;
    int     weightMin = 0+0+0+0, weightMax = 10+4+4+2,
            accelMin = 0+0+0+1, accelMax = 5+7+6+2,
            onRoadMin = 1+0+0+1, onRoadMax = 10+4+4+2,
            offRoadMin = 0+0+0+0, offRoadMax = 5+7+7+1,
            mTurboMin = 0+3+2+1, mTurboMax = 5+7+6+2,
            gSpeedMin = 1+0+0+0, gSpeedMax = 10+5+4+1,
            wSpeedMin = 1+1+0+0, wSpeedMax = 10+5+4+1,
            agSpeedMin = 1+0+0+0, agSpeedMax = 10+5+4+1,
            aSpeedMin = 1+0+0+1, aSpeedMax = 10+4+4+2,
            gHandMin = 0+0+0+1, gHandMax = 10+5+4+1,
            wHandMin = 0+1+0+0, wHandMax = 10+5+4+1,
            agHandMin = 0+1+0+0, agHandMax = 10+5+4+1,
            aHandMin = 0+0+0+1, aHandMax = 10+4+4+2,
            invinMin = 1+0+0+0, invinMax = 6+7+6+1,
            totMin =    weightMin+accelMin+onRoadMin+offRoadMin+mTurboMin+gSpeedMin+wSpeedMin+
                        agSpeedMax+aSpeedMin+gHandMin+wHandMin+agHandMin+aHandMin+invinMin,
            totMax =    weightMax+accelMax+onRoadMax+offRoadMax+mTurboMax+gSpeedMax+wSpeedMax+
                        agSpeedMax+aSpeedMax+gHandMax+wHandMax+agHandMax+aHandMax+invinMax;
    
    int GAP = 15;
    int columns = 5;

    public statPane(String pane) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
 
        JPanel rightHalf = new JPanel() 
        {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize()
            {
                return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        };
        rightHalf.setLayout(new BoxLayout(rightHalf, BoxLayout.PAGE_AXIS));
        if (pane.equals("individual"))
            rightHalf.add(createStatFields());
        else
            rightHalf.add(createStatBars());

        rightHalf.setBackground(Color.WHITE);
        // add(leftHalf);
        add(rightHalf);
    }

    protected JComponent createStatFields()
    {
        JPanel panel = new JPanel(new SpringLayout());
        String[] labelStrings = {
        "Weight", "Acceleration",
        "On-Road Traction", "Off-Road Traction", 
        "Mini Turbo", 
        "Ground Speed", "Water Speed", "Anti-Gravity \nSpeed", "Air Speed",
        "Ground Handling", "Water Handling", "Anti-Gravity Handling", "Air Handling",
        "Invincibility",
        };
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        weightField = new JTextField();
        accelerationField = new JTextField();
        onRoadTractionField = new JTextField();
        offRoadTractionField = new JTextField();
        miniTurboField = new JTextField();
        groundSpeedField = new JTextField();
        waterSpeedField = new JTextField();
        antiGravitySpeedField = new JTextField();
        airSpeedField = new JTextField();
        groundHandlingField = new JTextField();
        waterHandlingField = new JTextField();
        antiGravityHandlingField = new JTextField();
        airHandlingField = new JTextField();
        invincibilityField = new JTextField();

        fields[fieldNum++] = weightField;
        fields[fieldNum++] = accelerationField;
        fields[fieldNum++] = onRoadTractionField;
        fields[fieldNum++] = offRoadTractionField;
        fields[fieldNum++] = miniTurboField;
        fields[fieldNum++] = groundSpeedField;
        fields[fieldNum++] = waterSpeedField;
        fields[fieldNum++] = antiGravitySpeedField;
        fields[fieldNum++] = airSpeedField;
        fields[fieldNum++] = groundHandlingField;
        fields[fieldNum++] = waterHandlingField;
        fields[fieldNum++] = antiGravityHandlingField;
        fields[fieldNum++] = airHandlingField;
        fields[fieldNum++] = invincibilityField;

        for (int i = 0; i < labelStrings.length; i++)
        {
            labels[i] = new JLabel(labelStrings[i], JLabel.LEFT);
            labels[i].setLabelFor(fields[i]);
            
            labels[i].setSize(new Dimension(100, 15));
            labels[i].setFont(labels[i].getFont().deriveFont(10.0f));
            fields[i].setPreferredSize(new Dimension(50, 15));

            ((JTextField) fields[i]).setColumns(columns);
            ((JTextField) fields[i]).setEditable(false);
            ((JTextField) fields[i]).setHorizontalAlignment(JTextField.CENTER);

            panel.add(labels[i]);
            panel.add(fields[i]);
        }

        SpringUtilities.makeCompactGrid(panel,
                                        labelStrings.length, 2,
                                        GAP, GAP, //init x,y
                                        GAP, GAP/2);//xpad, ypad

        return panel;
    }

    protected JComponent createStatBars()
    {
        JPanel panel = new JPanel(new SpringLayout());
        String[] labelStrings = {
        "Weight", "Acceleration",
        "On-Road Traction", "Off-Road Traction", 
        "Mini Turbo", 
        "Ground Speed", "Water Speed", "Anti-Gravity \nSpeed", "Air Speed",
        "Ground Handling", "Water Handling", "Anti-Gravity Handling", "Air Handling",
        "Invincibility",
        "Total"
        };
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        JProgressBar[] bars = new JProgressBar[labelStrings.length];
        int fieldNum = 0;
        int barNum = 0;

        weightField = new JTextField();
        accelerationField = new JTextField();
        onRoadTractionField = new JTextField();
        offRoadTractionField = new JTextField();
        miniTurboField = new JTextField();
        groundSpeedField = new JTextField();
        waterSpeedField = new JTextField();
        antiGravitySpeedField = new JTextField();
        airSpeedField = new JTextField();
        groundHandlingField = new JTextField();
        waterHandlingField = new JTextField();
        antiGravityHandlingField = new JTextField();
        airHandlingField = new JTextField();
        invincibilityField = new JTextField();
        totalField = new JTextField();

        fields[fieldNum++] = weightField;
        fields[fieldNum++] = accelerationField;
        fields[fieldNum++] = onRoadTractionField;
        fields[fieldNum++] = offRoadTractionField;
        fields[fieldNum++] = miniTurboField;
        fields[fieldNum++] = groundSpeedField;
        fields[fieldNum++] = waterSpeedField;
        fields[fieldNum++] = antiGravitySpeedField;
        fields[fieldNum++] = airSpeedField;
        fields[fieldNum++] = groundHandlingField;
        fields[fieldNum++] = waterHandlingField;
        fields[fieldNum++] = antiGravityHandlingField;
        fields[fieldNum++] = airHandlingField;
        fields[fieldNum++] = invincibilityField;
        fields[fieldNum++] = totalField;

        weightBar = new JProgressBar(               weightMin, weightMax);
        accelerationBar = new JProgressBar(         accelMin, accelMax);
        onRoadTractionBar = new JProgressBar(       onRoadMin, onRoadMax);
        offRoadTractionBar = new JProgressBar(      offRoadMin, offRoadMax);
        miniTurboBar = new JProgressBar(            mTurboMin, mTurboMax);
        groundSpeedBar = new JProgressBar(          gSpeedMin, gSpeedMax);
        waterSpeedBar = new JProgressBar(           wSpeedMin, wSpeedMax);
        antiGravitySpeedBar = new JProgressBar(     agSpeedMin, agSpeedMax);
        airSpeedBar = new JProgressBar(             aSpeedMin, aSpeedMax);
        groundHandlingBar = new JProgressBar(       gHandMin, gHandMax);
        waterHandlingBar = new JProgressBar(        wHandMin, wHandMax);
        antiGravityHandlingBar = new JProgressBar(  agHandMin, agHandMax);
        airHandlingBar = new JProgressBar(          aHandMin, aHandMax);
        invincibilityBar = new JProgressBar(        invinMin, invinMax);
        totalBar = new JProgressBar(                totMin, totMax);

        bars[barNum++] = weightBar;
        bars[barNum++] = accelerationBar;
        bars[barNum++] = onRoadTractionBar;
        bars[barNum++] = offRoadTractionBar;
        bars[barNum++] = miniTurboBar;
        bars[barNum++] = groundSpeedBar;
        bars[barNum++] = waterSpeedBar;
        bars[barNum++] = antiGravitySpeedBar;
        bars[barNum++] = airSpeedBar;
        bars[barNum++] = groundHandlingBar;
        bars[barNum++] = waterHandlingBar;
        bars[barNum++] = antiGravityHandlingBar;
        bars[barNum++] = airHandlingBar;
        bars[barNum++] = invincibilityBar;
        bars[barNum++] = totalBar;

        for (int i = 0; i < labelStrings.length; i++)
        {
            labels[i] = new JLabel(labelStrings[i], JLabel.LEFT);
            // labels[i].setLabelFor(fields[i]);
            labels[i].setLabelFor(bars[i]);
            
            labels[i].setSize(new Dimension(100, 15));
            labels[i].setFont(labels[i].getFont().deriveFont(13.0f));
            fields[i].setPreferredSize(new Dimension(50, 15));
            bars[i].setSize(100, 15);

            ((JTextField) fields[i]).setColumns(columns);
            ((JTextField) fields[i]).setEditable(false);
            ((JTextField) fields[i]).setHorizontalAlignment(JTextField.CENTER);

            panel.add(labels[i]);
            panel.add(bars[i]);
            panel.add(fields[i]);
        }

        SpringUtilities.makeCompactGrid(panel,
                                        labelStrings.length, 3,
                                        5, 5, //init x,y
                                        GAP, GAP/3);//xpad, ypad

        return panel;
    }
}
