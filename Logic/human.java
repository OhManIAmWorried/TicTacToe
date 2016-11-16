package Logic;

/**
 * Created by Alex on 14.11.2016.
 */
public class human implements player {
    String name;
    boolean ind; //по хорошему, избавиться бы от нее, а использовать тоже из глобального пл паблик инд. Думаю, мб сделать метод, который будет копировать пл из меню. Я хз

    public human(boolean b){
        name="";
        ind = b;
    }

    public void setName(){  //Принимать имя из какого-нибудь окна

    }

    public String getName(){
        return name;
    }

    public void toMove(int[] poss){  //

        Field.setElement(poss[0], poss[1], ind);
    }

}