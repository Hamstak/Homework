/*
 * 
 * 
 */
package mazeVisualizer;
 
import asciiPanel.AsciiPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ApplicationMain extends JFrame implements KeyListener {
	
	private AsciiPanel terminal;
	private Maze maze;
	
	public ApplicationMain(){
		super();
		terminal = new AsciiPanel();
		terminal.write("Testing!", 1, 1);
		add(terminal);
		pack();
		maze = new Maze();
		addKeyListener(this);
		repaint();
	}
	public void repaint(){
		terminal.clear();
		maze.displayOutput(terminal);
		super.repaint();
	}
	public void keyPressed(KeyEvent e){
		maze = maze.respondToUserInput(e, terminal);
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	public static void main(String[] args){
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
