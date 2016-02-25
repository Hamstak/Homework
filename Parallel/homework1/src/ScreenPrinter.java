import javax.swing.*;

/**
 * Created by moth on 1/14/16.
 */
public class ScreenPrinter implements Runnable{
    String string;
    JTextArea output;
    public ScreenPrinter(JTextArea output, String string){
        this.string = string;
        this.output = output;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            output.append(string + '\n');
        }
    }
}
