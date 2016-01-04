package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.ReceivePanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.ReceiveVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class ReceiveChecking extends ReceivePanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);
    private ReceiveChecking() {
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
    public ReceiveChecking(ReceiveVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_arriveDate.setText(vo.getArriveDate());
        jtf_transferNum.setText(vo.getTransferNum());
        jtf_departure.setText(vo.getStart());
        jcb_arrivestate.setSelectedItem(vo.getArriveState());
    }

    @Override
    protected void performSure() {
        ReceiveVO receive_vo = new ReceiveVO(jtf_arriveDate.getText(),
                jtf_transferNum.getText(), jtf_departure.getText(),
                jcb_arrivestate.getSelectedItem().toString(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(receive_vo);
            bl.afterCheck(receive_vo);
        } catch (RemoteException e1) {
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        ReceiveVO receive_vo = new ReceiveVO(jtf_arriveDate.getText(),
                jtf_transferNum.getText(), jtf_departure.getText(),
                jcb_arrivestate.getSelectedItem().toString(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.afterCheck(receive_vo);
        } catch (RemoteException e1) {
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
