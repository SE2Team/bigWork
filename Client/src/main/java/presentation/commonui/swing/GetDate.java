package presentation.commonui.swing;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一个帮助计算一些数据的静态类
 * Created by MYK on 2015/11/23 0023.
 *
 * @author myk
 */
public class GetDate {
    /**
     * Gets time.
     *
     * @return 系统时间 time
     */
    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日hh时mm分");//设置日期格式
        return df.format(new Date());
    }

    public static String getDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年");//设置日期格式
        return df.format(new Date());
    }


}
