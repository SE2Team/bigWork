package presentation.financeui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.financeui.addAccountDialog.addAccountPanel;

public class modifyAccountDialog extends JDialog {

	private FinanceAccountPanel parent;

	public modifyAccountDialog(FinanceAccountPanel parent) {
		this.parent = parent;
		this.setContentPane(new modAccountPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 20, y = 60, addx = 120, addy = 90, jl_width = 100,
			jtf_width = 200, height = 25;

	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	// 定义添加账户信息，账户名称，余额的label
	JLabel addInfo, accountName, balance;
	// 定义对应的文本框
	JTextField jtf_accountName, jtf_balance;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	
	class modAccountPanel extends JPanel {

		modAccountPanel() {
			this.setLayout(null);

			addInfo = new JLabel("添加账户信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			accountName = new JLabel("账户名称", JLabel.CENTER);
			accountName.setFont(font);
			accountName.setBounds(x, y, jl_width, height);

			jtf_accountName = new JTextField();
			jtf_accountName.setFont(font);
			jtf_accountName.setBounds(x + addx, y, jtf_width, height);

			balance = new JLabel("余额", JLabel.CENTER);
			balance.setFont(font);
			balance.setBounds(x, y + addy, jl_width, height);

			jtf_balance = new JTextField();
			jtf_balance.setFont(font);
			jtf_balance.setBounds(x + addx, y + addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 2 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					rowContent = new String[]{jtf_accountName
							.getText(), jtf_balance.getText()};
					parent.updateAfterConfirm(rowContent);
					dispose();
				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 2 * addy + 10, 80, height);
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});

			this.add(addInfo);
			this.add(accountName);
			this.add(jtf_accountName);
			this.add(balance);
			this.add(jtf_balance);
			this.add(sure);
			this.add(cancel);

		}
	}
	
	/**
	 * 获取账户名称的文本框
	 * @return
	 */
	public JTextField getAccountName(){
		return jtf_accountName;
	}
	
	/**
	 * 获取账户余额的文本框
	 * @return
	 */
	public JTextField getAccountBalance(){
		return jtf_balance;
	}
}
