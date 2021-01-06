package com.commercialeater.utilities;

import com.commercialeater.Main;

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
        if (isSelected) {
            setBackground(Main.colorUtilities.getMainColor());
            list.setSelectionBackground(Main.colorUtilities.getBackground());
        }
        else {
            setBackground(Main.colorUtilities.getBackground());
        }

        return this;
    }
}
