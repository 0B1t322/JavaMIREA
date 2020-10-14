package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseBtnActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        switchCard(btn.getParent().getParent()); // panel1
    }

    private void switchCard(Container container) {
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.next(container);
    }
}
