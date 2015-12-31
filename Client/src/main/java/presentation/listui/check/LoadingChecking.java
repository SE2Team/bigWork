package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.LoadingPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.LoadingVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class LoadingChecking extends LoadingPanel {
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);

    public LoadingChecking() {
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

    public LoadingChecking(LoadingVO vo) {
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_loadingDate.setText(vo.getLoadingDate());
        jtf_hallNum.setText(vo.getHallNum());
        jtf_transportNum.setText(vo.getTransportNum());
        jtf_start.setText(vo.getStart());
        jtf_end.setText(vo.getEnd());
        jtf_monitor.setText(vo.getMonitor());
        jtf_supercargo.setText(vo.getSupercargo());
        jtf_vehicleNum.setText(vo.getVehicleNum());
        jta_consignList.setText(vo.getConsignList());
        jtf_Money.setText(vo.getTransportMoney());
    }

    @Override
    protected void performSure() {
        LoadingVO loading_vo = new LoadingVO(jtf_loadingDate.getText(),
                jtf_hallNum.getText(), jtf_transportNum.getText(),
                jtf_start.getText(), jtf_end.getText(), jtf_monitor
                .getText(), jtf_supercargo.getText(),
                jtf_vehicleNum.getText(), jta_consignList.getText(),
                jtf_Money.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(loading_vo);
            bl.afterCheck(loading_vo);
        } catch (RemoteException e1) {
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        LoadingVO loading_vo = new LoadingVO(jtf_loadingDate.getText(),
                jtf_hallNum.getText(), jtf_transportNum.getText(),
                jtf_start.getText(), jtf_end.getText(), jtf_monitor
                .getText(), jtf_supercargo.getText(),
                jtf_vehicleNum.getText(), jta_consignList.getText(),
                jtf_Money.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
//            bl.save2File(loading_vo);
            bl.afterCheck(loading_vo);
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
