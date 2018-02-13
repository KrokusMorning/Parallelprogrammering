package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


//Modified version used to test speed of sequential algorithm.
public class TeeActionSeq {
    private String filename;
    public String text;

    public void input(){
        //System.out.println("Enter text to write to filename in the form: 'filename text' ");
        //Scanner scan = new Scanner(System.in);
        this.filename = "TeeTest.txt"; //scan.next();
        this.text = "Hej Värld!"; //scan.nextLine();
    }

    public void stdOut() throws InterruptedException {
        System.out.println(this.text);
    }

    public void fileOut() throws IOException {
        BufferedWriter f = null;
        f = new BufferedWriter(new FileWriter(filename, true));
        f.write(this.text);
        f.close();
    }


}