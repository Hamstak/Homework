import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by tim on 10/27/15.
 */
public class MazePath {
    char[][] maze;
    ArrayList<ArrayList<Point>> paths;
    ArrayList<ArrayList<Point>> searched;
    ArrayList<Point> searching;
    Point start, goal;
    String markedFirst, marked;

    public MazePath(ArrayList<String> maze){
        constructMaze(maze);
        paths = new ArrayList<>();
        searched = new ArrayList<>();
        searching = new ArrayList<>();
        markedFirst = "";
        marked = "";

    }

    private void constructMaze(ArrayList<String> maze){
        char[][] temp;
        temp = new char[maze.size()][];
        int i = 0;
        for (String s: maze){
            temp[i] = new char[s.length()];
            for (int x = 0; x < s.length(); x++){
                char tempChar = s.charAt(x);
                if (tempChar == 'S') start = new Point(x, i);
                if (tempChar == 'G') goal = new Point(x, i);
                temp[i][x] = tempChar;
            }
            i++;
        }
        this.maze = temp;
    }

    public ArrayList<Point> deepClone(ArrayList<Point> list){
        ArrayList<Point> temp = new ArrayList<Point>();
        for (Point p: list){
            temp.add(p);
        }
        return temp;
    }
    public void findPath(){
        searching = new ArrayList<>();
        findPath(start, new ArrayList<Point>(), new ArrayList<Point>(), 0, 0);
    }

    public void mark(){
        marked = "";
        for (ArrayList<Point> list: paths){
            char[][] temp = new char[maze.length][maze[0].length];
            for (int x = 0; x < maze.length; x ++){
                for (int y = 0; y < maze[0].length; y++){
                    temp[x][y] = maze[x][y];
                }
            }
            for (Point p: list){
                temp[p.getY()][p.getX()] = '+';
            }
            marked += "---------------------------\n";
            for (int x = 0; x < temp.length; x++){
                String loopTemp = "";
                for (int y = 0; y < temp[0].length; y++){
                    loopTemp += temp[x][y];
                }
                loopTemp += "\n";
                
                marked += loopTemp;
            }
            marked += "---------------------------\n";
        }
    }
    public void markFirst(){
        ArrayList<Point> tempPath = paths.get(0);
        ArrayList<Point> tempSearch = searched.get(0);
        char[][] temp = new char[maze.length][maze[0].length];
        for (int x = 0; x < maze.length; x ++){
            for (int y = 0; y < maze[0].length; y++){
                temp[x][y] = maze[x][y];
            }
        }
        for (Point p: tempSearch){
            temp[p.getY()][p.getX()] = 'X';
        }
        for (Point p: tempPath){
            temp[p.getY()][p.getX()] = '+';
        }
        for (int x = 0; x < temp.length; x++){
            String loopTemp = "";
            for (int y = 0; y < temp[0].length; y++){
                loopTemp += temp[x][y];
            }
            loopTemp += "\n";
            markedFirst += loopTemp;
        }
    }

    public void findPath( Point here, ArrayList<Point> path, ArrayList<Point> searchedParent,int dx, int dy){
        boolean test = here.getY() < 0
                || here.getX() < 0
                || here.getY() >= maze.length
                || here.getX() >= maze[0].length
                || maze[here.getY()][here.getX()] == '#';
        if (here.equals(goal)) {
            searched.add(deepClone(searching));
            paths.add(path);
        }
        else if (!(test) && !searchedParent.contains(here)) {
            path.add(here);
            searching.add(here);
            searchedParent.add(here);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j) && !(-dx == i && -dy == j))
                        findPath(new Point(here.getX() + i, here.getY() + j), deepClone(path), deepClone(searchedParent), i, j);
                }
            }
        }
    }

    public String toString(){
        String result = "";
        for (int y = 0; y < maze.length; y++){
            String temp = "";
            for (int x = 0; x < maze[y].length; x++){
                temp += maze[y][x];
            }
            temp += "\n";
            result += temp;
        }
        return result;
    }

}
