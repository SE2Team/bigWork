package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.ReceiptPanel;
import vo.ReceiptVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class ReceiptChecking extends ReceiptPanel{
    private ReceiptChecking() {
        super();
    }

    public ReceiptChecking(ReceiptVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_date.setText(vo.getReceiptDate());
        jtf_money.setText(vo.getReceiptMoney());
        jtf_courier.setText(vo.getReceiptCourier());
        jta_ordernum.setText(vo.getOrderNum());
    }

    @Override
    protected void performSure() {
        ReceiptVO receipt_vo = new ReceiptVO(jtf_date.getText(), jtf_money.getText(), jtf_courier.getText(),
                jta_ordernum.getText(),false);
        try {
            ListblService bl = new ListController();
            bl.receipt(receipt_vo);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font);
        JOptionPane.showMessageDialog(null, tip);
    }
}
