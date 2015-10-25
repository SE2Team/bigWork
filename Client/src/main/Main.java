package main;

import businesslogic.listbl.ListBL;
import businesslogicservice.ListblService;
import presentation.listui.ListFinanceView;

import javax.swing.*;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class Main {
    public static void main(String[] args){
        JFrame mFrame = new JFrame();
        mFrame.setSize(800, 600);
        mFrame.setLocation(300, 300);
        ListblService bl=new ListBL();
        JPanel panel=new ListFinanceView(bl);
        mFrame.getContentPane().add(panel);
        mFrame.setTitle("输入收款单信息");
        mFrame.setVisible(true);
    }
}
