package com.commercialeater.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordPasswordField;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView logoImage;

    @FXML
    private ImageView padlockImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File logoFile = new File("imgs/pinterest_board_photo.png");
        logoImage.setImage(new Image(logoFile.toURI().toString()));

        File padlockFile = new File("imgs/padlock.png");
        padlockImage.setImage(new Image(padlockFile.toURI().toString()));
    }

    public void loginButtonOnAction(ActionEvent event) {

        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Please enter login and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {

    }
}
