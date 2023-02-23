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

        try {
           FileReader reader = new FileReader(file);
           BufferedReader buffer = new BufferedReader(reader);

            String line = "";
            int iteration = 0;

            while ( (line = buffer.readLine()) != null) {
                if (iteration == 0){
                    iteration++;
                    continue;
                }
                if (line.isBlank()){
                    continue;
                }
                ArrayList<String> innerStringStreams = new ArrayList<>();
                for ( String word : line.split(",")){
                    String realword = word.substring(1,word.length() - 1);
                    innerStringStreams.add(realword);

                }
                stringStreams.add(innerStringStreams);

            }

            buffer.close();
            reader.close();



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringStreams;
    }


    public void writeData( ArrayList<ArrayList<String>> stringStreams ){

        File file = new File(this.filePath);

        try {
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter buffer = new BufferedWriter(writer);

            for (ArrayList<String> innerArrays : stringStreams){

                String line = "";

                for (int i = 0; i < innerArrays.size(); i++){


                    if ( i == 0 ){
                        line = line + "\"" +innerArrays.get(i) + "\"";
                    }
                    else{
                        line = line + "," + "\"" +innerArrays.get(i) + "\"";
                    }


                }

                buffer.append(line);
                buffer.newLine();

            }

            buffer.close();
            writer.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void writeHeader( String header ){


        File file = new File(this.filePath);

        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

            String line = header;

            buffer.append(line);
            buffer.newLine();
            buffer.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void clearData(){

        File file = new File(this.filePath);

        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

            String line = "";

            buffer.append(line);
            buffer.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        CSVMachine test = new CSVMachine("Data/ingfosbreak/info.csv");

        System.out.println(test.readData());

        ArrayList<ArrayList<String>> temp = test.readData();

        test.clearData();

        System.out.println(test.readData());

        test.writeHeader("first,second,third");

        test.writeData(temp);

        System.out.println(test.readData());








    }

}
