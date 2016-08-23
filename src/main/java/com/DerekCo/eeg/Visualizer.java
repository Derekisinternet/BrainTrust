package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mastermind on 8/21/16.
 */
public class Visualizer implements Observer {
    private JPanel mainPanel;
    private EEGInputHandler inputs;
    private EEGReading eegReading;

    BrainWaveBar delta;
    BrainWaveBarWrapper theta;

    public Visualizer() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.black);

        delta = new BrainWaveBar();
        delta.setColor(Color.BLUE);

        theta = new BrainWaveBarWrapper("Theta", Color.green);

        mainPanel.add(delta);
        mainPanel.add(theta.panel);

    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String message = inputs.getMessage();
        try {
            eegReading = new EEGReading(message);
            //update Delta:
            delta.setReadingInput(eegReading.getDelta());
            delta.repaint();
            //Update Theta:
            theta.setReadingInput(eegReading.getTheta());
            theta.repaint();
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
        catch(NullPointerException exception) {
            System.out.println("Exception while updating Visualizer: " + exception);
        }
    }

}
