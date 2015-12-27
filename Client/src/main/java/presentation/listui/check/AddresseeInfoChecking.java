package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.AddresseeInfoPanel;
import util.ListState;
import vo.AddresseeInformationVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class AddresseeInfoChecking extends AddresseeInfoPanel{
    public AddresseeInfoChecking() {
        super();
    }

    public AddresseeInfoChecking(AddresseeInformationVO vo){
        this();
        jb1.setText("通过");
        jb2.setText("否决");
        jtf_receiveNum.setText(vo.getAddresseeNum());
        jtf_receiver.setText(vo.getAddresseeName());
        jtf_receiveDate.setText(vo.getAddresseeDate());

    }

    @Override
    protected void performJb1() {
        AddresseeInformationVO addressInfo_vo = new AddresseeInformationVO(
                jtf_receiveNum.getText(), jtf_receiver.getText(),
                jtf_receiveDate.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(addressInfo_vo);
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
