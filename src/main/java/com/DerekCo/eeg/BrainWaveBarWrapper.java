package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/22/16.
 * houses a BrainWaveBar and displays data about it.
 * Designed to be a transparent drop-in for BrainWaveBar, such that all you
 * have to do is change the constructor, and everything else should work.
 * Maybe not the best way to design it, but I was lazy.
 */
public class BrainWaveBarWrapper {
    BrainWaveBar bar;
    JPanel panel;
    TextField panelLabel;
    TextField panelValue;

    public BrainWaveBarWrapper(String label, Color color) {
        panel = new JPanel();

        panelValue = new TextField();
        panelValue.setEditable(false);

        bar = new BrainWaveBar();
        bar.setColor(color);

        panelLabel = new TextField();
        panelLabel.setText(label);
        panelLabel.setEditable(false);

        //set the panel to stack components vertically:
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(panelValue);
        panel.add(bar);
        panel.add(panelLabel);
    }

    void setReadingInput(int input) {
        bar.setReadingInput(input);
        setPanelValue(input);
    }

    void setPanelValue(int input){
        panelValue.setText(String.valueOf(input));
    }

    void repaint() {
        bar.repaint();
    }

    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(10, 150);
    }

}
