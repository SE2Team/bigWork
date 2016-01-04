package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.TransferReceivePanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.TransferReceiveVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransferReceiveChecking extends TransferReceivePanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);
    public TransferReceiveChecking() {
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

    public TransferReceiveChecking(TransferReceiveVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
//        jtf_orderNum.setText(vo.getOrderNum());
        jtf_arriveDate.setText(vo.getArriveDate());
        jcb_city.setSelectedItem(vo.getStart());
//        jtf_departure.setText(vo.getStart());
        state.setSelectedItem(vo.getCargoState());
        jtf_CenterNum.setText(vo.getTransferCenterNum());
        jtf_transferNum.setText(vo.getTransferNum());

    }

    @Override
    protected void performSure() {
        TransferReceiveVO vo = new TransferReceiveVO(jtf_arriveDate.getText(),
                jcb_city.getSelectedItem().toString(), state.getSelectedItem().toString(),
                jtf_CenterNum.getText(), jl_num.getText() + jtf_transferNum.getText(), ListState.PASSED);

        try {
            ListblService bl = new ListController();
            bl.save2File(vo);
            bl.afterCheck(vo);
        } catch (RemoteException e) {
            RunTip.makeTip("网络异常", false);
            return;
        }
        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        TransferReceiveVO vo = new TransferReceiveVO(jtf_arriveDate.getText(),
                jtf_departure.getText(), state.getSelectedItem().toString(),
                jtf_CenterNum.getText(), jtf_transferNum.getText(), ListState.PASSED);

        try {
            ListblService bl = new ListController();
            bl.afterCheck(vo);
        } catch (RemoteException e) {
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
