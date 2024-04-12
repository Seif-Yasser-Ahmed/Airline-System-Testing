module com.example.ainline_system_team5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ainline_system_team5 to javafx.fxml;
    exports com.example.ainline_system_team5;
}