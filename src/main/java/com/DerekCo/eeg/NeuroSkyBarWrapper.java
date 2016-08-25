package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/23/16.
 */
public class NeuroSkyBarWrapper {
    JPanel panel;
    private TextField barLabel;
    NeuroSkyBar bar;
    private TextField barValue;

    public NeuroSkyBarWrapper(Color color, String title) {
        panel = new JPanel();

        bar = new NeuroSkyBar();
        bar.setColor(color);
        barLabel = new TextField(title);
        barLabel.setEditable(false);
        barValue = new TextField("0");
        barValue.setEditable(false);
        barValue.setColumns(3);

        panel.add(barLabel);
        panel.add(bar);
        panel.add(barValue);
    }

    void update(int input){
        bar.setReadingInput(input);
        bar.repaint();
        barValue.setText(String.valueOf(input));
    }
}
