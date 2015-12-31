package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.DistributePanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.DistributeVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class DistributeChecking extends DistributePanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);

    public DistributeChecking() {
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

    public DistributeChecking(DistributeVO vo) {
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_arriveDate.setText(vo.getArriveDate());
        jtf_orderNum.setText(vo.getOrderNum());
        jtf_distributeHuman.setText(vo.getDistributeHuman());
    }

    @Override
    protected void performSure() {
        DistributeVO dis_vo = new DistributeVO(
                jtf_arriveDate.getText(), jtf_orderNum.getText(),
                jtf_distributeHuman.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(dis_vo);
            bl.afterCheck(dis_vo);
        } catch (RemoteException e1) {
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();

    }

    @Override
    protected void performCancel() {
        DistributeVO dis_vo = new DistributeVO(
                jtf_arriveDate.getText(), jtf_orderNum.getText(),
                jtf_distributeHuman.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
//            bl.save2File(dis_vo);
            bl.afterCheck(dis_vo);
        } catch (RemoteException e1) {
            RunTip.makeTip("网络异常", false);
            return;
        }
        returnTOApproval();
    }

    private void returnTOApproval() {
        ret.setBackground(Color.YELLOW);
//				ListApprovalPanel list = new ListApprovalPanel();
        ListApprovalPanel.getInstance().removeChecking(this);
    }
}
