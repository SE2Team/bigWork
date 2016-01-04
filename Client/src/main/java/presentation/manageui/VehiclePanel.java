/*
 * 营业厅业务员管理车辆信息界面
 */
package presentation.manageui;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import vo.VehicleVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class VehiclePanel extends JPanel {

	int x = 60, y = 60, width = 70, height = 30, addx = 100, addy = 70;

	// 定义车辆信息的label
	JLabel vehicleInfo;
	// 定义添加，删除，修改，查询按钮
	JButton add, delete, modify, search;
	// 定义表格
	JTable vehicleTable = null;
	// 定义表格模型对象
	DefaultTableModel tableModel;
	// 定义输入车辆代号文本框
	JTextField inputInfo;
	// Vector row,column;
	JScrollPane vehiclepane = null;
	// 定义所有字体
	Font font1 = new Font("楷体", Font.PLAIN, 30);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	// 定义表格各列的对象
	Object c0, c1, c2, c3;
	//被选中的要修改的行号
	int modRowNum;
	//定义原来的vo
	VehicleVO oVehicle = null;

	public VehiclePanel() {

		this.setLayout(null);


		vehicleInfo = new JLabel("车辆信息", JLabel.CENTER);
		vehicleInfo.setFont(font1);
		vehicleInfo.setBounds(220, 10, 200, height);

		add = new JButton("添加");
		add.setFont(font2);
		add.setBounds(x, y, width, height);

		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				addVehicleDialog addVehicle = new addVehicleDialog(
						VehiclePanel.this);
				addVehicle.setVisible(true);
			}
		});

		delete = new JButton("删除");
		delete.setFont(font2);
		delete.setBounds(x + addx, y, width, height);
		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int rowNum = vehicleTable.getSelectedRow();
				Object v0 = tableModel.getValueAt(rowNum, 0);
				Object v1 = tableModel.getValueAt(rowNum, 1);
				Object v2 = tableModel.getValueAt(rowNum, 2);
				Object v3 = tableModel.getValueAt(rowNum, 3);
				if (rowNum != -1) {
					VehicleVO vo = new VehicleVO(v0.toString(), v1.toString(),
							v2.toString(), v3.toString());
					ManageblService bl;
					try {
						bl = new ManageController();
						bl.delVehicle(vo);
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
		final modifyVehicleDialog modifyVehicle = new modifyVehicleDialog(VehiclePanel.this);
		modify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				modRowNum = vehicleTable.getSelectedRow();
				if (modRowNum != -1) {
					modifyVehicle.setVisible(true);
				}
			}

		});

		inputInfo = new JTextField();
		inputInfo.setFont(font2);
		inputInfo.setText("请输入车辆代号");
		inputInfo.setForeground(Color.GRAY);
		inputInfo.addFocusListener(new TextFocus());
		inputInfo.setBounds(x + 3 * addx + 20, y, 120, height);

		search = new JButton("查找");
		search.setFont(font2);
		search.setBounds(x + 4 * addx + 50, y, width, height);


		//-------------------------------------------------------------
		String[] column = {"车辆代号", "车牌号", "购买时间", "服役时间"};
		Iterator<VehicleVO> ite2 = null;
		ArrayList<VehicleVO> list2 = new ArrayList<VehicleVO>();
		ManageblService bl;
		int n = 0;
		VehicleVO vehicle;
		try {
			bl = new ManageController();
			ite2 = bl.checkVehicle();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			RunTip.makeTip("网络异常", false);
		}

		if (ite2 != null) {
			while (ite2.hasNext()) {
				list2.add(ite2.next());
			}
		}
		n = list2.size();
		final String row[][] = new String[n][4];
		for (int j = 0; j < n; j++) {
			vehicle = list2.get(j);
			String[] s1 = new String[4];
			s1[0] = vehicle.getVehicleNum();
			s1[1] = vehicle.getLicensePlate();
			s1[2] = vehicle.getBuyDate();
			s1[3] = vehicle.getUseTime();
			row[j] = s1;
		}
		vehicleTable = Table.getTable(column, row);
		tableModel = (DefaultTableModel) vehicleTable.getModel();
		//---------------------------------------------------------
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = inputInfo.getText();
				for (int j = 0; j < row.length; j++) {
					if (row[j][0].equals(num)) {
						vehicleTable.setRowSelectionInterval(j, j);
					}
				}
			}
		});
		//	tableModel =new DefaultTableModel(row, column);


		vehicleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
		vehicleTable.addMouseListener(new MouseAdapter() {// 鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = vehicleTable.getSelectedRow(); // 获得选中行索引
				c0 = tableModel.getValueAt(selectedRow, 0);
				c1 = tableModel.getValueAt(selectedRow, 1);
				c2 = tableModel.getValueAt(selectedRow, 2);
				c3 = tableModel.getValueAt(selectedRow, 3);
				modifyVehicle.getVehicleNum().setText(c0.toString());
				modifyVehicle.getLicensePlate().setText(c1.toString());
				modifyVehicle.getBuyDate().setText(c2.toString());
				modifyVehicle.getUseTime().setText(c3.toString());
				oVehicle = new VehicleVO(c0.toString(), c1.toString(), c2.toString(), c3.toString());

			}
		});
		vehicleTable.setFont(font2);
		vehicleTable.setRowHeight(20);
		vehiclepane = new JScrollPane(vehicleTable);
		vehiclepane.setBounds(0, y + addy, 650, 400);

		this.add(vehicleInfo);
		this.add(add);
		this.add(delete);
		this.add(modify);
		this.add(inputInfo);
		this.add(search);
		this.add(vehiclepane);

	}

	/**
	 * 添加用户输入的车辆信息
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
	}

	/**
	 * 焦点监听
	 *
	 * @author Administrator
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if ("请输入车辆代号".equalsIgnoreCase(inputInfo.getText())) {
				inputInfo.setText("");
				inputInfo.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if ("".equalsIgnoreCase(inputInfo.getText().trim())) {
				inputInfo.setForeground(Color.GRAY);
				inputInfo.setText("请输入车辆代号");
			}
		}

	}
}
