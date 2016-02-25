/**
 * Created by moth on 1/6/16.
 */
public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Hello from" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloRunnable());
        Thread t2 = new Thread(new HelloRunnable());

        t1.start();
        t2.start();
    }
}
