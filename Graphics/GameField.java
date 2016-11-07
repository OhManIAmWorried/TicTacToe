package Graphics;

import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame{

    private JPanel mainpanel = new JPanel();                         //Игровая панель на которую установленны кнопки
    private XOButton button[][] = new XOButton[3][3];                //матрица кнопок

    public static void main(String[] args){
        new GameField();                                             //создаём окно
    }

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
        add(mainpanel);                                              //добавляем рабочую поверхность на окно
        setVisible(true);                                            //режим видимости окна
    }
}
