package HungryBirds;

public class ParentBird extends Thread {
    BirdsNest nest;

    public ParentBird(BirdsNest nest) {
        this.nest = nest;
    }

    public void run(){
        try {
            nest.feed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
