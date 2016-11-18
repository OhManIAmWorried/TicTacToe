package Logic;

import Graphics.*;
import Logic.*;

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
        //TODO: этот метод должен быть вызван из Graphics.menu при нажатии на игру, должен вызывать метод меню по смене кнопок
        n = sideN * sideN;  // 3 * 3 = 9 итераций шага
        k = 0;
        player1 = p1;
        player2 = p2;
        switch (sideN){
            case 3: {field = new Field3x3(); break;}
            default: {throw new IllegalArgumentException("Invalid cells number");}
        }
        turn = false; //меняем при первой-же итерации в nextTurn, ходит первый игрок
        nextTurn();
    }

    //TODO: метод для блокировки заполненных ячеек

    public static void nextTurn(){                        //сюда ссылается ячейка поля при нажатии и меню для первого хода
        Menu.disableField();
        if (field.isWin(turn)) endOfGame(true);
        else if (field.isFull()) endOfGame(false);
        else {turn = !turn; toMove();}
    }

    public static void toMove(){                          //сюда ссылается nextTurn
        k = k + 1;                                        //TODO: подозреваю, что счётчик лишний
        if (turn) player1.toMove();
        else player2.toMove();
    }

    public static void setElement(int i, int j){field.setElement(i,j,turn);}

    public static void endOfGame(boolean win){ //TODO: Переделать в месседжи + дать команду в меню убрать поле, вернуть кнопки
        if (win)
            if (turn) System.out.println(player1.getName() + " wins!");
            else System.out.println(player2.getName() + " wins!");
        else
            System.out.println("tie");
    }
}
