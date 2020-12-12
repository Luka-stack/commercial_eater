package com.commercialeater.utilities;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class CustomComboRenderer extends BasicComboBoxRenderer {

    public CustomComboRenderer() {
        super();
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        setText(value.toString());
        if(isSelected) {
            setBackground(new Color(153, 194, 93));
        }
        else {
            setBackground(Color.white);
        }

        if (cellHasFocus) {
            setBackground(Color.white);
        }

        return this;
    }
}
