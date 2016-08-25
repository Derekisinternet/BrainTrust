package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/22/16.
 */
// this class is for all the different brainwave readings. Signal, Attention and Meditation
// are handled in separate classes.
class BrainWaveBar extends VizualizerBar {

    public void paintComponent(Graphics g) {
        g.setColor(getBarColor());
        try {
            if (getReadingInput() == 0) {
                g.fillRect(0, this.getHeight() - 2, this.getWidth(), this.getHeight());
            } else {
                g.fillRect(0, this.getHeight() - setBarHeight(getReadingInput()), this.getWidth(), this.getHeight());
                //System.out.println("Height: " + String.valueOf(setBarHeight(readingInput)) + "Max: " + String.valueOf(maxInputValue));
            }
        }
        catch (Exception exception) {
            System.out.println("Exception in BrainWaveBar" + exception.getMessage());
        }
    }

    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(10, 200);
    }

}