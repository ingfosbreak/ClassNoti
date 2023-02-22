package com.App.classnotification.models.CSV;

import java.io.*;
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

        File file = new File(this.filePath);
        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";
            while ( (line = buffer.readLine()) != null) {
                stringStreams.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                buffer.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return stringStreams;
    }


    public void writeData( ArrayList<String> stringStreams ){


    }

    public void clearData(){


    }

    public static void main(String[] args) {

        CSVMachine test = new CSVMachine("Data/ingfosbreak/info.csv");
        for (String word : test.readData()){
            System.out.println(word);
        }

    }

}
