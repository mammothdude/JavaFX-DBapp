package com.example.dbapp;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField sqlbox;
    @FXML
    private TableView qresult;
 /*
    public static String buttonpress; {
        String input = sqlbox.getText();
        String press = String.valueOf(input);
    }


    public String input = sqlbox.getText();

    public void setIn(String input) {
        this.input = input;
    }
    public String getIn() {
        return input;
    }

 */

    public void query () {
        ObservableList<DBquery> values = DBquery.getDBQuery();

        TableColumn<DBquery, String> col1 = new TableColumn<>("col1");
        col1.setCellValueFactory(new PropertyValueFactory<>("col1"));

        TableColumn<DBquery, String> col2 = new TableColumn<>("col2");
        col2.setCellValueFactory(new PropertyValueFactory<>("col2"));

        TableColumn<DBquery, String> col3 = new TableColumn<>("col3");
        col3.setCellValueFactory(new PropertyValueFactory<>("col3"));

        TableColumn<DBquery, String> col4 = new TableColumn<>("col4");
        col4.setCellValueFactory(new PropertyValueFactory<>("col4"));

        qresult.getColumns().setAll(col1, col2, col3, col4);
        qresult.setItems(values);

    }
}