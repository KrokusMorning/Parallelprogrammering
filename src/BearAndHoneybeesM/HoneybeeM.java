package BearAndHoneybeesM;

public class HoneybeeM extends Thread{
    HoneyPotM honeyPot;

    public HoneybeeM(HoneyPotM honeyPot) {
        this.honeyPot = honeyPot;
    }

    public void run(){
        while(true){
            try {
                honeyPot.fill();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(honeyPot.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
