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


public class PcController {
    @FXML

    public TableView<bestSellingPc> Table;
    public ImageView GameImage;
    public Button Swap;
    public Button Photo;
    public TableColumn<bestSellingPc, String> TableGame;
    public TableColumn<bestSellingPc, Float> TableSales;
    public TableColumn<bestSellingPc, String> TableSeries;
    public TableColumn<bestSellingPc, LocalDate> TableRelease;
    public TableColumn<bestSellingPc, String> TableDeveloper;
    public TableColumn<bestSellingPc, String> TablePublisher;
    public TableColumn<bestSellingPc, String> TableGenre;
    public void initialize()throws Exception{

        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    System.out.println("TableView select oldValue: " + oldValue);
                    System.out.println("TableView select newValue: " + newValue);
                    GameImage.setImage(newValue.getImageField());
                });

        bestSellingPc.readAllData();
        TableGame.setCellValueFactory(
                new PropertyValueFactory<>("game"));

        TableSales.setCellValueFactory(
                new PropertyValueFactory<>("sales"));

        TableSeries.setCellValueFactory(
                new PropertyValueFactory<>("series"));

        TableRelease.setCellValueFactory(
                new PropertyValueFactory<>("release"));

        TableDeveloper.setCellValueFactory(
                new PropertyValueFactory<>("developer"));

        TablePublisher.setCellValueFactory(
                new PropertyValueFactory<>("publisher"));

        TableGenre.setCellValueFactory(
                new PropertyValueFactory<>("genre"));

        TableGame.setCellFactory(TextFieldTableCell.forTableColumn());

        TableSales.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        TableSeries.setCellFactory(TextFieldTableCell.forTableColumn());

        TableDeveloper.setCellFactory(TextFieldTableCell.forTableColumn());

        TablePublisher.setCellFactory(TextFieldTableCell.forTableColumn());

        TableGenre.setCellFactory(TextFieldTableCell.forTableColumn());

        TableRelease.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));

        TableGame.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setGame(t.getNewValue());
                });

        TableSales.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, Float> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setSales(t.getNewValue());
                });

        TableSeries.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setSeries(t.getNewValue());
                });

        TablePublisher.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setPublisher(t.getNewValue());
                });

        TableDeveloper.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setDeveloper(t.getNewValue());
                });

        TableGenre.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setGenre(t.getNewValue());
                });

        TableRelease.setOnEditCommit(
                (TableColumn.CellEditEvent<bestSellingPc, LocalDate> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    bestSellingPc pcGame = t.getTableView().getItems().get(selectedRow);
                    pcGame.setRelease(t.getNewValue());
                });

        for (bestSellingPc pcGame : bestSellingPc.getAllPcGames()) {
            Table.getItems().add(pcGame);
        }

    }

    public void SetSwap() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("AllTime.fxml"));
        Scene AllTime = new Scene(fxmlLoader.load(), 1000, 400);
        Stage mainStage = (Stage)Swap.getScene().getWindow();
        mainStage.setScene(AllTime);
    }

    public void AddPhoto() throws Exception {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(GameImage.getScene().getWindow());
        FileInputStream input8 = new FileInputStream(selectedFile);
        Image imageExtra = new Image(input8);
        GameImage.setImage(imageExtra);
        bestSellingPc pcGame = Table.getSelectionModel().getSelectedItem();
        pcGame.setImageField(imageExtra);

    }
}
