package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.StockOutPanel;
import util.TransportType;
import vo.StockOutVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class StockOutChecking extends StockOutPanel{
    private StockOutChecking() {
        super();
    }

    public StockOutChecking(StockOutVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jtf_deliveryNum.setText(vo.getDeliveryNum());
        jtf_outDate.setText(vo.getOutDate());
        jtf_destination.setText(vo.getEnd());
        jtf_transferNum.setText(vo.getTransferNum());
        jcb_loadingWay.setSelectedItem("火车");//。。。。。全是火车
    }

    @Override
    protected void performSure() {
        // jcb_loadingWay.getSelectedItem().toString()
        StockOutVO out_vo = new StockOutVO(jtf_deliveryNum.getText(),
                jtf_outDate.getText(), jtf_destination.getText(),
                TransportType.TRAIN, jtf_transferNum.getText(),false);
        ListblService bl;
        try {
            bl = new ListController();
            bl.stockOut(out_vo);
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
