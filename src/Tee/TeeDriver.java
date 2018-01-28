package Tee;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeeDriver {
    public static void main(String[] args) throws IOException, InterruptedException {
        String text;
        Tee tee = new Tee();
        tee.start();
        tee.join();
        text = tee.text;
        TeeStdOut teeStdOut = new TeeStdOut(text);
        teeStdOut.start();

        TeeToFile teeToFile = new TeeToFile(text);
        teeToFile.start();
    }
}

