package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.ReceiptPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.ReceiptVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class ReceiptChecking extends ReceiptPanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);
    private ReceiptChecking() {
        super();

        ret = new JLabel(new ImageIcon("images/返回.png"));
        ret.setOpaque(true);
        ret.setBounds(5, 5, 35, 35);
        ret.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                returnTOApproval();
            }

            public void mouseEntered(MouseEvent e) {
                ret.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                ret.setBackground(color);
            }
        });
        this.add(ret);
    }

    public ReceiptChecking(ReceiptVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_date.setText(vo.getReceiptDate());
        jtf_money.setText(vo.getReceiptMoney());
        jtf_courier.setText(vo.getReceiptCourier());

        String str="";
        for(String num:vo.getOrderNum()){
            str+=num+"\n";
        }
        jta_ordernum.setText(str);
    }

    @Override
    protected void performSure() {
        ReceiptVO receipt_vo = new ReceiptVO(jtf_date.getText(), jtf_money.getText(), jtf_courier.getText(),
                ordernumList, ListState.PASSED);
        try {
            ListblService bl = new ListController();
            bl.save2File(receipt_vo);
            bl.afterCheck(receipt_vo);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        ReceiptVO receipt_vo = new ReceiptVO(jtf_date.getText(), jtf_money.getText(), jtf_courier.getText(),
                ordernumList, ListState.PASSED);
        try {
            ListblService bl = new ListController();
            bl.afterCheck(receipt_vo);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            RunTip.makeTip("网络异常", false);
            return;
        }

        returnTOApproval();
    }

    private void returnTOApproval() {
        ret.setBackground(Color.YELLOW);
        ListApprovalPanel.getInstance().removeChecking(this);
    }

}
