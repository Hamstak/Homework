import java.util.Queue;

public class ThreadPrime extends Thread {
	private int low;
	private int high;
    private int numFound;
	private Counter c;

	// each thread only  takes care of one subrange (low, high)
	public ThreadPrime (int lowLocal, int highLocal, Counter ct) {
		this.low = lowLocal;
		this.high = highLocal;
		c = ct;
	}

	public void run(){
        for (int i = low; i <= high; i++){
            if (isPrime(i)){
                numFound++;
            }
        }

        synchronized (c){
            c.increment(numFound);
        }
	}

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n <= 3)
            return true;
        else if (n%2 == 0 || n%3==0)
            return false;
        int i = 5;
        while(i*i <= n){
            if (n%i == 0 || n%(i+2) == 0)
                return false;
            i += 6;
        }
        return true;
    }
}
