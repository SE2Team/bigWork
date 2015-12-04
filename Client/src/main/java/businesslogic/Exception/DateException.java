package businesslogic.Exception;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MYK on 2015/11/28 0028.
 */
public class DateException extends Exception {
    public DateException() {
    }

    public DateException(String message) {
        super(message);
    }

    public static boolean isValid(String date) {
        if (date.contains("-")) {
            if (date.length() != (8 + 2)) {//2015-10-10
                return false;
            } else {
                String str[] = date.split("-");
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (String temp : str) {
                    int a = -1;
                    try {
                        a = Integer.parseInt(temp);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    array.add(a);
                }

                return DateException.time(array.get(0), array.get(1), array.get(2));

            }
        }
        return false;
    }

    private static boolean time(int y, int m, int d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String now = df.format(new Date());
        if (Integer.parseInt(now) < y * 10000 + m * 100 + d)
            return false;
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            if (d >= 1 && d <= 31) {
                return true;
            } else
                return false;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d >= 1 && d <= 30)
                return true;
            else
                return false;
        } else if (m == 2) {
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
                return d >= 1 && d <= 29;
            else return d >= 1 && d <= 28;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(DateException.isValid("2015-11-20"));
    }
}
