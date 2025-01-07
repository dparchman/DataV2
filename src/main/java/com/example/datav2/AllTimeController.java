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


public class AllTimeController {
    @FXML

    public TableView<bestSellingAllTime> Table;
    public ImageView GameImage;
    public Button Swap;
    public Button Photo;
    public Button SwapHome;
    public TableColumn<bestSellingAllTime, String> TableGame;
    public TableColumn<bestSellingAllTime, Integer> TableSalesInt;
    public TableColumn<bestSellingAllTime, String> TableSeries;
    public TableColumn<bestSellingAllTime, LocalDate> TableRelease;
    public TableColumn<bestSellingAllTime, String> TableDeveloper;
    public TableColumn<bestSellingAllTime, String> TablePublisher;
    public TableColumn<bestSellingAllTime, String> TablePlatform;
    public void initialize()throws Exception{
        bestSellingAllTime.readAllData();

        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    System.out.println("TableView select oldValue: " + oldValue);
                    System.out.println("TableView select newValue: " + newValue);
                    GameImage.setImage(newValue.getImageField());
                });

        TableGame.setCellValueFactory(
                new PropertyValueFactory<>("game"));

        TableSalesInt.setCellValueFactory(
                new PropertyValueFactory<>("salesInt"));

        TableSeries.setCellValueFactory(
                new PropertyValueFactory<>("series"));

        TableRelease.setCellValueFactory(
                new PropertyValueFactory<>("release"));

        TablePlatform.setCellValueFactory(
                new PropertyValueFactory<>("platform"));

        TableDeveloper.setCellValueFactory(
                new PropertyValueFactory<>("developer"));

        TablePublisher.setCellValueFactory(
                new PropertyValueFactory<>("publisher"));

        TableGame.setCellFactory(TextFieldTableCell.forTableColumn());

        TableSalesInt.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableSeries.setCellFactory(TextFieldTableCell.forTableColumn());

        TableDeveloper.setCellFactory(TextFieldTableCell.forTableColumn());

        TablePublisher.setCellFactory(TextFieldTableCell.forTableColumn());

        TableSeries.setCellFactory(TextFieldTableCell.forTableColumn());

        TableRelease.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));

        TableGame.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setGame(t.getNewValue());
                });
        TableSalesInt.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, Integer> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setSalesInt(t.getNewValue());
                });

        TableSeries.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setSeries(t.getNewValue());
                });

        TablePublisher.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setPublisher(t.getNewValue());
                });

        TableDeveloper.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setDeveloper(t.getNewValue());
                });

        TableSeries.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setSeries(t.getNewValue());
                });

        TableRelease.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingAllTime, LocalDate> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingAllTime allTime = t.getTableView().getItems().get(selectedRow);
                    allTime.setRelease(t.getNewValue());
                });


        for (bestSellingAllTime allTime : bestSellingAllTime.getAllTimeGames()) {
            Table.getItems().add(allTime);

        }

    }

    public void SetPrev() throws Exception {

    }
    public void SetNext() throws Exception {

    }
    public void SetSwap() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("Pc.fxml"));
        Scene AllTime = new Scene(fxmlLoader.load(), 850, 750);
        Stage mainStage = (Stage)Swap.getScene().getWindow();
        mainStage.setScene(AllTime);
    }
    public void SetSwapHome() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("Home.fxml"));
        Scene Home = new Scene(fxmlLoader.load(), 850, 750);
        Stage mainStage = (Stage)SwapHome.getScene().getWindow();
        mainStage.setScene(Home);
    }

    public void AddPhoto() throws Exception {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(GameImage.getScene().getWindow());
        FileInputStream input8 = new FileInputStream(selectedFile);
        Image imageExtra = new Image(input8);
        GameImage.setImage(imageExtra);
        bestSellingAllTime allTime = Table.getSelectionModel().getSelectedItem();
        allTime.setImageField(imageExtra);

    }
}

