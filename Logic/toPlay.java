package Logic;

import Graphics.*;
import Logic.*;

import javax.swing.*;
import java.util.Date;

public class toPlay
{
    private static boolean turn;  //флаг на валидность того что ходит первый игрок

    public static boolean getTurn(){return turn;}

    private static Field field;    //объект, содержащий в себе логику поля (матрица occupancy, матрица val, isEmpty, isFull, isWin)
    private static Player player1;
    private static Player player2;
    private static int n;  //кол-во шагов возможных в игре, в конструктор передаётся размерность стороны: 3,5,7
    private static int k;  //текущее кол-во итераций игры

    public toPlay(Player p1, Player p2, int sideN){
        Menu.getMenu().clShow("2");
        n = sideN * sideN;  // 3 * 3 = 9 итераций шага
        k = 0;
        player1 = p1;
        player2 = p2;
        switch (sideN){
            case 3: {
                field = new Field3x3();
                Menu.getMenu().clearField();
                break;
            }
            default: {throw new IllegalArgumentException("Invalid cells number");}
        }
        turn = false; //меняем при первой-же итерации в nextTurn, ходит первый игрок
        nextTurn();
    }

    public static void nextTurn(){                        //сюда ссылается ячейка поля при нажатии и меню для первого хода
        Menu.getMenu().disableField();
        if (field.isWin(turn)) endOfGame(true);
        else if (field.isFull()) endOfGame(false);
        else {
            turn = !turn;
            toMove();
        }
    }

    public static void toMove(){                          //сюда ссылается nextTurn
        k = k + 1;                                        //TODO: подозреваю, что счётчик лишний
        if (turn) player1.toMove();
        else player2.toMove();
    }

    public static void setElement(int i, int j){field.setElement(i,j,turn);}
    public static Date first;
    public static Date second;
    public static void setFirstDate(){
        first = new Date();
    }
    public static void setSecondDate(){
        second = new Date();
    }

    public static void endOfGame(boolean win){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu.getMenu().clShow("4");
                toPlay.setSecondDate();
                Result r = new Result(player1.getName(), player2.getName(), "0:0" , second.getTime() - first.getTime());

                if (win) {
                    if (turn) {
                        Menu.getMenu().showWin(true, true, player1.getName());
                        r = new Result(player1.getName(), player2.getName(), "1:0" , second.getTime() - first.getTime());
                    }
                    else {
                        Menu.getMenu().showWin(true, true, player2.getName());
                        r = new Result(player1.getName(), player2.getName(), "0:1" , second.getTime() - first.getTime());
                    }
                } else {
                    Menu.getMenu().showWin(true, false, "");
                }

                try{
                    Statistic s = new Statistic();
                    s.addElement(r);
                    s.writeStats();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
