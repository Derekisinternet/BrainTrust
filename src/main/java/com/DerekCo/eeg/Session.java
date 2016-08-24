package com.DerekCo.eeg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Mastermind on 8/22/16.
 * collects the raw data of a session for things like archiving or
 * Stats analysis.
 */
public class Session {
    private List<String> records;
    private int lastArchivedRecord;
    boolean archiveOutOfDate;
    String sessionName;

    public void Session() {
        records = new ArrayList<String>();
        archiveOutOfDate = true;
        // the session name is the time at the session start. Seems reasonable.
        // DON'T JUDGE ME FOR MY COMMENTS
        sessionName = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss").format(new Date());
    }

    public void record(String record){
        records.add(record);
        archiveOutOfDate = true;
    }

    public void archive() {
        FileOutputter file = new FileOutputter(sessionName);
        for (String record : records ) {
            file.append(record);
        }
        System.out.println("Session Archived!");
    }
}
