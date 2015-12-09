package presentation.financeui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 财务人员成本管理界面
 * 
 * @author WANXING 完成
 */
public class FinanceCostPanel extends JPanel {
	private JButton creatButton;
	private JButton checkButton;
	private JButton sureButton;
	private JButton deleteButton;
	private JLabel titleLabel;
	private JLabel dateLabel;
	private JLabel nameLabel;
	private JLabel sumLabel;
	private JLabel numLabel;
	private JLabel reasonLabel;
	private JLabel otherLabel;
	private JTextField dateTextField;
	private JTextField nameTextField;
	private JTextField sumTextField;
	private JTextField numTextField;
	private JTextArea reasonTextArea;
	private JTextArea otherTextArea;
	private JScrollPane jsp1,jsp2;
	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

	public FinanceCostPanel() {
		int width = 70, height = 30;
		// 初始化组件
		this.setSize(650, 530);
		this.setLayout(null);

		creatButton = new JButton("新建付款单");
		checkButton = new JButton("单据查看");
		sureButton = new JButton("确定");
		deleteButton = new JButton("取消");
		titleLabel = new JLabel("付款单");
		dateLabel = new JLabel("付款日期");
		nameLabel = new JLabel("付款人 ");
		sumLabel = new JLabel("付款金额");
		numLabel = new JLabel("付款账号");
		reasonLabel = new JLabel("条目  ");
		otherLabel = new JLabel("备注");
		dateTextField = new JTextField();
		nameTextField = new JTextField();
		sumTextField = new JTextField();
		numTextField = new JTextField();
		reasonTextArea = new JTextArea();
		otherTextArea = new JTextArea();

		// 界面
		creatButton.setFont(font2);
		creatButton.setBounds(150, 20, 150, height);

		checkButton.setFont(font2);
		checkButton.setBounds(350, 20, 150, height);

		titleLabel.setFont(font1);
		titleLabel.setBounds(270, 80, 200, height);

		dateLabel.setFont(font2);
		dateLabel.setBounds(80, 120, width, height);

		dateTextField.setFont(font2);
		dateTextField.setBounds(160, 120, 150, height);

		nameLabel.setFont(font2);
		nameLabel.setBounds(350, 120, width, height);

		nameTextField.setFont(font2);
		nameTextField.setBounds(430, 120, 150, height);

		sumLabel.setFont(font2);
		sumLabel.setBounds(80, 220, width, height);

		sumTextField.setFont(font2);
		sumTextField.setBounds(160, 220, 150, height);

		numLabel.setFont(font2);
		numLabel.setBounds(350, 220, width, height);

		numTextField.setFont(font2);
		numTextField.setBounds(430, 220, 150, height);

		reasonLabel.setFont(font2);
		reasonLabel.setBounds(80, 320, width, height);

		reasonTextArea.setFont(font2);
		
		jsp1 = new JScrollPane(reasonTextArea);
		jsp1.setBounds(160, 280, 150, 3 * height);

		otherLabel.setFont(font2);
		otherLabel.setBounds(350, 310, width, height);

		otherTextArea.setFont(font2);
		
		jsp2 = new JScrollPane(otherTextArea);
		jsp2.setBounds(430, 280, 150, 3 * height);

		sureButton.setFont(font2);
		sureButton.setBounds(180, 400, width, height);

		deleteButton.setFont(font2);
		deleteButton.setBounds(380, 400, width, height);

		add(creatButton);
		add(checkButton);
		add(titleLabel);
		add(dateLabel);
		add(dateTextField);
		add(sumLabel);
		add(sumTextField);
		add(nameLabel);
		add(nameTextField);
		add(numLabel);
		add(numTextField);
		add(reasonLabel);
		add(jsp1);
		add(otherLabel);
		add(jsp2);
		add(sureButton);
		add(deleteButton);
	}

	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 60, 650, 60);
	}
}
