package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeeToFile extends Thread{
    TeeAction teeAction;

    public TeeToFile(TeeAction teeAction) {
        this.teeAction = teeAction;
    }

    public void run(){
        //System.out.println("Thread name " + getName());
        try {
            teeAction.fileOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
