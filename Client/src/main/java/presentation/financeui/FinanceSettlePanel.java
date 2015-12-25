package presentation.financeui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.commonui.DateChooser;

/**
 * 财务人员结算管理
 * 
 * @author WANXING 完成
 */
public class FinanceSettlePanel extends JPanel {
	private int width = 70, height = 30;
	private JLabel titleLabel;
	private JButton addButton;//添加按钮
	private JButton checkButton;//查找按钮
	private JButton yesButton;//确定按钮
	private JButton noButton;//取消按钮
	private JTextField checkField;
	private JScrollPane jsp;
	private JTable settleTable;
	private DefaultTableModel tableModel;// 定义表格模型对象
	private DateChooser datechooser;//定义日期选择器

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
		checkField = new JTextField("请选择日期或输入营业厅编号");

		// 界面
		titleLabel.setFont(font1);
		titleLabel.setBounds(250, 10, 100, height);

		addButton.setFont(font2);
		addButton.setBounds(80, 50, width, height);
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new addSettleDialog(FinanceSettlePanel.this).setVisible(true);
			}
		});

		checkField.setFont(font2);
		checkField.setForeground(Color.GRAY);
		checkField.addFocusListener(new TextFocus());
		checkField.setBounds(310, 50, 200, height);

		datechooser = new DateChooser("yyyy-MM-dd",checkField);
		datechooser.setBounds(510, 50, 30, height);
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		checkButton.setFont(font2);
		checkButton.setBounds(550, 50, width, height);

		yesButton.setFont(font2);
		yesButton.setBounds(180, 420, width, height);

		noButton.setFont(font2);
		noButton.setBounds(380, 420, width, height);

		add(titleLabel);
		add(addButton);
		add(checkField);
		add(datechooser);
		add(checkButton);
		add(yesButton);
		add(noButton);

		String[] column = { "收款日期", "收款单位", "收款人", "收款金额", "收款地点" };
		String row[][] = {};
		tableModel = new DefaultTableModel(row,column);
		settleTable = new JTable(tableModel);
		settleTable.setFont(font2);
		settleTable.setRowHeight(20);
		jsp = new JScrollPane(settleTable);
		jsp.setBounds(0, 100, 650, 300);
		add(jsp);
	}

	/**
	 * 添加用户输入的信息
	 * @param row
	 */
	public void addAfterConfirm(String[] row){
		tableModel.addRow(row);
	}
	/**
	 * 监听焦点
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请选择日期或输入营业厅编号".equalsIgnoreCase(checkField.getText())) {
				checkField.setText("");
				checkField.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(checkField.getText().trim())) {
				checkField.setForeground(Color.GRAY);
				checkField.setText("请选择日期或输入营业厅编号");
			}
		}
	}
}
