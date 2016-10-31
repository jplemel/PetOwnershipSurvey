package com.plemel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Jennifer Plemel on 10/31/2016.
 */
public class PetSurvey extends JFrame{
    public JPanel rootPanel;
    public JCheckBox dogCheckBox;
    public JCheckBox catCheckBox;
    public JCheckBox fishCheckBox;
    public JLabel surveyResultsLabel;
    public JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    protected PetSurvey(){

        setContentPane(rootPanel); //in the slides it says "rootPane" and will cause compile error, should be rootPanel
        pack();
        setSize(new Dimension(350, 200));
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                fish = fishCheckBox.isSelected();
                updateResults();

            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                       "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }

            }
        });
    }

    private void updateResults(){
        String hasDog = dog ? "one dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cats";
        String hasFish = fish ? "one fish" : "no fish";

        String results = "You have " + hasDog + " and " + hasCat + " and " + hasFish ;
        surveyResultsLabel.setText(results);
    }

}
