package Logic;

import Graphics.*;

/**
 * Created by Alex on 14.11.2016.
 */
public class human implements Player {
    String name;

    public human(){name="default";}

    public void setName(){  //TODO: Принимать имя из какого-нибудь окна

    }

    public String getName(){
        return name;
    }

    public void toMove(){  //Рвзблокирует поле для человека
        Menu.enableField();
    }

}