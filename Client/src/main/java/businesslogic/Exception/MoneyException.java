package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/29 0029.
 *
 * @author myk
 */
public class MoneyException extends Exception {
    /**
     * Instantiates a new Money exception.
     *
     * @param message the message
     */
    public MoneyException(String message) {
        super(message);
    }

    /**
     * Is valid boolean.
     *
     * @param m the m
     * @return the boolean
     * @throws MoneyException the money exception
     */
    public static boolean isValid(String m) throws MoneyException {
        if (!InvalidDoubleException.isValid(m))
            throw new MoneyException("金额数据错误！");
        else {
            double d = Double.valueOf(m);
            if (d < 0)
                return false;
        }
        throw new MoneyException("金额数据错误！");
    }
}
