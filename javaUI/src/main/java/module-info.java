module com.example.teste {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visual to javafx.fxml;
    exports com.example.visual;
    exports backEnd;
    opens backEnd to javafx.fxml;
}