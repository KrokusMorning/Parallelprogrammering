package Tee;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeeDriver {
    public static void main(String[] args) throws IOException {
        final String FILENAME = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Tee/TeeText.txt";

        System.out.println("Enter text to write to file: ");
        Scanner scan = new Scanner(System.in);
        String content = scan.next();

        BufferedWriter f = null;
        f = new BufferedWriter(new FileWriter(FILENAME, true));
        f.write(content);
        f.close();

        System.out.println(content);

    }
}

