package BearAndHoneybeesM;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class HoneyPotM {
    int portions = 0;
    int portionsMax;

    public HoneyPotM(int portionsMax) {
        this.portionsMax = portionsMax;
    }

    synchronized public void fill() throws InterruptedException {
        while(portions == portionsMax){
            wait();
        }
        portions++;
        System.out.println(Thread.currentThread().getName() + " puts a " + portions + "th portion of honey in the pot. ");

        if(portions == portionsMax)
            System.out.println("!!! " + Thread.currentThread().getName() + " wakes the bear !!!");

        notifyAll();
    }

    synchronized public void eat() throws InterruptedException {
        while(portions < portionsMax){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " eats " + portions + " portions of honey and falls asleep.\n");
        portions = 0;
        notifyAll();
    }

    public int random(){
        int max = 5000;
        int min = 500;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
