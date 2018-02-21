package HungryBirdsM;

import java.util.concurrent.Semaphore;

public class HBDriverM {
    public static void main(String[] args) {

        int n = 5;
        int W = 10;

        BirdsNestM nest = new BirdsNestM(W);

        BabyBirdM babyBird[] = new BabyBirdM[n];

        ParentBirdM parentBird = new ParentBirdM(nest);
        parentBird.setName("ParentBirdM");
        parentBird.start();

        for(int i = 0; i < n; i++){
            babyBird[i] = new BabyBirdM(nest);
            babyBird[i].setName("BabyBirdM " + (i+1));
            babyBird[i].start();
        }

    }
}
