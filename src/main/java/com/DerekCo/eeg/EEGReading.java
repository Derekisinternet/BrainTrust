package com.DerekCo.eeg;

/**
 * Created by Mastermind on 2/17/17.
 */
public class EEGReading {
    private String timestamp;
    private int signal;
    private int reading;

    public EEGReading(String time,int sig, int read) {
        timestamp = time;
        signal = sig;
        reading = read;
    }
}
