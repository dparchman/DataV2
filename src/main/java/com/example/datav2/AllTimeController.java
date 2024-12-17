package com.example.datav2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class AllTimeController {
    @FXML

    public TableView<bestSellingAllTime> Table;
    public Button Prev;
    public Button Next;
    public TableColumn<bestSellingAllTime, String> TableGame;
    public TableColumn<bestSellingAllTime, Integer> TableSalesInt;
    public TableColumn<bestSellingAllTime, String> TableSeries;
    public TableColumn<bestSellingAllTime, LocalDate> TableRelease;
    public TableColumn<bestSellingAllTime, String> TableDeveloper;
    public TableColumn<bestSellingAllTime, String> TablePublisher;
    public TableColumn<bestSellingAllTime, String> TablePlatform;
    public void initialize()throws Exception{
        bestSellingAllTime.readAllData();
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


        for (bestSellingAllTime pcGame : bestSellingAllTime.getAllTimeGames()) {
            Table.getItems().add(pcGame);

        }

    }

    public void SetPrev() throws Exception {

    }
    public void SetNext() throws Exception {

    }
}
