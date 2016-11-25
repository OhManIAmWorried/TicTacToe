package Graphics.Panels;

import Logic.Human;
import Logic.PC;
import Logic.Player;
import Logic.toPlay;
import Graphics.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel{

    private static ButtonGroup group1;
    private static ButtonGroup group2;
    private static JRadioButton rbtn11; //PC
    private static JRadioButton rbtn12; //Human
    private static JRadioButton rbtn21; //PC
    private static JRadioButton rbtn22; //Human
    private static JLabel lbl1;         //Player1:
    private static JLabel lbl2;         //Player2:
    private static JTextField tf1;
    private static JTextField tf2;
    private static Player player1;
    private static Player player2;
    private static JButton readybtn;
    private static boolean sw1 = false;
    private static boolean sw2 = false;
    private static JPanel panel;

    public NamePanel(){

        group1 = new ButtonGroup();
        rbtn11 = new JRadioButton("Computer", false);
        rbtn12 = new JRadioButton("Human", true);
        group1.add(rbtn11);
        group1.add(rbtn12);
        lbl1 = new JLabel("Player 1:");
        tf1 = new JTextField("Mr. Nobody");              //One of my all-time favorite films  =P

        group2 = new ButtonGroup();
        rbtn21 = new JRadioButton("Computer", false);
        rbtn22 = new JRadioButton("Human", true);
        group2.add(rbtn21);
        group2.add(rbtn22);
        lbl2 = new JLabel("Player 2:");
        tf2 = new JTextField("Ms. Nobody");

        readybtn = new JButton("Ready");

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(rbtn11);
        panel.add(rbtn21);
        panel.add(rbtn12);
        panel.add(rbtn22);
        panel.add(tf1);
        panel.add(tf2);

        setLayout(new GridLayout(2,1));
        add(panel);
        add(readybtn);

        rbtn11.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.setPlayer1(new PC());
                String n = Menu.setName();
                player1.setName(n);
                tf1.setText(player1.getName());
            }
        });

        rbtn12.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1 = new Human();
                player1.setName("Mr. Nobody");
                tf1.setText("Mr. Nobody");
            }
        });

        rbtn21.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new PC();
                String n = Menu.setName();
                player2.setName(n);
                tf2.setText(player2.getName());
            }
        });

        rbtn22.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new Human();
                player2.setName("Ms. Nobody");
                tf2.setText("Ms. Nobody");
            }
        });

        readybtn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1.setName(tf1.getText());
                player2.setName(tf2.getText());
                int n = 3;
                new toPlay(player1, player2, n);
            }
        });

    }

}