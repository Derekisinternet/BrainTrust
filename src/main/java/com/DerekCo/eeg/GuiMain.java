package com.DerekCo.eeg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Mastermind on 8/21/16.
 */
public class GuiMain {
    JButton startButton;
    JButton endButton;
    JFrame frame;
    EEGInputHandler input;
    RawDataWindow rawData;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

        startButton = new JButton("Start Session");
        startButton.addActionListener(new StartButtonListener());
        endButton = new JButton("End Session");
        endButton.addActionListener(new EndButtonListener());
        frame.getContentPane().add(BorderLayout.NORTH, startButton);
//        frame.getContentPane().add(BorderLayout.WEST, endButton);

    }

    class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            if (startButton.getText() == "Start Session") {
                if (rawData == null) {
                    rawData = new RawDataWindow();
                }
                //start the EEG stream
                input = new EEGInputHandler();
                input.initialize();

                startButton.setText("Pause Session");
            }
            else {
                startButton.setText("Start Session");
                //stop the EEG stream.
                input.close();
                rawData = null;
            }
        }
    }

    class EndButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //end the session.
            //TODO: add some validation and protect the data we've gathered.
            input = null;
        }
    }

}
