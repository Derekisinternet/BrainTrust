package com.DerekCo.eeg;

import java.io.*;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by Derek on 8/20/16.
 * Ingests a bunch of EEG Rows and does stats operations on them.
 */
public class SessionStats {
    List<EEGRow> rawData = new ArrayList<EEGRow>();

    public SessionStats(File filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            while ((line = reader.readLine()) != null) {
                EEGRow row = new EEGRow(line);
                rawData.add(row);
            }
        } catch(Exception except){
            except.printStackTrace();
        }

    }

    public int getAverageValue( int index) {
        int numRows = 0;
        int total = 0;
        for (EEGRow row : rawData) {
            total += row.getReadingAt(index);
            numRows +=1;
        }
        return total / numRows;
    }

    public int getHighestValue(int index) {
        int highest = 0;
        for (EEGRow row : rawData) {
            int value = row.getReadingAt(index);
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }
}
