package Tee;

public class Tee extends Thread {
    TeeAction teeAction;

    public Tee(TeeAction teeAction) {
        this.teeAction = teeAction;
    }

    public void run(){
        teeAction.input();
    }


}
