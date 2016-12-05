package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Graphics.CS.*;
import Graphics.Panels.*;
import Logic.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Menu extends JFrame{
    private JPanel mainpanel;              //main panel                   //Главная, наерное, панель JFrame
    private JPanel widepanel;              //content panel                //"Широкая" панель бежевого (Default) цвета для красоты
    private JPanel contentpanel;           //buttons panel                //Панель в которую вставленны CardLayout панели с контентом
    private JPanel backpanel;              //main background panel        //главная большая панель фона, на ней widepanel
    private StatsPanel statspanel;

    private JButton statsButton;

    private static MMenuPanel mmenupanel;   //main menu panel         "1"  //Панель с тремя кнопками (Оффлайн, онлайн, чат)
    private static FieldPanel fieldpanel;   //gamefield panel         "3"  //Панель с игровым полем
    private static NamePanel namepanel;     //pre-offline game panel  "2"  //Панель с выбором типа игры и имён игроков для оффлайн режима
    private static OffResPanel offrespanel; //post-offline game panel "4"  //Панель результатов для оффлайн игры
    private static CardLayout cl;

    private static int n;               //elements per edge            //Кол-во элементов на сторону
    private static ColorScheme cs;       //color scheme                 //Цветовая схема, доступна из Logic и Graphics, что берут её из Graphics.Menu.cs

    private static Player player1;
    private static Player player2;

    private static Menu amenu;

    public static void setPlayer1(Player that) {player1 = that;}

    public static void setPlayer2(Player that) {player2 = that;}

    public void setColorScheme(ColorScheme that) {cs = that;}
    public static ColorScheme getCs() {return cs;}

    public static String setName(){
        String[] names = {"Mary", "John", "Arty", "A. Hitler", "Neco", "Lady X.", "Superman", "I. Newton", "Tugaryn-Snake", "Casanova Snake", "Avatar"};
        return names[(int) Math.round(Math.random()*10)];
    }

    public static void main(String[] args){amenu = new Menu();}

    public void addPanels(){
        contentpanel.setBackground(cs.CONTPANEL_BG);
        cl = new CardLayout();
        contentpanel.setLayout(cl);

        mmenupanel = new MMenuPanel();
        fieldpanel = new FieldPanel(n);
        namepanel = new NamePanel();
        offrespanel = new OffResPanel();
        statspanel = new StatsPanel();

        contentpanel.add(mmenupanel,"1");
        contentpanel.add(fieldpanel,"2");
        contentpanel.add(namepanel,"3");
        contentpanel.add(offrespanel,"4");
        contentpanel.add(statspanel, "5");
    }

    private void Defaults(){
        n = 3;                     //клеток на сторону
        this.cs = new CS_Milk();   //цветовая схема

        backpanel.setBackground(cs.BACKPANEL_BG);
        widepanel.setBackground(cs.WIDEPANEL_BG);

        add(mainpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setMinimumSize(new Dimension(700,500));
        setAlwaysOnTop(true);
        setVisible(true);
    }

    Menu(){
        super("Tic Tac Toe v0.1");
        Defaults();
        addPanels();
        clShow("1");
        statsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clShow("5");
                statspanel.Upgrade();
            }
        });
    }

    public void clShow(String name){
        cl.show(contentpanel,name);
    }

    public static Menu getMenu(){return amenu;}

    private void createUIComponents() {}

    public static void showWin(Boolean offline, Boolean win, String name){
        Result r = new Result(player1.getName(), player2.getName(), "1:0" , new Date());
        try{
            Statistic s = new Statistic();
            s.addElement(r);
            s.writeStats();
        } catch(Exception e){

        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (offline) {
            if (win) offrespanel.showWin(name);
            else offrespanel.showTie();
        }
        else {
            //TODO: win for online mode
        }
    }


    public void clearField() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                fieldpanel.clearCell(i,j);
    }

    public void doHighlight(int i, int j){fieldpanel.doMarkCell(i,j);}
    public void disableField(){fieldpanel.setOff();}
    public void enableField(){fieldpanel.setOn(); /*System.out.println("Enabling (Menu)");*/}
    public void setCell(int i, int j){fieldpanel.setCell(i,j);}
}

