package Graphics.Panels;

import Graphics.CS.ColorScheme;
import Logic.Result;
import Logic.Statistic;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Graphics.Menu;

/**
 * Created by Alex on 02.12.2016.
 */
public class StatsPanel extends JPanel {
    Statistic stat;
    JLabel[][] label;
    JPanel[] panel;
    JButton button1;
    JButton button2;

    public StatsPanel(){
        setLayout(new GridLayout(12, 1));
        stat = new Statistic();
        upgrade(false);
    }

    public void clear(){
        for(int i=0; i<panel.length; i++)
            remove(panel[i]);
    }

    public void upgrade(boolean ind){
        Result[] res= new Result[1];
        try {
            res = stat.readStats();
        } catch (Exception e){
            e.printStackTrace();
        }

        if (ind)
            clear();

        panel = new JPanel[12];
        label = new JLabel[4][stat.getSize()+1];
        label[0][0] = new JLabel("1st player");
        label[1][0] = new JLabel("Result");
        label[2][0] = new JLabel("2nd player");
        label[3][0] = new JLabel("Time");

        panel[0] = new JPanel();
        panel[0].setLayout(new GridLayout(1,4));
        panel[0].setOpaque(false);


        for(int j=0; j<4; j++) {
            label[j][0].setHorizontalAlignment(SwingConstants.CENTER);
            label[j][0].setFont(new Font("Century Gothic", Font.BOLD, 16));
            panel[0].add(label[j][0]);
        }

        this.add(panel[0]);

        for (int i = 1; i <= stat.getSize(); i++) {
            label[0][i] = new JLabel(res[i-1].Name1);
            label[1][i] = new JLabel(res[i-1].Res);
            label[2][i] = new JLabel(res[i-1].Name2);
            label[3][i] = new JLabel(res[i-1].Time+"");

            for(int j=0; j<4; j++)
                label[j][i].setHorizontalAlignment(SwingConstants.CENTER);

            panel[i] = new JPanel();
            panel[i].setLayout(new GridLayout(1,4));
            panel[i].setOpaque(false);

            panel[i].add(label[0][i]);
            panel[i].add(label[1][i]);
            panel[i].add(label[2][i]);
            panel[i].add(label[3][i]);
            this.add(panel[i]);
        }
        for(int i = stat.getSize()+1; i<11; i++){
            panel[i] = new JPanel();
            panel[i].setOpaque(false);
            this.add(panel[i]);
        }

        panel[11] = new JPanel();
        panel[11].setLayout(new GridLayout(1,2));
        panel[11].setOpaque(false);

        button1 = new JButton("Return to menu");
        button2 = new JButton("Clear stats");

        panel[11].add(button1);
        panel[11].add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().clShow("1");                    //Shows menu
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stat.clear();
                upgrade(true);
            }
        });
        this.add(panel[11]);
        updateColors();
    }

    public void updateColors(){
        ColorScheme cs = Menu.getCs();
        setBackground(cs.CONTPANEL_BG);
        for(int i = 0; i<label.length; i++)
            for(int j =0; j<label[i].length; j++){
            //label[i][j].setBackground(cs.CONTPANEL_BG);
                label[i][j].setForeground(cs.LABEL_FG);
            }

        /* for(int i = 0; i<panel.length; i++){
            panel[i].setBackground(cs.CONTPANEL_BG);
        }*/

        button1.setBorder(new MatteBorder(2, 8, 2, 4, cs.CONTPANEL_BG));
        button2.setBorder(new MatteBorder(2, 4, 2, 8, cs.CONTPANEL_BG));
        button1.setBackground(cs.BUTTON_BG);
        button1.setForeground(cs.BUTTON_FG);
        button2.setBackground(cs.BUTTON_BG);
        button2.setForeground(cs.BUTTON_FG);
    }
}
