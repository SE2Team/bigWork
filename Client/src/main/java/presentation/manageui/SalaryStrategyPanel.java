package presentation.manageui;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * 完成
 *
 * @author WANXING
 */
//总经理制定薪水策略
public class SalaryStrategyPanel extends JPanel {

    int x = 100, y = 100, addx = 200, addy = 100, width = 100, height = 40, width2 = 230;
    //定义所有字体
    Font font1 = new Font("楷体", Font.PLAIN, 25);
    Font font2 = new Font("宋体", Font.PLAIN, 20);
    Font font3 = new Font("宋体", Font.PLAIN, 18);
    private String[] employeeType = {"快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员", "总经理", "管理员"};
    private JLabel thymPanel;
    private JLabel typeLabel;
    private JLabel wayLabel;
    private JComboBox etBox;
    private JRadioButton jrdMonth, jrdTimes, jrdCount;
    private ButtonGroup group;
    private JButton sure, cancel;
    private String type;

    public SalaryStrategyPanel() {
        RadioButtonListener radioButtonListener = new RadioButtonListener();

        this.setLayout(null);

        thymPanel = new JLabel("制定薪水策略", JLabel.CENTER);
        thymPanel.setFont(font1);
        thymPanel.setBounds(200, 10, 200, height);

        typeLabel = new JLabel("人员类型", JLabel.CENTER);
        typeLabel.setFont(font2);
        typeLabel.setBounds(x, y, width2, height);

        wayLabel = new JLabel("薪水计算方式", JLabel.CENTER);
        wayLabel.setFont(font2);
        wayLabel.setBounds(x, y + addy, width2, height);

        etBox = new JComboBox(employeeType);
        etBox.setFont(font3);
        etBox.setBounds(x + addx, y, width2, height);

        jrdMonth = new JRadioButton("按月");
        jrdMonth.addActionListener(radioButtonListener);
        jrdTimes = new JRadioButton("计次");
        jrdTimes.addActionListener(radioButtonListener);
        jrdCount = new JRadioButton("提成");
        jrdCount.addActionListener(radioButtonListener);
        jrdMonth.setFont(font3);
        jrdTimes.setFont(font3);
        jrdCount.setFont(font3);
        jrdMonth.setBounds(x + addx, 170, width, height);
        jrdTimes.setBounds(x + addx, 200, width, height);
        jrdCount.setBounds(x + addx, 230, width, height);
        group = new ButtonGroup();
        group.add(jrdCount);
        group.add(jrdMonth);
        group.add(jrdTimes);

        sure = new JButton("确定");
        sure.setFont(font2);
        sure.setBounds(x + 80, y + 2 * addy, width, height);
        sure.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ManageblService bl;
                try {
                    bl = new ManageController();
                    bl.updateSalary(etBox.getSelectedItem().toString(), type);
                } catch (RemoteException e1) {
                    JLabel tip = new JLabel("提示：网络异常");
                    tip.setFont(font3);
                    JOptionPane.showMessageDialog(null, tip);
                    return;
                }


            }
        });
        cancel = new JButton("取消");
        cancel.setFont(font2);
        cancel.setBounds(x + 80 + addx, y + 2 * addy, width, height);


        add(thymPanel);
        add(wayLabel);
        add(jrdMonth);
        add(jrdTimes);
        add(jrdCount);
        add(typeLabel);
        add(etBox);
        add(typeLabel);
        add(sure);
        add(cancel);
    }

    class RadioButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            JRadioButton temp = (JRadioButton) e.getSource();

            if (temp.isSelected()) {
                type = temp.getText();
            }
        }

    }
}
