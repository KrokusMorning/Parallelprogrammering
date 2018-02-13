package BearAndHoneybees;

public class Honeybee extends Thread{
    HoneyPot honeyPot;

    public Honeybee(HoneyPot honeyPot) {
        this.honeyPot = honeyPot;
    }

    public void run(){
        try {
            honeyPot.fill();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
