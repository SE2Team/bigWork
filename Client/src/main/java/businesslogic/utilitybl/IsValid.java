package businesslogic.utilitybl;

/**
 * Created by MYK on 2015/11/25 0025.
 *
 * @author myk
 */
public class IsValid {
    /**
     * 判断输入的字符串是否合法
     *
     * @param str the str
     * @return boolean
     */

    public static boolean isDouble(String str) {
        double temp = 0;
        try {
            temp = Double.valueOf(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Is integer boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isInteger(String str) {
        int temp = 0;
        try {
            temp = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
