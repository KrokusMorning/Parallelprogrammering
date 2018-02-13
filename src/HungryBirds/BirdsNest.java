package HungryBirds;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BirdsNest {
    Semaphore worms;
    Semaphore chirp;
    Semaphore turn;
    int W;

    public BirdsNest(Semaphore sem1, Semaphore sem2, Semaphore sem3, int W) {
        this.worms = sem1;
        this.chirp = sem2;
        this.turn = sem3;
        this.W = W;
    }

    public void feed() throws InterruptedException {
        while(true){
            chirp.acquire();
            worms.release(W);
            System.out.println("\n" + Thread.currentThread().getName() + " flies away an catches " + worms.availablePermits() +
                    " more worms and puts them on the dish.\n");
        }
    }

    public void eat() throws InterruptedException {
        while(true){
            turn.acquire();
            if(worms.availablePermits() == 0){
                System.out.println("\n" + Thread.currentThread().getName() + " chirps for ParentBird to get more worms.");
                chirp.release();}
            worms.acquire();
            System.out.println(Thread.currentThread().getName() + " takes a worm from the dish. There is now " +
                    worms.availablePermits() + " worms left.");
            turn.release();
            Thread.sleep(random());
        }

    }

    private int random(){
        int max = 5000;
        int min = 500;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}