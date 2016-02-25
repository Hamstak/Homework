/**
 * Created by moth on 2/19/16.
 */
public class ThreadPool implements Runnable{
    static final int THREADPOOL_SIZE = 5;
    static final int WORKER_SLEEP_TIME = 10000;
    private int capacity = 50;
    private int actualNumberThreads = THREADPOOL_SIZE * 4;
    private WorkerThread workers[] = new WorkerThread[actualNumberThreads];
    private Threshold stop = new Threshold();
    private JobQueue jobQueue = new JobQueue(capacity);

    int waitCheck;
    int threshold[];
    private Threshold firstThreshold = new Threshold();
    private Threshold secondThreshold = new Threshold();

    public ThreadPool(int sec, int t1, int t2){
        threshold = new int[2];
        threshold[0] = t1;
        threshold[1] = t2;
    }

    public void startPool(){
        System.out.println("Starting Pool");
        for(int i = 0; i < workers.length; i++){
            if(i <= threshold[0])
                workers[i] = new WorkerThread(jobQueue, new Threshold(true), stop);
            else if ( i > threshold[0] && i <= threshold[1] )
                workers[i] = new WorkerThread(jobQueue, firstThreshold, stop);
            else
                workers[i] = new WorkerThread(jobQueue, secondThreshold, stop);
        }
        for(int i = 0; i < workers.length; i++){
            workers[i].start();
        }
    }

    public synchronized boolean add(Runnable job){
        return jobQueue.enqueue(job);
    }

    private synchronized void increasePool(){
        System.out.println("Increasing pool");
        if (secondThreshold.isThreshold()){
            System.err.println("You goofed increasing the pool");
        }
        if(!firstThreshold.isThreshold()) {
            firstThreshold.setThreshold(true);
            System.out.println("Increased to 10");
            synchronized (jobQueue) {
                jobQueue.notifyAll();
            }
        } else{
            secondThreshold.setThreshold(true);
            synchronized (jobQueue){
                System.out.println("Increased to 20");
                jobQueue.notifyAll();
            }
        }

    }

    private synchronized void decreasePool(){
        System.out.println("Decreasing pool");
        if (!firstThreshold.isThreshold()){
            System.err.println("You goofed decreasing the pool");
        }
        if(secondThreshold.isThreshold()) {
            System.out.println("Decreased to 10");
            secondThreshold.setThreshold(false);
            synchronized (jobQueue){
                jobQueue.notifyAll();
            }
        } else {
            System.out.println("Decreased to 5");
            firstThreshold.setThreshold(false);
            synchronized (jobQueue){
                jobQueue.notifyAll();
            }
        }
    }

    public synchronized void stopPool(){
        stop.setThreshold(true);
        System.out.println("Stopping pool");
        synchronized (jobQueue){
            notifyAll();
        }
    }

    @Override
    public void run() {
        startPool();
        do{
            if (jobQueue.size() > threshold[0] && !firstThreshold.isThreshold())
                increasePool();
            else if (jobQueue.size() > threshold[1] && !secondThreshold.isThreshold())
                increasePool();
            else if (jobQueue.size() < threshold[0] && firstThreshold.isThreshold())
                decreasePool();
            else if (jobQueue.size() < threshold[1] && secondThreshold.isThreshold())
                decreasePool();

            try{
                Thread.sleep(waitCheck * 1000);
            }catch (InterruptedException e){
                System.err.println("Spurious wakeup on threadpool monitor during sleep");
            }
        }while(!stop.isThreshold());
        while (jobQueue.size() > 0){
            jobQueue.dequeue();
        }
    }

    public synchronized boolean isFull() {
        return jobQueue.isFull();
    }

    private class WorkerThread extends Thread{
        private Threshold threshold;
        private JobQueue jobQueue;
        private Threshold stop;

        public WorkerThread(JobQueue jobQueue, Threshold threshold, Threshold stop){
            this.threshold = threshold;
            this.jobQueue = jobQueue;
            this.stop = stop;
        }

        @Override
        public void run() {
            while (!stop.isThreshold()){
                Runnable temp = null;
                if (threshold.isThreshold()){
                    temp = jobQueue.dequeue();
                }
                if (temp != null){
                    //System.out.println("Running command");
                    try{
                        Thread.sleep(WORKER_SLEEP_TIME);
                    }catch(Exception e){}
                    temp.run();
                }else{
                        synchronized (jobQueue){
                            try{ jobQueue.wait();}catch (InterruptedException e){}
                        }
                }
                //try{Thread.sleep(5000);}catch(Exception e){}
            }
        }
    }
}
