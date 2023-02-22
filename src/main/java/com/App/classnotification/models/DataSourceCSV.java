package com.App.classnotification.models;

public interface DataSourceCSV <T>{

    T readData();

    void writeData(T t);

    void clearData();

}
