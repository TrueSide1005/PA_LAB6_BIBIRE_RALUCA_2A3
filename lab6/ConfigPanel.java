/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author School
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String color[] = {"Black", "Random"};
        colorCombo = new JComboBox(color);
        colorCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox colorCombo = (JComboBox) event.getSource();

                Object selected = colorCombo.getSelectedItem();
                if ("Black".equals(selected)) {
                    Color color = new Color(0, 0, 0);
                    frame.canvas.graphics.setColor(color);
                } else if ("Random".equals(selected)) {
                    Random rand = new Random();
                    int r = rand.nextInt(128) + 128; // 128 ... 255
                    int g = rand.nextInt(128) + 128; // 128 ... 255
                    int b = rand.nextInt(128) + 128; // 128 ... 255
                    Color color = new Color(r, g, b);
                    frame.canvas.graphics.setColor(color);
                }
            }
        });

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
