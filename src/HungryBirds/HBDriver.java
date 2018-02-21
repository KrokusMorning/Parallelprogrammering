package HungryBirds;

import java.util.concurrent.Semaphore;

public class HBDriver {
    public static void main(String[] args) {

        int n = 5;
        int W = 10;
        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(1);
        Semaphore sem3 = new Semaphore(1);
        BirdsNest nest = new BirdsNest(sem1, sem2, sem3, W);

        BabyBird babyBird[] = new BabyBird[n];

        ParentBird parentBird = new ParentBird(nest);
        parentBird.setName("ParentBirdM");
        parentBird.start();

        for(int i = 0; i < n; i++){
            babyBird[i] = new BabyBird(nest);
            babyBird[i].setName("BabyBirdM " + (i+1));
            babyBird[i].start();
        }

    }
}
