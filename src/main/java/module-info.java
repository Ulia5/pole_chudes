module com.example.pole_chudes {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.pole_chudes to javafx.fxml;
    exports com.example.pole_chudes;
}