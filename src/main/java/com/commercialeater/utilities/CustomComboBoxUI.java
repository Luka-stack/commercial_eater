package com.commercialeater.utilities;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class CustomComboBoxUI extends BasicComboBoxUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();
        uninstallDefaults();

        comboBox.setRenderer(new CustomComboRenderer());
    }

//    @Override
//    protected JButton createArrowButton() {
//        final JButton button = new JButton("V");
//        button.setName("ComboBox.arrowButton"); //Mandatory, as per BasicComboBoxUI#createArrowButton().
//        return button;
//    }

    @Override
    public void configureArrowButton() {
        super.configureArrowButton(); //Do not forget this!
        arrowButton.setBackground(new Color(153, 194, 93));
//        arrowButton.setForeground(Color.BLUE);
    }
}
