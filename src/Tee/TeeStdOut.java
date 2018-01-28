package Tee;

public class TeeStdOut extends Thread{
    public String text;

    public TeeStdOut(String text) {
        this.text = text;
    }

    public void run(){
        System.out.println("Thread name " + getName());
        System.out.println(this.text);
    }
}
