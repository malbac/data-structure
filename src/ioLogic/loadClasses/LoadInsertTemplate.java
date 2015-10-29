package ioLogic.loadClasses;

import data.DataManager;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Malbac on 28.10.2015.
 */
public abstract class LoadInsertTemplate {
    public final  void readFile(String fileName,DataManager dataManager){

        try{
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            String[] variablesToSave;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                variablesToSave = line.split(",");
                proceedLine(variablesToSave,dataManager);
            }
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
    }

    protected abstract void proceedLine(String[] line,DataManager dataManager);
}
