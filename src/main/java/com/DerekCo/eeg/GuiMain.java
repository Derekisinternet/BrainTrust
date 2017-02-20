package com.DerekCo.eeg;

import java.awt.*;
import java.awt.event.*;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;

/**
 * Created by Mastermind on 8/21/16.
 */
public class GuiMain {
    JButton startButton;
    JButton sessionButton;
    JButton debugButton;
    JFrame frame;
    EEGInputHandler input;
    RawDataWindow rawData;
    Visualizer visualizer;
    JPanel toolbar;
    Session session;
    SessionNotes sessionNotes;
    SessionPanel sessionPanel;

    public GuiMain() {
        frame = new JFrame("BrainTrust");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(750,350);
        frame.addWindowListener(new ExitListener());

        initToolbar();

        visualizer = new Visualizer();
        frame.getContentPane().add(BorderLayout.CENTER, visualizer.getMainPanel());

        session = new Session();
        sessionNotes = new SessionNotes(session.getName());

        // Always have this as the last operation. Otherwise,
        // things after it won't be visible.
        frame.setVisible(true);
    }

    void initToolbar(){
        toolbar = new JPanel();
        startButton = new JButton("Start Session");
        startButton.addActionListener(new StartButtonListener());

        sessionButton = (new JButton("Session Data"));
        sessionButton.addActionListener(new SessionButtonListener());


        debugButton = new JButton("Debugger");
        debugButton.addActionListener(new DebugButtonListener());

        toolbar.add(startButton);
        toolbar.add(sessionButton);
        toolbar.add(debugButton);

        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
    }

    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            if (startButton.getText() == "Start Session") {

                //start the EEG stream
                input = new EEGInputHandler();
                input.addObserver(visualizer);
                input.addObserver(session);
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

    class SessionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JFrame sessionFrame = new JFrame("Session Data");
            sessionFrame.addWindowListener(new SessionWindowExitListener());
            sessionFrame.setDefaultCloseOperation(sessionFrame.DISPOSE_ON_CLOSE);
            sessionFrame.setSize(380,530);

            sessionPanel = new SessionPanel(getSessionName(), sessionNotes);
            sessionFrame.add(sessionPanel.getPanel());

            sessionFrame.setVisible(true);
        }
        //access the instance variable of the outer class:
        private String getSessionName(){return session.getName();}
    }

    private class SessionWindowExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            //save the sessionNotes.
            sessionPanel.close();
        }
    }


    private class DebugButtonListener implements ActionListener {
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

    private class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            if (session.getSessionLength() > 0) {
                String ObjButtons[] = {"Yes", "No", "Cancel"};
                int promptResult = JOptionPane.showOptionDialog(null,
                        "Do You Want to Archive Your Session Before Exiting?", "See You Space Cowboy . . .",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[0]);
                if (promptResult == 2) {
                    //exit the window
                } else {
                    if (promptResult == 0) {
                        //Save the session
                        session.archive();
                        try {sessionPanel.close();}
                        catch (NullPointerException exception){
                            //this means that the window isn't open, so we cool.
                        }

                    }
                }
            }
            EntityManagerFactorySingleton.getInstance().close();
            System.exit(0);
        }
    }

}
