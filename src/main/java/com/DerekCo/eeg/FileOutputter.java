package com.DerekCo.eeg;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * Created by Mastermind on 8/20/16.
 */
public class FileOutputter {
    private String fileName;

    public FileOutputter() {
        String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss").format(new Date());
        fileName =  "EEG_Readings/" + dateFormat + ".csv";
    }

    void append(String line) {
        //add a newline char at the end, so we get a new row each time we write.
        line = line + "\n";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(line);
            writer.close();
        } catch(IOException except) {
            except.printStackTrace();
        }

    }
}
