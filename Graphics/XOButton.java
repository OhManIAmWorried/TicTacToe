package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    private static boolean val = false;

    public XOButton(){
        X = new ImageIcon(this.getClass().getResource("X.png"));
        O = new ImageIcon(this.getClass().getResource("O.png"));
        this.addActionListener(this);
    }

    public void setVal(boolean v){
        this.val = v;
    }

    public void actionPerformed(ActionEvent e){
        if (val) putO(); else putX();
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
