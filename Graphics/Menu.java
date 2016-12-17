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

    private JButton statsbtn;
    private JButton settingsbtn;
    private JLabel tttlabel;

    private static MMenuPanel mmenupanel;        //main menu panel         "1"  //Панель с тремя кнопками (Оффлайн, онлайн, чат)
    private static FieldPanel fieldpanel;        //gamefield panel         "3"  //Панель с игровым полем
    private static NamePanel namepanel;          //pre-offline game panel  "2"  //Панель с выбором типа игры и имён игроков для оффлайн режима
    private static OffResPanel offrespanel;      //post-offline game panel "4"  //Панель результатов для оффлайн игры
    private static StatsPanel statspanel;        //stats panel             "5"  //Панель статистики
    private static SettingsPanel settingspanel;  //settings panel          "6"  //Панель настроек


    private static CardLayout cl;

    private static int n;               //elements per edge            //Кол-во элементов на сторону
    private static int csindex;         //color scheme index           //Индекс цветовой схемы в массиве цветовых схем в настройках (SettingsPanel)
    private static ColorScheme cs;      //color scheme                 //Цветовая схема, доступна из Logic и Graphics, что берут её из Graphics.Menu.cs

    private Player player1;
    private Player player2;

    private static Menu amenu;

    public void setPlayer1(Player that) {this.player1 = that;}

    public void setPlayer2(Player that) {this.player2 = that;}

    public void setColorScheme(ColorScheme that) {cs = that;}
    public static ColorScheme getCs() {return cs;}

    public static String setName(){
        String[] names = {"Mary", "John", "Arty", "A. Hitler", "Neco", "Lady X.", "Superman", "I. Newton", "Tugaryn-Snake", "Casanova Snake", "Avatar"};
        return names[(int) Math.round(Math.random()*10)];
    }

    public static void main(String[] args){amenu = new Menu();}

    public void addPanels(){
        cl = new CardLayout();
        contentpanel.setLayout(cl);
        mmenupanel = new MMenuPanel();
        fieldpanel = new FieldPanel(n);
        namepanel = new NamePanel();
        offrespanel = new OffResPanel();
        statspanel = new StatsPanel();
        settingspanel = new SettingsPanel(csindex);
        contentpanel.add(mmenupanel, "1");
        contentpanel.add(fieldpanel, "2");
        contentpanel.add(namepanel, "3");
        contentpanel.add(offrespanel, "4");
        contentpanel.add(statspanel, "5");
        contentpanel.add(settingspanel, "6");
    }

    private void Defaults(){
        n = 3;                     //клеток на сторону
        cs = new CS_Milk();   //цветовая схема
        csindex = 0;
        add(mainpanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setMinimumSize(new Dimension(700,500));
        setAlwaysOnTop(true);
    }

    Menu(){
        super("Tic Tac Toe v0.1");
        Defaults();
        addPanels();
        updateColors();
        clShow("1");
        setVisible(true);

        statsbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clShow("5");
                statspanel.Upgrade(true);
            }
        });

        settingsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingspanel.setTmpCS(cs);
                clShow("6");
            }
        });
    }

    public void clShow(String name){
        cl.show(contentpanel,name);
    }

    public static Menu getMenu(){return amenu;}

    private void createUIComponents() {}

    public void showWin(Boolean offline, Boolean win, String name){
        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
        if (offline)
            if (win) offrespanel.showWin(name);
            else offrespanel.showTie();
        else {/*TODO: win for online mode*/}
    }

    public void clearField() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                fieldpanel.clearCell(i,j);
    }

    public void doHighlight(int i, int j) {fieldpanel.doMarkCell(i,j);}

    public void disableField() {fieldpanel.setOff();}

    public void enableField() {fieldpanel.setOn(); /*System.out.println("Enabling (Menu)");*/}

    public void setCell(int i, int j) {fieldpanel.setCell(i,j);}

    public void setCSIndex(int index) {csindex = index;}
    public int getCSIndex() {return csindex;}

    public void setCS(ColorScheme that) {cs = that;}

    public void updateColors(){
        mmenupanel.updateColors();
        if (this != null) fieldpanel.updateColors();
        namepanel.updateColors();
        offrespanel.updateColors();
        statspanel.updateColors();

        backpanel.setBackground(cs.BACKPANEL_BG);
        widepanel.setBackground(cs.WIDEPANEL_BG);
        contentpanel.setBackground(cs.CONTPANEL_BG);
        settingsbtn.setBackground(cs.BUTTON_PRIMARY_BG);
        settingsbtn.setForeground(cs.BUTTON_PRIMARY_FG);
        statsbtn.setBackground(cs.BUTTON_PRIMARY_BG);
        statsbtn.setForeground(cs.BUTTON_PRIMARY_FG);
        tttlabel.setForeground(cs.LABEL_FG);
    }
}

