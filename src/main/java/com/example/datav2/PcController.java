package com.example.datav2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PcController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}