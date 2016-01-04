package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.listui.AddresseeInfoPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.AddresseeInformationVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class AddresseeInfoChecking extends AddresseeInfoPanel{
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);

    public AddresseeInfoChecking() {
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
            bl.afterCheck(addressInfo_vo);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            RunTip.makeTip("网络异常", false);
            return;
        }

        RunTip.makeTip("保存成功", true);
        returnTOApproval();
    }

    @Override
    protected void performJb2() {
        AddresseeInformationVO addressInfo_vo = new AddresseeInformationVO(
                jtf_receiveNum.getText(), jtf_receiver.getText(),
                jtf_receiveDate.getText(), ListState.PASSED);
        ListblService bl;
        try {
            bl = new ListController();
            bl.save2File(addressInfo_vo);
            bl.afterCheck(addressInfo_vo);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
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
