package com.App.classnotification.models;

import java.util.ArrayList;

public class CSVMachine implements DataSourceCSV<ArrayList<String>>{

    private String dirName;
    private String fileName;

    public CSVMachine( String dirName, String fileName ) {

        this.dirName = dirName;

        this.fileName = fileName;


    }

    private void checkFileIsExisted () {



    }

    public ArrayList<String> readData(){
        ArrayList<String> stringStreams = new ArrayList<>();

        return stringStreams;
    }

    public void writeData( ArrayList<String> stringStreams){


    }

    public void clearData(){


    }





}
