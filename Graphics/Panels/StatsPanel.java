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

    public StatsPanel(){
        setLayout(new GridLayout(10, 4));
        stat = new Statistic();
        Upgrade();
    }

    public void Upgrade(){
        try {
            stat.readStats();
        } catch (Exception e){
            e.printStackTrace();
        }
        label = new JLabel[4][stat.getSize()];
        Result[] res = stat.getStatsArr();
        System.out.println(stat.getSize());
        for (int i = 0; i < stat.getSize(); i++) {
            System.out.println(i);
            System.out.println(res[i].Name1+"____"+res[i].Res+ "____"+res[i].Name2+ "____"+res[i].Time.getTime());
            for(int j=0; j<4; j++)
                label[j][i] = new JLabel();
            label[0][i].setText(res[i].Name1);
            label[1][i].setText(res[i].Res);
            label[2][i].setText(res[i].Name2);
            label[3][i].setText(res[i].Time.getTime()+" ");
            this.add(label[0][i]);
            this.add(label[1][i]);
            this.add(label[2][i]);
            this.add(label[3][i]);
        }
    }
}
