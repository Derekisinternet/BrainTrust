package com.DerekCo.eeg;

import java.io.*;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by Derek on 8/20/16.
 * Ingests a bunch of EEG Rows and does stats operations on them.
 */
public class SessionStats {
    List<EEGReading> rawData = new ArrayList<EEGReading>();

    public SessionStats(File filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            while ((line = reader.readLine()) != null) {
                EEGReading row = new EEGReading(line);
                rawData.add(row);
            }
        } catch(Exception except){
            except.printStackTrace();
        }

    }

//    public int average(String parameter){
//
//    }
}
