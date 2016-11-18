package Graphics;

import javax.swing.*;
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
    private static int n;          //elements per edge

    private static XOButton[][] cells;

    public static void main(String[] args){
        new Menu();
    }
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

    public static void setCell(int i, int j){System.out. println("cell set"); cells[i][j].doClick();}

    private void addField(int n){
        pvpb.setVisible(false);
        pvcb.setVisible(false);
        cvcb.setVisible(false);
        bpanel.remove(pvpb);
        bpanel.remove(pvcb);
        bpanel.remove(cvcb);
        bpanel.setLayout(new GridLayout(n,n));
        cells = new XOButton[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cells[i][j] = new XOButton(i,j);
                bpanel.add(cells[i][j]);
            }
        bpanel.revalidate();
        bpanel.repaint();
    }

    private void createUIComponents() {

        cpanel = new JPanel();
        bpanel = new JPanel();

        pvpb = new JButton();
        pvcb = new JButton();
        cvcb = new JButton();

        pvpb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addField(n);
                Player player1 = new Human();
                Player player2 = new Human();
                new toPlay(player1,player2,n);
            }
        });

        pvcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addField(n);
                Player player1 = new Human();
                Player player2 = new PC();
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
                new toPlay(player1,player2,n);
            }
        });
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
