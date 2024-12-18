module com.example.datav2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.datav2 to javafx.fxml;
    exports com.example.datav2;
}