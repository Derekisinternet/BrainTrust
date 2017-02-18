package com.DerekCo.eeg;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;
/**
 * Created by Mastermind on 8/20/16.
 */
public class SessionStatsTest {

    private SessionStats stats;
    private File file;

    @Before
    public void setup() {
        //input file with 59 rows of data
        file = new File("src/test/java/com/DerekCo/eeg/eeg_sample.csv");
        stats = new SessionStats(file);
    }


    @Test
    public  void createsEEGArray() {
        assertEquals(59, stats.rawData.size());
    }

//    @Test
//    public void findsAverageValue() {
//        // 4 = delta waves
//        assertEquals(621970, stats.getAverageValue(4));
//    }
}
