package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mastermind on 8/25/16.
 */
public class SessionNotes {
    JPanel panel;
    JPanel buffer;
    JTextArea recordField;
    JTextArea inputField;
    JButton submit;
    JButton mark;

    public SessionNotes(){
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        //set the panel to stack components vertically:
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(260, 350));

        recordField = new JTextArea(3, 4);
        recordField.setEditable(false);
        recordField.setLineWrap(true);

        buffer = new JPanel();

        inputField = new JTextArea(3, 2);
        inputField.setEditable(true);
        inputField.setLineWrap(true);


        submit = new JButton("Submit");
        mark = new JButton("Mark");

        panel.add(recordField);
        panel.add(buffer);
        panel.add(inputField);
        panel.add(submit);
        panel.add(mark);

    }

    public JPanel getMainPanel() {
        return this.panel;
    }
}
