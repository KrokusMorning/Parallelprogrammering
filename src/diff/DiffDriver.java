package diff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiffDriver {
    public static void main(String[] args) throws IOException {
        long tp1 = System.nanoTime();
        String array1[];
        String array2[];
        DiffReader diffReader1 = new DiffReader("/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/pg30.txt");
        DiffReader diffReader2 = new DiffReader("/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/pg302.txt");
        diffReader1.start();
        diffReader2.start();
        try {
            diffReader1.join();
            diffReader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        array1 = diffReader1.linesArray;
        array2 = diffReader2.linesArray;
        int array1length = array1.length;
        int array2length = array2.length;
        int length = 0;
        int diff = 0;
        if (array2length > array1length) {
            length = array1length;
            diff = array2length - length;
        } else {
            length = array2length;
            diff = array1length - length;
        }
        DiffWriter diffWriter1 = new DiffWriter(array1, array2, 0, length);
        diffWriter1.start();


        long tp2 = System.nanoTime();
        long tp3 = tp2 - tp1;

        long ts1 = System.nanoTime();
        String filepath1 = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/pg30.txt";
        String filepath2 = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/pg302.txt";

        StringBuilder sb1s = new StringBuilder();
        StringBuilder sb2s = new StringBuilder();

        BufferedReader buffR1s = null;
        String str1s;
        List<String> lists1 = new ArrayList<String>();

        try {
            buffR1s = new BufferedReader(new FileReader(filepath1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((str1s = buffR1s.readLine()) != null) {
                lists1.add(str1s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] stringArr1 = lists1.toArray(new String[0]);

        BufferedReader buffR2s = null;
        String str2s;
        List<String> lists2 = new ArrayList<String>();

        try {
            buffR2s = new BufferedReader(new FileReader(filepath2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((str2s = buffR2s.readLine()) != null) {
                lists2.add(str2s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] stringArr2 = lists2.toArray(new String[0]);


        int lengths = 0;
        int diffs = 0;
        int array1lengths = stringArr1.length;
        int array2lengths = stringArr2.length;

        if (array2lengths > array1lengths) {
            lengths = array1lengths;
            diffs = array2lengths - lengths;
        } else {
            lengths = array2lengths;
            diffs = array1lengths - lengths;
        }

        for (int i = 0; i < lengths; i++) {
            if (!stringArr1[i].equals(stringArr2[i])) {
                sb1s.append(stringArr1[i]);
                sb2s.append(stringArr2[i]);
                sb1s.append(System.lineSeparator());
                sb2s.append(System.lineSeparator());
            }
        }

        if (array1lengths != lengths) {
            for (int i = lengths; i < lengths + diffs; i++) {
                sb1s.append(stringArr1[i]);
                sb1s.append(System.lineSeparator());
            }
        } else {
            for (int i = lengths; i < lengths + diffs; i++) {
                sb2s.append(stringArr2[i]);
                sb2s.append(System.lineSeparator());
            }
        }

        long ts2 = System.nanoTime();
        long ts3 = ts2 - ts1;
        System.out.println("Execution time (parallel):   " + tp3);
        System.out.println("Execution time (sequntial):  " + ts3);
        System.out.println("Percent faster : " + ((float) ts3 / (float) tp3) + " times faster.");

        String everything1 = sb1s.toString();
        System.out.println(everything1);
        String everything2 = sb2s.toString();
        System.out.println(everything2);


    }
}
