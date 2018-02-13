package Tee;

import java.io.IOException;

public class TeeDriver {
    public static void main(String[] args) throws IOException, InterruptedException {

        /*Used for testing.
        //Sequential. I create instances of the thread classes to eliminate the time difference from the overhead.

        TeeAction teeSeq = new TeeAction();
        long ts1 = System.nanoTime();

        TeeActionSeq teeActionSeq = new TeeActionSeq();
        Tee teeS = new Tee(teeSeq);
        TeeStdOut teeStdOutS = new TeeStdOut(teeSeq);
        TeeToFile teeToFileS = new TeeToFile(teeSeq);

        teeActionSeq.input();
        teeActionSeq.stdOut();
        teeActionSeq.fileOut();

        long ts2 = System.nanoTime();
        long ts3 = ts2 - ts1;*/


        //Parallel
        long tp1 = System.nanoTime();

        TeeAction teeAction = new TeeAction();
        Tee tee = new Tee(teeAction);
        TeeStdOut teeStdOut = new TeeStdOut(teeAction);
        TeeToFile teeToFile = new TeeToFile(teeAction);
        tee.start();
        teeStdOut.start();
        teeToFile.start();
        teeStdOut.join();
        teeToFile.join();

        long tp2 = System.nanoTime();
        long tp3 = tp2 - tp1;

        System.out.println("Execution time (parallel):   " + tp3 + "ns");
       /* System.out.println("Execution time (sequential):  " + ts3 + "ns");
        System.out.println("Parallel = " + ((float) ts3 / (float) tp3) + " times speed of sequential.");*/
    }
}

