import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by moth on 1/19/16.
 */
public class Main {
    ConcurrentLinkedQueue<Thread> threads;
    int messageCount = 0;
    Object lock;

    public static void main(String[] args) {
        if(args.length == 1) {
            Main main = new Main(Integer.parseInt(args[0]));
        }else {
            System.out.println("Usage: Java Main 3");
        }
    }

    public Main(int i){
        threads = new ConcurrentLinkedQueue<>();
        lock = new Object();
        this.addThreads(i);
        ConcurrentLinkedQueue<Thread> copy = new ConcurrentLinkedQueue<>();
        copyQueue(copy, threads);
        startThreads(copy);
        joinThreads(copy);
    }

    private void addThreads(int n){
        for(int i = 0; i < n; i++) {
            threads.add(new Thread(new MessageWriter(i+1)));
        }
    }

    private static void copyQueue(ConcurrentLinkedQueue<Thread> dest, ConcurrentLinkedQueue<Thread> source){
        for (Thread t: source){
            dest.add(t);
        }
    }

    private static void startThreads(Iterable<Thread> threads){
        for(Thread t: threads){
            t.start();
        }
    }

    private void joinThreads(Iterable<Thread> threads){
        for (Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        }
    }

    private class MessageWriter implements Runnable{
        private int id;

        public MessageWriter(int id){
            this.id = id;
        }

        @Override
        public void run() {
            while(messageCount < 10) {
                synchronized (lock) {
                    if (threads.peek() == Thread.currentThread() && messageCount < 50) {
                        messageCount++;
                        switch(messageCount){
                            case 1:
                                System.out.println(messageCount + "st Message " + " from thread: " + id);
                                break;
                            case 2:
                                System.out.println(messageCount + "nd Message " + " from thread: " + id);
                                break;
                            case 3:
                                System.out.println(messageCount + "rd Message " + " from thread: " + id);
                                break;3
                            default:
                                System.out.println(messageCount + "th Message " + " from thread: " + id);
                        }

                        threads.add(threads.poll());
                        lock.notifyAll();
                        if( messageCount < 10)
                            try {lock.wait();} catch (InterruptedException e) {}
                    }else if (messageCount <10){
                        lock.notify();
                        try {lock.wait();} catch (InterruptedException e) {}
                    }else{
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
