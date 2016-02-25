import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {

  private PhilCanvas display;
  private int identity;
  private Lock lock = new ReentrantLock();
  
  Fork(PhilCanvas disp, int id)
    { display = disp; identity = id;}

  public void put() {
      synchronized (this){
        display.setFork(identity,false);
        lock.unlock();
        notifyAll();
      }

  }

  public boolean get() throws java.lang.InterruptedException {
	synchronized (this){
      for(int i = 0; i < 3; i++){
        if(lock.tryLock()){
          display.setFork(identity, true);
          return true;
        }
        wait(1000);
      }
	  return false;
    }
  }

  public int getIdentity(){ return identity;}
}
