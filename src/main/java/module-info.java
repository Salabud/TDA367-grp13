module com.example.antsimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.antsimulator to javafx.fxml;
    exports com.example.antsimulator;
}