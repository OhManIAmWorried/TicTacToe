package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel mpanel;         //main panel
    private JPanel cpanel;         //content panel
    private JPanel bpanel;         //buttons panel
    private JButton pvpb;          //pvp button
    private JButton pvcb;          //pvc button
    private JButton cvcb;          //cvc button

    private XOButton[][] cells;

    public static void main(String[] args){
        new Menu();
    }
    Menu(){
        super("Tic Tac Toe v0.0");
        add(mpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setMinimumSize(new Dimension(700,500));
        setAlwaysOnTop(true);
        setVisible(true);
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
                pvpb.setVisible(false);
                pvcb.setVisible(false);
                cvcb.setVisible(false);
                bpanel.remove(pvpb);
                bpanel.remove(pvcb);
                bpanel.remove(cvcb);
                bpanel.setLayout(new GridLayout(3,3));
                cells = new XOButton[3][3];
                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++) {
                        cells[i][j] = new XOButton();
                        bpanel.add(cells[i][j]);
                    }
            }
        });
    }
}
