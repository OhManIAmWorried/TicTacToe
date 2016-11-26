package Graphics;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.ColorScheme.*;
import Graphics.Panels.FieldPanel;
import Graphics.Panels.MMenuPanel;
import Graphics.Panels.NamePanel;
import Logic.*;

public class Menu extends JFrame{
    private JPanel mainpanel;             //main panel                   //Главная, наерное, панель JFrame
    private JPanel widepanel;             //content panel                //"Широкая" панель бежевого (Default) цвета для красоты
    private JPanel contentpanel;          //buttons panel                //Панель в которую вставленны CardLayout панели с контентом
    private static MMenuPanel mmenupanel; //main menu panel              //Панель с тремя кнопками (Оффлайн, онлайн, чат)
    private static FieldPanel fieldpanel; //gamefield panel              //Панель с игровым полем
    private static NamePanel namepanel;   //pre-offline game panel       //Панель с выбором типа игры и имён игроков для оффлайн режима
    private static CardLayout cl;

    private static int n;               //elements per edge            //Кол-во элементов на сторону
    public static ColorScheme cs;       //color scheme                 //Цветовая схема, доступна из Logic и Graphics, что берут её из Graphics.Menu.cs

    private static Player player1;
    private static Player player2;


    public static void setPlayer1(Player that) {player1 = that;}

    public static void setPlayer2(Player that) {player2 = that;}

    public static void setColorScheme(ColorScheme that){
        cs = that;
    }

    public static String setName(){
        String[] names = {"Mary", "John", "Arty", "A. Hitler", "Neco", "Lady X.", "Superman", "I. Newton", "Tugaryn-Snake", "Casanova Snake", "Avatar"};
        return names[(int) Math.round(Math.random()*10)];
    }

    private static Menu amenu;

    public static void main(String[] args){amenu = new Menu();}

    public void addPanels(){
        mmenupanel = new MMenuPanel();
        fieldpanel = new FieldPanel(n);
        namepanel = new NamePanel();
        cl = new CardLayout();
        contentpanel.setLayout(cl);
        contentpanel.add(mmenupanel,"1");
        contentpanel.add(fieldpanel,"2");
        contentpanel.add(namepanel,"3");
    }

    private void Defaults(){
        n = 3;              //клеток на сторону
        cs = new CS_Milk();   //цветовая схема

        add(mainpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setMinimumSize(new Dimension(700,500));
        setAlwaysOnTop(true);
        setVisible(true);
    }

    Menu(){
        super("Tic Tac Toe v0.0");
        Defaults();
        addPanels();
        clShow("1");
    }

    public void clShow(String name){
        cl.show(contentpanel,name);
    }

    public static Menu getMenu(){return amenu;}

    private void createUIComponents() {}

    public void disableField(){fieldpanel.setOff();}
    public void enableField(){fieldpanel.setOn(); System.out.println("Enabeling (Menu)");}
    public void setCell(int i, int j){fieldpanel.setCell(i,j);}
}

