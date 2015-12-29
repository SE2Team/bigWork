package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import presentation.financeui.FinanceCostPanel;
import util.ListState;
import vo.PaymentVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/28 0028.
 */
public class PaymentChecking extends FinanceCostPanel {
    private PaymentChecking() {
        super();
    }

    public PaymentChecking(PaymentVO vo) {
        this();
        sure.setText("通过");
        cancel.setText("否决");
        dateTextField.setText(vo.getPayDate());
        sumTextField.setText(vo.getPayMoney());
        nameTextField.setText(vo.getPayHuman());
        numTextField.setText(vo.getPayAccount());
        reasonTextArea.setText(vo.getPayReason());
        otherTextArea.setText(vo.getPayComment());
    }

    @Override
    protected void performSure() {
        boolean isOk = NumExceptioin.isBankNumValid(numTextField)
                && NumExceptioin.isDouble(sumTextField);
        if (isOk && isAllEntered.isEntered(costJtf)) {
            PaymentVO vo = new PaymentVO(dateTextField.getText().trim(),
                    sumTextField.getText().trim(), nameTextField.getText()
                    .trim(), numTextField.getText().trim(),
                    reasonTextArea.getText().trim(), otherTextArea.getText()
                    .trim(), ListState.UNCHECK);
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
            JLabel tip = new JLabel("提示：保存成功");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if ((!isOk) && isAllEntered.isEntered(costJtf)) {
            JLabel tip = new JLabel("提示：请输入正确格式的信息");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if (isOk && !isAllEntered.isEntered(costJtf)) {
            JLabel tip = new JLabel("提示：仍有信息未输入");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        } else if (!isOk && !isAllEntered.isEntered(costJtf)) {
            JLabel tip = new JLabel("请输入所有正确格式的信息");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }
    }
}
