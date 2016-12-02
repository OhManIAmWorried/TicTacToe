package Logic;

import java.util.Date;
import java.io.RandomAccessFile;

/**
 * Created by Alex on 02.12.2016.
 */

public class Statistic {
    private static final String dir = "Stat.txt";
    Result[] StatsArr;
    int size;

    public Statistic() throws Exception{
        size = 0;
        StatsArr = readStats();
    }

    private void writeStats() throws Exception{
        RandomAccessFile f = new RandomAccessFile(dir, "rw");
        for (int i = 0; i<size; i++){
            writeResult(f, 91*i, StatsArr[i]);
        }
        f.close();
    }

    private void writeResult(RandomAccessFile file, int pos, Result t) throws Exception {
        file.seek(pos);
        for (int i = t.Name1.length(); i < 21; i++)
            t.Name1 = t.Name1 + " ";

        for (int i = t.Name2.length(); i < 21; i++)
            t.Name2 = t.Name2 + " ";

        for (int i = t.Type1.length(); i < 21; i++)
            t.Type1 = t.Type1 + " ";

        for (int i = t.Type2.length(); i < 21; i++)
            t.Type2 = t.Type2 + " ";

        file.write(t.Name1.getBytes());
        file.write(t.Type1.getBytes());
        file.write(t.Name2.getBytes());
        file.write(t.Type2.getBytes());
        file.write(t.Res.getBytes());
        file.writeLong(t.Time.getTime());
    }

    private void addElement(Result res){
        if (size==10)
            size=9;

        for (int i = size; i>0; i--)
            StatsArr[i] = StatsArr[i-1];
        StatsArr[0] = res;
        size++;
    }

    public Result[] readStats() throws Exception{
        RandomAccessFile f = new RandomAccessFile(dir, "rw");
        Result[] arr = new Result[10];
        for (int i = 0; i<f.length()/91; i++){
            arr[i] = getOne(f, 91*i);
            size++;
        }
        return arr;
    }

    public Result getOne(RandomAccessFile file, int pos) throws Exception {
        file.seek(pos);
        Result t = new Result();
        int b;
        // побитово читаем символы и плюсуем их в строку

        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Name1 = t.Name1 + (char) b;
        }

        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Type1 = t.Type1 + (char) b;
        }

        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Name2 = t.Name2 + (char) b;
        }

        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Type2 = t.Type2 + (char) b;
        }

        for (int i = 0; i < 4; i++) {
            b = file.read();
            t.Res = t.Res + (char) b;
        }

        t.Time = new Date(file.readLong());

        return t;
    }
}

class Result{
    String Name1;
    String Type1;
    String Name2;
    String Type2;
    String Res;
    Date Time;

    public Result() {
        Name1 = "Vasya";
        Type1 = "Hum";
        Name2 = "Siri";
        Type2 = "iLady";
        Res = "1:0";
        Time = new Date();
    }

    public Result(String name1, String type1, String name2, String type2, String res, Date time) {
        Name1 = name1;
        Type1 = type1;
        Name2 = name2;
        Type2 = type2;
        Res = res;
        Time = time;
    }
}