package Graphics.Panels;

import Graphics.CS.CS_Milk;
import Graphics.CS.ColorScheme;
import Graphics.Menu;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oly on 18.12.2016.
 */
public class RulesPanel extends JPanel{

    private ColorScheme cs;
    private JLabel ruleslabel;
    private JButton returnbtn;

    public RulesPanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        ruleslabel = new JLabel("<html>RULES" +
                                "<br/>_______________________________________________________" +
                                "<br/>RU<br/>Игроки по очереди ставят на свободные клетки поля 3х3 знаки (один всегда" +
                                " крестики, другой всегда нолики). Первый, выстроивший в ряд 3 своих фигуры по " +
                                "вертикали, горизонтали или диагонали, выигрывает.<br/>__________________________" +
                                "_____________________________<br/>ENG<br/>TicTacToe is a game" +
                                " for two players, X and O, who take turns marking the spaces in a 3×3 grid. The player" +
                                " who succeeds in placing three of their marks in a horizontal, vertical, or diagonal " +
                                "row wins the game.</html>");
        add(ruleslabel);
        returnbtn = new JButton("Return to Menu");
        add(returnbtn);
        cs = new CS_Milk();
        updateColors();
        returnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("1");                   //Returns to Menu
            }
        });
    }

    public void updateColors(){
        if (Menu.getMenu() != null) cs = Menu.getMenu().getCs();
        ruleslabel.setBorder(new MatteBorder(5, 5, 5, 0, cs.TEXTFIELD_BG));
        setBackground(cs.TEXTFIELD_BG);
        setForeground(cs.TEXTFIELD_FG);
        returnbtn.setBackground(cs.TEXTFIELD_BG);
        returnbtn.setForeground(cs.TEXTFIELD_FG);
    }
}
