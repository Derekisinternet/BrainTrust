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
    Visualizer visualizer;

    public GuiMain() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        startButton = new JButton("Start Session");
        frame.getContentPane().add(BorderLayout.NORTH, startButton);
        startButton.addActionListener(new StartButtonListener());

        visualizer = new Visualizer();
        frame.getContentPane().add(BorderLayout.CENTER, visualizer);

        // Always have this as the last operation. Otherwise,
        // things after it won't be visible.
        frame.setVisible(true);
    }

    class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            if (startButton.getText() == "Start Session") {
                if (rawData == null) {
                    rawData = new RawDataWindow();
                }
                //start the EEG stream
                input = new EEGInputHandler();
                input.addObserver(rawData);
                input.addObserver(visualizer);
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
