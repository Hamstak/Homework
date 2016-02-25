import javax.swing.*;

/**
 * Created by moth on 1/13/16.
 */
public class Printer implements Runnable {
    Thread waiter;
    int count;


    public Printer(Thread waiter){
        this.waiter = waiter;
    }

    @Override
    public void run() {
        if (count <= 50){
            if (count == 25){
                waiter.interrupt();
            }
            print();
            incrementCount();
            run();
        }else{
            System.out.println("Printer is done with its work, terminating!");
        }
    }

    public void incrementCount(){
        count++;
    }

    public void print(){
        System.out.println("Message number " + count + ", from the Thread Printer");
    }

}
