package com.commercialeater.utilities;

import com.commercialeater.Main;

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
        super.configureArrowButton();
        arrowButton.setBackground(Main.uiUtilities.getMainColor());
    }
}
