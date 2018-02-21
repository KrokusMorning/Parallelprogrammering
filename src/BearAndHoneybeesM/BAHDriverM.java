package BearAndHoneybeesM;

import java.util.concurrent.Semaphore;

public class BAHDriverM {
    public static void main(String[] args) {
        int portionsMax = 10;

        int n = 5;
        HoneyPotM honeyPot = new HoneyPotM(portionsMax);

        HoneybeeM honeybees[] = new HoneybeeM[n];

        BearM bear = new BearM(honeyPot);
        bear.setName("The bear");
        bear.start();

        for(int i = 0; i < n; i++){
            honeybees[i] = new HoneybeeM(honeyPot);
            honeybees[i].setName("HoneyBee " + (i+1));
            honeybees[i].start();
        }

    }
}
