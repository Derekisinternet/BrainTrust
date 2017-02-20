package com.DerekCo.eeg;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mastermind on 8/25/16.
 */
public class SessionPanel implements Observer{

    private String sessionName;

    private JPanel panel;
    private SessionNotesPanel notesPanel;
    private EEGInputHandler inputs;
    private EEGReading eegRow;

    public SessionPanel(String name, SessionNotes notes) {

        sessionName = name;

        panel = new JPanel();
        //set the panel to stack components vertically:
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        notesPanel = new SessionNotesPanel(sessionName, notes);
        panel.add(notesPanel.getMainPanel());

    }

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String message = inputs.getMessage();
        try {
            eegRow = new EEGReading(message);
            updateFields(eegRow);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
        catch(NullPointerException exception) {
            System.out.println("Exception while updating SessionPanel: " + exception);
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    private synchronized void updateFields(EEGReading input) {

    }

    public void close () {
        notesPanel.close();
    }

}
