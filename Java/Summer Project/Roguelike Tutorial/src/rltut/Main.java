package rltut;

import asciiPanel.AsciiPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener{

    private AsciiPanel terminal;
    //private Screen screen;

    public Main(){
        super();
        terminal = new AsciiPanel();
        terminal.write("testing!",1,1);
        add(terminal);
        pack();
        addKeyListener(this);
    }

    public void repaint(){
        terminal.clear();
        super.repaint();
    }

    public void keyPressed(KeyEvent e){
        //screen = screen.respondeToUserInput(e);
        repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}


    public static void main(String[] args) {
	    Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
