package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.*;

public class Menu extends JFrame{
    private JPanel mpanel;         //main panel
    private JPanel cpanel;         //content panel
    private JPanel bpanel;         //buttons panel
    private JButton pvpb;          //pvp button
    private JButton pvcb;          //pvc button
    private JButton cvcb;          //cvc button
    private JButton b;
    private JPanel pan1;
    private JPanel pan2;
    private static int n;          //elements per edge
    Player player1;
    Player player2;

    private String setName(){
        String[] names = {"Mary", "John", "Arty", "A. Hitler", "Neco", "Lady X.", "Superman", "I. Newton", "Tugaryn-Snake", "Casanova Snake", "Avatar"};
        return names[(int) Math.round(Math.random()*10)];
    }
    private static XOButton[][] cells;

    private static Menu amenu;

    public static void main(String[] args){amenu = new Menu();}

    Menu(){
        super("Tic Tac Toe v0.0");
        n = 3;                                      //TODO: button for changing the value of n
        add(mpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setMinimumSize(new Dimension(700,500));
        setAlwaysOnTop(true);
        setVisible(true);
    }

    public static Menu getMenu(){return amenu;}

    public static void setCell(int i, int j){System.out.println("cell set"); cells[i][j].doClick();}

    private void addField(int n){
        bpanel.remove(b);
        bpanel.remove(pan1);
        bpanel.remove(pan2);
        /*bpanel.setVisible(false);
        pvpb.setVisible(false);
        pvcb.setVisible(false);
        cvcb.setVisible(false);
        bpanel.remove(pvpb);
        bpanel.remove(pvcb);
        bpanel.remove(cvcb);
        bpanel.validate();
        bpanel.repaint();*/
        bpanel.setLayout(new GridLayout(n,n));
        cells = new XOButton[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cells[i][j] = new XOButton(i,j);
                bpanel.add(cells[i][j]);
            }
        bpanel.validate();
        bpanel.repaint();
        bpanel.setVisible(true);
    }

    private void addForm(int n) {
        player1 = new Human();
        player2 = new Human();
        bpanel.setVisible(false);
        pvpb.setVisible(false);
        pvcb.setVisible(false);
        cvcb.setVisible(false);
        bpanel.remove(pvpb);
        bpanel.remove(pvcb);
        bpanel.remove(cvcb);
        player1 = new Human();
        player2 = new Human();

        //player1
        ButtonGroup group1 = new ButtonGroup();
        JRadioButton r11 = new JRadioButton("Computer", false);
        JRadioButton r12 = new JRadioButton("Human", true);
        group1.add(r11);
        group1.add(r12);
        JTextField tf1 = new JTextField("Mr. Nobody");
        JLabel l1 = new JLabel("Name:");
        l1.setBackground(new Color(40,40,40));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2));
        p1.setBackground(new Color(40,40,40));
        p1.setBorder(new EmptyBorder(12,12,12,12));
        r11.setBackground(new Color(40,40,40));
        r12.setBackground(new Color(40,40,40));

        p1.add(r11);
        p1.add(l1);
        p1.add(r12);
        p1.add(tf1);
        p1.setVisible(true);
        pan1 = new JPanel();
        pan1.setBackground(new Color(40,40,40));
        pan1.setLayout(new GridLayout(1,2));
        JLabel lbl1 = new JLabel("Player 1: ");
        lbl1.setBackground(new Color(40,40,40));
        pan1.add(lbl1);
        pan1.add(p1);
        //player2
        ButtonGroup group2 = new ButtonGroup();
        JRadioButton r21 = new JRadioButton("Computer", false);
        JRadioButton r22 = new JRadioButton("Human", true);
        group2.add(r21);
        group2.add(r22);
        JTextField tf2 = new JTextField("Ms. Nobody");
        JLabel l2 = new JLabel("Name:");
        l2.setBackground(new Color(40,40,40));
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2));
        p2.setBackground(new Color(40,40,40));
        p2.setBorder(new EmptyBorder(12,12,12,12));
        r21.setBackground(new Color(40,40,40));
        r22.setBackground(new Color(40,40,40));

        r11.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    player1 = new PC();
                    String n = setName();
                    player1.setName(n);
                    tf1.setText(player1.getName());
            }
        });

        r12.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1 = new Human();
                player1.setName("Mr. Nobody");
                tf1.setText("Mr. Nobody");
            }
        });

        r21.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new PC();
                String n = setName();
                player2.setName(n);
                tf2.setText(player2.getName());
            }
        });

        r22.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2 = new Human();
                player2.setName("Ms. Nobody");
                tf2.setText("Ms. Nobody");
            }
        });

        p2.add(r21);
        p2.add(l2);
        p2.add(r22);
        p2.add(tf2);
        p2.setVisible(true);
        pan2 = new JPanel();
        pan2.setBackground(new Color(40,40,40));
        pan2.setLayout(new GridLayout(1,2));
        JLabel lbl2 = new JLabel("Player 2: ");
        lbl2.setBackground(new Color(40,40,40));
        pan2.add(lbl2);
        pan2.add(p2);

        b = new JButton("Submit");
        b.setBackground(new Color(241,232,198));

        //b.setMargin(new Insets(20, 20, 20, 20));
       // b.setPreferredSize(new Dimension(100, 30));
        bpanel.setLayout(new GridLayout(3,1));
        bpanel.add(pan1);
        bpanel.add(pan2);
        bpanel.add(b);



        bpanel.validate();
        bpanel.repaint();
        bpanel.setVisible(true);

        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 3;
                player1.setName(tf1.getText());
                player2.setName(tf2.getText());
                addField(n);
                new toPlay(player1, player2, n);
            }

            });
    }

    //TODO: fix the overdrawing

    private void createUIComponents() {

        cpanel = new JPanel();
        bpanel = new JPanel();

        pvpb = new JButton();
        pvcb = new JButton();
        cvcb = new JButton();

        pvpb.addActionListener(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e) {
                addForm(n);


            }
        });

      /*  pvcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addField(n);
                Player player1 = new Human();
                Player player2 = new PC();
                player1.setName();
                player2.setName();
                new toPlay(player1,player2,n);
            }
        });

        cvcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addField(n);
                System.out.println("Added");
                Player player1 = new PC();
                Player player2 = new PC();
                player1.setName();
                player2.setName();
                new toPlay(player1,player2,n);
            }
        });*/
    }

    public static void disableField(){
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j].setDisabled();
    }

    public static void enableField(){
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j].setEnabled();
    }
}
