package Logic;

import Graphics.*;

import javax.swing.*;

/**
 * Created by Alex on 14.11.2016.
 */
public class Human  extends JFrame implements Player {
    String name;

    public Human(){ name="default"; }

    public void setName(String n){
        name = n;

    }  //TODO: Принимать имя из какого-нибудь окна

    public String getName(){
        return name;
    }

    public void toMove(){  //Рвзблокирует поле для человека
        System.out.println(name + " is here");
        Menu.getMenu().enableField();
    }
}

/*
class wind extends JFrame {
    public wind(){
        JFrame fr1 = new JFrame();
        JPanel p = new JPanel();
        JLabel lbl = new JLabel("Введите Ваше имя:");
        JTextField tf = new JTextField();
        JButton b = new JButton();
        p.add(lbl);
        p.add(tf);
        p.add(b);
        fr1.add(p);
    }
}
*/