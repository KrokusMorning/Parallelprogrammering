package BearAndHoneybees;

public class Bear extends Thread {
    HoneyPot honeyPot;

    public Bear(HoneyPot honeyPot) {
        this.honeyPot = honeyPot;
    }

    public void run(){
        try {
            honeyPot.eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
