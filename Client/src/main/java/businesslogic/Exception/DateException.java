package businesslogic.Exception;

/**
 * Created by MYK on 2015/11/28 0028.
 */
public class DateException extends Exception{
    public DateException() {
    }

    public DateException(String message) {
        super(message);
    }

    public static boolean IsValid(String date){
        return false;
    }
}
