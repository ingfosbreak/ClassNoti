package com.App.classnotification.models.CSV;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CSVMachine implements DataSourceCSV<ArrayList<String>>{

    private String filePath;

    public CSVMachine( String filePath ) {

        this.filePath = filePath;

        checkFileIsExisted(this.filePath);

    }

    private void checkFileIsExisted (String filePath) {

        File file;

        String [] pathArrays = this.filePath.split("/");

        String filePathUse = "";

        for (int i = 0; i < pathArrays.length; i++ ){
            if ( i == 0 ) {
                filePathUse = filePathUse + pathArrays[i];
            }
            else {
                filePathUse = filePathUse + File.separator + pathArrays[i];
            }

            if (pathArrays[i].endsWith(".csv")) {
                file = new File(filePathUse);
                if ( !file.exists() ) {
                    try {
                        file.createNewFile();
                    } catch ( IOException e ){
                        throw new RuntimeException(e);
                    }
                }


            }

            file = new File(filePathUse);
            if ( !file.exists() ) {
                file.mkdir();
            }

        }

    }

    public ArrayList<String> readData(){
        ArrayList<String> stringStreams = new ArrayList<>();

        return stringStreams;
    }

    public void writeData( ArrayList<String> stringStreams ){


    }

    public void clearData(){


    }

    public static void main(String[] args) {

        CSVMachine test = new CSVMachine("Data/ak/ex.csv");
        System.out.println(test.filePath);

    }





}
