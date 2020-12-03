package com.commercialeater.utilities;

import javax.swing.*;
import java.awt.*;

public class UIUtilities {

    public static void buttonHoverExited(JPanel panel) {
        panel.setBackground(new Color(153, 194, 93));
    }

    public static void buttonHoverEntered(JPanel panel) {
        panel.setBackground(new Color(125, 166, 63));
    }
}
