package com.DerekCo.eeg;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mastermind on 9/2/16.
 */
public class SessionNotes {
    String fileDir = "Session_Notes/";
    String filePath;

    public SessionNotes(String sessionName) {
        filePath = fileDir + sessionName + ".csv";
    }

    public void archive(String contents) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
        } catch (IOException exception){}
    }
}
