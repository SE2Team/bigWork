package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.TransferReceivePanel;
import vo.TransferReceiveVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransferReceiveChecking extends TransferReceivePanel{
    public TransferReceiveChecking() {
        super();
    }

    public TransferReceiveChecking(TransferReceiveVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_orderNum.setText(vo.getOrderNum());
        jtf_arriveDate.setText(vo.getArriveDate());
        jtf_departure.setText(vo.getStart());
        state.setSelectedItem(vo.getCargoState());
        jtf_CenterNum.setText(vo.getTransferCenterNum());
        jtf_transferNum.setText(vo.getTransferNum());

    }

    @Override
    protected void performSure() {
        TransferReceiveVO vo = new TransferReceiveVO(jtf_orderNum.getText(),jtf_arriveDate.getText(),
                jtf_departure.getText(), state.getSelectedItem().toString(),
                jtf_CenterNum.getText(), jtf_transferNum.getText(), false);

        try {
            ListblService bl = new ListController();
            bl.transArrive(vo);
        } catch (RemoteException e) {
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }
        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font);
        JOptionPane.showMessageDialog(null, tip);
    }
}
