import java.util.concurrent.BrokenBarrierException;

/**
 * Created by moth on 2/4/16.
 */
public class MyCyclicBarrier {
    int parties;
    int haveArrived;
    Runnable barrierAction;

    public MyCyclicBarrier(int parties, Runnable barrierAction){
        this.parties = parties;
        this.barrierAction = barrierAction;
        haveArrived = 0;
    }

    public int await() throws InterruptedException, BrokenBarrierException{

        synchronized (this){
            int temp = haveArrived;
            haveArrived++;
            if(haveArrived == parties){
                barrierAction.run();
                haveArrived = 0;
                this.notifyAll();
            }else{
                try{
                    wait();
                }catch (InterruptedException e){
                    if (haveArrived != parties)
                        throw new BrokenBarrierException();
                    else
                        throw e;
                }
            }
            return temp;
        }

    }
}
