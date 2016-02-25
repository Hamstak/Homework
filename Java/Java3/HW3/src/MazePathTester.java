import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tim on 10/27/15.
 */
public class MazePathTester {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList input = new ArrayList();
        Scanner fp = FileUtil.openInputFile("inputPuzzle2.txt");
        PrintWriter fout = FileUtil.openOutputFile("path1.txt");
        while(fp.hasNextLine()){
            input.add(fp.nextLine());
        }
        //System.out.println(input);
        MazePath test = new MazePath(input);
        test.findPath();
        //System.out.println(test.paths);
        //System.out.println(test);
        test.markFirst();
        fout.println(test.markedFirst);
        fout.close();
        test.mark();
        fout = FileUtil.openOutputFile("pathAll.txt");
        fout.println(test.marked);
        fout.close();
    }
}