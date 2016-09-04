package com.DerekCo.eeg;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mastermind on 9/2/16.
 */
public class SessionNotes {
    String fileDir = "Session_Notes/";
    String fileName;

    public SessionNotes(String sessionName) {
        fileName = sessionName;
    }

    public void archive(String contents) {
        FileOutputter file = new FileOutputter(fileDir, fileName, false);
        file.output(contents);
    }

    public String getNotes() {
        String notesRecord = "";
        //if the file exists, return the contents
        //else, return an empty string.
        return notesRecord;
    }
}
