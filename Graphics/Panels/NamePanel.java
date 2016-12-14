package Graphics.Panels;

import Graphics.CS.ColorScheme;
import Logic.Human;
import Logic.PC;
import Logic.Player;
import Logic.toPlay;
import Graphics.Menu;

import javax.swing.border.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
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

        player1 = new Human();
        player2 = new Human();

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

        ColorScheme cs = Menu.getMenu().getCs();

        lbl1.setBackground(cs.TEXTFIELD_BG);
        panel.setBackground(cs.CONTPANEL_BG);
        rbtn11.setBackground(cs.RADIOBUTTON_BG);
        rbtn12.setBackground(cs.RADIOBUTTON_BG);
        rbtn21.setBackground(cs.RADIOBUTTON_BG);
        rbtn22.setBackground(cs.RADIOBUTTON_BG);
        rbtn11.setForeground(cs.RADIOBUTTON_FG);
        rbtn12.setForeground(cs.RADIOBUTTON_FG);
        rbtn21.setForeground(cs.RADIOBUTTON_FG);
        rbtn22.setForeground(cs.RADIOBUTTON_FG);
        tf1.setBackground(cs.TEXTFIELD_BG);
        tf2.setBackground(cs.TEXTFIELD_BG);
        tf1.setForeground(cs.TEXTFIELD_FG);
        tf2.setForeground(cs.TEXTFIELD_FG);
        tf1.setCaretColor(cs.TEXTFIELD_CARET);
        tf2.setCaretColor(cs.TEXTFIELD_CARET);
        readybtn.setBackground(cs.BUTTON_BG);
        readybtn.setForeground(cs.BUTTON_FG);
        lbl1.setForeground(cs.LABEL_FG);
        lbl2.setForeground(cs.LABEL_FG);

        setBorder(new MatteBorder(5, 5, 5, 5, cs.CONTPANEL_BG));
        readybtn.setBorder(new MatteBorder(10,0,5,0, cs.CONTPANEL_BG));

        readybtn.setFont(new Font("Alien Encounters", Font.PLAIN, 19));

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
                player1 = new PC();
                Menu.getMenu().setPlayer1(player1);
                String n = Menu.setName();
                player1.setName(n);
                tf1.setText(player1.getName());
            }
        });

        rbtn12.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1 = new Human();
                Menu.getMenu().setPlayer1(player1);
                player1.setName("Mr. Nobody");
                tf1.setText("Mr. Nobody");
            }
        });

        rbtn21.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new PC();
                Menu.getMenu().setPlayer2(player2);
                String n = Menu.setName();
                player2.setName(n);
                tf2.setText(player2.getName());
            }
        });

        rbtn22.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new Human();
                Menu.getMenu().setPlayer2(player2);
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

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new toPlay(player1, player2, n);
                    }
                });
            }
        });
    }
}
