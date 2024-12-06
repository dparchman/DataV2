package com.example.datav2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class PcController {
    @FXML

    public TableView Table;
    public Button Prev;
    public Button Next;


    public void SetPrev() throws Exception {

    }
    public void SetNext() throws Exception {

    }

    TableColumn<Person, String> column1 =
            new TableColumn<>("First Name");

    column1.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));


    TableColumn<Person, String> column2 =
            new TableColumn<>("Last Name");

    column2.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));


    Table.getColumns().add(column1);
    Table.getColumns().add(column2);
}
