package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/28 0028.
 */
public class TransferException extends Exception{

    public TransferException() {
        super();
    }

    public TransferException(String message) {
        super(message);
    }

    public static boolean isValid(String num){
        //025(城市编号)+0（中转中心）+日期（8位）+7位数
        if(num.length()!=19)
            return false;
        if(!DateException.isValid(num.substring(5,13)))
            return false;
        return true;
    }
}
