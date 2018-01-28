package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeeToFile extends Thread{
    final String FILENAME = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Tee/TeeText.txt";
    public String text;

    public TeeToFile(String text) {
        this.text = text;
    }

    public void run(){
        System.out.println("Thread name " + getName());

        BufferedWriter f = null;
        try {
            f = new BufferedWriter(new FileWriter(FILENAME, true));
            f.write(this.text);
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
