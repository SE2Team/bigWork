package businesslogic.utilitybl;

import util.UserType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一个帮助计算一些数据的静态类
 * Created by MYK on 2015/11/23 0023.
 *
 * @author myk
 */
public class Helper {


    private static UserType type;
    /**
     * Gets time.
     *
     * @return 系统时间 time
     */
    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 比较任意日期数据和现在时间的先后
     *
     * @param date the date
     * @return date -now 晚于当前时间时，返回true（非法时间）
     */
    public static boolean compareTo(String date) {
        if(Helper.Date2int(date)<=Helper.Date2int(Helper.getTime())){
            return true;
        }
        return false;
    }

    /**
     * 比较两个日期先后
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return date2 -date1
     */
    public static boolean compareTo(String date1, String date2) {
        if(Helper.Date2int(date1)<Helper.Date2int(date2)){
            return true;
        }
        return false;
    }


    /**
     *
     * @param date1
     * @param date2 between date1 and now
     * @return
     */
    public static boolean isBetween(String date1,String date2) {
        if(!Helper.compareTo(date1))
            return false;
        if(Helper.compareTo(date1,date2)&&Helper.compareTo(date2))
            return true;

        return false;
    }

    public static boolean isBetween(String date1,String date2,String date3){
        if(compareTo(date1, date2)&&compareTo(date2,date3)&&compareTo(date1,date3))
            return true;
        return false;
    }

    /**
     * 判断是否等于当前日期
     * @param date
     * @return
     */
    public static boolean isEqual(String date){
        if(Date2int(date)==Date2int(getTime()))
            return true;
        return false;
    }

    private static int Date2int(String s){
        int i=0;
        String array[]=s.split("-");
        String temp="";
        for(int j=0;j<array.length;j++){
            temp+=array[j];
        }

        i=Integer.parseInt(temp);
        return i;
    }
    public static UserType getUserType() {
        return type;
    }

    public static void setUserType(UserType type) {
        Helper.type = type;
    }

}
