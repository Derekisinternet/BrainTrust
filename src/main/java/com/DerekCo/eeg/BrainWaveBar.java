package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/22/16.
 */
// this class is for all the different brainwave readings. Signal, Attention and Meditation
// are handled in separate classes.
class BrainWaveBar extends JPanel {

    private Color barColor;
    private int readingInput;
    //not all readings are created equal, so the bar height is a percentage of the
    //max value:
    private int maxValue;

    void setColor(Color color) {
        barColor = color;
    }

    void setReadingInput(int input){
        readingInput = input;
    }

    void setMaxValue(int max){
        maxValue = max;
    }

    public void paintComponent(Graphics g) {
        g.setColor(barColor);
        try {
            if (readingInput == 0) {
                g.fillRect(10, this.getHeight() - 2, 10, this.getHeight());
            } else {
                g.fillRect(10, this.getHeight() - readingInput, 10, this.getHeight());
                System.out.println("Got a new value!");
            }
        }
        catch (Exception exception) {
            System.out.println("Exception in BrainWaveBar" + exception.getMessage());
        }
    }

}