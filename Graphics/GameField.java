package Graphics;

import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame{

    private JPanel mainpanel = new JPanel();
    private XOButton button[] = new XOButton[9];

    public static void main(String[] args){
        new GameField();
    }

    public GameField(){
        super("TicTacToe v 0.0");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainpanel.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++){
            button[i] = new XOButton();
            mainpanel.add(button[i]);
        }

        setAlwaysOnTop(true);
        setResizable(false);
        add(mainpanel);
        setVisible(true);
    }
}
