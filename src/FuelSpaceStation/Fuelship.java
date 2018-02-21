package FuelSpaceStation;

public class Fuelship extends Thread {
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
            try {
                Thread.sleep((long)(Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fssMonitor.takePlace(-1, -1);
            System.out.println("\n" + Thread.currentThread().getName() + " waits. n:" + nCargoMax + "q:" + qCargoMax);
            fssMonitor.deployFuelCargoN(nCargoMax);
            nCargo = 0;
            fssMonitor.deployFuelCargoQ(qCargoMax);
            qCargo = 0;
            fssMonitor.reFuel(nTankMax, qTankMax);
            qTank = qTankMax;
            nTank = nTankMax;
            try {
                Thread.sleep((long)(Math.random() * 250));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fssMonitor.leavePlace();
            fssMonitor.takePlace(nTankMax, qTankMax);
            fssMonitor.reFuel(nTankMax, qTankMax);
            try {
                Thread.sleep((long)(Math.random() * 250));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fssMonitor.leavePlace();
            nCargo = nCargoMax;
            qCargo = qCargoMax;
            nTank = 0;
            qTank = 0;
        }
        System.out.println("\n" + Thread.currentThread().getName() + " finished.");
    }
}
