module com.classnotification.classnotification {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.classnotification.classnotification to javafx.fxml;
    exports com.classnotification.classnotification;
}