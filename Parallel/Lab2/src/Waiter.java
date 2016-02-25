/**
 * Created by moth on 1/13/16.
 */
public class Waiter implements Runnable{

    public Waiter(){
    }

    @Override
    public void run() {
        try{
            Thread.sleep(Long.MAX_VALUE);
        }catch (InterruptedException e){
            System.out.println("Printer is halfway done!");
        }
        System.out.println("Waiter is done with its work, terminating");
    }
}
