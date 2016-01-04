package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.StockOutPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import util.TransportType;
import vo.StockOutVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class StockOutChecking extends StockOutPanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);
    private StockOutChecking() {
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

    public StockOutChecking(StockOutVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_deliveryNum.setText(vo.getDeliveryNum());
        jtf_outDate.setText(vo.getOutDate());
        jcb_destination.setSelectedItem(vo.getEnd());
        jtf_transferNum.setText(vo.getTransferNum());
        jcb_loadingWay.setSelectedItem("火车");//。。。。。全是火车
    }

    @Override
    protected void performSure() {
        // jcb_loadingWay.getSelectedItem().toString()
        StockOutVO out_vo = new StockOutVO(jtf_deliveryNum.getText(),
                jtf_outDate.getText(), jcb_destination.getSelectedItem().toString(),
                TransportType.TRAIN, jtf_transferNum.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(out_vo);
            bl.afterCheck(out_vo);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        StockOutVO out_vo = new StockOutVO(jtf_deliveryNum.getText(),
                jtf_outDate.getText(), jcb_destination.getSelectedItem().toString(),
                TransportType.TRAIN, jtf_transferNum.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.afterCheck(out_vo);
        } catch (RemoteException e1) {
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
