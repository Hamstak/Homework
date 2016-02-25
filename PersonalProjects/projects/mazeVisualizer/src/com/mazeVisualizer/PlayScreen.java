package com.mazeVisualizer;

        import java.awt.event.KeyEvent;
        import asciiPanel.AsciiPanel;
        import rltut.World;
        import rltut.WorldBuilder;
        import rltut.Creature;
        import rltut.CreatureFactory;
        import java.util.*;

public class PlayScreen implements Screen{

    private static int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                                    {1,0,1,1,1,0,1,1,1,1,0,0,1},
                                    {0,0,0,0,1,0,1,0,1,0,1,0,0},
                                    {1,1,1,0,1,1,1,0,1,0,1,1,1},
                                    {1,0,1,0,0,0,0,1,1,1,0,0,1},
                                    {1,0,1,1,1,1,1,1,0,1,1,1,1},
                                    {1,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {1,1,1,1,1,1,1,1,1,1,1,1,1}};
    private int PosX;
    private int PosY;
    private int dx;
    private int dy;

    public PlayScreen(){
        PosX = 0;
        PosY = 0;
        dx =  0;
        dy =  0;
    }

    public void displayTiles(AsciiPanel terminal){
        for (int x = 0; x < grid[0].length; x++){
            for (int y = 0; y < grid.length; y++){
                terminal.write((char)grid[y][x],y,x);
            }
        }
    }
    public void displayOutput(AsciiPanel terminal){

        displayTiles(terminal);
        terminal.write('@', PosX, PosY);
    }
    public void searchMaze(Scanner kb){

        if (PosX < 0 || PosX > grid[0].length || PosY < 0 || PosX > grid.length || grid[PosY][PosX] == 0 || grid[PosY][PosX] == 3 || grid[PosY][PosX] == 7)
            return;
        if (PosX == grid[0].length - 1 && PosY == grid.length - 1){
            grid[PosY][PosX] = 7;
            return;
        }
        grid[PosY][PosX] = 3;
        for (int dx = -1; dx < 2; dx++){
            for (int dy = -1; dy < 2; dy++){
                if (Math.abs(dx) == Math.abs(dy))
                    continue;
                PosX = PosX + dx;
                PosY = PosY + dy;
                kb.nextLine();
                searchMaze(kb);
            }
        }
    }
    public Screen respondToUserInput(KeyEvent key){
        Scanner kb = new Scanner(System.in);
        switch(key.getKeyCode()){
            default: searchMaze(kb);
        }
        return this;
    }
}

