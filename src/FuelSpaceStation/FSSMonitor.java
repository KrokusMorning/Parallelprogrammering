package FuelSpaceStation;

public class FSSMonitor {
    private int nitrogen;
    private int quantumFluid;
    private int places;
    private int nitrogenMax;
    private int quantumFluidMax;


    public FSSMonitor(int nitrogenMax, int quantumFluidMax, int places) {
        this.places = places;
        this.nitrogenMax = nitrogenMax;
        this.quantumFluidMax = quantumFluidMax;
    }

    public synchronized void reFuel(int amountN, int amountQ) {
        while (nitrogen < amountN || quantumFluid < amountQ){
            System.out.println("\n" + Thread.currentThread().getName() + " got place not fuel");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nitrogen -= amountN;
        quantumFluid -= amountQ;
        notifyAll();
    }

    public synchronized void takePlace(int amountN, int amountQ) {
        while (places == 0 || nitrogen < amountN || quantumFluid < amountQ){
            System.out.println("\n" + Thread.currentThread().getName() + " waits. n:" + nitrogen + "q:" + quantumFluid + "places:" + places);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n" + Thread.currentThread().getName() + " docks.");
        places--;
        notifyAll();
        System.out.println("\n" + places + " places taken.");
    }

    public synchronized void leavePlace() {
        System.out.println("\n" + Thread.currentThread().getName() + " leaves.");
        places++;
        System.out.println("\n" + places + " places taken.");
        notifyAll();
    }

    public synchronized void deployFuelCargoN(int cargo){
        System.out.println("\n" + Thread.currentThread().getName() + nitrogen + " N");
        while (nitrogen+cargo <= nitrogenMax){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        nitrogen += cargo;
        System.out.println("\n" + Thread.currentThread().getName() + " N cargo deployed");

        notifyAll();
    }

    public synchronized void deployFuelCargoQ(int cargo){
        while (cargo+quantumFluid <= quantumFluidMax ){
            System.out.println("\n" + Thread.currentThread().getName() + " awaits Q cargo deployment conditions.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        quantumFluid += cargo;
        System.out.println("\n" + Thread.currentThread().getName() + " Q cargo deployed.");

        notifyAll();
    }




}
