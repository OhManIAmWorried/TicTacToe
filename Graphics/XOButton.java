package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.*;

import static Logic.toPlay.getTurn;
import static Logic.toPlay.toMove;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    int indexi,indexj;
    boolean enabled;          //false if field is disabled
    boolean occupied;         //true if cell is occupied

    public XOButton(int i,int j){
        indexi = i;
        indexj = j;
        X = new ImageIcon(this.getClass().getResource("x.png"));
        O = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
        this.setBackground(new Color(241,232,198));
        occupied = false;
    }

    public void actionPerformed(ActionEvent e){
        if ((enabled) && !(occupied)) {
            System.out.println("Action performed");
            if (toPlay.getTurn()) putO();
            else putX();
            occupied = true;
            toPlay.setElement(indexi, indexj);
            toPlay.nextTurn();
        }
    }

    public void setDisabled(){enabled = false;}
    public void setEnabled(){enabled = true;}

    public void putX(){
        setIcon(X);
    }

    public void putO(){
        setIcon(O);
    }

    public void putBlank(){
        setIcon(null);
    }
}
