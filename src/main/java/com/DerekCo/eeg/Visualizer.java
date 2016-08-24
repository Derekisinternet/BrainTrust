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

    BrainWaveBarWrapper delta;
    BrainWaveBarWrapper theta;
    BrainWaveBarWrapper lowAlpha;
    BrainWaveBarWrapper highAlpha;
    BrainWaveBarWrapper lowBeta;
    BrainWaveBarWrapper highBeta;
    BrainWaveBarWrapper lowGamma;
    BrainWaveBarWrapper highGamma;


    public Visualizer() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.black);

        initFields();

    }

    void initFields() {
        lowAlpha = new BrainWaveBarWrapper("Low Alpha", Color.ORANGE);
        highAlpha = new BrainWaveBarWrapper("High Alpha", Color.ORANGE);
        lowBeta = new BrainWaveBarWrapper("Low Beta", Color.MAGENTA);
        highBeta = new BrainWaveBarWrapper("High Beta", Color.MAGENTA);
        lowGamma = new BrainWaveBarWrapper("Low Gamma", Color.RED);
        highGamma = new BrainWaveBarWrapper("High Gamma", Color.RED);
        delta = new BrainWaveBarWrapper("Delta", Color.BLUE);
        theta = new BrainWaveBarWrapper("Theta", Color.green);

        mainPanel.add(lowAlpha.panel);
        mainPanel.add(highAlpha.panel);
        mainPanel.add(lowBeta.panel);
        mainPanel.add(highBeta.panel);
        mainPanel.add(lowGamma.panel);
        mainPanel.add(highGamma.panel);
        mainPanel.add(delta.panel);
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
            updateFields(eegReading);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
        catch(NullPointerException exception) {
            System.out.println("Exception while updating Visualizer: " + exception);
        }
    }

    private synchronized void updateFields(EEGReading input) {
        delta.updateChart(input.getDelta());
        theta.updateChart(input.getTheta());
        lowAlpha.updateChart(input.getLowAlpha());
        highAlpha.updateChart(input.getHighAlpha());
        lowBeta.updateChart(input.getLowBeta());
        highBeta.updateChart(input.getHighBeta());
        lowGamma.updateChart(input.getLowGamma());
        highGamma.updateChart(input.getHighGamma());
    }

}
