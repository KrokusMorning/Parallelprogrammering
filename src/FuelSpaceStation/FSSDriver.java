package FuelSpaceStation;

public class FSSDriver {

    public static void main(String[] args) {
        int N = 5000;
        int Q = 5000;
        int V = 4;

        int trips = 10;
        int NMAX = 10;
        int QMAX = 10;
        int NCMAX = 100;
        int QCMAX = 100;

        FSSMonitor fssMonitor = new FSSMonitor(N, Q, V);

        Spaceship spaceship[] = new Spaceship[12];
        Fuelship fuelship[] = new Fuelship[spaceship.length/4];

        int j = 0;
        for(int i = 0; i < spaceship.length; i++){
            spaceship[i] = new Spaceship(fssMonitor, trips, (int)(Math.random() * 5 + 10), (int)(Math.random() * 5 + 10));
            spaceship[i].setName("Spaceship " + (i+1));
            spaceship[i].start();
            if(i%4 == 0){
                fuelship[j] = new Fuelship(fssMonitor,trips, (int)(Math.random() * 5 + 10), (int)(Math.random() * 5 + 10), (int)(Math.random() * 500 + 1000), (int)(Math.random() * 500 + 1000));
                fuelship[j].setName("Fuelship " + (j+1));
                fuelship[j].start();
                j++;
            }
        }


    }


}
