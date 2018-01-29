package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tee extends Thread {
    TeeAction teeAction;

    public Tee(TeeAction teeAction) {
        this.teeAction = teeAction;
    }

    public void run(){
        //System.out.println("Thread name " + getName());
        teeAction.input();

    }


}
