package Logic;

import Graphics.*;
import Logic.*;

public class toPlay
{
    Field field;          //объект, содержащий в себе логику поля (матрица occupancy, матрица val, isEmpty, isFull, isWin)
    public boolean turn2; //флаг на валидность того что ходит второй игрок (sic.)
    player player1;
    player player2;

    public toPlay(player pl1, player pl2) {
        field = new Field();
        player1 = pl1;
        player2 = pl2;
    }

    public void newGame(){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                field.occupancy[i][j] = false;
    }


    public void toMove(int[] pos){
        if (!turn2)
            player1.toMove(pos);
        else
            player2.toMove(pos);
        turn2 = !turn2;
    }

    public boolean EndOfGame(){ //Переделать в месседжи
        boolean result=false;

        if (field.isWin(turn2)){
            if(turn2)
                System.out.println(player1.getName()+" wins!");
            else
                System.out.println(player2.getName()+" wins!");
            result = true;
        }
        else
        if (field.isFull()){
            System.out.println("No one wins!");
            result = true;
        }

        return result;
    }

}
