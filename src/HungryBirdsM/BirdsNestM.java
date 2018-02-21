package HungryBirdsM;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BirdsNestM {
    int W;
    int worms;

    public BirdsNestM(int W) {
        this.W = W;
        worms = 0;
    }

    public synchronized void feed() throws InterruptedException {
        while(worms > 0){
            wait();
        }
        Thread.sleep(random());
        worms = W;
        System.out.println("\n" + Thread.currentThread().getName() + " flies away an catches " + worms +
                " more worms and puts them on the dish.\n");
        notifyAll();
    }

    public synchronized void eat() throws InterruptedException {
        while(worms <= 0){
            System.out.println("\n" + Thread.currentThread().getName() + " waits ");
            wait();
        }

        worms--;
        if(worms == 0)
            System.out.println("\n" + Thread.currentThread().getName() + " takes the last worm and chirps for ParentBird to get more worms.");
        else
        System.out.println(Thread.currentThread().getName() + " takes a worm from the dish. There is now " +
                worms + " worms left.");
        notifyAll();


    }

    public int random(){
        int max = 5000;
        int min = 500;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}