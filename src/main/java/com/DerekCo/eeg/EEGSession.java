package com.DerekCo.eeg;

/**
 * Created by Mastermind on 8/20/16.
 * The current EEG Row is as follows:
 * 1) timestamp
 * 2) signal strength
 * 3) attention - proprietary value determined by NeuroSky
 * 4) meditation - same as above
 * 5) delta - (1-3Hz) sleep
 * 6) theta - (4-7Hz) relaxed, meditative
 * 7) low alpha (8-9Hz) eyes closed, relaxed
 * 8) high alpha (10-12Hz)
 * 9) low beta (13-17Hz) alert, focused
 * 10) high beta (18-30Hz)
 * 11) low gamma (31-40Hz) multi-sensory procsessing
 * 12) high gamma (41-50Hz)
 */
public class EEGSession {

    public EEGSession(String filepath) {

    }

}
