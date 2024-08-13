module com.example.donemprojesiyeni {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.donemprojesiyeni to javafx.fxml;
    exports com.example.donemprojesiyeni;
}