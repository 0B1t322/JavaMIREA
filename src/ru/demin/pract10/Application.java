package ru.demin.pract10;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Application {
    private JTextField varA;
    private JTextField varB;
    private JTextField answer;
    private State      state = State.NONE;
    private JPanel     buttonsPanel;
    private Component[] stateButtons;
    private DocumentListener myDocumentListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (varA.getText().length() == 1) {
                varA.setText("0");
            }

            calc();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (varA.getText().length() == 1) {
                varA.setText("0");
            }
            calc();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            //calc();
        }


    };

    public Application() {
        // constarct first textField
        varA = new JTextField();
        varA.setHorizontalAlignment(JTextField.CENTER);
        varA.setMaximumSize(new Dimension(50,50));
        varA.setPreferredSize(new Dimension(50, 50));
        varA.setText("0");
        varA.getDocument().addDocumentListener(myDocumentListener);


        // constacrt second textField
        varB = new JTextField();
        varB.setHorizontalAlignment(JTextField.CENTER);
        varB.setMaximumSize(new Dimension(50,50));
        varB.setPreferredSize(new Dimension(50, 50));
        varB.setText("0");
        varB.getDocument().addDocumentListener(myDocumentListener);

        answer = new JTextField();
        answer.setHorizontalAlignment(JTextField.CENTER);
        answer.setEnabled(false);
        answer.setMaximumSize(new Dimension(50,50));
        answer.setPreferredSize(new Dimension(50,50));
        answer.setText("0");

        buttonsPanel = new JPanel(new FlowLayout());

        prepareButtons();

        stateButtons = buttonsPanel.getComponents();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        JFrame frame = prepareFrame();

    }

    private JFrame prepareFrame() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 450));

        JPanel mainLayout = prepareMainLayout();

        frame.getContentPane().add(mainLayout);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JPanel prepareMainLayout() {
        JPanel textFields = new JPanel(new GridLayout(4,1));
        textFields.add(varA);
        textFields.add(buttonsPanel);
        textFields.add(varB);
        textFields.add(answer);

        JPanel mainLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainLayout.add(textFields);

        return mainLayout;
    }

    private void prepareButtons() {
       JButton btnSum = new JButton("+");
       btnSum.setSize(50, 50);
       btnSum.addActionListener((event)->{
           setEnabled(State.SUM);
       });

       JButton btnMin = new JButton("-");
       btnMin.setSize(50, 50);
       btnMin.addActionListener((event)->{
           setEnabled(State.MIN);
       });

       JButton btnUmn = new JButton("*");
       btnUmn.setSize(50, 50);
       btnUmn.addActionListener((event)->{
           setEnabled(State.UMN);
       });

       JButton btnDel = new JButton("/");
       btnDel.setSize(50, 50);
       btnDel.addActionListener((event)->{
           setEnabled(State.DEL);
       });

       buttonsPanel.add(btnSum);
       buttonsPanel.add(btnMin);
       buttonsPanel.add(btnUmn);
       buttonsPanel.add(btnDel);
    }

    private void setEnabled(State state) {
        switch (this.state) {
            case SUM: {
                JButton btn = (JButton) stateButtons[0];
                btn.setSelected(false);
                break;
            }
            case MIN :{
                JButton btn = (JButton) stateButtons[1];
                btn.setSelected(false);
                break;
            }
            case UMN :{
                JButton btn = (JButton) stateButtons[2];
                btn.setSelected(false);
                break;
            }
            case DEL : {
                JButton btn = (JButton) stateButtons[3];
                btn.setSelected(false);
                break;
            }
        }

        switch (state) {
            case SUM: {
                JButton btn = (JButton) stateButtons[0];
                btn.setSelected(true);
                break;
            }
            case MIN :{
                JButton btn = (JButton) stateButtons[1];
                btn.setSelected(true);
                break;
            }
            case UMN :{
                JButton btn = (JButton) stateButtons[2];
                btn.setSelected(true);
                break;
            }
            case DEL : {
                JButton btn = (JButton) stateButtons[3];
                btn.setSelected(true);
                break;
            }
        }

        this.state = state;
        calc();
    }

    private void calc() {
        float A = Float.parseFloat(varA.getText());
        float B = Float.parseFloat(varB.getText());

        switch (this.state) {
            case SUM: {
                float ans = A + B;
                answer.setText(String.valueOf(ans));
                break;
            }
            case MIN: {
                float ans = A - B;
                answer.setText(String.valueOf(ans));
                break;
            }
            case DEL: {
                float ans = A / B;
                answer.setText(String.valueOf(ans));
                break;
            }
            case UMN: {
                float ans = A * B;
                answer.setText(String.valueOf(ans));
                break;
            }

            case NONE: {
                break;
            }


        }
    }
}
