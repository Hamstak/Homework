
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;


public class Inputter extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;

    private JTextArea output;

    String string = "";
    ScreenPrinter printer;
    Thread printerThread;

    public Inputter(String name) {
        super(name);
        //JTextArea output = new JTextArea(20,30) // Can this statement replace the next one?
        output = new JTextArea(20, 30);                      //create JTextArea in which all messages are shown.
        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);  // JTextArea always set focus on the last message appended.

        //
        add(new JScrollPane(output)); // add a Scroll bar to JFrame, scrolling associated with JTextArea object
        setSize(500, 500);            // when lines of messages exceeds the line capacity of JFrame, scroll bar scroll down.
        setVisible(true);
        output.addKeyListener(this);  // Adds the specified key listener to receive key events from this component.
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    //
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!string.equals("exit") && !string.equals("")) {
                printer = new ScreenPrinter(output, string);
                printerThread = new Thread(printer);
                System.out.println();
                string = "";
                printerThread.start();
            }else if (string.equals("exit")){
                System.exit(0);
            }
        } else {
            if (printerThread != null) {
                printerThread.interrupt();
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                string = string.substring(0, string.length() - 1);
            }
            string += e.getKeyChar();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Inputter inp = new Inputter("A JFrame and KeyListener Demo");

        inp.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
    }
}
