package presentation.manageui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.check.*;
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
    private static ListApprovalPanel ME = null;

    int width = 100, height = 20;
    private JButton waitButton;
    private JButton checkButton;
    private JButton passButton;
    private JButton updateButton;
    ListblService bl = null;

    private JScrollPane jsp;
    private JTable listTable;
    private DefaultTableModel model;
    private String listType = null;
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
            String[] temp = {String.valueOf(cout), cCheck(String.valueOf(vo.getIsCheck())), cType(vo.getType().toString())};
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

        ME = this;

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
                        bl.afterCheck((AddresseeInformationVO) tempVO);
                        break;
                    case DISTRIBUTEINFO:
                        bl.save2File((DistributeVO) tempVO);
                        bl.afterCheck((DistributeVO) tempVO);
                        break;
                    case LOADINGINFO:
                        bl.save2File((LoadingVO) tempVO);
                        bl.afterCheck((OrderVO) tempVO);
                        break;
                    case ORDER:
                        bl.save2File((OrderVO) tempVO);
                        bl.afterCheck((OrderVO) tempVO);
                        break;
                    case RECEIPT:
                        bl.save2File((ReceiptVO) tempVO);
                        bl.afterCheck((ReceiptVO) tempVO);
                        break;
                    case RECEIVEINFO:
                        bl.save2File((ReceiveVO) tempVO);
                        bl.afterCheck((ReceiveVO) tempVO);
                        break;
                    case STOCKIN:
                        bl.save2File((StockInVO) tempVO);
                        bl.afterCheck((StockInVO) tempVO);
                        break;
                    case STOCKOUT:
                        bl.save2File((StockOutVO) tempVO);
                        bl.afterCheck((StockOutVO) tempVO);
                        break;
                    case TRANSINFO:
                        bl.save2File((TransferVO) tempVO);
                        bl.afterCheck((TransferVO) tempVO);
                        break;
                    case TRANSARRIVE:
                        bl.save2File((TransferReceiveVO) tempVO);
                        bl.afterCheck((TransferReceiveVO) tempVO);
                        break;
                    case PAYMENT:
                        bl.save2File((PaymentVO) tempVO);
                        bl.afterCheck((PaymentVO) tempVO);
                        break;
                    case GATHERING:
                        bl.save2File((GatheringVO) tempVO);
                        bl.afterCheck((GatheringVO) tempVO);
                        break;

                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                JLabel tip = new JLabel("提示：网络异常");
                tip.setFont(font2);
                JOptionPane.showMessageDialog(null, tip);
            }

            model.setValueAt(cCheck(String.valueOf(tempVO.getIsCheck())), i, 1);
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
            try {
                switch (tempVO.getType()) {
                    case ADDRESSEEINFOMATION:
                        bl.afterCheck((AddresseeInformationVO) tempVO);
                        break;
                    case DISTRIBUTEINFO:
                        bl.afterCheck((DistributeVO) tempVO);
                        break;
                    case LOADINGINFO:
                        bl.afterCheck((OrderVO) tempVO);
                        break;
                    case ORDER:
                        bl.afterCheck((OrderVO) tempVO);
                        break;
                    case RECEIPT:
                        bl.afterCheck((ReceiptVO) tempVO);
                        break;
                    case RECEIVEINFO:
                        bl.afterCheck((ReceiveVO) tempVO);
                        break;
                    case STOCKIN:
                        bl.afterCheck((StockInVO) tempVO);
                        break;
                    case STOCKOUT:
                        bl.afterCheck((StockOutVO) tempVO);
                        break;
                    case TRANSINFO:
                        bl.afterCheck((TransferVO) tempVO);
                        break;
                    case TRANSARRIVE:
                        bl.afterCheck((TransferReceiveVO) tempVO);
                        break;
                    case PAYMENT:
                        bl.afterCheck((PaymentVO) tempVO);
                        break;
                    case GATHERING:
                        bl.afterCheck((GatheringVO) tempVO);
                        break;

                }
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                JLabel tip = new JLabel("提示：网络异常");
                tip.setFont(font2);
                JOptionPane.showMessageDialog(null, tip);
            }
            model.setValueAt(cCheck(String.valueOf(tempVO.getIsCheck())), i, 1);
        }
    }

    OrderVO ordervo = null;
    AddresseeInformationVO addresseevo = null;
    LoadingVO loadingvo = null;
    ReceiveVO recvo = null;
    DistributeVO disvo = null;
    ReceiptVO receiptvo = null;
    StockInVO invo = null;
    StockOutVO outvo = null;
    TransferVO transferVo = null;
    TransferReceiveVO transRecVo = null;
    GatheringVO gatheringVo = null;
    PaymentVO paymentVo = null;
    //5
    public void check() {
        int i = listTable.getSelectedRow();
        if (i == -1) {
            JLabel tip = new JLabel("提示：请选中要查看的单据");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else {
            Object type = model.getValueAt(i, 2);
            ListVO tempVO = arrayList.get(i);
            switch (tempVO.getType()) {
                case ADDRESSEEINFOMATION:
                    addresseevo = (AddresseeInformationVO) tempVO;
                    break;
                case DISTRIBUTEINFO:
                    disvo = (DistributeVO) tempVO;
                    break;
                case LOADINGINFO:
                    loadingvo = (LoadingVO) tempVO;
                    break;
                case ORDER:
                    ordervo = (OrderVO) tempVO;
                    break;
                case RECEIPT:
                    receiptvo = (ReceiptVO) tempVO;
                    break;
                case RECEIVEINFO:
                    recvo = (ReceiveVO) tempVO;
                    break;
                case STOCKIN:
                    invo = (StockInVO) tempVO;
                    break;
                case STOCKOUT:
                    outvo = (StockOutVO) tempVO;
                    break;
                case TRANSINFO:
                    transferVo = (TransferVO) tempVO;
                    break;
                case TRANSARRIVE:
                    transRecVo = (TransferReceiveVO) tempVO;
                    break;
                case PAYMENT:
                    paymentVo = (PaymentVO) tempVO;
                    break;
                case GATHERING:
                    gatheringVo = (GatheringVO) tempVO;
                    break;
            }
            listType = type.toString();
            if ("订单".equals(listType)) addPanel(new OrderChecking(ordervo));
            if ("收件单".equals(listType)) addPanel(new AddresseeInfoChecking(addresseevo));
            if ("装车单".equals(listType)) addPanel(new LoadingChecking(loadingvo));
            if ("接收单".equals(listType)) addPanel(new ReceiveChecking(recvo));
            if ("派件单".equals(listType)) addPanel(new DistributeChecking(disvo));
            if ("快递员收款单".equals(listType)) addPanel(new ReceiptChecking(receiptvo));
            if ("中转单".equals(listType)) addPanel(new TransferChecking(transferVo));
            if ("中转中心到达单".equals(listType)) addPanel(new TransferReceiveChecking(transRecVo));
            if ("库存入库单".equals(listType)) addPanel(new StockInChecking(invo));
            if ("库存出库单".equals(listType)) addPanel(new StockOutChecking(outvo));
        }
    }

    private void update() {
        DefaultTableModel model1;
        String[] column1 = {"序号", "审批状态", "单据类型"};
        String row1[][] = new String[50][3];
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
            String[] temp = {String.valueOf(cout), cCheck(String.valueOf(vo.getIsCheck())), cType(vo.getType().toString())};
            row1[cout - 1] = temp;
            cout++;
        }
        model1 = new DefaultTableModel(row1, column1);
        listTable.setModel(model1);
//    	for(int i=0;i<arrayList.size();i++){
//    		ListVO tempvo = arrayList.get(i);
//    		String[] temp= {String.valueOf(i+1), cCheck(String.valueOf(tempvo.getIsCheck())), cType(tempvo.getType().toString())};
//    		model.setValueAt(temp[0], i, 0);
//    		model.setValueAt(temp[1], i, 1);
//    		model.setValueAt(temp[2], i, 2);
//    	}
        listTable.updateUI();
        //没有更新JTable啊啊
    }

    private String cCheck(String str) {
        if (str.equals("UNCHECK")) {
            return "未审批";
        } else if (str.equals("REJECTED")) {
            return "已否决";
        } else {
            return "已通过";
        }
    }

    private String cType(String str) {
        if (str.equals("ADDRESSEEINFOMATION")) {
            return "收件单";
        } else if (str.equals("DISTRIBUTEINFO")) {
            return "派件单";
        } else if (str.equals("LOADINGINFO")) {
            return "装车单";
        } else if (str.equals("ORDER")) {
            return "订单";
        } else if (str.equals("RECEIPT")) {
            return "营业厅收款单";
        } else if (str.endsWith("RECEIVEINFO")) {
            return "接收单";
        } else if (str.equals("STOCKIN")) {
            return "库存入库单";
        } else if (str.endsWith("STOCKOUT")) {
            return "库存出库单";
        } else if (str.equals("TRANSINFO")) {
            return "中转中心中转单";
        } else if (str.endsWith("TRANSARRIVE")) {
            return "中转中心到达单";
        } else if (str.equals("PAYMENT")) {
            return "付款单";
        } else if (str.endsWith("GATHERING")) {
            return "财务收款单";
        } else {
            return "";
        }
    }

    private void addPanel(JPanel panel) {
        this.setUnvisible();
        panel.setBounds(0, 0, 650, 530);
        this.add(panel);
        repaint();
    }

    private void removePanel(JPanel panel) {
        this.remove(panel);
        this.setvisible();
        repaint();
    }

    private void setUnvisible() {
        waitButton.setVisible(false);
        checkButton.setVisible(false);
        passButton.setVisible(false);
        updateButton.setVisible(false);
        jsp.setVisible(false);
    }

    private void setvisible() {
        waitButton.setVisible(true);
        checkButton.setVisible(true);
        passButton.setVisible(true);
        updateButton.setVisible(true);
        jsp.setVisible(true);
    }


    public String getType() {
        return listType;
    }

    public static ListApprovalPanel getInstance() {
        return ME;

    }

    public void removeChecking(JPanel jp) {
        removePanel(jp);
        update();
    }


}