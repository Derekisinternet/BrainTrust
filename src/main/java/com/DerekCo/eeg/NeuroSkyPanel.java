package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/22/16.
 * houses the charts for Signal Strength, Attention and Meditation.
 */
public class NeuroSkyPanel {

    JPanel panel;
    NeuroSkyBarWrapper attention;
    NeuroSkyBarWrapper meditation;


    public NeuroSkyPanel(){
        panel = new JPanel();
        panel.setBackground(Color.black);
        attention = new NeuroSkyBarWrapper(Color.CYAN, "Attention");
        meditation = new NeuroSkyBarWrapper(Color.GREEN, "Meditation");

        panel.add(attention.panel);
        panel.add(meditation.panel);
    }

    public void updateFields(int signalNum, int attentionNum, int meditationNum) {
        attention.update(attentionNum);
        meditation.update(meditationNum);
    }
}
