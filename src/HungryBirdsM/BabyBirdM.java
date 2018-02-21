package HungryBirdsM;

public class BabyBirdM extends Thread {
    BirdsNestM nest;

    public BabyBirdM(BirdsNestM nest) {
        this.nest = nest;
    }

    public void run(){
        while(true){
            try {
                nest.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(nest.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
