
import presentation.userui.LogInFrame;

import javax.swing.*;


/**
 * Created by Administrator on 2015/10/25 0025.
 */
class Main {
    public static void main(String[] args) {
        String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        LogInFrame loginframe = new LogInFrame();
    }
}
