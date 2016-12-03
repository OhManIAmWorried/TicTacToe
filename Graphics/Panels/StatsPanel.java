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

    public StatsPanel() throws Exception {
        setLayout(new GridLayout(4, 10));
        stat = new Statistic();
        Upgrade();
    }

    public void Upgrade(){
        label = new JLabel[4][stat.getSize()];
        try {
            stat.readStats();
        } catch (Exception e){

        }
        Result[] res = stat.getStatsArr();
        for (int i = 0; i < stat.getSize(); i++) {
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
