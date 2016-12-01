package Graphics;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.*;

import static Logic.toPlay.getTurn;
import static Logic.toPlay.toMove;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    int indexi,indexj;
    boolean enabled;
    boolean occupied;

    public XOButton(int i,int j){
        indexi = i;
        indexj = j;
        setBackground(Menu.getMenu().getCs().FIELDCELL_BG);
        setBorder(new MatteBorder(1, 1, 1, 1, Menu.getMenu().getCs().FIELDCELL_BORDER));
        X = new ImageIcon(this.getClass().getResource("x.png"));
        O = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
        occupied = false;
    }

    public void actionPerformed(ActionEvent e){
        if (occupied) System.out.println("Occupied");
        if (!enabled) System.out.println("Disabled");
        if ((enabled) && !(occupied)) {
            System.out.println("Action performed (XOButton)");
            if (toPlay.getTurn()) putO();
            else putX();
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
        //SwingUtilities.invokeLater(new Runnable() {
        //    @Override
        //    public void run() {
                setBackground(Menu.getMenu().getCs().FIELDCELLWIN_BG);
                System.out.println("Highlighted (XOButton)");
        //    }
        //});
    }

    public void putBlank(){
        setIcon(null);
        setBackground(Menu.getMenu().getCs().FIELDCELL_BG);
        occupied = false;
    }
}
