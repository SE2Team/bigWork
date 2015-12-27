package presentation.manageui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import util.ListState;
import vo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 完成
 *
 * @author WANXING
 */
//总经理审批单据
public class ListApprovalPanel extends JPanel {
    int width = 100, height = 20;
    private JButton waitButton;
    private JButton checkButton;
    private JButton passButton;
    private JButton updateButton;
    ListblService bl = null;

    private JScrollPane jsp;
    private JTable listTable;
    private DefaultTableModel model;
    String[] column = {"序号", "审批状态", "单据类型"};
    String row[][] = new String[50][3];

    Font font1 = new Font("宋体", Font.PLAIN, 15);
    Font font2 = new Font("宋体", Font.PLAIN, 12);
    private ArrayList<ListVO> arrayList;


    public ListApprovalPanel() {
        //初始化各组件
        this.setSize(650, 530);
        this.setLayout(null);
        waitButton = new JButton("否决");
        checkButton = new JButton("查看");
        passButton = new JButton("通过");
        updateButton = new JButton("更新");
        //todo 增加一个按钮

        //界面
        waitButton.setFont(font2);
        waitButton.setBounds(200, 15, width, height);

        checkButton.setFont(font2);
        checkButton.setBounds(360, 15, width, height);

        passButton.setFont(font2);
        passButton.setBounds(40, 15, width, height);

        updateButton.setFont(font2);
        updateButton.setBounds(520, 15, width, height);

        add(waitButton);
        add(checkButton);
        add(passButton);
        add(updateButton);


        arrayList = new ArrayList<ListVO>();
        Iterator<ListVO> itr = null;


        try {
            bl = new ListController();
            itr = bl.push();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        int cout = 1;
        while (itr.hasNext()) {
            ListVO vo = itr.next();
            arrayList.add(vo);
            String[] temp = {String.valueOf(cout), String.valueOf(vo.getIsCheck()), vo.getType().toString()};
            row[cout - 1] = temp;
            cout++;
        }


//
//
//        for(ListVO vo:arrayList){
//            System.out.println(temp[0]);
//            rowArray.add(temp);
//            cout++;
//        }
//
//        for(int i=0;i<rowArray.size();i++){
//            if(i>=10){
//                break;
//            }
//            System.out.println("count"+i);
//            System.out.println(rowArray.get(i)[0]+rowArray.get(i)[1]+rowArray.get(i)[2]+rowArray.get(i)[3]);
//            row[i]=rowArray.get(i);
//        }
        model = new DefaultTableModel(row, column);
        listTable = new JTable(model);
        listTable.setFont(font1);
        listTable.setRowHeight(20);
        jsp = new JScrollPane(listTable);
        jsp.setBounds(0, 70, 650, 300);
        add(jsp);


        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass();
            }
        });

        waitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wait1();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 50, 650, 50);
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    private void pass() {
        int i = listTable.getSelectedRow();
        if (i == -1) {
            JLabel tip = new JLabel("提示：请选择要同意通过的单据");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else {
            arrayList.get(i).setIsCheck(ListState.PASSED);
            ListVO tempVO = arrayList.get(i);

            try {
                switch (tempVO.getType()) {
                    case ADDRESSEEINFOMATION:
                        bl.save2File((AddresseeInformationVO) tempVO);
                        break;
                    case DISTRIBUTEINFO:
                        bl.save2File((DistributeVO) tempVO);
                        break;
                    case LOADINGINFO:
                        bl.save2File((LoadingVO) tempVO);
                        break;
                    case ORDER:
                        bl.save2File((OrderVO) tempVO);
                        break;
                    case RECEIPT:
                        bl.save2File((ReceiptVO) tempVO);
                        break;
                    case RECEIVEINFO:
                        bl.save2File((ReceiveVO) tempVO);
                        break;
                    case STOCKIN:
                        bl.save2File((StockInVO) tempVO);
                        break;
                    case STOCKOUT:
                        bl.save2File((StockOutVO) tempVO);
                        break;
                    case TRANSINFO:
                        bl.save2File((TransferVO) tempVO);
                        break;
                    case TRANSARRIVE:
                        bl.save2File((TransferReceiveVO) tempVO);
                        break;

                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                JLabel tip = new JLabel("提示：网络异常");
                tip.setFont(font2);
                JOptionPane.showMessageDialog(null, tip);
            }

            model.setValueAt(String.valueOf(tempVO.getIsCheck()), i, 1);
        }

    }

    private void wait1() {
        int i = listTable.getSelectedRow();
        if (i == -1) {
            JLabel tip = new JLabel("提示：请选择要否决的单据");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else {
            arrayList.get(i).setIsCheck(ListState.REJECTED);
            ListVO tempVO = arrayList.get(i);
            //否决的单据暂时就不要调用逻辑层了，就是说不用存进去了（暂定）
//            try {
//                bl.save2File(tempVO);
//            } catch (RemoteException e) {
//                // TODO Auto-generated catch block
//                JLabel tip = new JLabel("提示：网络异常");
//                tip.setFont(font2);
//                JOptionPane.showMessageDialog(null, tip);
//            }

            model.setValueAt(String.valueOf(tempVO.getIsCheck()), i, 1);
        }
    }

    private void check() {

    }

    private void update() {
        ListblService bl1 = null;
        Iterator<ListVO> itr1 = null;
        try {
            bl1 = new ListController();
            itr1 = bl1.push();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        int cout = 1;
        while (itr1.hasNext()) {
            ListVO vo = itr1.next();
            String[] temp = {String.valueOf(cout), String.valueOf(vo.getIsCheck()), vo.getType().toString()};
            model.setValueAt(temp[0], cout - 1, 0);
            model.setValueAt(temp[1], cout - 1, 1);
            model.setValueAt(temp[2], cout - 1, 2);
            cout++;
        }

        //没有更新JTable啊啊
    }
}