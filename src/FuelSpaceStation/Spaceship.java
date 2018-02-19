package FuelSpaceStation;

public class Spaceship extends Thread{
    FSSMonitor fssMonitor;
    int nTankMax;
    int qTankMax;
    int nTank;
    int qTank;
    int trips;

    public Spaceship(FSSMonitor fssMonitor, int trips, int nTankMax, int qTankMax) {
        this.fssMonitor = fssMonitor;
        this.nTankMax = nTankMax;
        this.qTankMax = qTankMax;
        this.trips = trips;
    }

    public void run(){
        for (int i = 0; i < trips; i++){
            fssMonitor.reFuel(nTankMax, qTankMax);
            qTank = qTankMax;
            nTank = nTankMax;
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nTank = 0;
            qTank = 0;
        }
        System.out.println("\n" + Thread.currentThread().getName() + " finished.");
    }
}
