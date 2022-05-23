module com.example.dbapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbapp to javafx.fxml;
    exports com.example.dbapp;
}