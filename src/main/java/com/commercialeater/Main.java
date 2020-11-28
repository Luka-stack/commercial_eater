package com.commercialeater;

import com.commercialeater.views.LoginWindow;
import com.commercialeater.views.MainWindow;

public class Main {

    public static MainWindow mainWindow;

    public static void main(String[] args) {

        // TMP
        openMainApplication("New");

        //openLoginWindow();
    }

    public static void openMainApplication(String email) {

        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setBottomInformation("Logged as " + email);
    }

    public static void openLoginWindow() {

        new LoginWindow().setVisible(true);
    }

}
