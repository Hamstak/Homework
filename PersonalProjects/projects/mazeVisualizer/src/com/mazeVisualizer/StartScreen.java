package com.mazeVisualizer;

        import java.awt.event.KeyEvent;
        import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal){
        terminal.writeCenter("Maze Visualizer",21);
        terminal.writeCenter("--== press [ENTER] to start ==--",22);
    }
    public Screen respondToUserInput(KeyEvent key){
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}

