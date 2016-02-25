/*
 *
 */
package rltut;

import java.util.*;

public class WorldBuilder {

    private int width;
    private int height;
    private int depth;
    private int nextRegion;
    private Tile[][][] tiles;
    private int[][][] regions;

    public WorldBuilder (int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.nextRegion = 1;
        this.tiles = new Tile[width][height][depth];
    }
    public World build(){
        return new World(tiles);
    }
    private WorldBuilder randomizeTiles(){
        for (int z = 0; z < depth; z++){
            for (int i = 0;  i < width; i++){
                for (int j = 0; j < height; j++){
                    tiles[i][j][z] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
                }
            }
        }
        return this;
    }
    private WorldBuilder smooth(int times){
        Tile[][][] tiles2 = new Tile[width][height][depth];
        for (int time = 0; time < times; time++){
            for (int z = 0; z < depth; z++){
                for (int i = 0; i < width; i++){
                    for (int j = 0; j < height; j++){
                        int floors = 0;
                        int rocks = 0;
                        for (int di = -1; di < 2; di++){
                            for (int dj = -1; dj < 2; dj++){
                                if ( isNotValid(i, j, di, dj) ){
                                    continue;
                                }else if (tiles[i + di][j + dj][z] == Tile.FLOOR){
                                    floors++;
                                }else{
                                    rocks++;
                                }
                            }
                        }
                        tiles2[i][j][z] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                    }
                }
            }
            tiles = tiles2;
        }
        return this;
    }
    private boolean isNotValid(int i, int j, int di, int dj){
        boolean yn1 = i + di < 0;
        boolean yn2 = i + di >= width;
        boolean yn3 = j + dj < 0;
        boolean yn4 = j + dj >= height;
        return (yn1 || yn2 || yn3 || yn4);
    }
    public WorldBuilder makeCaves(){
        return randomizeTiles().smooth(8).createRegions().connectRegions();
    }
    private WorldBuilder createRegions(){
        regions = new int[width][height][depth];

        for (int z = 0; z < depth; z++){
            for (int x = 0; x < width; x++){
                for (int y = 0; y < height; y++){
                    if (tiles[x][y][z] != Tile.WALL && regions [x][y][z] == 0){
                        int size = fillRegion((nextRegion++),x,y,z);

                        if (size<25){
                            removeRegion(nextRegion-1,z);
                        }
                    }
                }
            }
        }
        return this;
    }
    private void removeRegion(int region, int z){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (regions[x][y][z] == region){
                    regions[x][y][z] = 0;
                    tiles[x][y][z] = Tile.WALL;
                }
            }
        }
    }
    private int fillRegion(int region, int x, int y, int z){
        int size = 1;
        ArrayList<Point> open = new ArrayList<Point>();
        open.add(new Point(x,y,z));
        regions[x][y][z] = region;
        while(!open.isEmpty()){
            Point p = open.remove(0);
            for(Point neighbor: p.neighbors8()){
                if(neighbor.x >= width || neighbor.y >= height || neighbor.z >= depth || regions[neighbor.x][neighbor.y][neighbor.z]>0 || tiles[neighbor.x][neighbor.y][neighbor.z] == Tile.WALL)
                    continue;
                size++;
                regions[neighbor.x][neighbor.y][neighbor.z] = region;
                open.add(neighbor);
            }
        }
        return size;
    }
    public WorldBuilder connectRegions(){
        for (int z = 0; z < depth - 1; z++){
            connectRegionsDown(z);
        }
        return this;
    }
    private void connectRegionsDown(int z){
        List<String> connected = new ArrayList<String>();

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                String region = regions[x][y][z] + "," + regions[x][y][z + 1];
                if (tiles[x][y][z] == Tile.FLOOR && tiles[x][y][z + 1] == Tile.FLOOR && !connected.contains(region)){
                    connected.add(region);
                    connectRegionsDown(z,regions[x][y][z],regions[x][y][z + 1]);
                }
            }
        }
    }
    private void connectRegionsDown(int z, int r1, int r2){
        List<Point> candidates = findRegionOverlap(z,r1,r2);

        int stairs = 0;
        do{
            Point p = candidates.remove(0);
            tiles[p.x][p.y][z] = Tile.STAIRS_DOWN;
            tiles[p.x][p.y][z + 1] = Tile.STAIRS_UP;
            stairs++;
        }while(candidates.size()/stairs > 250);
    }
    public List<Point> findRegionOverlap(int z, int r1, int r2){
        ArrayList<Point> candidates = new ArrayList<Point>();

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (tiles[x][y][z] == Tile.FLOOR && tiles[x][y][z+1] == Tile.FLOOR && regions[x][y][z] == r1 && regions[x][y][z] == r2){
                    candidates.add(new Point(x,y,z));
                }
            }
        }
        Collections.shuffle(candidates);
        return candidates;
    }
}

