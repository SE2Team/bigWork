package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.TransferPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.TransferVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransferChecking extends TransferPanel {
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);

    private TransferChecking() {
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

    public TransferChecking(TransferVO vo) {
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jcb_way.setSelectedItem(vo.getLoadingWay());
        jtf_loadingDate.setText(vo.getLoadingDate());
        jtf_transferNum.setText(vo.getTransportNum());
        jtf_vehicleNum.setText(vo.getVehicleNum());
        jtf_start.setText(vo.getStart());
        jtf_end.setText(vo.getEnd());
        jtf_containerNum.setText(vo.getContainerNum());
        jtf_monitor.setText(vo.getMonitor());
        jtf_supercargo.setText(vo.getSupercargo());
        jta_orderNums.setText(vo.getOrderNum());
        jtf_money.setText(vo.getMoney());

    }

    @Override
    protected void performSure() {
        TransferVO transfervo = new TransferVO(jcb_way
                .getSelectedItem().toString(), jtf_loadingDate
                .getText(), jtf_transferNum.getText(), jtf_vehicleNum
                .getText(), jtf_start.getText(), jtf_end.getText(),
                jtf_containerNum.getText(), jtf_monitor.getText(),
                jtf_supercargo.getText(), jta_orderNums.getText(),
                jtf_money.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(transfervo);
            bl.afterCheck(transfervo);
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
        TransferVO transfervo = new TransferVO(jcb_way
                .getSelectedItem().toString(), jtf_loadingDate
                .getText(), jtf_transferNum.getText(), jtf_vehicleNum
                .getText(), jtf_start.getText(), jtf_end.getText(),
                jtf_containerNum.getText(), jtf_monitor.getText(),
                jtf_supercargo.getText(), jta_orderNums.getText(),
                jtf_money.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.afterCheck(transfervo);
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
