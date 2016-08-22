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
    private int maxbarHeight = 100;

    void setColor(Color color) {
        barColor = color;
    }

    void setReadingInput(int input){
        readingInput = input;
    }

    private void setMaxValue(int max){
        maxValue = max;
    }

    public void paintComponent(Graphics g) {
        g.setColor(barColor);
        try {
            if (readingInput == 0) {
                g.fillRect(0, this.getHeight() - 2, 10, this.getHeight());
            } else {
                g.fillRect(0, this.getHeight() - setBarHeight(readingInput), 10, this.getHeight());
            }
        }
        catch (Exception exception) {
            System.out.println("Exception in BrainWaveBar" + exception.getMessage());
        }
    }

    //convert raw EEG value into a bar height:
    int setBarHeight(int inputValue){
        checkMaxValue(inputValue);
        float percentage = (inputValue / maxValue);
        float newBarHeight = (percentage * maxbarHeight);
        return Math.round(newBarHeight);
    }

    // since different brainwave readings aren't uniform in their values, this method will create
    // an elastic upper bound on what a maxed out bar means.
    private void checkMaxValue(int input) {
        if (input > maxValue) {
            maxValue = input;
        }
    }

    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(20, 100);
    }

}