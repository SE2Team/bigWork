/**
 * Created by MYK on 2015/11/25 0025.
 */
public class Cla {
    public void  go(boolean bool) throws MyException {
        if(bool)
            System.out.println("success");
        else
            throw new MyException();
        System.out.println("Cal finished!");
    }
}
