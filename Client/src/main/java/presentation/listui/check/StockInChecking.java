package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.StockInPanel;
import util.ListState;
import vo.StockInVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/8 0008.
 */
public class StockInChecking extends StockInPanel {
    public StockInChecking() {
        super();
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
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font2);
        JOptionPane.showMessageDialog(null, tip);
    }
}
