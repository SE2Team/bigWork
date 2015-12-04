package businesslogic.Exception;

/**
 * Created by MYK on 2015/12/2 0002.
 */
public class DeliverNumException extends Exception{
    public DeliverNumException(String message) {
        super(message);
    }

    public static boolean isValid(String num) throws DeliverNumException {
        if(num.length()!=10)
            throw new DeliverNumException("快递单号长度不对");

        return true;
    }

}
