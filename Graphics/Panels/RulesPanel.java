package Graphics.Panels;

import Graphics.CS.CS_Milk;
import Graphics.CS.ColorScheme;
import Graphics.Menu;
import com.sun.javafx.scene.layout.region.Margins;

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
        setLayout(new BorderLayout());
        ruleslabel = new JLabel("<html><center><font size=4 face = Century Gothic><bold>Rules</bold></font></center>" +
                                "<p align= justify>_______________________________________________________<br>" +
                                "RU<br/>Игроки по очереди ставят на свободные клетки поля 3х3 знаки (один всегда" +
                                " крестики, другой всегда нолики). Первый, выстроивший в ряд 3 своих фигуры по " +
                                "вертикали, горизонтали или диагонали, выигрывает.<br/>__________________________" +
                                "_____________________________<br/>ENG<br/>TicTacToe is a game" +
                                " for two players, X and O, who take turns marking the spaces in a 3×3 grid. The player" +
                                " who succeeds in placing three of their marks in a horizontal, vertical, or diagonal " +
                                "row wins the game.</p></html>");
        add(ruleslabel, BorderLayout.CENTER);
        returnbtn = new JButton("Return to Menu");


        add(returnbtn, BorderLayout.SOUTH);


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
        ruleslabel.setBorder(new MatteBorder(5, 5, 5, 0, cs.CONTPANEL_BG));
        ruleslabel.setForeground(cs.LABEL_FG);
        setBackground(cs.CONTPANEL_BG);
        setForeground(cs.LABEL_FG);
        returnbtn.setBackground(cs.BUTTON_BG);
        returnbtn.setForeground(cs.BUTTON_FG);
        returnbtn.setBorder(new MatteBorder(5, 5, 5, 5, cs.CONTPANEL_BG));

    }
}
