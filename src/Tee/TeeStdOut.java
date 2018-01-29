package Tee;

public class TeeStdOut extends Thread{
    public String text;
    TeeAction teeAction;

    public TeeStdOut(TeeAction teeAction) {
        this.teeAction = teeAction;
       // this.text = text;

    }

    public void run(){
        try {
            teeAction.stdOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Thread name " + getName());

    }
}
