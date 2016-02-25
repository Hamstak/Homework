/**
 * Created by moth on 1/13/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread waiter = new Thread(new Waiter());
        Thread printer = new Thread(new Printer(waiter));

        waiter.start();
        printer.start();

        waiter.join();
        printer.join();

        System.out.println("Both Waiter and Printer have finished and terminated");
    }
}
