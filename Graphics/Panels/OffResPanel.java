package Graphics.Panels;

import Graphics.CS.ColorScheme;
import Graphics.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OffResPanel extends JPanel {
    JLabel msglabel;
    JButton contbutton;

    public OffResPanel() {
        ColorScheme cs = Menu.getCs();
        msglabel = new JLabel();
        contbutton = new JButton("continue");
        setLayout(new GridLayout(2,1));

        setBackground(cs.CONTPANEL_BG);
        msglabel.setForeground(cs.LABEL_FG);
        contbutton.setBackground(cs.BUTTON_PRIMARY_BG);
        contbutton.setForeground(cs.BUTTON_PRIMARY_FG);

        msglabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(msglabel);
        add(contbutton);

        contbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("1");
            }
        });
    }

    public void showWin(String name) {
        msglabel.setText(name + " Wins!");
        System.out.println(name + " Wins!");
    }

    public void showTie() {
        msglabel.setText("Tie!");
        System.out.println("Tie!");
    }
}
