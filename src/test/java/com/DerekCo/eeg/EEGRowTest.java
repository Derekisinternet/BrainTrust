package com.DerekCo.eeg;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mastermind on 8/20/16.
 */
public class EEGRowTest {
    String sample = "16:55:25:791,200,0,0,86919,48488,6439,25507,12768,4335,2645,3233\n";
    EEGRow row = new EEGRow(sample.trim());

    @Test(expected=IllegalArgumentException.class)
    public void testIndexAtThrowsException(){
        int reading = row.getReadingAt(50);
    }

}
