package Graphics;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.CS.ColorScheme;
import Logic.*;

import static Logic.toPlay.getTurn;
import static Logic.toPlay.toMove;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    int indexi,indexj;
    boolean enabled;
    boolean occupied;
    boolean ofirst;

    public XOButton(int i,int j){
        indexi = i;
        indexj = j;
        updateColors();
        this.addActionListener(this);
        occupied = false;
        ofirst = false;
    }

    public void actionPerformed(ActionEvent e){
        if (occupied) System.out.println("Occupied");
        if (!enabled) System.out.println("Disabled");
        if ((enabled) && !(occupied)) {
            System.out.println("Action performed (XOButton)");
            if (toPlay.getTurn()) if (Menu.getMenu().getOFirst()) putO(); else putX();
            else if (Menu.getMenu().getOFirst()) putX(); else putO();
            occupied = true;
            toPlay.setElement(indexi, indexj);
            revalidate();
            repaint();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    toPlay.nextTurn();
                }
            });
        }
    }

    public void setDisabled(){enabled = false;}
    public void setEnabled(){enabled = true; /*System.out.println("Enabled");*/}

    public void putX(){
        setIcon(X);
    }

    public void putO(){
        setIcon(O);
    }

    public void doHighlight() {
        setBackground(Menu.getMenu().getCs().FIELDCELLWIN_BG);
        System.out.println("Highlighted (XOButton)");
    }

    public void putBlank(){
        setIcon(null);
        setBackground(Menu.getMenu().getCs().FIELDCELL_BG);
        occupied = false;
    }

    public void updateColors(){
        ColorScheme cs = Menu.getMenu().getCs();
        setBackground(cs.FIELDCELL_BG);
        setBorder(new MatteBorder(1, 1, 1, 1, cs.FIELDCELL_BORDER));
        X = new ImageIcon(this.getClass().getResource(cs.X_ICONDIR));
        O = new ImageIcon(this.getClass().getResource(cs.O_ICONDIR));
    }
}
