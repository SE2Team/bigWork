package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import presentation.financeui.FinanceCostPanel;
import presentation.manageui.ListApprovalPanel;
import util.ListState;
import vo.PaymentVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/28 0028.
 */
public class PaymentChecking extends FinanceCostPanel {
    protected JLabel ret;
    protected Color color = new Color(221, 242, 247);

    private PaymentChecking() {
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
                bl.afterCheck(vo);
            } catch (RemoteException e) {
                RunTip.makeTip("网络异常", false);
                return;
            }
            RunTip.makeTip("保存成功", false);
            returnTOApproval();
        } else if ((!isOk) && isAllEntered.isEntered(costJtf)) {
            RunTip.makeTip("请输入正确格式的信息", false);
        } else if (isOk && !isAllEntered.isEntered(costJtf)) {
            RunTip.makeTip("仍有信息未输入", false);
        } else if (!isOk && !isAllEntered.isEntered(costJtf)) {
            RunTip.makeTip("请输入所有正确格式的信息", false);
        }
    }

    @Override
    protected void performCancel() {
        PaymentVO vo = new PaymentVO(dateTextField.getText().trim(),
                sumTextField.getText().trim(), nameTextField.getText()
                .trim(), numTextField.getText().trim(),
                reasonTextArea.getText().trim(), otherTextArea.getText()
                .trim(), ListState.UNCHECK);
        ListblService bl;
        try {
            bl = new ListController();
//            bl.save2File(vo);
            bl.afterCheck(vo);
        } catch (RemoteException e) {
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
