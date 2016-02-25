package rltut.screens;

/**
 * Created by tim on 5/11/15.
 */

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Screen {
    public void displayOutput(AsciiPanel terminal);

    public Screen respondToUserInput(KeyEvent key);
}
