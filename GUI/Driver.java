package GUI;

import javax.swing.*;

public class Driver extends JPanel
{
    protected static void createAndShowGUI() {
        JFrame frame = new groupPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}