package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/23/16.
 * This is the parent class for all of the moving bars in the Visualizer
 */
public class VizualizerBar extends JPanel {

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

    Color getBarColor() {
        return barColor;
    }

    void setReadingInput(int input){
        readingInput = input;
    }
    int getReadingInput() {
        return readingInput;
    }

    private void setMaxInputValue(int max){
        maxInputValue = max;
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
    void checkMaxInputValue(int input) {
        if (input > maxInputValue) {
            setMaxInputValue(input);
        }
    }

    int getMaxInputValue() {
        return maxInputValue;
    }

}
