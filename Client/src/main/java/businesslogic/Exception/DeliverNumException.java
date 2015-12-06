package businesslogic.Exception;

/**
 * Created by MYK on 2015/12/2 0002.
 *
 * @author myk
 */
public class DeliverNumException extends Exception {
    /**
     * Instantiates a new Deliver num exception.
     *
     * @param message the message
     */
    public DeliverNumException(String message) {
        super(message);
    }

    /**
     * Is valid boolean.
     *
     * @param num the num
     * @return the boolean
     * @throws DeliverNumException the deliver num exception
     */
    public static boolean isValid(String num) throws DeliverNumException {
        if (num.length() != 10)
            throw new DeliverNumException("快递单号长度不对");

        return true;
    }

}
