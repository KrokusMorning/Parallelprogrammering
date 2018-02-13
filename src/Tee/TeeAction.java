package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TeeAction {
    private String filename;
    private volatile boolean flag = false;
    public String text;

    public void input(){
        System.out.println("Enter text to write to filename in the form: 'filename text' ");
        Scanner scan = new Scanner(System.in);
        this.filename = scan.next();//"TeeTest.txt";//
        this.text = scan.nextLine();//"Hello World!";
        flag = true;
    }

    public void stdOut() throws InterruptedException {
        while(!flag)continue;
        System.out.println(this.text);
    }

    public void fileOut() throws IOException, InterruptedException {
        BufferedWriter f = null;
        while(!flag)continue;
        f = new BufferedWriter(new FileWriter(filename, true));
        f.write(this.text);
        f.close();
    }


}