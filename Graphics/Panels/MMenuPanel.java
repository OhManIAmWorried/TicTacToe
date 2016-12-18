package Graphics.Panels;

import Graphics.CS.ColorScheme;
import Graphics.Menu;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oly on 25.11.2016.
 */
public class MMenuPanel extends JPanel{
    private JButton toplaybtn; //Play button
    private JButton statsbtn; //Stats button
    private JButton settingsbtn; //Settings button
    private JButton rulesbtn; //Rules button

    private ColorScheme cs;

    public void updateColors(){
        cs = Menu.getCs();

        setBackground(cs.WIDEPANEL_BG);

        toplaybtn.setForeground(cs.BUTTON_PRIMARY_FG);
        toplaybtn.setBackground(cs.BUTTON_PRIMARY_BG);
        statsbtn.setForeground(cs.BUTTON_PRIMARY_FG);
        statsbtn.setBackground(cs.BUTTON_PRIMARY_BG);
        settingsbtn.setForeground(cs.BUTTON_PRIMARY_FG);
        settingsbtn.setBackground(cs.BUTTON_PRIMARY_BG);
        rulesbtn.setBackground(cs.BUTTON_PRIMARY_BG);
        rulesbtn.setForeground(cs.BUTTON_PRIMARY_FG);

        int w = 10;
        toplaybtn.setBorder(new MatteBorder(w/2, w, w/2, w, cs.FIELDCELL_BORDER));
        statsbtn.setBorder(new MatteBorder(w/2, w, w/2, w, cs.FIELDCELL_BORDER));
        settingsbtn.setBorder(new MatteBorder(w/2, w, w/2, w, cs.FIELDCELL_BORDER));
        rulesbtn.setBorder(new MatteBorder(w/2, w, w/2, w, cs.FIELDCELL_BORDER));

        toplaybtn.setFont(new Font("Khmer", Font.PLAIN, 16));
        statsbtn.setFont(new Font("Khmer", Font.PLAIN, 16));
        settingsbtn.setFont(new Font("Khmer", Font.PLAIN, 16));
        rulesbtn.setFont(new Font("Khmer", Font.PLAIN, 16));

        toplaybtn.setVisible(true);
        statsbtn.setVisible(true);
        settingsbtn.setVisible(true);
        rulesbtn.setVisible(true);
    }

    public MMenuPanel(){
        setSize(400,250);
        setVisible(true);
        setLayout(new GridLayout(4,1));
        toplaybtn = new JButton("Play");
        statsbtn = new JButton("Stats");
        settingsbtn = new JButton("Settings");
        rulesbtn = new JButton("Rules");
        updateColors();
        add(toplaybtn);
        add(statsbtn);
        add(settingsbtn);
        add(rulesbtn);

        toplaybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("3");
            }
        });

        statsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("5");
                Menu.getMenu().updateStats();
            }
        });

        settingsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().updateSettingsPanelVariables();;
                Menu.getMenu().clShow("6");
            }
        });

        rulesbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("7");
            }
        });
    }
}

