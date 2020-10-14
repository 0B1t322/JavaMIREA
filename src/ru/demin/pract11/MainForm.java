package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JPanel btnsPanel;
    private JButton intBtn1;
    private JButton intBtn2;
    private JButton intBtn3;
    private JButton intBtn4;
    private JButton intBtn5;
    private JButton intBtn6;
    private JButton intBtn7;
    private JButton intBtn8;
    private JButton intBtn9;
    private JPanel choosePanel;
    private JRadioButton PvsP; // изначально уже выбрана
    private JRadioButton PvsB;
    private JPanel gamePanel;
    private JLabel TextLabel;
    private JButton startBtn;

    private Component[] btnComponents = btnsPanel.getComponents();

    TTTMatr matr = new TTTMatr();

    private ActionListener rBtnAction;
    private ActionListener btnAcrion;
    private ActionListener startBtnAction;

    private Bot bot;

    MainForm() {
        bot = new Bot(matr, btnComponents);
        actionsInit();

        textLabelInit();
        inpBtnInit();
        rBtnInit();

        setVisible(true);
        setSize(500,500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(panel1);

    }

    private void inpBtnInit() {
        for(Component component: btnComponents) {
            JButton btn = (JButton) component;
            btn.setText("");
            btn.addActionListener(btnAcrion);
        }
        startBtn.addActionListener(startBtnAction);
    }

    private void rBtnInit() {
        this.PvsB.addActionListener(rBtnAction);
        this.PvsP.addActionListener(rBtnAction);
    }

    private void textLabelInit() {
        TextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TextLabel.setVerticalAlignment(SwingConstants.CENTER);

        TextLabel.setText("X move");
    }

    private void actionsInit() {
        chooseRadioBtnActionListener radioListener = new chooseRadioBtnActionListener(PvsP, PvsB);
        bot.setActive(radioListener.getIsBot());
        rBtnAction = radioListener;

        gameBtnActionListener gameListener =  new gameBtnActionListener(matr, TextLabel);
        gameListener.setBot(this.bot);
        btnAcrion = gameListener;

        startBtnAction = new chooseBtnActionListener();

    }


}
