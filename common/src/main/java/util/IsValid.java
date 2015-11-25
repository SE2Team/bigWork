package util;

/**
 * Created by MYK on 2015/11/25 0025.
 */
public class IsValid {


    public static boolean isDouble(String str){
        double temp=0;
        try {
            temp=Double.valueOf(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String str){
        int temp=0;
        try {
            temp=Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
