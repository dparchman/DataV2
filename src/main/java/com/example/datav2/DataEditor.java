package com.example.datav2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataEditor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void stop() throws Exception {
        bestSellingPc.saveData();
    }

    public static void main(String[] args) {
        launch();
    }
}

