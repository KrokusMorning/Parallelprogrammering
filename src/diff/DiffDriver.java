package diff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DiffDriver {
    public static void main(String[] args) throws IOException {
        String array1[];
        String array2[];


        DiffReader diffReader1 = new DiffReader("/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/DiffText1.txt");
        DiffReader diffReader2 = new DiffReader("/Users/ocean/Desktop/Concurrent Programming/Homework/src/Diff/DiffText2.txt");
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
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = 0;
        int diff = 0;

        if (array2.length>array1.length) {
            length = array1.length;
            diff = array2.length - length;
        }
        else{
            length = array2.length;
            diff = array1.length - length;
        }

        for (int i = 0; i < length; i++) {
            if (!array1[i].equals(array2[i])){
                sb1.append(array1[i]);
                sb2.append(array2[i]);
                sb1.append(System.lineSeparator());
                sb2.append(System.lineSeparator());
            }
        }

        if(array1.length != length){
            for(int i = length; i < length + diff; i++){
                sb1.append(array1[i]);
                sb1.append(System.lineSeparator());
            }
        }
        else{
            for(int i = length; i < length + diff; i++){
                sb2.append(array2[i]);
                sb2.append(System.lineSeparator());
            }
        }




        /*StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        BufferedReader br1 =diffReader1.br;
        String line1 = br1.readLine();
        BufferedReader br2 =diffReader2.br;
        String line2 = br2.readLine();


        while (line1 != null && line2 != null) {
            if (!line1.equals(line2)){
                sb1.append(line1);
                sb2.append(line2);
                sb1.append(System.lineSeparator());
                sb2.append(System.lineSeparator());
            }
            line2 = br2.readLine();
            line1 = br1.readLine();
            if(line1 == null || line2 == null){
                while (line1 != null) {
                    sb1.append(line1);
                    sb1.append(System.lineSeparator());
                    line1 = br1.readLine();
                }
                while (line2 != null) {
                    sb2.append(line2);
                    sb2.append(System.lineSeparator());
                    line2 = br2.readLine();
                }
            }
        }*/
        String everything1 = sb1.toString();
        System.out.println(everything1);
        String everything2 = sb2.toString();
        System.out.println(everything2);

    }



}
