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
    // not all readings are created equal, so the bar height is set as a percentage of the
    // input value divide by the max Input value:
    private int maxInputValue;
    //NOTE: if you change maxBarHeight, then update getPreferredSize() to match!
    private int maxBarHeight = 200;

    void setColor(Color color) {
        barColor = color;
    }

    void setReadingInput(int input){
        readingInput = input;
    }

    private void setMaxInputValue(int max){
        maxInputValue = max;
    }

    public void paintComponent(Graphics g) {
        g.setColor(barColor);
        try {
            if (readingInput == 0) {
                g.fillRect(0, this.getHeight() - 2, this.getWidth(), this.getHeight());
            } else {
                g.fillRect(0, this.getHeight() - setBarHeight(readingInput), this.getWidth(), this.getHeight());
                //System.out.println("Height: " + String.valueOf(setBarHeight(readingInput)) + "Max: " + String.valueOf(maxInputValue));
            }
        }
        catch (Exception exception) {
            System.out.println("Exception in BrainWaveBar" + exception.getMessage());
        }
    }

    //convert raw EEG value into a bar height:
    int setBarHeight(int inputValue){
        checkMaxInputValue(inputValue);
        float percentage = ( (float) inputValue / (float) maxInputValue);
        float newBarHeight = (percentage * maxBarHeight);
        return Math.round(newBarHeight);
    }

    // since different brainwave readings aren't uniform in their values, this method will create
    // an elastic upper bound on what a maxed out bar means.
    private void checkMaxInputValue(int input) {
        if (input > maxInputValue) {
            setMaxInputValue(input);
        }
    }

    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(10, 200);
    }

}