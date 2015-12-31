/**
 * 中转中心业务员中转接收界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ListState;
import vo.TransferReceiveVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class TransferReceivePanel extends JPanel {

    protected int x = 30, y = 60, addx1 = 130, addx2 = 180, addy = 100,
            width = 130, height = 30;

    // 定义中转中心编号，到达日期，中转单编号，出发地，货物到达状态的label
    protected JLabel transferCenterNum, arriveDate, transferNum, departure,
            arriveState;
    // 定义对应的文本框
    protected JTextField jtf_CenterNum, jtf_arriveDate, jtf_transferNum,
            jtf_departure;
    // 定义下拉框
    protected JComboBox state;
    // 定义确定 取消按钮
    protected JButton sure, cancel;
    // 定义文本框下拉框按钮的字体
    protected Font font = new Font("宋体", Font.PLAIN, 20);
    protected Font font2 = new Font("宋体", Font.PLAIN, 18);
    // 定义错误提示信息的label
    protected JLabel tip1, tip2;
    // 定义日期选择器
    protected DateChooser datechooser;
    // 定义文本框的数组
    protected JTextField[] transReceiveJtf;

    public TransferReceivePanel() {

        this.setLayout(null);

        transferCenterNum = new JLabel("中转中心编号", JLabel.CENTER);
        transferCenterNum.setFont(font);
        transferCenterNum.setBounds(x, y, width, height);

        jtf_CenterNum = new JTextField();
        jtf_CenterNum.setFont(font2);
        jtf_CenterNum.setBounds(x + addx1, y, width, height);
        jtf_CenterNum.addFocusListener(new TextFocus());

        arriveDate = new JLabel("到达日期", JLabel.CENTER);
        arriveDate.setFont(font);
        arriveDate.setBounds(x + addx1 + addx2, y, width, height);

        jtf_arriveDate = new JTextField();
        jtf_arriveDate.setFont(font2);
        jtf_arriveDate.setEditable(false);
        jtf_arriveDate.setBounds(x + 2 * addx1 + addx2, y, width - 30, height);

        datechooser = new DateChooser("yyyy-MM-dd", jtf_arriveDate);
        datechooser
                .setBounds(x + 2 * addx1 + addx2 + width - 30, y, 30, height);
        jtf_arriveDate.setText(datechooser.commit());
        datechooser.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        transferNum = new JLabel("中转单编号", JLabel.CENTER);
        transferNum.setFont(font);
        transferNum.setBounds(x, y + addy, 2 * width, height);

        jtf_transferNum = new JTextField();
        jtf_transferNum.setFont(font2);
        jtf_transferNum.setBounds(x + 2 * addx1, y + addy, 2 * width, height);
        jtf_transferNum.addFocusListener(new TextFocus());

        departure = new JLabel("出发地", JLabel.CENTER);
        departure.setFont(font);
        departure.setBounds(x, y + 2 * addy, width, height);

        jtf_departure = new JTextField();
        jtf_departure.setFont(font2);
        jtf_departure.setBounds(x + addx1, y + 2 * addy, width, height);

        arriveState = new JLabel("货物到达状态", JLabel.CENTER);
        arriveState.setFont(font);
        arriveState.setBounds(x + addx1 + addx2, y + 2 * addy, width, height);

        state = new JComboBox();
        state.addItem("完整");
        state.addItem("损坏");
        state.addItem("丢失");
        state.setFont(font);
        state.setBounds(x + 2 * addx1 + addx2, y + 2 * addy, width, height);

        sure = new JButton("确定");
        sure.setFont(font);
        sure.setBounds(x + 150, y + 3 * addy, 80, height);
        sure.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                performSure();
            }

        });

        transReceiveJtf = new JTextField[]{jtf_CenterNum, jtf_transferNum,
                jtf_departure};

        cancel = new JButton("取消");
        cancel.setFont(font);
        cancel.setBounds(x + addx2 + 150, y + 3 * addy, 80, height);
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                performCancel();
            }
        });

        this.add(transferCenterNum);
        this.add(jtf_CenterNum);
        this.add(arriveDate);
        this.add(jtf_arriveDate);
        this.add(datechooser);
        this.add(transferNum);
        this.add(jtf_transferNum);
        this.add(departure);
        this.add(jtf_departure);
        this.add(arriveState);
        this.add(state);
        this.add(sure);
        this.add(cancel);
    }

    protected void performCancel() {
        Empty emptyLoading = new Empty(transReceiveJtf);
    }

    // 错误提示信息是否已经被添加
    boolean isCenterNumAdd = false;
    boolean isTransAdd = false;

    /**
     * 监听焦点
     *
     * @author Administrator
     */
    class TextFocus implements FocusListener {

        public void focusGained(FocusEvent arg0) {
            // TODO Auto-generated method stub

        }

        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            JTextField temp = (JTextField) e.getSource();
            if (temp == jtf_CenterNum) {
                if (!NumExceptioin.isTransCenterValid(jtf_CenterNum)) {
                    isCenterNumAdd = true;
                    if (tip1 == null) {
                        tip1 = new JLabel("中转中心编号位数应为4位", JLabel.CENTER);
                        tip1.setBounds(x + 70, y + height, 2 * width, height);
                        tip1.setFont(font2);
                        tip1.setForeground(Color.RED);
                        addTip(tip1);
                    }
                } else {
                    if (isCenterNumAdd
                            && !"".equalsIgnoreCase(jtf_CenterNum.getText()
                            .trim())) {
                        isCenterNumAdd = false;
                        removeTip(tip1);
                        tip1 = null;
                    }
                }
            }
            if (temp == jtf_transferNum) {
                if (!NumExceptioin.isTransListValid(jtf_transferNum)) {
                    isTransAdd = true;
                    if (tip2 == null) {
                        tip2 = new JLabel("中转单编号位数应为19位", JLabel.CENTER);
                        tip2.setBounds(x + 2 * addx1, y + addy + height,
                                2 * width, height);
                        tip2.setFont(font2);
                        tip2.setForeground(Color.RED);
                        addTip(tip2);
                    }
                } else {
                    if (isTransAdd
                            && !"".equalsIgnoreCase(jtf_transferNum.getText()
                            .trim())) {
                        isTransAdd = false;
                        removeTip(tip2);
                        tip2 = null;
                    }
                }
            }
        }

    }

    protected void performSure() {
        boolean isOk = NumExceptioin.isTransCenterValid(jtf_CenterNum)
                && NumExceptioin.isTransListValid(jtf_transferNum);
        if (isOk && isAllEntered.isEntered(transReceiveJtf)) {
            TransferReceiveVO vo = new TransferReceiveVO(jtf_arriveDate.getText(),
                    jtf_departure.getText(), state.getSelectedItem().toString(),
                    jtf_CenterNum.getText(), jtf_transferNum.getText(), ListState.UNCHECK);

            try {
                ListblService bl = new ListController();
                bl.save(vo);
            } catch (RemoteException e) {
                RunTip.makeTip("网络异常", false);
            }
            RunTip.makeTip("保存成功", true);
        } else if ((!isOk) && isAllEntered.isEntered(transReceiveJtf)) {
            RunTip.makeTip("请输入正确格式的信息", false);
        } else if (isOk && !isAllEntered.isEntered(transReceiveJtf)) {
            RunTip.makeTip("仍有信息未输入", false);
        } else if (!isOk && !isAllEntered.isEntered(transReceiveJtf)) {
            RunTip.makeTip("请输入所有正确格式的信息", false);
        }

    }

    /**
     * 添加错误提示信息
     *
     * @param tip
     */
    public void addTip(JLabel tip) {
        this.add(tip);
        this.repaint();
    }

    /**
     * 移除错误提示信息
     *
     * @param tip
     */
    public void removeTip(JLabel tip) {
        this.remove(tip);
        this.repaint();
    }
}
