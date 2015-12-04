package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/26 0026.
 */
public class InvalidDoubleException extends Exception{
    public InvalidDoubleException(String message) {
        super(message);
    }

    public static boolean isValid(String s){
        try {
            double d=Double.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
