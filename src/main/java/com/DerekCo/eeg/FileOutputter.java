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
        fileName = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss").format(new Date()) + ".csv";
    }

    void append(String line) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(line);
            writer.close();
        } catch(IOException except) {
            except.printStackTrace();
        }

    }
}
