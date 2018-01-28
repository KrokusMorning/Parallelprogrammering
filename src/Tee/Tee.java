package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tee extends Thread {

    //public static String text;
    public String text;

    public Tee() {
        //this.text = text;
    }

    public String getText() {
        return text;
    }

    public void run(){
        System.out.println("Thread name " + getName());
        final String FILENAME = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Tee/TeeText.txt";

        System.out.println("Enter text to write to file: ");
        Scanner scan = new Scanner(System.in);
        this.text = scan.next();

    }


}
