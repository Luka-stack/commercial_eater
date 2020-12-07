package com.commercialeater;

import com.commercialeater.views.LoginWindow;
import com.commercialeater.views.MainWindow;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);
    public static MainWindow mainWindow;

    public static void main(String[] args) {

        DOMConfigurator.configure("D:\\New folder\\jv\\commercial_eater\\config\\log4jconfig.xml");

        // TMP
        openMainApplication("New");

        //openLoginWindow();
    }

    public static void openMainApplication(String email) {

        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setBottomInformation("Logged as " + email);
        logger.debug("User with email " + email + " logged to application");
    }

    public static void openLoginWindow() {

        new LoginWindow().setVisible(true);
    }

}
