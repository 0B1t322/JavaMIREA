package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseRadioBtnActionListener implements ActionListener {

    private JRadioButton PvsP;
    private JRadioButton PvsB;
    private MyBool isBot = new MyBool(false);

    public MyBool getIsBot() {
        return isBot;
    }

    public chooseRadioBtnActionListener(JRadioButton pvsP, JRadioButton pvsB) {
        PvsP = pvsP;
        PvsB = pvsB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton clickedBtn = (JRadioButton) e.getSource();

        if(clickedBtn == PvsP) {
            isBot.setVar(false);
            PvsB.setSelected(false);
        } else {
            isBot.setVar(true);
            PvsP.setSelected(false);
        }


    }


}
