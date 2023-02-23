package com.App.classnotification.models.CSV;

import java.io.*;
import java.util.ArrayList;

public class CSVMachine implements DataSourceCSV<ArrayList<ArrayList<String>>>{

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

    public ArrayList<ArrayList<String>> readData(){
        ArrayList<ArrayList<String>> stringStreams = new ArrayList<ArrayList<String>>();

        File file = new File(this.filePath);
        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);



            String line = "";
            while ( (line = buffer.readLine()) != null) {
                ArrayList<String> innerStringStreams = new ArrayList<>();
                for ( String word : line.split(",")){
                    innerStringStreams.add(word);
                    stringStreams.add(innerStringStreams);
                }

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


    public void writeData( ArrayList<ArrayList<String>> stringStreams ){



    }


    public void writeHeader( String header ){

    }

    public void clearData(){


    }

    public static void main(String[] args) {

        CSVMachine test = new CSVMachine("Data/ingfosbreak/info.csv");

        System.out.println(test.readData());








    }

}
