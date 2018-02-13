package BearAndHoneybees;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class HoneyPot {
    Semaphore turn;
    Semaphore eat;
    int portions = 0;

    public HoneyPot(Semaphore turn, Semaphore eat) {
        this.turn = turn;
        this.eat = eat;
    }

    public void fill() throws InterruptedException {
        while(true){
            turn.acquire();
            portions++;
            System.out.println(Thread.currentThread().getName() + " puts a portion of honey in the pot. ");
            if(portions == 10){
                eat.release();
                System.out.println(Thread.currentThread().getName() + " wakes the bear. ");}
            else
                turn.release();
            Thread.sleep(random());
        }

    }

    public void eat() throws InterruptedException {
        while(true){
            eat.acquire();
            System.out.println(Thread.currentThread().getName() + " eats " + portions + " portions and falls asleep.");
            Thread.sleep(random());
            portions = 0;
            turn.release();
        }

    }

    private int random(){
        int max = 5000;
        int min = 500;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
