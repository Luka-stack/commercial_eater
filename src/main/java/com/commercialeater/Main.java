package com.commercialeater;

import com.commercialeater.utilities.ColorUtilities;
import com.commercialeater.utilities.PDFGenerator;
import com.commercialeater.views.LoginWindow;
import com.commercialeater.views.MainWindow;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);
    public static MainWindow mainWindow;
    public static ColorUtilities colorUtilities;

    public static void main(String[] args) {

        DOMConfigurator.configure("config\\log4jconfig.xml");
        colorUtilities = new ColorUtilities();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.WHITE));
            UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.BLACK));
        }
        catch (Exception evt) { }

        // TMP
        openMainApplication("New");

        //openLoginWindow();
    }

    public static void openMainApplication(String email) {

        mainWindow = new MainWindow(false);
        mainWindow.setVisible(true);
        mainWindow.setBottomInformation("Logged as " + email);
        logger.debug("User with email " + email + " logged to application");
    }

    public static void redrawWindowWithNewStyle() {

        colorUtilities = new ColorUtilities();

        mainWindow.dispose();
        mainWindow = new MainWindow(true);
        mainWindow.setVisible(true);
        mainWindow.setBottomInformation("Colors changed");
    }

    public static void openLoginWindow() {

        new LoginWindow().setVisible(true);
    }

}
