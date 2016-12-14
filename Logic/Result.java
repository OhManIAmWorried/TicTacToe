package Logic;

import java.util.Date;

/**
 * Created by Alex on 02.12.2016.
 */
public class Result {

  public String Name1;
  public String Name2;
  public String Res;
  public Date Time;

    public Result() {
        Name1 = "";
        Name2 = "";
        Res = "";
        Time = new Date();
    }

    public Result(String name1, String name2, String res, Date time) {
        Name1 = name1;
        Name2 = name2;
        Res = res;
        Time = time;
    }
}