/*
 * 营业厅业务员管理司机信息界面
 */
package presentation.manageui;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import presentation.commonui.RunTip;
import presentation.commonui.UIdata.UserInfo;
import presentation.commonui.swing.Table;
import vo.DriverVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class DriverPanel extends JPanel {

    int x = 60, y = 60, width = 70, height = 30, addx = 100, addy = 70;

    ManageblService managebl;
    // 定义司机信息的label
    JLabel DriverInfo;
    // 定义添加，删除，修改，查询按钮
    JButton add, delete, modify, search;

    JScrollPane jsp;
    // 定义表格
    JTable driverTable = null;
    // 定义表格模型对象
    DefaultTableModel tableModel;
    // 定义输入司机编号文本框
    JTextField inputInfo;
    // 定义字体
    Font font1 = new Font("楷体", Font.PLAIN, 25);
    Font font2 = new Font("宋体", Font.PLAIN, 15);
    // 定义表格各列的对象
    Object c0, c1, c2, c3, c4, c5, c6, c7;
    //被选中的要修改的行号
    int modRowNum;
    // 修改前的vo
    DriverVO preVo = null;

    modifyDriverDialog modDriver;

    public DriverPanel() {


        this.setLayout(null);

        DriverInfo = new JLabel("司机信息", JLabel.CENTER);
        DriverInfo.setFont(font1);
        DriverInfo.setBounds(220, 10, 200, height);

        add = new JButton("添加");
        add.setFont(font2);
        add.setBounds(x, y, width, height);
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                new addDriverDialog(DriverPanel.this).setVisible(true);

            }
        });

        delete = new JButton("删除");
        delete.setFont(font2);
        delete.setBounds(x + addx, y, width, height);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int rowNum = driverTable.getSelectedRow();
                Object d0 = tableModel.getValueAt(rowNum, 0);
                Object d1 = tableModel.getValueAt(rowNum, 1);
                Object d2 = tableModel.getValueAt(rowNum, 2) != null ? tableModel
                        .getValueAt(rowNum, 2) : "";
                Object d3 = tableModel.getValueAt(rowNum, 3);
                Object d4 = tableModel.getValueAt(rowNum, 4);
                Object d5 = tableModel.getValueAt(rowNum, 5);
                Object d6 = tableModel.getValueAt(rowNum, 6);
                Object d7 = tableModel.getValueAt(rowNum, 7);
                if (rowNum != -1) {
                    DriverVO vo = new DriverVO(d0.toString(), d1.toString(), d3
                            .toString(), d4.toString(), d5.toString(), d6
                            .toString(), d2.toString(), d7.toString());
                    ManageblService bl;
                    try {
                        bl = new ManageController();
                        bl.delDriver(vo);
                    } catch (RemoteException e1) {
                        RunTip.makeTip("网络异常", false);
                        return;
                    }
                    tableModel.removeRow(rowNum);
                }
            }
        });

        modify = new JButton("修改");
        modify.setFont(font2);
        modify.setBounds(x + 2 * addx, y, width, height);
        modify.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                modRowNum = driverTable.getSelectedRow();
                if (modRowNum != -1) {
                    modDriver = new modifyDriverDialog(DriverPanel.this);
                    modDriver.setVisible(true);
                    modDriver.getDriverNum().setText(c0.toString().substring(6));
                    modDriver.getDriverName().setText(c1.toString());
                    if (c2.toString().equals("男")) {
                        modDriver.getMale().setSelected(true);
                    } else {
                        modDriver.getFemale().setSelected(true);
                    }
                    modDriver.getBirthDate().setText(c3.toString());
                    modDriver.getIdNum().setText(c4.toString());
                    modDriver.getPhone().setText(c5.toString());
                    modDriver.getInstitution().setText(c6.toString());
                    modDriver.getLicenseTime().setText(c7.toString());
                }
            }
        });

        inputInfo = new JTextField();
        inputInfo.setFont(font2);
        inputInfo.setText("请输入司机编号");
        inputInfo.setForeground(Color.GRAY);
        inputInfo.addFocusListener(new TextFocus());
        inputInfo.setBounds(x + 3 * addx + 20, y, 120, height);

        search = new JButton("查询");
        search.setFont(font2);
        search.setBounds(x + 4 * addx + 50, y, width, height);
        search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String num = inputInfo.getText();
                ;
                ManageblService bl1;
                DriverVO driver;

                try {
                    bl1 = new ManageController();
                    driver = bl1.checkDriver(num);
                } catch (RemoteException e2) {
                    RunTip.makeTip("网络异常", false);
                }

            }
        });


        String[] column = {"司机编号", "姓名", "性别", "出生日期", "身份证号", "手机", "车辆单位",
                "行驶证期限"};

        // ----------------------------------------
        // 获得driverVO
        int n = 0;
        Iterator<DriverVO> ite1 = null;
        ArrayList<DriverVO> list1 = new ArrayList<DriverVO>();
        ArrayList<DriverVO> list2 = new ArrayList<DriverVO>();
        ManageblService bl;
        DriverVO driver;

        try {
            bl = new ManageController();
            ite1 = bl.checkDriver();
            if (ite1 != null) {
                while (ite1.hasNext()) {
                    DriverVO driverVO = ite1.next();
//					list1.add(ite1.next());
                    String num = null;
                    try {
                        num = bl.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
                    } catch (RemoteException e1) {
                        RunTip.makeTip("网络异常", false);
                    }

                    if (driverVO.getDriverNum().substring(0, 6).equals(num)) {
                        list1.add(driverVO);
                    }
                }

            }
        } catch (RemoteException e2) {
            RunTip.makeTip("网络异常", false);
        }


        n = list1.size();
        final String row[][] = new String[n][8];
        // 将s1赋值为司机信息
        for (int j = 0; j < n; j++) {
            String[] s1 = new String[8];
            driver = list1.get(j);
            s1[0] = driver.getDriverNum();
            s1[1] = driver.getDriverName();
            s1[2] = driver.getSex();
            s1[3] = driver.getBirthDate();
            s1[4] = driver.getIdNum();
            s1[5] = driver.getPhone();
            s1[6] = driver.getVehicleInstitution();
            s1[7] = driver.getLicenseTime();
            row[j] = s1;

        }

        // new DefaultTableModel(row, column);
        driverTable = Table.getTable(column, row);
        tableModel = (DefaultTableModel) driverTable.getModel();
        //-------------------------------------------------
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = inputInfo.getText();
                for (int j = 0; j < row.length; j++) {
                    if (row[j][0].equals(num)) {
                        driverTable.setRowSelectionInterval(j, j);
                    } else {
                        RunTip.makeTip("找不到该司机", false);
                    }
                }
            }
        });

        driverTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
        driverTable.addMouseListener(new MouseAdapter() {// 鼠标事件
            public void mouseClicked(MouseEvent e) {
                int selectedRow = driverTable.getSelectedRow(); // 获得选中行索引
                c0 = tableModel.getValueAt(selectedRow, 0);
                c1 = tableModel.getValueAt(selectedRow, 1);
                c2 = tableModel.getValueAt(selectedRow, 2) != null ? tableModel.getValueAt(selectedRow, 2) : "";
                c3 = tableModel.getValueAt(selectedRow, 3);
                c4 = tableModel.getValueAt(selectedRow, 4);
                c5 = tableModel.getValueAt(selectedRow, 5);
                c6 = tableModel.getValueAt(selectedRow, 6);
                c7 = tableModel.getValueAt(selectedRow, 7);
                try {

                    preVo = new DriverVO(c0.toString(), c1.toString(), c3.toString(), c4.toString(), c5.toString(),
                            c6.toString(), c2.toString(), c7.toString());
                } catch (NullPointerException e1) {
                    RunTip.makeTip("", false);
                }
            }
        });
        driverTable.setFont(font2);
        driverTable.setRowHeight(20);
        jsp = new JScrollPane(driverTable);
        jsp.setBounds(0, y + addy, 650, 400);

        this.add(DriverInfo);
        this.add(add);
        this.add(delete);
        this.add(modify);
        this.add(inputInfo);
        this.add(search);
        this.add(jsp);
    }

    /**
     * 添加用户输入的司机信息
     *
     * @param row
     */
    public void addAfterConfirm(String[] row) {
        tableModel.addRow(row);
    }

    /**
     * 修改司机信息
     *
     * @param row
     */
    public void updateAfterConfirm(String[] row) {
        tableModel.setValueAt(row[0], modRowNum, 0);
        tableModel.setValueAt(row[1], modRowNum, 1);
        tableModel.setValueAt(row[2], modRowNum, 2);
        tableModel.setValueAt(row[3], modRowNum, 3);
        tableModel.setValueAt(row[4], modRowNum, 4);
        tableModel.setValueAt(row[5], modRowNum, 5);
        tableModel.setValueAt(row[6], modRowNum, 6);
        tableModel.setValueAt(row[7], modRowNum, 7);
    }

    /**
     * 获取原来的vo
     *
     * @return
     */
    public DriverVO getVo() {
        return preVo;
    }


    /**
     * 焦点监听
     *
     * @author Administrator
     */
    class TextFocus implements FocusListener {

        public void focusGained(FocusEvent arg0) {
            if ("请输入司机编号".equalsIgnoreCase(inputInfo.getText())) {
                inputInfo.setText("");
                inputInfo.setForeground(Color.BLACK);
            }
        }

        public void focusLost(FocusEvent arg0) {
            if ("".equalsIgnoreCase(inputInfo.getText().trim())) {
                inputInfo.setForeground(Color.GRAY);
                inputInfo.setText("请输入司机编号");
            }
        }

    }
}