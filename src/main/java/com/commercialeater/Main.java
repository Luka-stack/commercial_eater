package com.commercialeater;

import com.commercialeater.views.MainPage;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }

}
