package Tee;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TeeDriver {
    public static void main(String[] args) throws IOException, InterruptedException {

        TeeAction teeAction = new TeeAction();

        Tee tee = new Tee(teeAction);
        TeeStdOut teeStdOut = new TeeStdOut(teeAction);
        TeeToFile teeToFile = new TeeToFile(teeAction);
        teeStdOut.start();
        teeToFile.start();
        tee.start();

        /*String text;
        Tee tee = new Tee();
        tee.start();
        tee.join();
        text = tee.text;
        TeeStdOut teeStdOut = new TeeStdOut(text);
        teeStdOut.start();
        TeeToFile teeToFile = new TeeToFile(text);
        teeToFile.start();
        lock.unlock();*/
    }
}

