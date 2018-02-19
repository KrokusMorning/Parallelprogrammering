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

    synchronized public void reFuel(int amountN, int amountQ) {
        while (places == 0 || nitrogen < amountN || quantumFluid < amountQ){
            System.out.println("\n" + Thread.currentThread().getName() + " awaits conditions.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        places--;
        System.out.println("\n" + Thread.currentThread().getName() + " docks at space station.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nitrogen -= amountN;
        quantumFluid -= amountQ;
        System.out.println("\n" + Thread.currentThread().getName() + " leaves space station with full tanks.");
        places++;

        notifyAll();
    }

    synchronized public void takePlace() throws InterruptedException {
        while (places == 0)
            wait();
        places--;
    }

    synchronized public void leavePlace() throws InterruptedException {
        places++;
        notifyAll();
    }

    synchronized public int refuelN(int amount) throws InterruptedException {

        while (nitrogen < amount)
            wait();
        nitrogen = nitrogen - amount;

        return amount;
    }

    synchronized public int refuelQ(int amount) throws InterruptedException {

        while (quantumFluid < amount)
            wait();
        quantumFluid -= amount;

        return amount;
    }

    synchronized public void deployFuelCargoN(int cargo){
        while (nitrogen > 0){
            System.out.println("\n" + Thread.currentThread().getName() + " awaits N cargo deployment conditions.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nitrogen += cargo;
        System.out.println("\n" + Thread.currentThread().getName() + " N cargo deployed");

        notifyAll();
    }

    synchronized public void deployFuelCargoQ(int cargo){
        while (quantumFluid > 0){
            System.out.println("\n" + Thread.currentThread().getName() + " awaits Q cargo deployment conditions.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quantumFluid += cargo;
        System.out.println("\n" + Thread.currentThread().getName() + " Q cargo deployed.");

        notifyAll();
    }




}
