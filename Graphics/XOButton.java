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

    public XOButton(int i,int j){
        indexi = i;
        indexj = j;
        X = new ImageIcon(this.getClass().getResource("x.png"));
        O = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
        this.setBackground(new Color(241,232,198));
    }

    public void actionPerformed(ActionEvent e){
        if (toPlay.getTurn()) putO(); else putX();
        toPlay.setElement(indexi, indexj);
        toPlay.nextTurn();
    }

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
