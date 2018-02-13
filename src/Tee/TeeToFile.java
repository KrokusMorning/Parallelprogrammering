package Tee;

import java.io.IOException;

public class TeeToFile extends Thread{
    TeeAction teeAction;

    public TeeToFile(TeeAction teeAction) {
        this.teeAction = teeAction;
    }

    public void run(){
        try {
            teeAction.fileOut();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
