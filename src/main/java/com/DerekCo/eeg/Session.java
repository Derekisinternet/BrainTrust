package com.DerekCo.eeg;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Mastermind on 8/22/16.
 * collects the raw data of a session for things like archiving or
 * Stats analysis.
 */
public class Session implements Observer {
    private List<String> records;
    private int lastArchivedRecord;
    private boolean archiveOutOfDate;
    private String sessionName;
    private EEGInputHandler input;

    public Session() {
        records = new ArrayList<String>();
        archiveOutOfDate = true;
        // the session name is the time at the session start. Seems reasonable.
        // DON'T JUDGE ME FOR MY COMMENTS
        sessionName = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss").format(new Date());
    }

    public void update(Observable observable, Object arg){
        input = (EEGInputHandler) observable;
        String record = input.getMessage();
        records.add(record);
        archiveOutOfDate = true;
    }

    public void archive() {
        FileOutputter file = new FileOutputter("EEG_Readings/", sessionName, ".csv", true);
        System.out.println(file.getFileName());
        for (String record : records ) {
            file.output(record);
        }
        //System.out.println("Session Archived!");
    }

    public int getRecordLength() {
        return records.size();
    }

    public String getName() {
        return sessionName;
    }
}
