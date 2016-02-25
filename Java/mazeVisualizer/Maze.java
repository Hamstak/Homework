/*
 * 
 * 
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import java.util.*;

public class Maze{
	
	    private static mazeVisualizer.Tile[][] grid;
		public char glyph(int dx, int dy){ return grid[dx][dy].glyph(); }
		public Color color(int dx, int dy){return grid[dx][dy].color();}
		private int screenWidth;
		private int screenHeight;
		private int PosX;
		private int PosY;
	
	public Maze(){
		screenWidth = 80;
		screenHeight = 21;
		PosX = 0;
		PosY = 0;
	}
	public int getScrollX(){
		return Math.max(0, Math.min(PosX - screenWidth / 2, grid.length - screenWidth));
	}
	public int getScrollY(){
		return Math.max(0, Math.min(PosY - screenHeight/ 2, grid[0].length - screenHeight));
	}

	public void displayTiles(AsciiPanel terminal, int left, int top){
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int dx = x + left;
				int dy = y + top;
					terminal.write(grid.glyph(dx,dy),x,y, grid.color(dx,dy));
			}	
		}
	}
	public void displayOutput(AsciiPanel terminal){
		int left = getScrollX();
		int top = getScrollY();
		
		displayTiles(terminal, left, top);
		terminal.write('@', PosX - left, PosY - top, AsciiPanel.brightWhite);
	}
	public void searchMaze(AsciiPanel terminal){
		
	}
	public Maze respondToUserInput(KeyEvent key, AsciiPanel terminal){
		switch(key.getKeyCode()){
			default: searchMaze(terminal);
		}
		return this;
	}
}

