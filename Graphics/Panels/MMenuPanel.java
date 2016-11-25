package Graphics.Panels;

import Graphics.ColorScheme.ColorScheme;
import Graphics.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oly on 25.11.2016.
 */
public class MMenuPanel extends JPanel{
    private static JButton offbtn; //Offline button
    private static JButton onlbtn; //Online button
    private static JButton chtbtn; //Chat button
    private static ColorScheme cs;

    public void update(){
        cs = Menu.cs;
        setBackground(cs.CONTPANEL_BG);
        offbtn.setForeground(cs.BUTTON_FG);
        offbtn.setBackground(cs.BUTTON_BG);
        onlbtn.setForeground(cs.BUTTON_FG);
        onlbtn.setBackground(cs.BUTTON_BG);
        chtbtn.setForeground(cs.BUTTON_FG);
        chtbtn.setBackground(cs.BUTTON_BG);
    }

    public MMenuPanel(){
        setSize(400,250);
        setVisible(true);
        setLayout(new GridLayout(3,1));
        offbtn = new JButton("Offline mode");
        onlbtn = new JButton("Online mode");
        chtbtn = new JButton("Chat");
        update();
        add(offbtn);
        add(onlbtn);
        add(chtbtn);

        System.out.println("Check");

        offbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("2");
            }
        });
    }
}

