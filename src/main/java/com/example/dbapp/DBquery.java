package com.example.dbapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class DBquery {
    /*                                      //I'm missing something really basic here
    textfieldInput sqlquery = new textfieldInput();
    String sql = sqlquery.getInput();

     */

    private StringProperty col1;            //I just went with 4 columns, couldn't figure out how to auto-generate columns
    private StringProperty col2;
    private StringProperty col3;
    private StringProperty col4;

    public DBquery(String col1, String col2, String col3, String col4) {
        this.col1 = new SimpleStringProperty(this, "col1");
        this.col2 = new SimpleStringProperty(this, "col2");
        this.col3 = new SimpleStringProperty(this, "col3");
        this.col4 = new SimpleStringProperty(this, "col4");

        this.setCol1(col1);
        this.setCol2(col2);
        this.setCol3(col3);
        this.setCol4(col4);
    }

    public void setCol4(String col4) {  this.col4.set(col4); }
    public String getCol4() { return col4.get(); }

    public void setCol3(String col3) {  this.col3.set(col3); }
    public String getCol3() { return col3.get(); }

    public void setCol2(String col2) {  this.col2.set(col2); }
    public String getCol2() { return col2.get(); }

    public void setCol1(String col1) {  this.col1.set(col1); }
    public String getCol1() { return col1.get(); }

    public static ObservableList<DBquery> getDBQuery () {

        ObservableList<DBquery> values = FXCollections.observableArrayList();

        String conn_url = "jdbc:mysql://localhost:3306/employees?user=user&password=&serverTimezone=UTC";
                            //to make mysql workable I had to create a user named user
                            //switch user=user to user=root on another machine
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(conn_url);
            Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery(sql);     //How do I get the input from the textfield???
            ResultSet rs = stmt.executeQuery("select * from employees limit 10"); // this is to see if the tableview loads - it does!

            while(rs != null && rs.next()) {
                String col1 = rs.getString(1);
                String col2 = rs.getString(2);
                String col3 = rs.getString(3);
                String col4 = rs.getString(4);
                values.add(new DBquery(col1, col2, col3, col4));
                //System.out.println(rs.getString("first_name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return values;
    }


}
