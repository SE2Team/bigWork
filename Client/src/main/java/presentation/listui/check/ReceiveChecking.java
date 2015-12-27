package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.ReceivePanel;
import util.ListState;
import vo.ReceiveVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class ReceiveChecking extends ReceivePanel{
    private ReceiveChecking() {
        super();
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
