/**
 * Created by moth on 1/25/16.
 */
public class MyBool {
    private boolean dumbshit;
    private boolean checked;

    public MyBool(){
        dumbshit = false;
        checked = false;
    }

    public MyBool(boolean bol){
        dumbshit = bol;
    }

    public boolean getBool(){
        return dumbshit;
    }

    public void setBool(boolean bol){
        dumbshit = bol;
    }

    public void setCheck(){
        checked = true;
    }

    public boolean check(){
        return checked;
    }
}
