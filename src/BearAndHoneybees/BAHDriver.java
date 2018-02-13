package BearAndHoneybees;

import java.util.concurrent.Semaphore;

public class BAHDriver {
    public static void main(String[] args) {

        int n = 5;
        Semaphore turn = new Semaphore(1, true);
        Semaphore eat = new Semaphore(0);
        HoneyPot honeyPot = new HoneyPot(turn, eat);

        Honeybee honeybees[] = new Honeybee[n];

        Bear bear = new Bear(honeyPot);
        bear.setName("Bear");
        bear.start();

        for(int i = 0; i < n; i++){
            honeybees[i] = new Honeybee(honeyPot);
            honeybees[i].setName("HoneyBee " + (i+1));
            honeybees[i].start();
        }

    }
}
