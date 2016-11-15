package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    private static boolean val = false;

    public XOButton(){
        X = new ImageIcon(this.getClass().getResource("x.png"));
        O = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
        this.setBackground(new Color(241,232,198));
    }

    public void setVal(boolean v){
        this.val = v;
    }

    public void actionPerformed(ActionEvent e){
        if (val) putO(); else putO();
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
