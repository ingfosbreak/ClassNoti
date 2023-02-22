module com.classnotification.classnotification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.App.classnotification to javafx.fxml;
    exports com.App.classnotification;
}