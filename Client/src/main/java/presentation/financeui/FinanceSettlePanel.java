package presentation.financeui;

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

/**
 * 财务人员结算管理
 * 
 * @author WANXING 完成
 */
public class FinanceSettlePanel extends JPanel {
	int width = 70, height = 30;
	private JLabel titleLabel;
	private JButton addButton;
	private JButton checkButton;
	private JButton yesButton;
	private JButton noButton;
	private JTextField checkField;

	private JScrollPane jsp;
	private JTable settleTable;

	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

	public FinanceSettlePanel() {
		// 初始化各组件
		this.setLayout(null);
		titleLabel = new JLabel("收款单");
		addButton = new JButton("添加");
		checkButton = new JButton("查询");
		yesButton = new JButton("确定");
		noButton = new JButton("取消");
		checkField = new JTextField("请输入您想查看的收款单的日期");

		// 界面
		titleLabel.setFont(font1);
		titleLabel.setBounds(250, 10, 100, height);

		addButton.setFont(font2);
		addButton.setBounds(80, 80, width, height);
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new addSettleDialog(FinanceSettlePanel.this).setVisible(true);
			}
		});

		checkField.setFont(font2);
		checkField.setForeground(Color.GRAY);
		checkField.addFocusListener(new TextFocus());
		checkField.setBounds(320, 80, 220, height);

		checkButton.setFont(font2);
		checkButton.setBounds(550, 80, width, height);

		yesButton.setFont(font2);
		yesButton.setBounds(180, 420, width, height);

		noButton.setFont(font2);
		noButton.setBounds(380, 420, width, height);

		add(titleLabel);
		add(addButton);
		add(checkField);
		add(checkButton);
		add(yesButton);
		add(noButton);

		String[] column = { "序号", "收款日期", "收款单位", "收款人", "收款金额", "收款地点" };
		String[] s1 = { "1", "2015-11-11", "-", "-", "-", "-" };
		String row[][] = { s1 };
		settleTable = new JTable(row, column);
		settleTable.setFont(font2);
		settleTable.setRowHeight(20);
		jsp = new JScrollPane(settleTable);
		jsp.setBounds(0, 130, 650, 260);
		add(jsp);
	}

	// 等待画虚线
//	public void paintComponent(java.awt.Graphics g) {
//		super.paintComponent(g);
//		g.drawLine(20, 50, 610, 50);
//	}

	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请输入您想查看的收款单的日期".equalsIgnoreCase(checkField.getText())) {
				checkField.setText("");
				checkField.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(checkField.getText().trim())) {
				checkField.setForeground(Color.GRAY);
				checkField.setText("请输入您想查看的收款单的日期");
			}
		}
	}
}
