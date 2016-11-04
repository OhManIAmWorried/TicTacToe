package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    byte val = 0;
    /*
    0: nothing
    1: x
    2: o
    */

    public XOButton(){
        X = new ImageIcon(this.getClass().getResource("X.png"));
        O = new ImageIcon(this.getClass().getResource("O.png"));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        val++;
        val%=3;
        switch(val){
            case 0: { setIcon(null); break;}
            case 1: { setIcon(X); break;}
            case 2: { setIcon(O); break;}
        }
    }
}
