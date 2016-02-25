import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrimeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (args.length < 3) {
			System.out.println("Usage: MyPrimeTest numThread low high \n");
			return;
		}
		int nthreads = Integer.parseInt(args[0]);
		int low = Integer.parseInt(args[1]);
		int high = Integer.parseInt(args[2]);
		Counter c = new Counter();
		
		//test cost of serial code
		long start = System.currentTimeMillis();
		int numPrimeSerial = SerialPrime.numSerailPrimes(low, high);
		long end = System.currentTimeMillis();
		long timeCostSer = end - start;
		System.out.println("Time cost of serial code: " + timeCostSer + " ms.");
		
		//test of concurrent code
		// **************************************
        // Write me here
		c = new Counter();


		Queue<Thread> threads = new LinkedList<>();
		for (int i = low; i < high; i = i + ((high-low)/nthreads) + 1){
			//System.out.println(i + " " + (i + (high -low)/nthreads));
			if ( i + (high - low)/nthreads > high)
				threads.add(new Thread(new ThreadPrime(i, high, c)));
			else
				threads.add(new Thread(new ThreadPrime(i, i +(high-low)/nthreads, c)));
		}
		long conStart = System.currentTimeMillis();
		for (Thread t: threads){
			t.start();
		}
		for (Thread t: threads){
			t.join();
		}
		long timeCostCon = System.currentTimeMillis() - conStart;
		//int numPrimeCon = c.total();
		
		
		// **************************************
		System.out.println("Time cost of parallel code: " + timeCostCon + " ms.");
		System.out.format("The speedup ration is by using concurrent programming: %5.2f. %n", (double)timeCostSer / timeCostCon);
		
		System.out.println("Number prime found by serial code is: " + numPrimeSerial);
		System.out.println("Number prime found by parallel code is " + (c.total()));
	}
		

}
