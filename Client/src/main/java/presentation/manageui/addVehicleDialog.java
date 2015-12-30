/*
 * 营业厅业务员添加车辆信息
 */
package presentation.manageui;

import businesslogic.financebl.FinanceController;
import businesslogic.managebl.ManageController;
import businesslogicservice.FinanceblService;
import businesslogicservice.ManageblService;
import presentation.commonui.DateChooser;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.MyDialog;
import presentation.exception.NumExceptioin;
import presentation.financeui.FinanceInitialPanel;
import util.ExistException;
import vo.VehicleVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class addVehicleDialog extends MyDialog {
    // 错误提示信息是否已经被添加
    boolean isVehicleNumAdd = false;
    boolean isLicenseAdd = false;
    boolean isUsetimeAdd = false;
    private VehiclePanel parent;
    private FinanceInitialPanel parent2;
    private int x = 40, y = 60, addx = 110, addy = 55, jl_width = 100,
            jtf_width = 200, height = 25;
    // 设置所有文字的字体
    private Font font = new Font("宋体", Font.PLAIN, 20);
    private Font font2 = new Font("宋体", Font.PLAIN, 18);
    // 定义添加车辆信息，车辆代号，车牌号，购买时间，服役时间的label
    private JLabel addInfo, vehicleNum, licensePlate, buyDate, useTime;
    // 定义对应的文本框
    private JTextField jtf_vehicleNum, jtf_licensePlate, jtf_buyDate,
            jtf_useTime;
    // 定义确定，取消按钮
    private JButton sure, cancel;
    // 定义错误提示信息的label
    private JLabel tip1, tip2, tip3;
    // 定义用来存放用户输入信息的数组
    private String[] rowContent;
    // 定义文本框的数组
    private JTextField[] vehicleJtf;
    // 定义日期选择器
    private DateChooser datechooser;

    public addVehicleDialog(VehiclePanel parent) {
        super();

        this.parent = parent;
        this.setContentPane(new addVehiclePanel(parent));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public addVehicleDialog(FinanceInitialPanel parent) {
        super();

        this.parent2 = parent;
        this.setContentPane(new addVehiclePanel(parent2));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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

    class addVehiclePanel extends JPanel {

        addVehiclePanel(final JPanel jp) {
            this.setLayout(null);

            addInfo = new JLabel("添加车辆信息", JLabel.CENTER);
            addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
            addInfo.setBounds(100, 10, jtf_width, height);

            vehicleNum = new JLabel("车辆代号", JLabel.CENTER);
            vehicleNum.setFont(font);
            vehicleNum.setBounds(x, y, jl_width, height);

            jtf_vehicleNum = new JTextField();
            jtf_vehicleNum.setFont(font2);
            jtf_vehicleNum.setBounds(x + addx, y, jtf_width, height);
            jtf_vehicleNum.addFocusListener(new TextFocus());

            licensePlate = new JLabel("车牌号", JLabel.CENTER);
            licensePlate.setFont(font);
            licensePlate.setBounds(x, y + addy, jl_width, height);

            jtf_licensePlate = new JTextField();
            jtf_licensePlate.setFont(font2);
            jtf_licensePlate.setBounds(x + addx, y + addy, jtf_width, height);
            jtf_licensePlate.addFocusListener(new TextFocus());

            buyDate = new JLabel("购买时间", JLabel.CENTER);
            buyDate.setFont(font);
            buyDate.setBounds(x, y + 2 * addy, jl_width, height);

            jtf_buyDate = new JTextField();
            jtf_buyDate.setFont(font2);
            jtf_buyDate.setEditable(false);
            jtf_buyDate.setBounds(x + addx, y + 2 * addy, jtf_width - 30,
                    height);

            datechooser = new DateChooser("yyyy-MM-dd", jtf_buyDate);
            datechooser.setBounds(x + addx + jtf_width - 30, y + 2 * addy, 30,
                    height);
            jtf_buyDate.setText(datechooser.commit());
            datechooser.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            });

            useTime = new JLabel("服役时间", JLabel.CENTER);
            useTime.setFont(font);
            useTime.setBounds(x, y + 3 * addy, jl_width, height);

            jtf_useTime = new JTextField();
            jtf_useTime.setFont(font2);
            jtf_useTime.setBounds(x + addx, y + 3 * addy, jtf_width, height);
            jtf_useTime.addFocusListener(new TextFocus());

            sure = new JButton("确定");
            sure.setFont(font);
            sure.setBounds(80, y + 4 * addy + 10, 80, height);
            sure.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    boolean isOk = NumExceptioin.isVehicleValid(jtf_vehicleNum)
                            && NumExceptioin
                            .islicensePlateValid(jtf_licensePlate)
                            && NumExceptioin.isInt(jtf_useTime);
                    vehicleJtf = new JTextField[]{jtf_vehicleNum,
                            jtf_licensePlate, jtf_useTime};
                    if (isOk && isAllEntered.isEntered(vehicleJtf)) {
                        VehicleVO vehicle_vo = new VehicleVO(jtf_vehicleNum
                                .getText(), jtf_licensePlate.getText(),
                                jtf_buyDate.getText(), jtf_useTime.getText());
                        if (jp == parent) {
                            ManageblService bl;
                            try {
                                bl = new ManageController();
                                try {
                                    bl.addVehicle(vehicle_vo);
                                } catch (ExistException e) {
                                    // TODO Auto-generated catch block
                                    JLabel tip = new JLabel("提示：该车辆信息已存在");
                                    tip.setFont(font2);
                                    JOptionPane.showMessageDialog(null, tip);
                                    return;
                                }
                            } catch (RemoteException e1) {
                                // TODO Auto-generated catch block
                                JLabel tip = new JLabel("提示：网络异常");
                                tip.setFont(font2);
                                JOptionPane.showMessageDialog(null, tip);
                                return;
                            }
                        }
                        if (jp == parent2) {
                            FinanceblService bl;
                            try {
                                bl = new FinanceController();
                                bl.initial(vehicle_vo);
                            } catch (RemoteException e1) {
                                JLabel tip = new JLabel("提示：网络异常");
                                tip.setFont(font2);
                                JOptionPane.showMessageDialog(null, tip);
                                return;
                            }
                        }

                        rowContent = new String[]{jtf_vehicleNum.getText(),
                                jtf_licensePlate.getText(),
                                jtf_buyDate.getText(), jtf_useTime.getText()};
                        if (jp == parent) {
                            parent.addAfterConfirm(rowContent);
                        }
                        if (jp == parent2) {
                            parent2.addVehInfo(rowContent);
                        }

                        dispose();
                        JLabel tip = new JLabel("提示：添加成功");
                        tip.setFont(font2);
                        JOptionPane.showMessageDialog(null, tip);
                    } else if ((!isOk) && isAllEntered.isEntered(vehicleJtf)) {
                        JLabel tip = new JLabel("提示：请输入正确格式的信息");
                        tip.setFont(font2);
                        JOptionPane.showMessageDialog(null, tip);
                    } else if (isOk && !isAllEntered.isEntered(vehicleJtf)) {
                        JLabel tip = new JLabel("提示：仍有信息未输入");
                        tip.setFont(font2);
                        JOptionPane.showMessageDialog(null, tip);
                    } else if (!isOk && !isAllEntered.isEntered(vehicleJtf)) {
                        JLabel tip = new JLabel("请输入所有正确格式的信息");
                        tip.setFont(font2);
                        JOptionPane.showMessageDialog(null, tip);
                    }
                }
            });

            cancel = new JButton("取消");
            cancel.setFont(font);
            cancel.setBounds(120 + addx, y + 4 * addy + 10, 80, height);
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dispose();
                }
            });

            this.add(addInfo);
            this.add(vehicleNum);
            this.add(jtf_vehicleNum);
            this.add(licensePlate);
            this.add(jtf_licensePlate);
            this.add(vehicleNum);
            this.add(jtf_vehicleNum);
            this.add(buyDate);
            this.add(jtf_buyDate);
            this.add(datechooser);
            this.add(useTime);
            this.add(jtf_useTime);
            this.add(sure);
            this.add(cancel);
        }
    }

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

            if (temp == jtf_vehicleNum) {
                if (!NumExceptioin.isVehicleValid(jtf_vehicleNum)) {
                    isVehicleNumAdd = true;
                    if (tip1 == null) {
                        tip1 = new JLabel("车辆代号为9位0~9整数", JLabel.CENTER);
                        tip1.setBounds(x + addx, y + height, jtf_width, height);
                        tip1.setFont(font2);
                        tip1.setForeground(Color.RED);
                        addTip(tip1);
                    }

                } else {
                    if (isVehicleNumAdd
                            && !"".equalsIgnoreCase(jtf_vehicleNum.getText()
                            .trim())) {
                        isVehicleNumAdd = false;
                        removeTip(tip1);
                        tip1 = null;
                    }
                }
            }
            if (temp == jtf_licensePlate) {
                String s = jtf_licensePlate.getText();
                jtf_licensePlate.setText(s.toUpperCase());
                if (!NumExceptioin.islicensePlateValid(jtf_licensePlate)) {
                    isLicenseAdd = true;
                    if (tip2 == null) {
                        tip2 = new JLabel("请输入如 苏A00000 格式的车牌号", JLabel.CENTER);
                        tip2.setBounds(x, y + addy + height, 2 * jtf_width,
                                height);
                        tip2.setFont(font2);
                        tip2.setForeground(Color.RED);
                        addTip(tip2);
                    }

                } else {
                    if (isLicenseAdd
                            && !"".equalsIgnoreCase(jtf_licensePlate.getText()
                            .trim())) {
                        isLicenseAdd = false;
                        removeTip(tip2);
                        tip2 = null;
                    }
                }
            }
            if (temp == jtf_useTime) {
                if (!NumExceptioin.isInt(jtf_useTime)) {
                    isUsetimeAdd = true;
                    if (tip3 == null) {
                        tip3 = new JLabel("请输入整数", JLabel.CENTER);
                        tip3.setBounds(x + addx, y + 3 * addy + height,
                                jtf_width, height);
                        tip3.setFont(font2);
                        tip3.setForeground(Color.RED);
                        addTip(tip3);
                    }

                } else {
                    if (isUsetimeAdd
                            && !"".equalsIgnoreCase(jtf_useTime.getText()
                            .trim())) {
                        isUsetimeAdd = false;
                        removeTip(tip3);
                        tip3 = null;
                    }
                }
            }
        }
    }

}
