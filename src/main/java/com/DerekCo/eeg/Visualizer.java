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
    private JPanel brainWavePanel;
    private EEGInputHandler inputs;
    private EEGRow eegRow;

    BrainWaveBarWrapper delta;
    BrainWaveBarWrapper theta;
    BrainWaveBarWrapper lowAlpha;
    BrainWaveBarWrapper highAlpha;
    BrainWaveBarWrapper lowBeta;
    BrainWaveBarWrapper highBeta;
    BrainWaveBarWrapper lowGamma;
    BrainWaveBarWrapper highGamma;
    NeuroSkyPanel neuroSky;


    public Visualizer() {
        //main panel stacks brainwave panel on top of NeuroSky panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        brainWavePanel = new JPanel();
        brainWavePanel.setBackground(Color.black);
        initBrainWaveFields();
        mainPanel.add(brainWavePanel);

        neuroSky = new NeuroSkyPanel();

        mainPanel.add(neuroSky.panel);
    }

    void initBrainWaveFields() {
        lowAlpha = new BrainWaveBarWrapper("Low Alpha", Color.ORANGE);
        highAlpha = new BrainWaveBarWrapper("High Alpha", Color.ORANGE);
        lowBeta = new BrainWaveBarWrapper("Low Beta", Color.MAGENTA);
        highBeta = new BrainWaveBarWrapper("High Beta", Color.MAGENTA);
        lowGamma = new BrainWaveBarWrapper("Low Gamma", Color.RED);
        highGamma = new BrainWaveBarWrapper("High Gamma", Color.RED);
        delta = new BrainWaveBarWrapper("Delta", Color.BLUE);
        theta = new BrainWaveBarWrapper("Theta", Color.green);

        brainWavePanel.add(lowAlpha.panel);
        brainWavePanel.add(highAlpha.panel);
        brainWavePanel.add(lowBeta.panel);
        brainWavePanel.add(highBeta.panel);
        brainWavePanel.add(lowGamma.panel);
        brainWavePanel.add(highGamma.panel);
        brainWavePanel.add(delta.panel);
        brainWavePanel.add(theta.panel);
    }


    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String message = inputs.getMessage();
        try {
            eegRow = new EEGRow(message);
            updateFields(eegRow);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
        catch(NullPointerException exception) {
            System.out.println("Exception while updating Visualizer: " + exception);
        }
    }

    private synchronized void updateFields(EEGRow input) {
        delta.updateChart(input.getReadingAt(4));
        theta.updateChart(input.getReadingAt(5));
        lowAlpha.updateChart(input.getReadingAt(6));
        highAlpha.updateChart(input.getReadingAt(7));
        lowBeta.updateChart(input.getReadingAt(8));
        highBeta.updateChart(input.getReadingAt(9));
        lowGamma.updateChart(input.getReadingAt(10));
        highGamma.updateChart(input.getReadingAt(11));
        neuroSky.updateFields(input.getSignalStrength(), input.getReadingAt(2), input.getReadingAt(3));
    }

}
