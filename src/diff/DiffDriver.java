package diff;

import java.io.IOException;

public class DiffDriver {
    public static void main(String[] args) throws IOException {
        /*For testing.

        //Sequential
        long ts1 = System.nanoTime();

        DiffInput diffInputSeq = new DiffInput();
        DiffReader diffReaderSeq1 = new DiffReader(diffInputSeq.filename1);
        DiffReader diffReaderSeq2 = new DiffReader(diffInputSeq.filename2);
        diffReaderSeq1.read();
        diffReaderSeq2.read();
        DiffWriter diffWriterSeq = new DiffWriter(diffReaderSeq1.stringArr, diffReaderSeq2.stringArr);

        long ts2 = System.nanoTime();
        long ts3 = ts2 - ts1;*/


        //Parallel
        long tp1 = System.nanoTime();

        DiffInput diffInput = new DiffInput();
        DiffReader diffReader1 = new DiffReader(diffInput.filename1);
        DiffReader diffReader2 = new DiffReader(diffInput.filename2);
        diffReader2.start();
        diffReader1.start();
        try {
            diffReader1.join();
            diffReader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DiffWriter diffWriter = new DiffWriter(diffReader1.stringArr, diffReader2.stringArr);

        long tp2 = System.nanoTime();
        long tp3 = tp2 - tp1;

        System.out.println("Execution time (parallel):   " + tp3 + "ns");

        /*System.out.println("Execution time (sequential):  " + ts3 + "ns");
        System.out.println("Parallel = " + ((float) ts3 / (float) tp3) + " times speed of sequential.");*/
    }
}
