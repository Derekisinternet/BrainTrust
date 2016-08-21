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
}
