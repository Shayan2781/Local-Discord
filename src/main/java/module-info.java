
module com.example.discord {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;



    opens com.example.discord to javafx.fxml;
    exports com.example.discord;
}