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

    String[] values;


    public EEGRow(String row) {
        values = row.split(",");
    }

    String getTimeStamp() {
        return values[0];
    }

    int getSignalStrength(){
        return Integer.parseInt(values[1]);
    }

    int getAttention() { return Integer.parseInt(values[2]);}

    int getMeditation() {return Integer.parseInt(values[3]);}

    int getDelta() {return Integer.parseInt(values[4]);}

    int gettheta() {return Integer.parseInt(values[5]);}

    int getLowAlpha() {return Integer.parseInt(values[6]);}

    int getHighAlpha() {return Integer.parseInt(values[7]);}

    int getlowBeta() {return Integer.parseInt(values[8]);}

    int getHighBeta() {return Integer.parseInt(values[9]);}

    int getlowGamma() {return Integer.parseInt(values[10]);}

    int getHighGamma() {return Integer.parseInt(values[11]);}

    int getReadingAt(int index) {
        if (index > 1 && index < 12) {
            return Integer.parseInt(values[index]);
        } else throw new IllegalArgumentException("The index range is 2-11");
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
