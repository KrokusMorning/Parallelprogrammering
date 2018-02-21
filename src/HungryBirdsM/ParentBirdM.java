package HungryBirdsM;

public class ParentBirdM extends Thread {
    BirdsNestM nest;

    public ParentBirdM(BirdsNestM nest) {
        this.nest = nest;
    }

    public void run(){
        while(true){
            try {
                nest.feed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
