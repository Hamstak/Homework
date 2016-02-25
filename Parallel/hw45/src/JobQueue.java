import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by moth on 2/19/16.
 */
public class JobQueue {
    private Queue<Runnable> jobQueue = new LinkedList<>();
    int capacity;

    public JobQueue(int capacity){
        this.capacity = capacity;
    }

    public synchronized boolean enqueue(Runnable job){
        if(size() >= capacity){
            return false;
        }
        jobQueue.add(job);
        notifyAll();
        return true;
    }

    public synchronized Runnable dequeue(){
        return jobQueue.poll();
    }
    public synchronized int size(){ return jobQueue.size();}

    public synchronized boolean isFull() {
        return size() == capacity;
    }
}
