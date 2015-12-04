package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/29 0029.
 */
public class MoneyException extends Exception{
    public MoneyException(String message) {
        super(message);
    }

    public static boolean isValid(String m) throws MoneyException {
        if(!InvalidDoubleException.isValid(m))
            throw new MoneyException("金额数据错误！");
        else{
            double d=Double.valueOf(m);
            if(d<0)
                return false;
        }
        throw new MoneyException("金额数据错误！");
    }
}
