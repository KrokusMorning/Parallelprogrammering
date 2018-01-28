package diff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiffReader extends Thread{
    public final String filepath;
    BufferedReader br = null;
    String linesArray[];

    public DiffReader(String filepath) {
        this.filepath = filepath;
    }

    public void run(){
        BufferedReader buffR = null;
        String str;
        List<String> list = new ArrayList<String>();

        try {
            buffR = new BufferedReader(new FileReader(filepath));
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

        String[] stringArr = list.toArray(new String[0]);
        linesArray = stringArr;

    }
}
