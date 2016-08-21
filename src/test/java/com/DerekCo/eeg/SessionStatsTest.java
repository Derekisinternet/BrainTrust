package com.DerekCo.eeg;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * Created by Mastermind on 8/20/16.
 */
public class SessionStatsTest {

    @Test
    public  void createsEEGArray() {
        File file = new File("src/test/java/com/DerekCo/eeg/eeg_sample.csv");

        SessionStats stats = new SessionStats(file);
        assertEquals(59, stats.rawData.size());
    }
}
