package src.main;


import src.businesslogic.listbl.ListController;
import src.businesslogicservice.ListblService;
import src.presentation.listui.ListFinanceView;

import javax.swing.*;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class Main {
    public static void main(String[] args) {
        JFrame mFrame = new JFrame();
        mFrame.setSize(900, 600);
        mFrame.setLocation(300, 300);
        ListblService bl = new ListController();
        JPanel panel = new ListFinanceView(bl);
        mFrame.getContentPane().add(panel);
        mFrame.setTitle("输入收款单信息");
        mFrame.setVisible(true);
    }
}
