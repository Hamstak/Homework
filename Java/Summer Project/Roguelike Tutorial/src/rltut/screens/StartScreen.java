package rltut.screens;

import asciiPanel.AsciiPanel;

/**
 * Created by tim on 5/11/15.
 */
public class StartScreen {

    public void displayOutput(AsciiPanel terminal){
        terminal.write("rl tutorial",1,1);
        terminal.writeCenter("-=Press [ENTER] to continue=-")
    }
}
