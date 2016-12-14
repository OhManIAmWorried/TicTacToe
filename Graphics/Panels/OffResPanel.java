package Graphics.Panels;

import Graphics.CS.ColorScheme;
import Graphics.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OffResPanel extends JPanel {
    JButton contbutton;

    public OffResPanel() {
        ColorScheme cs = Menu.getCs();

        contbutton = new JButton();

        setLayout(new BorderLayout());

        setBackground(cs.CONTPANEL_BG);
        contbutton.setBackground(cs.BUTTON_PRIMARY_BG);
        contbutton.setForeground(/*Color.RED*/cs.BUTTON_PRIMARY_FG);
        add(contbutton);

        contbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("1");
            }
        });
    }

    public void showWin(String name) {
        contbutton.setText(name + " Wins!");
        System.out.println(name + " Wins! (OffResPanel)");
    }

    public void showTie() {
        contbutton.setText("Tie!");
        System.out.println("Tie! (OffResPanel)");
    }
}
