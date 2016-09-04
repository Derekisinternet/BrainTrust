package com.DerekCo.eeg;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * Created by Mastermind on 8/20/16.
 */
public class FileOutputter {
    private String fileName;
    Boolean appendBool;

    public FileOutputter(String filePath, String name, Boolean append) {

        fileName =  filePath + name;
        appendBool = append;
    }

    public FileOutputter(String filePath, String fileName, String suffix, Boolean append){
        fileName = filePath + fileName + suffix;
        appendBool = append;
    }

    void output(String line) {
        //add a newline char at the end, so we get a new row each time we write.
        line = line + "\n";
        try {
            FileWriter writer = new FileWriter(fileName, appendBool);
            writer.write(line);
            writer.close();
        } catch(IOException except) {
            except.printStackTrace();
        }


    }
}
