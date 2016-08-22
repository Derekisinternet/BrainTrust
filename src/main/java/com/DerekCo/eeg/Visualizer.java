package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mastermind on 8/21/16.
 */
public class Visualizer extends JPanel implements Observer {
    private EEGInputHandler inputs;
    private EEGReading eegReading;

    int maxBarHeight = 60;

    public void update(Observable observable, Object arg) {
        inputs = (EEGInputHandler) observable;
        String message = inputs.getMessage();
        try {
            eegReading = new EEGReading(message);
            this.repaint();
        } catch (IndexOutOfBoundsException exception){
            System.out.println("received incomplete EEG reading.");
        }
    }

    // main method that updates the class
    public void paintComponent(Graphics g) {
        g.fillRect(0,0, this.getWidth(), this.getHeight());
        g.setColor(Color.orange);
        if (eegReading == null){
            g.fillRect(10, this.getHeight()-2 ,10,this.getHeight());
        }
        else {
            g.fillRect(10, this.getHeight() - eegReading.getAttention(), 10, this.getHeight());
        }
    }

}
