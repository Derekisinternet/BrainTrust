package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/23/16.
 */
public class NeuroSkyBar extends VizualizerBar {


    //NOTE: if you change maxBarLength, then update getPreferredSize() to match!
    private int maxBarLength = 200;

    public void paintComponent(Graphics g) {
        g.setColor(getBarColor());
        try {
            if (getReadingInput() == 0) {
                g.fillRect(0, 0, 2, this.getHeight());
            } else {
                g.fillRect(0, 0, setBarLength(getReadingInput()), this.getHeight());
                //System.out.println("Height: " + String.valueOf(setBarHeight(readingInput)) + "Max: " + String.valueOf(maxInputValue));
            }
        }
        catch (Exception exception) {
            System.out.println("Exception in NeuroSkyBar" + exception.getMessage());
        }
    }

    int setBarLength(int inputValue){
        checkMaxInputValue(inputValue);
        float percentage = ( (float) inputValue / (float) getMaxInputValue());
        float newBarHeight = (percentage * maxBarLength);
        return Math.round(newBarHeight);
    }

    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(200, 10);
    }

 }
