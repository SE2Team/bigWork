package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/28 0028.
 *
 * @author myk
 */
public class TransferException extends Exception {

    /**
     * Instantiates a new Transfer exception.
     */
    public TransferException() {
        super();
    }

    /**
     * Instantiates a new Transfer exception.
     *
     * @param message the message
     */
    public TransferException(String message) {
        super(message);
    }

    /**
     * Is valid boolean.
     *
     * @param num the num
     * @return the boolean
     */
    public static boolean isValid(String num) {
        //025(城市编号)+0（中转中心）+日期（8位）+7位数
        if (num.length() != 19)
            return false;
        if (!DateException.isValid(num.substring(5, 13)))
            return false;
        return true;
    }
}
