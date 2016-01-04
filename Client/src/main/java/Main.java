import presentation.userui.LogInFrame;

import javax.swing.*;


/**
 * Created by Administrator on 2015/10/25 0025.
 */
class Main {
    public static void main(String[] args) {
//    	JFrame mFrame = new JFrame();
//        mFrame.setSize(900, 600);
//        mFrame.setLocation(300, 300);
//        ListblService bl=new ListController();
//        JPanel panel=new ListFinanceView(bl);
//        mFrame.getContentPane().add(panel);
//        mFrame.setTitle("ss�");
//        mFrame.setVisible(true);
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
