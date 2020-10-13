package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JButton inpBtn1;
    private JButton inpBtn2;
    private JButton inpBtn3;
    private JButton inpBtn4;
    private JButton inpBtn5;
    private JButton inpBtn6;
    private JButton inpBtn7;
    private JButton inpBtn8;
    private JButton inpBtn9;
    private JPanel btnsPanel;
    private JLabel TextLabel;


    TTTMatr matr = new TTTMatr();
    Bot bot = new Bot(matr ,btnsPanel.getComponents());

    private ActionListener btnAcrion = new MtBtnActionListener(matr ,TextLabel);


    MainForm() {
        textLabelInit();
        inpBtnInit();

        setVisible(true);
        setSize(500,500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(panel1);


    }

    private void inpBtnInit() {
        Component[] btnComponents = btnsPanel.getComponents();
        for(Component component: btnComponents) {
            JButton btn = (JButton) component;
            btn.addActionListener(btnAcrion);
        }
    }

    private void textLabelInit() {
        TextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TextLabel.setVerticalAlignment(SwingConstants.CENTER);

        TextLabel.setText("X move");
    }


}
