package FuelSpaceStation;

public class Fuelship extends Thread{
    FSSMonitor fssMonitor;
    int nTankMax;
    int qTankMax;
    int nCargoMax;
    int qCargoMax;
    int nTank;
    int qTank;
    int nCargo;
    int qCargo;
    int trips;

    public Fuelship(FSSMonitor fssMonitor, int trips, int nTankMax, int qTankMax, int nCargoMax, int qCargoMax) {
        this.fssMonitor = fssMonitor;
        this.nTankMax = nTankMax;
        this.qTankMax = qTankMax;
        this.nCargoMax = nCargoMax;
        this.qCargoMax = qCargoMax;
        this.trips = trips;
    }

    public void run() {
        for (int i = 0; i < trips; i++){
            fssMonitor.deployFuelCargoN(nCargoMax);
            nCargo = 0;
            fssMonitor.deployFuelCargoQ(qCargoMax);
            qCargo = 0;
            fssMonitor.reFuel(nTankMax, qTankMax);
            qTank = qTankMax;
            nTank = nTankMax;
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nCargo = nCargoMax;
            qCargo = qCargoMax;
            nTank = 0;
            qTank = 0;
        }
        System.out.println("\n" + Thread.currentThread().getName() + " finished.");
    }
}
