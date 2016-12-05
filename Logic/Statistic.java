package Logic;

import java.util.Date;
import java.io.RandomAccessFile;

/**
 * Created by Alex on 02.12.2016.
 */

public class Statistic {
    private static final String dir = "Stat.txt";
    private Result[] StatsArr;
    private int size;

    public Statistic() throws Exception{
        StatsArr = readStats();
    }


    public int getSize(){
        return size;
    }

    public Result[] getStatsArr() { return StatsArr;   }

    public void addElement(Result res){
        if (size==10)
            size=9;

        for (int i = size; i>0; i--)
            StatsArr[i] = StatsArr[i-1];
        StatsArr[0] = res;
        size++;
    }

    public void writeStats() throws Exception{
        RandomAccessFile f = new RandomAccessFile(dir, "rw");
        for (int i = 0; i<size; i++){
            writeResult(f, 51*i, StatsArr[i]);
        }
        f.close();
    }

    private void writeResult(RandomAccessFile file, int pos, Result t) throws Exception {
        file.seek(pos);
        for (int i = t.Name1.length(); i < 20; i++)
            t.Name1 = t.Name1 + " ";

        for (int i = t.Name2.length(); i < 20; i++)
            t.Name2 = t.Name2 + " ";


        file.write(t.Name1.getBytes());
        file.write(t.Name2.getBytes());
        file.write(t.Res.getBytes());
        file.writeLong(t.Time.getTime());
    }


    public Result[] readStats() throws Exception{
        size=0;
        RandomAccessFile f = new RandomAccessFile(dir, "rw");
        Result[] arr = new Result[10];
        for (int i = 0; i<f.length()/51; i++){
            arr[i] = getOne(f, 51*i);
            size++;
        }
        return arr;
    }

    private Result getOne(RandomAccessFile file, int pos) throws Exception {
        file.seek(pos);
        Result t = new Result();
        int b;
        // побитово читаем символы и плюсуем их в строку
        t.Name1 = "";
        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Name1 = t.Name1 + (char) b;
        }
        t.Name1 = t.Name1.trim();

        t.Name2="";
        for (int i = 0; i < 20; i++) {
            b = file.read();
            t.Name2 = t.Name2 + (char) b;
        }
        t.Name2 = t.Name2.trim();

        t.Res="";
        for (int i = 0; i < 3; i++) {
            b = file.read();
            t.Res = t.Res + (char) b;
        }

        t.Time = new Date(file.readLong());

        return t;
    }
}

