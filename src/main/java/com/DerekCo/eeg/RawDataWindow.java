package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/21/16.
 */
public class RawDataWindow {
    JFrame frame;
    JPanel panel;
    JScrollPane scroller;
    JTextArea text;

    public RawDataWindow() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);
        frame.setVisible(true);

        panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,panel);

        text = new JTextArea(10, 20);
        text.setLineWrap(true);
        scroller = new JScrollPane(text);
        panel.add(scroller);
    }

    public void append(String arg) {
        text.append(arg);

    }
}
