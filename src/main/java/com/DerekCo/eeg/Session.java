package com.DerekCo.eeg;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * A collection of EEG Rows
 *
 */
@Entity
@Table
public class Session implements Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="session_id")
    private int sessionId;

    private List<String> records;
    private int lastArchivedRecord;
    private boolean archiveOutOfDate;
    private String sessionName;
    private EEGInputHandler input;

    public Session() {
        records = new ArrayList<String>();
        archiveOutOfDate = true;
        // the session name is the time at the session start. Seems reasonable.
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

    public int getSessionLength() {
        return records.size();
    }

    public String getName() {
        return sessionName;
    }

    void persist(){

    }

}
