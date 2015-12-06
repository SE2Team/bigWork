package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/26 0026.
 *
 * @author myk
 */
public class InvalidIntegerException extends InputNullException {
    /**
     * Instantiates a new Invalid integer exception.
     *
     * @param message the message
     */
    public InvalidIntegerException(String message) {
        super(message);
    }

    /**
     * Is valid boolean.
     *
     * @param num the num
     * @return the boolean
     */
    public static boolean isValid(String num) {
        try {
            int a = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
