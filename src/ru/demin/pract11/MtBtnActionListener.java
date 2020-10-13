package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MtBtnActionListener implements ActionListener {
    private Matrer matrer;
    private JLabel textLabel;
    boolean ifEnd = false;

    public MtBtnActionListener(Matrer matrer ,JLabel textLabel) {
        this.matrer = matrer;
        this.textLabel = textLabel;
    }

    private int count = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (count % 2 == 0) {
            btn.setText("X");
            textLabel.setText("O move");
        } else {
            btn.setText("O");
            textLabel.setText("X move");
        }
        setToMatr(btn.getParent(), btn);
        if (ifEnd) {
            disableAllBtns(btn.getParent());
            setWinner();
            return;
        }
        btn.setEnabled(false);
        count++;

    }

    private void setToMatr(Container container, JButton btn) {
        GridBagLayout layout = (GridBagLayout) container.getLayout();
        int row = layout.getConstraints(btn).gridx;
        int col = layout.getConstraints(btn).gridy;
        System.out.printf("y:%s x:%s", col, row);
        byte num;
        if(btn.getText() == "X") {
            num = 1;
        } else {
            num = -1;
        }
        ifEnd = matrer.setNum(num, col, row);
    }

    private void disableAllBtns(Container container) {
        Component[] btns = container.getComponents();
        for(var btn : btns) {
            JButton button = (JButton) btn;
            button.setEnabled(false);
        }
    }
    private void setWinner() {
        String winText;
        if(count % 2 == 0) {
            winText = "X win";
        } else {
            winText = "O win";
        }

        textLabel.setText(winText);
        textLabel.setForeground(Color.GREEN);
    }
}
