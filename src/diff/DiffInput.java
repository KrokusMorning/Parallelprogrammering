package diff;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DiffInput {
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    String filename1 = s.concat("/");
    String filename2 = s.concat("/");

    public DiffInput() {
        try {
            input();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void input() throws InterruptedException {
        System.out.println("Enter filenames in the form: 'filename1 filename2' ");
        Scanner scan = new Scanner(System.in);
        this.filename1 += scan.next();//"DiffT.txt";
        this.filename2 += scan.next();//"DiffT2.txt";
    }


}