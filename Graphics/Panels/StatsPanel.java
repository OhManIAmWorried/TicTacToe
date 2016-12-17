package Graphics.Panels;

import Logic.Result;
import Logic.Statistic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 02.12.2016.
 */
public class StatsPanel extends JPanel {
    Statistic stat;
    JLabel[][] label;
    JPanel[] panel;

    public StatsPanel(){
        setLayout(new GridLayout(11, 1));
        stat = new Statistic();
        Upgrade(false);
    }

    public void Clear(){
        for(int i=0; i<panel.length; i++)
            remove(panel[i]);
    }

    public void Upgrade(boolean ind){
        Result[] res= new Result[1];
        try {
            res = stat.readStats();
        } catch (Exception e){
            e.printStackTrace();
        }

        if (ind)
            Clear();

        panel = new JPanel[stat.getSize()];
        label = new JLabel[4][stat.getSize()];


        for (int i = 0; i < stat.getSize(); i++) {
            System.out.println(res[i].Name1+"____"+res[i].Res+ "____"+res[i].Name2+ "____"+res[i].Time);

            label[0][i] = new JLabel(res[i].Name1);
            label[1][i] = new JLabel(res[i].Res);
            label[2][i] = new JLabel(res[i].Name2);
            label[3][i] = new JLabel(res[i].Time+" ");
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
    }

    public  void updateColors(){

    }
}
