package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/22/16.
 * houses a BrainWaveBar and displays data about it, like a label and its numerical value.
 */
public class BrainWaveBarWrapper {

    JPanel panel;
    private BrainWaveBar bar;
    private TextField panelLabel;
    private TextField panelValue;

    public BrainWaveBarWrapper(String label, Color color) {
        panel = new JPanel();

        panelValue = new TextField();
        panelValue.setText("0");
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

    synchronized void updateChart(int input) {
        bar.setReadingInput(input);
        bar.repaint();
        setPanelValue(input);
    }

    void setPanelValue(int input){
        panelValue.setText(String.valueOf(input));
    }


    // sets default dimensions when added to the Visualizer. Or any JComponet, really.
    public Dimension getPreferredSize() {
        return new Dimension(10, 250);
    }

}
