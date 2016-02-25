/**
 * Created by moth on 11/6/15.
 */
public class DailyProgrammer239 {
    public static void main(String[] args) {
        gameOfThrees(100);
        System.out.println();
        gameOfThrees(31337357);
    }

    public static void gameOfThrees(int num){
        while(num > 1){
            double modifier = (int)Math.round(-Math.sin(5 * (num % 3)/Math.PI) + Math.sin(2.5 * (num % 3)/Math.PI));
            System.out.println("" + num + " " + modifier + " " + "/3");
            num += modifier;
            num /= 3;
        }
        System.out.println(num);
    }
}
