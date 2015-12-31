package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.StockInPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.StockInVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/8 0008.
 */
public class StockInChecking extends StockInPanel {
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);
    public StockInChecking() {
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
    public StockInChecking(StockInVO vo){
        this();
        jtf_deliveryNum.setText(vo.getDeliveryNum());
        jtf_inDate.setText(vo.getInDate());
        jtf_destination.setText(vo.getEnd());
        jtf_zoneNum.setText(vo.getZoneNum());
        jtf_rowNum.setText(vo.getRowNum());
        jtf_shelfNum.setText(vo.getShelfNum());
        jtf_positionNum.setText(vo.getPositionNum());
        sure.setText("通过");
        cancel.setText("否决");

    }

    @Override
    protected void performSure() {
        StockInVO in_vo = new StockInVO(jtf_deliveryNum.getText(),
                jtf_inDate.getText(), jtf_destination.getText(),
                jtf_zoneNum.getText(), jtf_rowNum.getText(),
                jtf_shelfNum.getText(), jtf_positionNum.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(in_vo);
            bl.afterCheck(in_vo);
        } catch (RemoteException e1) {
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performCancel() {
        super.performCancel();
        StockInVO in_vo = new StockInVO(jtf_deliveryNum.getText(),
                jtf_inDate.getText(), jtf_destination.getText(),
                jtf_zoneNum.getText(), jtf_rowNum.getText(),
                jtf_shelfNum.getText(), jtf_positionNum.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.afterCheck(in_vo);
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
