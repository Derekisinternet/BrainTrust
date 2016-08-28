package com.DerekCo.eeg;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mastermind on 8/25/16.
 */
public class SessionPanel implements Observer{
    private JPanel panel;
    private SessionNotes notes;
    private EEGInputHandler inputs;
    private EEGReading eegReading;

    public SessionPanel() {
        panel = new JPanel();
        //set the panel to stack components vertically:
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        notes = new SessionNotes();
        panel.add(notes.getMainPanel());

    }

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String message = inputs.getMessage();
        try {
            eegReading = new EEGReading(message);
            updateFields(eegReading);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
        catch(NullPointerException exception) {
            System.out.println("Exception while updating Visualizer: " + exception);
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    private synchronized void updateFields(EEGReading input) {

    }

}
