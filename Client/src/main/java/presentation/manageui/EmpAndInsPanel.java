package presentation.manageui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 
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
	// 成本收益表
	private JLabel t2Label;
	private JButton add2Button;
	private JButton del2Button;
	private JButton mod2Button;
	private JButton check2Button;
	private JTextField c2Field;
	private JScrollPane jsp2;
	private JTable instituteTable;

	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

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

		mod1Button.setFont(font2);
		mod1Button.setBounds(350, 10, width, height);

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

		String[] column1 = { "序号", "单据类型", "详细信息" };
		String[] s1 = { "1", "收款单1", "" };
		String row1[][] = { s1 };
		employTable = new JTable(row1, column1);
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
				new addInstituInfoDialog(EmpAndInsPanel.this).setVisible(true);
			}
		});

		del2Button.setFont(font2);
		del2Button.setBounds(260, 10, width, height);

		mod2Button.setFont(font2);
		mod2Button.setBounds(350, 10, width, height);

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

		String[] column2 = { "序号", "单据类型", "详细信息" };
		String[] s2 = { "1", "收款单", "" };
		String row2[][] = { s2 };
		instituteTable = new JTable(row2, column2);
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

	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
			JTextField text = (JTextField) e.getSource();
			if (text == c1Field) {
				if ("请输入用户名".equalsIgnoreCase(c1Field.getText())||"请输入机构信息".equalsIgnoreCase(c2Field.getText())) {
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
}