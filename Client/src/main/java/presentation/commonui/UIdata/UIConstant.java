package presentation.commonui.UIdata;

import java.awt.*;

/**
 * Created by MYK on 2016/1/3 0003.
 */
public class UIConstant {
    public static String[] position = {"快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员", "高级财务人员", "总经理", "管理员"};

    private Font kai = new Font("楷体", Font.PLAIN, 25);
    private Font song20 = new Font("宋体", Font.PLAIN, 20);
    private Font song18 = new Font("宋体", Font.PLAIN, 18);

    static UIConstant ME = new UIConstant();


    public static Font getKai() {
        return ME.kai;
    }

    public static void setKai(Font kai) {
        ME.kai = kai;
    }

    public static Font getSong20() {
        return ME.song20;
    }

    public static void setSong20(Font song20) {
        ME.song20 = song20;
    }

    public static Font getSong18() {
        return ME.song18;
    }

    public static void setSong18(Font song18) {
        ME.song18 = song18;
    }
}
