package Graphics;

import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame{

    private JPanel mainpanel = new JPanel();                         //Игровая панель на которую установленны кнопки
    private JPanel menupanel = new JPanel();
    private XOButton button[][] = new XOButton[3][3];                //матрица кнопок
/*
    public static void main(String[] args){
        new GameField();                                             //создаём окно
    }
*/
    public GameField(){
        super("TicTacToe v 0.0");                                    //называем окно
        setSize(400,400);                                            //устанавливаем размер окна (ширина x высота)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     //устанавливаем операции по выходу //TODO: Всплывающее сообщение "Вы уверенны?"
        mainpanel.setLayout(new GridLayout(3,3));                    //устанавливаем разметку сеткой на рабочую поверхность

        for (int i = 0; i < 3; i++)                                  //добавляем кнопки на рабочую поверхность
            for (int j = 0; j < 3; j++) {
                button[i][j] = new XOButton();                       //TODO: Выбор своих и чужих символов для отображения
                mainpanel.add(button[i][j]);
            }

        setAlwaysOnTop(true);                                        //режим поверх всех окон
        setResizable(false);                                         //режим статического размера

        JButton b1 = new JButton("P v P");
        JButton b2 = new JButton("P v C");
        JButton b3 = new JButton("C v C");
        JButton b4 = new JButton("Settings");
        JButton b5 = new JButton("Stats");
        menupanel.add(b1,BorderLayout.NORTH);
        menupanel.add(b2,BorderLayout.NORTH);
        menupanel.add(b3,BorderLayout.NORTH);
        menupanel.add(b4,BorderLayout.NORTH);
        menupanel.add(b5,BorderLayout.NORTH);
        add(menupanel,BorderLayout.NORTH);

        setAlwaysOnTop(true);                                        //режим поверх всех окон      
        setResizable(false);                                         //режим статического размера
        add(mainpanel,BorderLayout.CENTER);                                            //добавляем рабочую поверхность на окно
        setVisible(true);                                            //режим видимости окна
    }
}
