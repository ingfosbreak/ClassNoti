package com.App.classnotification.models.CSV;

public interface DataSourceCSV <T>{

    T readData();

    void writeData(T t);

    void writeHeader(String header);
    void clearData();

}
