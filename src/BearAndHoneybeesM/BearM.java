package BearAndHoneybeesM;

public class BearM extends Thread {
    HoneyPotM honeyPot;

    public BearM(HoneyPotM honeyPot) {
        this.honeyPot = honeyPot;
    }

    public void run(){
        while(true){
            try {
                honeyPot.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
