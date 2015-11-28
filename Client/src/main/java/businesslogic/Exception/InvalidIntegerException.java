package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/26 0026.
 */
public class InvalidIntegerException extends InputNullException {
    public InvalidIntegerException(String message) {
        super(message);
    }

    public static boolean isValid(String num){
        try {
            int a =Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
