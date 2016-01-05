package presentation.manageui;


import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import util.ExistException;
import vo.OrganizationVO;
import vo.WorkerVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author WANXING 完成2
 */
// 总经理人员与机构管理
public class EmpAndInsPanel extends JPanel {
    int width = 70, height = 30;
    private JTabbedPane tab;
    private JPanel employPanel;
    private JPanel institutionPanel;
    // 人员信息
    private JLabel t1Label;
    private JButton add1Button;
    private JButton del1Button;
    private JButton mod1Button;
    private JButton check1Button;
    private JTextField c1Field;
    private JScrollPane jsp1;
    private JTable employTable;
    private DefaultTableModel tableModel1;// 定义人员表格模型对象
    private Object emp0, emp1, emp2, emp3, emp4, emp5, emp6;// 定义人员表格各列的对象
    private int e_modRowNum;//被选中的要修改的人员行号

    // 成本收益表
    private JLabel t2Label;
    private JButton add2Button;
    private JButton del2Button;
    private JButton mod2Button;
    private JButton check2Button;
    private JTextField c2Field;
    private JScrollPane jsp2;
    private JTable instituteTable;
    private DefaultTableModel tableModel2;// 定义机构表格模型对象
    private Object ins0, ins1, ins2;// 定义机构表格各列的对象
    private int i_modRowNum;//被选中的要修改的机构行号
    private WorkerVO oWorkervo = null;
    private addInstituInfoDialog addInstituInfo;
    modifyInstitutionDialog modInstition;
    Object c0, c1, c2, c3, c4, c5, c6;
    modifyEmployeeDialog modEmployee;

    Font font1 = new Font("楷体", Font.PLAIN, 25);
    Font font2 = new Font("宋体", Font.PLAIN, 15);

    ManageblService bl;

    WorkerVO vo;
    OrganizationVO organizationVO;



