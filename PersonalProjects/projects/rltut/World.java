/*
 *
 *
 */
package rltut;

import java.awt.Color;
import java.util.*;

public class World {

    private List<Creature> creatures;
    public Creature creature(int x, int y, int z) {
        if (creatures == null){
            return null;
        }
        for (Creature c: creatures){
            if ( c.x== x && c.y==y && c.z == z){
                return c;
            }
        }
        return null;
    }

    private Tile[][][] tiles;
    private int width;
    public int width() {return width;}

    private int height;
    public int height() { return height; }

    private int depth;
    public int depth() { return depth; }

    public World(Tile[][][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.depth = tiles[0][0].length;
        creatures = new ArrayList();
    }
    public Tile tiles(int x, int y, int z){
        if (x < 0 || x >= width || y < 0 || y >= height || z < 0 || z >= depth)
            return Tile.BOUNDS;
        else
            return tiles[x][y][z];
    }
    public char glyph(int x, int y, int z){
        return tiles(x,y,z).glyph();
    }
    public Color color(int x,int y, int z){
        return tiles(x,y,z).color();
    }
    public void dig(int x,int y, int z){
        if (tiles(x,y,z).isDiggable()){
            tiles[x][y][z] = Tile.FLOOR;
        }
    }
    public void addAtEmptyLocation(Creature creature, int z){
        int x;
        int y;

        do{
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }while (!tiles(x,y,z).isGround() || creature(x,y,z)!= null);

        creature.x = x;
        creature.y = y;
        creature.z = z;
        creatures.add(creature);
    }
    public void remove(Creature other){
        creatures.remove(other);
    }
    public void update(){
        List<Creature> toUpdate = new ArrayList<Creature>(creatures);
        for (Creature c: toUpdate){
            c.update();
        }
    }
}

