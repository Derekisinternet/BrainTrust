package com.DerekCo.eeg;

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
public class EEGRow {

    String timeStamp;
    private int signal_strength, attention, meditation, delta, theta, low_alpha, high_alpha,
        low_beta, high_beta, low_gamma, high_gamma;

    public EEGRow(String row) {
        String[] params = row.split(",");
        timeStamp = params[0];
        signal_strength = Integer.parseInt(params[1]);
        attention = Integer.parseInt(params[2]);
        meditation = Integer.parseInt(params[3]);
        delta = Integer.parseInt(params[4]);
        theta = Integer.parseInt(params[5]);
        low_alpha = Integer.parseInt(params[6]);
        high_alpha = Integer.parseInt(params[7]);
        low_beta = Integer.parseInt(params[8]);
        high_beta = Integer.parseInt(params[9]);
        low_gamma = Integer.parseInt(params[10]);
        high_gamma = Integer.parseInt(params[11]);

    }

    String getTimeStamp() {
        return this.timeStamp;
    }

    int getSignal_strength(){
        return this.signal_strength;
    }

    int getAttention() {
        return this.attention;
    }

    int getMeditation() {
        return this.meditation;
    }

    int getDelta() {
        return this.delta;
    }

    int getTheta() {
        return this.theta;
    }

    int getLow_alpha() {
        return this.low_alpha;
    }

    int getHigh_alpha() {
        return this.high_alpha;
    }

    int getLow_beta() {
        return this.low_beta;
    }

    int getHigh_beta() {
        return this.high_alpha;
    }

    int getLow_gamma() {
        return this.low_gamma;
    }

    int getHigh_gamma() {
        return this.high_gamma;
    }

    // signal_strentgh can be 0-200. The lower the value, the higher the strength. Counterintuitive,
    // but I didn't write the EEG firmware, so IDK what to tell you.
    boolean signalStrengthAboveThreshold() {
        int threshold = 100;
        if (this.signal_strength < threshold) {
            return true;
        }
        return false;
    }

}
