package Tee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TeeAction {
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private String filename = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Tee/";

    public String text;
    final String FILENAME = "/Users/ocean/Desktop/Concurrent Programming/Homework/src/Tee/TeeText.txt";

    public void input(){
        System.out.println("Enter text to write to file: ");
        lock.lock();
        Scanner scan = new Scanner(System.in);
        this.filename += scan.next();
        this.text = scan.nextLine();
        condition.signalAll();
        lock.unlock();
    }

    public void stdOut() throws InterruptedException {
        lock.lock();
        condition.await();
        System.out.println(this.text);
        lock.unlock();
    }

    public void fileOut() throws InterruptedException {
        BufferedWriter f = null;
        lock.lock();
        condition.await();
        try {
            f = new BufferedWriter(new FileWriter(filename, true));
            f.write(this.text);
            f.close();
            lock.unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
