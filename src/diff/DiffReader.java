package diff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiffReader extends Thread{
    public final String filename;
    String stringArr[];

    public DiffReader(String filename) {

        this.filename = filename;
    }

    public void run(){
        read();
    }

    public void read(){
        BufferedReader buffR = null;
        String str;
        List<String> list = new ArrayList<String>();
        try {
            buffR = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while((str = buffR.readLine()) != null){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.stringArr = list.toArray(new String[0]);

    }
}
