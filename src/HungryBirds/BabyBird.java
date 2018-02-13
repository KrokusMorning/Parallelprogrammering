package HungryBirds;

public class BabyBird extends Thread {
    BirdsNest nest;

    public BabyBird(BirdsNest nest) {
        this.nest = nest;
    }

    public void run(){
        try {
            nest.eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
