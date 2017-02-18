package com.DerekCo.eeg;

import javax.persistence.*;

/**
 * Created by Derek on 8/20/16.
 *
 * An object built from a single row from a CSV built by FileOutputter.
 * This class might also be usable by the EEGInputHandler . . .
 *
 * The current EEG Row is as follows:
 * 0) timestamp
 * 1) signal strength
 * 2) attention - proprietary value determined by NeuroSky
 * 3) meditation - same as above
 * 4) delta - (1-3Hz) sleep
 * 5) theta - (4-7Hz) relaxed, meditative
 * 6) low alpha (8-9Hz) eyes closed, relaxed
 * 7) high alpha (10-12Hz)
 * 8) low beta (13-17Hz) alert, focused
 * 9) high beta (18-30Hz)
 * 10) low gamma (31-40Hz) multi-sensory procsessing
 * 11) high gamma (41-50Hz)
 */

@Entity
@Table(name="eeg_reading")
public class EEGReading {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="reading_id")
    private long readingId;

    @Column(name="session_id")
    private long sessionId;

    private String time_stamp;
    private int signal;
    private int attention;
    private int meditation;
    private int delta;
    private int theta;

    @Column(name="low_alpha")
    private int lowAlpha;
    @Column(name="high_alpha")
    private int highAlpha;

    @Column(name="low_beta")
    private int lowBeta;
    @Column(name="high_beta")
    private int highBeta;

    @Column(name="low_gamma")
    private int lowGamma;
    @Column(name="high_gamma")
    private int highGamma;

    public EEGReading(String row) {
        String[] values = row.split(",");
        setTimeStamp(values[0]);
        setSignalStrength(Integer.parseInt(values[1]));
        setAttention(Integer.parseInt(values[2]));
        setMeditation(Integer.parseInt(values[3]));
        setDelta(Integer.parseInt(values[4]));
        setTheta(Integer.parseInt(values[5]));
        setLowAlpha(Integer.parseInt(values[6]));
        setHighAlpha(Integer.parseInt(values[7]));
        setLowBeta(Integer.parseInt(values[8]));
        setHighBeta(Integer.parseInt(values[9]));
        setLowGamma(Integer.parseInt(values[10]));
        setHighGamme(Integer.parseInt(values[11]));
    }

    public String getTimeStamp() {
        return time_stamp;
    }
    public void setTimeStamp(String value) { time_stamp = value;}

    public int getSignalStrength(){
        return signal;
    }
    public void setSignalStrength(int value) {signal = value;}

    public int getAttention() { return attention;}
    public void setAttention(int val) {attention = val;}

    public int getMeditation() {return meditation;}
    public void setMeditation(int val) {meditation = val;}

    public int getDelta() {return delta;}
    public void setDelta(int val) { delta = val;}

    public int getTheta() {return theta;}
    public void setTheta(int val) { theta = val;}

    public int getLowAlpha() {return lowAlpha;}
    public void setLowAlpha(int val) { lowAlpha = val;}

    public int getHighAlpha() {return highAlpha;}
    public void setHighAlpha(int val) { highAlpha = val;}

    public int getlowBeta() {return lowBeta;}
    public void setLowBeta(int val) { lowBeta = val;}

    public int getHighBeta() {return highBeta;}
    public void setHighBeta(int val) { highBeta = val;}

    public int getLowGamma() {return lowGamma;}
    public void setLowGamma(int val) { lowGamma = val;}

    public int getHighGamma() {return highGamma;}
    public void setHighGamme(int val) { highGamma = val;}

    public long getSessionId() { return sessionId;}

    public void setSessionId(int id) {
        sessionId = id;
    }


    // signal_strentgh can be 0-200. The lower the value, the higher the strength. Counterintuitive,
    // but I didn't write the EEG firmware, so IDK what to tell you.
    boolean signalStrengthAboveThreshold() {
        int threshold = 100;
        if (this.getSignalStrength() < threshold) {
            return true;
        }
        return false;
    }

}
