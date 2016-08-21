package com.DerekCo.eeg;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by Mastermind on 8/20/16.
 */
public class EEGRowTest {
    @Test
    public void testCreation(){
        String row = "16:55:25:791,200,0,0,86919,48488,6439,25507,12768,4335,2645,3233\n";
        System.out.println(row.split(","));
        EEGRow object = new EEGRow(row.trim());
        assertEquals(200, object.getSignal_strength());
    }
}
