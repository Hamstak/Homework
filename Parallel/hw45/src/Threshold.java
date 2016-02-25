/**
 * Created by moth on 2/19/16.
 */
public class Threshold {
    boolean threshold = false;

    public Threshold(){}

    public Threshold( boolean input){ threshold = input;}

    public synchronized void setThreshold(boolean input){
        threshold = input;
    }

    public synchronized boolean isThreshold(){ return threshold;}
}
