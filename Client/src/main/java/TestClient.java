import presentation.commonui.DateChooser;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/5 0005.
 */
public class TestClient {
    public static void main(String[] args) {
//        File directory = new File("");//设定为当前文件夹
//        try{
//            System.out.println(directory.getCanonicalPath());//获取标准的路径
//            System.out.println(directory.getAbsolutePath());//获取绝对路径
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        JFrame frame2 = new JFrame();
        frame2.getContentPane().setLayout(null);

        JTextField jt = new JTextField("date");
        DateChooser dateChooser = new DateChooser("yyyy-MM-dd", jt);
        dateChooser.setBounds(30, 30, 30, 30);


        frame2.getContentPane().add(dateChooser);
        frame2.getContentPane().add(jt);

        frame2.setSize(500, 400);
        frame2.setVisible(true);
    }
}
