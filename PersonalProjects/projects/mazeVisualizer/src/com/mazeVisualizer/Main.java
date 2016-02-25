package com.mazeVisualizer;

import asciiPanel.AsciiPanel;
import javax.swing.JFrame;


public class Main extends JFrame {

    private AsciiPanel terminal;
    private static char[][] grid = { {'1','1','1','0','1','1','0','0','0','1','1','1','1'},
            {'1','0','1','1','1','0','1','1','1','1','0','0','1'},
            {'0','0','0','0','1','0','1','0','1','0','1','0','0'},
            {'1','1','1','0','1','1','1','0','1','0','1','1','1'},
            {'1','0','1','0','0','0','0','1','1','1','0','0','1'},
            {'1','0','1','1','1','1','1','1','0','1','1','1','1'},
            {'1','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1'}};
    private static boolean start;

    public Main(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        repaint();
    }

    public void repaint(){
        terminal.clear();
        displayOutput(terminal, 0, 0);
        if (start)
            searchMaze(terminal, 0, 0);
        super.repaint();
    }

    private static boolean searchMaze(AsciiPanel terminal, int x, int y){
        if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || grid[x][y] == '3')
            return false;
        if (x == grid.length - 1 && y == grid[0].length - 1){
            grid[x][y] = '7';
            return true;
        }
        grid[x][y] = '3';
        displayOutput(terminal, x, y);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int dx = -1; dx < 2; dx++){
            for (int dy = -1; dy < 2; dy++){
                if (Math.abs(dx) == Math.abs(dy))
                    continue;
                if (searchMaze(terminal, x + dx, y + dy)){
                    grid[x][y] = '7';
                    return true;
                }
            }
        }
        return false;
    }

    public static void displayOutput(AsciiPanel terminal, int x, int y){

        displayTiles(terminal);
        terminal.write('@', y, x);
    }

    public static void displayTiles(AsciiPanel terminal){
        for (int x = 0; x < grid[0].length; x++){
            for (int y = 0; y < grid.length; y++){
                terminal.write((char)grid[y][x],y,x);
            }
        }
    }

    public static void main(String[] args){
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        start = true;
        app.repaint();
    }
}