    public EmpAndInsPanel() {
        // 初始化各组件
        this.setSize(650, 530);
        this.setLayout(null);

        tab = new JTabbedPane(JTabbedPane.TOP);
        // 人员信息
        employPanel = new JPanel();
        employPanel.setLayout(null);
        t1Label = new JLabel("人员信息列表");
        add1Button = new JButton("添加");
        del1Button = new JButton("删除");
        mod1Button = new JButton("修改");
        check1Button = new JButton("查找");
        c1Field = new JTextField(8);

        t1Label.setFont(font1);
        t1Label.setBounds(5, 5, 150, 40);

        add1Button.setFont(font2);
        add1Button.setBounds(170, 10, width, height);
        add1Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new addEmployeeInfoDialog(EmpAndInsPanel.this).setVisible(true);
            }
        });

        del1Button.setFont(font2);
        del1Button.setBounds(260, 10, width, height);
        del1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int rowNum = employTable.getSelectedRow();
                c0 = tableModel1.getValueAt(rowNum, 0);
                c1 = tableModel1.getValueAt(rowNum, 1);
                c2 = tableModel1.getValueAt(rowNum, 2);
                c3 = tableModel1.getValueAt(rowNum, 3);
                c4 = tableModel1.getValueAt(rowNum, 4);
                c5 = tableModel1.getValueAt(rowNum, 5);
                c6 = tableModel1.getValueAt(rowNum, 6);
                WorkerVO vo = new WorkerVO(c0.toString(), c3.toString(), c4
                        .toString(), c5.toString(), c6.toString(), c1
                        .toString(), c2.toString());
                if (rowNum != -1) {
                    ManageblService bl;
                    try {
                        bl = new ManageController();
                        try {
                            bl.delWorker(vo);
                        } catch (ExistException e) {
                            RunTip.makeTip("该机构已存在", false);
                            return;
                        }
                    } catch (RemoteException e) {
                        RunTip.makeTip("网络异常", false);
                        return;
                    }
                    tableModel1.removeRow(rowNum);
                }
            }
        });

        mod1Button.setFont(font2);
        mod1Button.setBounds(350, 10, width, height);

        mod1Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                e_modRowNum = employTable.getSelectedRow();
                if (e_modRowNum != -1) {
//                    modEmployee.getAge().setText(emp2.toString());
//                    modEmployee.getIdNum().setText(emp3.toString());
//                    modEmployee.getPosition().setText(emp4.toString());
//                    modEmployee.getInstitution().setText(emp5.toString());
////				modEmployee.getAccountNum().setText(emp6.toString());
                    modEmployee = new modifyEmployeeDialog(EmpAndInsPanel.this, new WorkerVO(emp0.toString(),
                            emp3.toString(), emp4.toString(), emp5.toString(),
                            emp6.toString(), emp1.toString(), emp2.toString()));
                    modEmployee.setVisible(true);
                }
            }
        });

        c1Field.setFont(font2);
        c1Field.setText("请输入用户名");
        c1Field.setForeground(Color.GRAY);
        c1Field.addFocusListener(new TextFocus());
        c1Field.setBounds(430, 10, 120, height);

        check1Button.setFont(font2);
        check1Button.setBounds(550, 10, width, height);


        employPanel.add(t1Label);
        employPanel.add(c1Field);
        employPanel.add(add1Button);
        employPanel.add(del1Button);
        employPanel.add(mod1Button);
        employPanel.add(check1Button);

        //----------------------------------------------------
        Iterator<WorkerVO> ite2 = null;
        ArrayList<WorkerVO> list2 = new ArrayList<WorkerVO>();
        int n = 0;
        try {
            bl = new ManageController();
            ite2 = bl.checkWorker();
        } catch (RemoteException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        if (ite2 != null) {
            while (ite2.hasNext()) {
                list2.add(ite2.next());
            }
        }
        n = list2.size();
        final String row1[][] = new String[n][8];
        for (int j = 0; j < n; j++) {
            vo = list2.get(j);
            String[] temp = {vo.getName(), vo.getSex(), vo.getAge(), vo.getIdNum(), vo.getPosition(),
                    vo.getOrganization(), vo.getUserId()};
            row1[j] = temp;
        }
        String[] column1 = {"姓名", "性别", "年龄", "身份证号", "职位", "所属机构", "系统用户名"};
        employTable = Table.getTable(column1, row1);
        tableModel1 = (DefaultTableModel) employTable.getModel();
        //----------------------------------------------------
        check1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = c1Field.getText();
                for (int j = 0; j < row1.length; j++) {
                    if (row1[j][0].equals(name)) {
                        employTable.setRowSelectionInterval(j, j);
                    }
                }
            }
        });
        employTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        employTable.addMouseListener(new MouseAdapter() {// 鼠标事件
            public void mouseClicked(MouseEvent e) {
                int selectedRow = employTable.getSelectedRow(); // 获得选中行索引
                emp0 = tableModel1.getValueAt(selectedRow, 0);
                emp1 = tableModel1.getValueAt(selectedRow, 1);
                emp2 = tableModel1.getValueAt(selectedRow, 2);
                emp3 = tableModel1.getValueAt(selectedRow, 3);
                emp4 = tableModel1.getValueAt(selectedRow, 4);
                emp5 = tableModel1.getValueAt(selectedRow, 5);
                emp6 = tableModel1.getValueAt(selectedRow, 6);
            }
        });
        employTable.setFont(font2);
        employTable.setRowHeight(20);
        jsp1 = new JScrollPane(employTable);
        jsp1.setBounds(0, 70, 650, 395);
        employPanel.add(jsp1);

        // 机构信息
        institutionPanel = new JPanel();
        institutionPanel.setLayout(null);
        t2Label = new JLabel("机构信息列表");
        add2Button = new JButton("添加");
        del2Button = new JButton("删除");
        mod2Button = new JButton("修改");
        check2Button = new JButton("查找");
        c2Field = new JTextField(8);

        t2Label.setFont(font1);
        t2Label.setBounds(5, 5, 150, 40);

        add2Button.setFont(font2);
        add2Button.setBounds(170, 10, width, height);
        add2Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                addInstituInfo = new addInstituInfoDialog(EmpAndInsPanel.this);
                addInstituInfo.setVisible(true);
            }
        });

        del2Button.setFont(font2);
        del2Button.setBounds(260, 10, width, height);
        del2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int rowNum = instituteTable.getSelectedRow();
                if (rowNum != -1) {
                    tableModel2.removeRow(rowNum);
                    try {
                        bl.delOrganization(new OrganizationVO(ins0.toString(), ins1.toString(), ins2.toString()));
                    } catch (RemoteException e) {
                        RunTip.makeTip("网络异常", false);
                    } catch (ExistException e) {
                        RunTip.makeTip("机构信息重复", false);
                    }
                }
            }
        });

        mod2Button.setFont(font2);
        mod2Button.setBounds(350, 10, width, height);
        mod2Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                i_modRowNum = instituteTable.getSelectedRow();
                if (i_modRowNum != -1) {
                    modInstition = new modifyInstitutionDialog
                            (EmpAndInsPanel.this, new OrganizationVO(ins0.toString(), ins1.toString(), ins2.toString()));
                    modInstition.setVisible(true);
                }
            }
        });

        c2Field.setFont(font2);
        c2Field.setText("请输入机构编号");
        c2Field.setForeground(Color.GRAY);
        c2Field.addFocusListener(new TextFocus());
        c2Field.setBounds(430, 10, 120, height);

        check2Button.setFont(font2);
        check2Button.setBounds(550, 10, width, height);


        institutionPanel.add(t2Label);
        institutionPanel.add(c2Field);
        institutionPanel.add(add2Button);
        institutionPanel.add(del2Button);
        institutionPanel.add(mod2Button);
        institutionPanel.add(check2Button);

        //---------------------------------------------------------------------
        Iterator<OrganizationVO> ite1 = null;
        ArrayList<OrganizationVO> list1 = new ArrayList<OrganizationVO>();
        int n1 = 0;
        ManageblService bl1;
        OrganizationVO vo1;
        try {
            bl1 = new ManageController();
            ite1 = bl1.checkOrganization();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (ite1 != null) {
            while (ite1.hasNext()) {
                list1.add(ite1.next());
            }
        }
        n1 = list1.size();
        final String row[][] = new String[n1][3];
        for (int j = 0; j < n1; j++) {
            vo1 = list1.get(j);
            String[] temp = {vo1.getNum(), vo1.getCity(), vo1.getName()};
            row[j] = temp;
        }
        String[] column2 = {"机构编号", "城市", "机构名称"};
        instituteTable = Table.getTable(column2, row);
        tableModel2 = (DefaultTableModel) instituteTable.getModel();
        //-----------------------------------------------------------------

        check2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = c2Field.getText();
                for (int j = 0; j < row.length; j++) {
                    if (row[j][0].equals(num)) {
                        instituteTable.setRowSelectionInterval(j, j);
                    }
                }
            }
        });
        //	String row2[][] = {s2};
        //	tableModel2 = new DefaultTableModel(row2, column2);
        //	instituteTable = new JTable(tableModel2);
        instituteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单击
        instituteTable.addMouseListener(new MouseAdapter() {//鼠标事件
            public void mouseClicked(MouseEvent e) {
                int selectedRow = instituteTable.getSelectedRow(); // 获得选中行索引
                ins0 = tableModel2.getValueAt(selectedRow, 0);
                ins1 = tableModel2.getValueAt(selectedRow, 1);
                ins2 = tableModel2.getValueAt(selectedRow, 2);
            }
        });
        instituteTable.setFont(font2);
        instituteTable.setRowHeight(20);
        jsp2 = new JScrollPane(instituteTable);
        jsp2.setBounds(0, 70, 650, 395);
        institutionPanel.add(jsp2);

        tab.add(employPanel, "人员信息");
        tab.add(institutionPanel, "机构信息");

        tab.setBounds(0, 0, 650, 530);
        add(tab);
    }

    /**
     * 添加用户输入的人员信息
     *
     * @param row
     */
    public void addEmpInfo(String[] row) {
        tableModel1.addRow(row);
    }

    /**
     * 修改人员信息
     *
     * @param row
     */
    public void updateEmpInfo(String[] row) {
        tableModel1.setValueAt(row[0], e_modRowNum, 0);
        tableModel1.setValueAt(row[1], e_modRowNum, 1);
        tableModel1.setValueAt(row[2], e_modRowNum, 2);
        tableModel1.setValueAt(row[3], e_modRowNum, 3);
        tableModel1.setValueAt(row[4], e_modRowNum, 4);
        tableModel1.setValueAt(row[5], e_modRowNum, 5);
        tableModel1.setValueAt(row[6], e_modRowNum, 6);
    }

    /**
     * 获取原来的员工信息的vo
     *
     * @return
     */
    public WorkerVO getVo() {
        return oWorkervo;
    }

    /**
     * 添加用户输入的机构信息
     *
     * @param row
     */
    public void addInsInfo(String[] row) {
        tableModel2.addRow(row);
    }

    /**
     * 修改机构信息
     *
     * @param row
     */
    public void updateInsInfo(String[] row) {
        tableModel2.setValueAt(row[0], i_modRowNum, 0);
        tableModel2.setValueAt(row[1], i_modRowNum, 1);
    }

    /**
     * 焦点监听
     *
     * @author Administrator
     */
    class TextFocus implements FocusListener {

        public void focusGained(FocusEvent e) {
            JTextField text = (JTextField) e.getSource();
            if (text == c1Field) {
                if ("请输入用户名".equalsIgnoreCase(c1Field.getText()) || "请输入机构信息".equalsIgnoreCase(c2Field.getText())) {
                    c1Field.setText("");
                    c1Field.setForeground(Color.BLACK);
                }

            }
            if (text == c2Field) {
                if ("请输入机构编号".equalsIgnoreCase(c2Field.getText())) {

                    c2Field.setText("");
                    c2Field.setForeground(Color.BLACK);
                }

            }
        }

        public void focusLost(FocusEvent e) {
            JTextField text = (JTextField) e.getSource();
            if (text == c1Field) {
                if ("".equalsIgnoreCase(c1Field.getText().trim())) {
                    c1Field.setForeground(Color.GRAY);
                    c1Field.setText("请输入用户名");
                }

            }
            if (text == c2Field) {
                if ("".equalsIgnoreCase(c2Field.getText().trim())) {
                    c2Field.setForeground(Color.GRAY);
                    c2Field.setText("请输入机构编号");
                }
            }
        }

    }

    public void update1() {
        DefaultTableModel model1;
        String[] column1 = {"姓名", "性别", "年龄", "身份证号", "职位", "所属机构", "系统用户名"};
        Iterator<WorkerVO> ite = null;
        ArrayList<WorkerVO> list2 = new ArrayList<WorkerVO>();
        int n = 0;
        ManageblService bl;
        WorkerVO vo;
        try {
            bl = new ManageController();
            ite = bl.checkWorker();
        } catch (RemoteException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        if (ite != null) {
            while (ite.hasNext()) {
                list2.add(ite.next());
            }
        }
        n = list2.size();
        String row1[][] = new String[n][8];
        for (int j = 0; j < n; j++) {
            vo = list2.get(j);
            String[] temp = {vo.getName(), vo.getSex(), vo.getAge(), vo.getIdNum(), vo.getPosition(),
                    vo.getOrganization(), vo.getUserId()};
            row1[j] = temp;
        }
        model1 = new DefaultTableModel(row1, column1);
        employTable.setModel(model1);
        employTable.updateUI();
    }

    public void update2() {
        DefaultTableModel model2;
        String[] column2 = {"机构编号", "城市", "机构名称"};
        ;
        Iterator<OrganizationVO> ite = null;
        ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
        int n1 = 0;
        ManageblService bl2;
        OrganizationVO vo;
        try {
            bl2 = new ManageController();
            ite = bl2.checkOrganization();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (ite != null) {
            while (ite.hasNext()) {
                list.add(ite.next());
            }
        }
        n1 = list.size();
        String row2[][] = new String[n1][3];
        for (int j = 0; j < n1; j++) {
            vo = list.get(j);
            String[] temp = {vo.getNum(), vo.getCity(), vo.getName()};
            row2[j] = temp;
        }
        model2 = new DefaultTableModel(row2, column2);
        instituteTable.setModel(model2);
        instituteTable.updateUI();
    }

}