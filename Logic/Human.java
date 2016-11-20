package Logic;

import Graphics.*;

/**
 * Created by Alex on 14.11.2016.
 */
public class Human implements Player {
    String name;

    public Human(){ name="default"; }

    public void setName(){}  //TODO: Принимать имя из какого-нибудь окна

    public String getName(){
        return name;
    }

    public void toMove(){  //Рвзблокирует поле для человека
        System.out.println(name + " is here");
        Menu.enableField();
    }

}