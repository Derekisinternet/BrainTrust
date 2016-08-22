package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

/**
 * Created by Mastermind on 8/21/16.
 */
public class RawDataWindow implements Observer {
    JFrame frame;
    JPanel panel;
    JScrollPane scroller;
    JTextArea text;
    private EEGInputHandler inputs;

    public RawDataWindow() {
        frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);
        frame.setVisible(true);

        panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,panel);

        text = new JTextArea(10, 20);
        text.setLineWrap(true);
        scroller = new JScrollPane(text);
        panel.add(scroller);
    }

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String newline = inputs.getMessage();
        text.append(newline);

    }
}
