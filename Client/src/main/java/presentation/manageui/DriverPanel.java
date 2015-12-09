/*
 * 营业厅业务员管理司机信息界面
 */
package presentation.manageui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class DriverPanel extends JPanel {

	int x = 60, y = 60, width = 70, height = 30, addx = 100, addy = 70;

	// 定义司机信息的label
	JLabel DriverInfo;
	// 定义添加，删除，修改，查询按钮
	JButton add, delete, modify, search;

	JScrollPane jsp;
	// 定义表格
	JTable driverTable = null;
	// 定义输入司机编号文本框
	JTextField inputInfo;
	// 定义字体
	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

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

		modify = new JButton("修改");
		modify.setFont(font2);
		modify.setBounds(x + 2 * addx, y, width, height);

		inputInfo = new JTextField();
		inputInfo.setFont(font2);
		inputInfo.setText("请输入司机编号");
		inputInfo.setForeground(Color.GRAY);
		inputInfo.addFocusListener(new TextFocus());
		inputInfo.setBounds(x + 3 * addx + 20, y, 120, height);

		search = new JButton("查询");
		search.setFont(font2);
		search.setBounds(x + 4 * addx + 50, y, width, height);

		String[] column = { "司机编号", "姓名", "性别", "出生日期", "身份证号", "手机", "车辆单位",
				"行驶证期限" };
		String[] s1 = { "025000000", "张三", "男", "1988-8-8",
				"320682198808082631", "18322913658", "", "2" };
		String row[][] = { s1 };
		driverTable = new JTable(row, column);
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
