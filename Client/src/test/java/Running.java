/**
 * Created by MYK on 2015/11/25 0025.
 */
public class Running {
    public static void main(String[] args) {
        try {
            new Cla().go(false);
        } catch (MyException e) {
            Handler.handl();
        }
    }
}
