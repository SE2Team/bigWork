package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.DistributePanel;
import util.ListState;
import vo.DistributeVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class DistributeChecking extends DistributePanel{
    private DistributeChecking() {
        super();
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
            bl.save(dis_vo);
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
