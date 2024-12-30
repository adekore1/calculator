module com.calc.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.calc.demo to javafx.fxml;
    exports com.calc.demo;
}