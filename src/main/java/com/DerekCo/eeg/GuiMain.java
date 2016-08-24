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
    JButton debugButton;
    JFrame frame;
    EEGInputHandler input;
    RawDataWindow rawData;
    Visualizer visualizer;
    JPanel toolbar;
    Session session;

    public GuiMain() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(700,350);
        frame.addWindowListener(new ExitListener());

        initToolbar();

        visualizer = new Visualizer();
        frame.getContentPane().add(BorderLayout.CENTER, visualizer.getMainPanel());

        session = new Session();

        // Always have this as the last operation. Otherwise,
        // things after it won't be visible.
        frame.setVisible(true);
    }

    void initToolbar(){
        toolbar = new JPanel();
        startButton = new JButton("Start Session");
        startButton.addActionListener(new StartButtonListener());

        debugButton = new JButton("Debugger");
        debugButton.addActionListener(new DebugButtonListener());

        toolbar.add(startButton);
        toolbar.add(debugButton);

        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
    }

    class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            if (startButton.getText() == "Start Session") {

                //start the EEG stream
                input = new EEGInputHandler();
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

    class DebugButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (rawData == null) {
                rawData = new RawDataWindow();
                try {
                    input.addObserver(rawData);
                }
                catch (NullPointerException exception) {
                    //TODO: figure out how to wait for input to get initialized.
                }
            }
        }
    }

    class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            String ObjButtons[] = {"Yes", "No", "Cancel"};
            int promptResult = JOptionPane.showOptionDialog(null,
                    "Do You Want to Archive Your Session Before Exiting?", "See You Space Cowboy . . .",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    ObjButtons,ObjButtons[0]);
            if (promptResult == 2) {
                //exit the window
            }
            else {
                if (promptResult == 0 ) {
                    //Save the session
                }
                System.exit(0);
            }
        }
    }

}
