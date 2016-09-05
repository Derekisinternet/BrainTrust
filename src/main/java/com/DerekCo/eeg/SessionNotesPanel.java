package com.DerekCo.eeg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mastermind on 8/25/16.
 */
public class SessionNotesPanel {
    JPanel panel;
    JPanel buffer;
    JTextArea recordField;
    JTextArea inputField;
    JTextField inputLabel;
    JButton submit;
    String sessionName;
    SessionNotes notesObj;

    public SessionNotesPanel(String name, SessionNotes notes){

        sessionName = name;
        notesObj = notes;

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        //set the panel to stack components vertically:
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(260, 350));

        recordField = new JTextArea(3, 10);
        recordField.setEditable(false);
        recordField.setLineWrap(true);
        recordField.setWrapStyleWord(true);
        populateRecordField();

        buffer = new JPanel();
        buffer.setBackground(Color.LIGHT_GRAY);
        inputLabel = new JTextField("Add Note:");
        inputLabel.setEditable(false);
        inputLabel.setBackground(Color.LIGHT_GRAY);
        buffer.add(inputLabel);

        inputField = new JTextArea(3, 2);
        inputField.setEditable(true);
        inputField.setLineWrap(true);
        inputField.setWrapStyleWord(true);


        submit = new JButton("Submit");
        submit.addActionListener(new SubmitButtonListener());

        panel.add(recordField);
        panel.add(buffer);
        panel.add(inputField);
        panel.add(submit);

    }

    void populateRecordField() {
        String record = notesObj.getNotes();
        recordField.append(record);
    }

    void close() {
        notesObj.archive(recordField.getText());
    }

    public JPanel getMainPanel() {
        return this.panel;
    }

    public String timeStamp() {
        return new SimpleDateFormat("HH:mm:ss - ").format(new Date());
    }

    class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String noteText = inputField.getText() + "\n";
            recordField.append(timeStamp());
            recordField.append(noteText);
            inputField.setText("");

        }
    }
}
