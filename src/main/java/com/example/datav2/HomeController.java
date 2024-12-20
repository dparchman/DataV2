package com.example.datav2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;


public class HomeController {
    @FXML

    public Button ViewPC;
    public Button ViewAllTime;
    public void initialize()throws Exception{


    }
    public void SetViewPC() throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("Pc.fxml"));
        Scene AllTime = new Scene(fxmlLoader.load(), 850, 750);
        Stage mainStage = (Stage)ViewPC.getScene().getWindow();
        mainStage.setScene(AllTime);
    }
    public void setViewAllTime() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("AllTime.fxml"));
        Scene AllTime = new Scene(fxmlLoader.load(), 850, 750);
        Stage mainStage = (Stage) ViewAllTime.getScene().getWindow();
        mainStage.setScene(AllTime);
    }
}
