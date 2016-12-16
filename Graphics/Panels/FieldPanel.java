package Graphics.Panels;

import Graphics.CS.*;
import Graphics.XOButton;
import Graphics.Menu;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class FieldPanel extends JPanel {
    private XOButton[][] cells;
    private static ColorScheme cs;
    private static int n;

    public void updateColors() {
        cs = Menu.getMenu().getCs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].updateColors();
            }
        }
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
        updateColors();
    }

    public void setOff() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j].setDisabled();
    }

    public void setOn() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {cells[i][j].setEnabled();}
    }

    public void doMarkCell(int i, int j){cells[i][j].doHighlight();}
    public void clearCell(int i, int j){cells[i][j].putBlank();}
    public void setCell(int i, int j){cells[i][j].doClick();}
}
