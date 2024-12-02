module com.example.datav2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datav2 to javafx.fxml;
    exports com.example.datav2;
}