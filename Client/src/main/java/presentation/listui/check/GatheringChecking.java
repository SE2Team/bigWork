package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import presentation.financeui.FinanceSettlePanel;
import presentation.financeui.addSettleDialog;
import util.ListState;
import vo.GatheringVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/29 0029.
 */
public class GatheringChecking extends addSettleDialog {

    private GatheringChecking(FinanceSettlePanel parent) {
        super(parent);
    }

    public GatheringChecking(FinanceSettlePanel parent, GatheringVO vo) {
        super(parent);
        sure.setText("通过");
        cancel.setText("否决");
        jtf_date.setText(vo.getDate());
        jtf_org.setText(vo.getWorkplace());
        jtf_payee.setText(vo.getMan());
        jtf_amount.setText(vo.getMoney());
        jtf_place.setText(vo.getPlace());
    }


    @Override
    protected void performSure() {
        settleJtf = new JTextField[]{jtf_org, jtf_payee,
                jtf_amount, jtf_place};
        boolean isOk = NumExceptioin.isDouble(jtf_amount);
        if (isOk && isAllEntered.isEntered(settleJtf)) {
            GatheringVO vo = new GatheringVO(jtf_date.getText()
                    .trim(), jtf_org.getText().trim(), jtf_payee
                    .getText().trim(), jtf_amount.getText().trim(),
                    jtf_place.getText().trim(), ListState.UNCHECK);
            ListblService bl;
            try {
                bl = new ListController();
                bl.save2File(vo);
            } catch (RemoteException e) {
                JLabel tip = new JLabel("提示：网络异常");
                tip.setFont(font2);
                JOptionPane.showMessageDialog(null, tip);
                return;
            }

            rowContent = new String[]{jtf_date.getText(),
                    jtf_org.getText(), jtf_payee.getText(),
                    jtf_amount.getText(), jtf_place.getText()};
            parent.addAfterConfirm(rowContent);

            dispose();
            JLabel tip = new JLabel("提示：添加成功");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if ((!isOk) && isAllEntered.isEntered(settleJtf)) {
            JLabel tip = new JLabel("提示：请输入正确格式的信息");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if (isOk && !isAllEntered.isEntered(settleJtf)) {
            JLabel tip = new JLabel("提示：仍有信息未输入");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if (!isOk && !isAllEntered.isEntered(settleJtf)) {
            JLabel tip = new JLabel("请输入所有正确格式的信息");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }
    }
}
