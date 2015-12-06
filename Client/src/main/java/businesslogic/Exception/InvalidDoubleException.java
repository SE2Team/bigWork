package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/26 0026.
 *
 * @author myk
 */
public class InvalidDoubleException extends Exception {
    /**
     * Instantiates a new Invalid double exception.
     *
     * @param message the message
     */
    public InvalidDoubleException(String message) {
        super(message);
    }

    /**
     * Is valid boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public static boolean isValid(String s) {
        try {
            double d = Double.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
