package com.DerekCo.eeg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


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
        File file = new File(fileDir + fileName);
        if (file.exists()) {
            try {
                String content = new Scanner(file).useDelimiter("\\Z").next();
                return content;
            } catch (FileNotFoundException exception) {
                //maybe do something
            }
        }
        //if the file exists, return the contents
        //else, return an empty string.
        return notesRecord;
    }
}
