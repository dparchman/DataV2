package com.example.datav2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class PcController {
    @FXML

    public TableView<bestSellingPc> Table;
    public Button Prev;
    public Button Next;
    public TableColumn<bestSellingPc, String> TableGame;
    public TableColumn<bestSellingPc, Float> TableSales;
    public TableColumn<bestSellingPc, String> TableSeries;
    public TableColumn<bestSellingPc, LocalDate> TableRelease;
    public TableColumn<bestSellingPc, String> TableDeveloper;
    public TableColumn<bestSellingPc, String> TablePublisher;
    public TableColumn<bestSellingPc, String> TableGenre;
    public void initialize()throws Exception{
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

        for (bestSellingPc pcGame : bestSellingPc.getAllPcGames()) {
            Table.getItems().add(pcGame);

        }

    }

    public void SetPrev() throws Exception {

    }
    public void SetNext() throws Exception {

    }
}
