package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oly on 07.11.2016.
 */
public class Menu extends JFrame{
    private JPanel panel1;
    private JButton pvpb;

    public static void main(String[] args){
        new Menu();
    }
    Menu(){
        super("Tic Tac Toe v0.0");
        add(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450,500);
        setVisible(true);
    }

    private void createUIComponents() {
        pvpb = new JButton();
        pvpb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField g = new GameField();
            }
        });
    }
}
