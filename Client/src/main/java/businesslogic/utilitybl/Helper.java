package businesslogic.utilitybl;

import businesslogic.Exception.DateException;

/**
 * 一个帮助计算一些数据的静态类
 * Created by MYK on 2015/11/23 0023.
 *
 * @author myk
 */
public class Helper {
    /**
     * Gets time.
     *
     * @return 系统时间 time
     */
    public static String getTime() {
        return null;
    }

    /**
     * 比较任意日期数据和现在时间的先后
     *
     * @param date the date
     * @return date -now 晚于当前时间时，返回true（非法时间）
     */
    public static boolean compareTo(String date) {
        if (!DateException.isValid(date))
            return true;
        return true;
    }

    /**
     * 比较两个日期先后
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return date1 -date2
     */
    public static boolean compareTo(String date1, String date2) {
        if (!DateException.isValid(date1) || !DateException.isValid(date2))
            return false;
        return false;
    }

    /**
     * 判断一个日期串是否合法
     *
     * @param date the date
     * @return boolean
     */


    public static boolean isBetween(String date) {
        return false;
    }
}
