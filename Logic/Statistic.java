package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Alex on 02.12.2016.
 */

public class Statistic {
    private static final String dir = "Stat.txt";
    private Result[] StatsArr;
    private int size;

    public Statistic(){
        StatsArr = readStats();
    }


    public int getSize(){
        return size;
    }

    public void addElement(Result res){
        if (size==10)
            size=9;

        for (int i = size; i>0; i--)
            StatsArr[i] = StatsArr[i-1];
        StatsArr[0] = res;
        size++;
    }

    public void writeStats() {
        try {
            RandomAccessFile f = new RandomAccessFile(dir, "rw");
            for (int i = 0; i<size; i++){
                writeResult(f, 51*i, StatsArr[i]);
            }
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        file.writeLong(t.Time);
    }


    public Result[]  readStats(){
        size=0;
        Result[] arr = new Result[10];
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(dir, "rw");
            for (int i = 0; i<f.length()/51; i++){
                arr[i] = getOne(dir, 51*i);
                size++;
            }
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public void clear(){
            try {
                File f = new File(dir);
                f.delete();
            } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Result getOne(String dir, int pos) {
        Result t = new Result();
        try {
            RandomAccessFile file = new RandomAccessFile(dir,"rw");
            file.seek(pos);
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

            t.Time = file.readLong();

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}

