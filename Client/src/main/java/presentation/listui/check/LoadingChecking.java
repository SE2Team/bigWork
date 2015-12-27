package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.LoadingPanel;
import util.ListState;
import vo.LoadingVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class LoadingChecking extends LoadingPanel{
    private LoadingChecking() {
        super();
    }

    public LoadingChecking(LoadingVO vo){
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
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block

            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font);
        JOptionPane.showMessageDialog(null, tip);
    }
}
