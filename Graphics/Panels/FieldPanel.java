package Graphics.Panels;

import Graphics.CS.*;
import Graphics.XOButton;
import Graphics.Menu;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    private XOButton[][] cells;
    private static ColorScheme cs;
    private static int n;

    public void reUpdate() {
        cs = Menu.getMenu().getCs();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j].setBackground(cs.BUTTON_BG);
        setBackground(cs.CONTPANEL_BG);
    }

    public FieldPanel(int n) {
        cells = new XOButton[n][n];
        setLayout(new GridLayout(n,n));
        this.n = n;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cells[i][j] = new XOButton(i, j);
                add(cells[i][j]);
            }
        reUpdate();
    }

    public void setOff() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j].setDisabled();
    }

    public void setOn() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                System.out.println("Enabeling (Field)");
                cells[i][j].setEnabled();
                cells[i][j].revalidate();
            }
    }

    public void setCell(int i, int j){cells[i][j].doClick(); System.out.println("Clicked");}
}
