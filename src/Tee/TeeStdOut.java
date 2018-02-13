package Tee;

public class TeeStdOut extends Thread{
    TeeAction teeAction;

    public TeeStdOut(TeeAction teeAction) {
        this.teeAction = teeAction;
    }

    public void run(){
        try {
            teeAction.stdOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
