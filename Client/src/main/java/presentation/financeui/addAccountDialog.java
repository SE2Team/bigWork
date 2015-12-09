/**
 * 财务人员添加账户信息界面
 */
package presentation.financeui;

import vo.AccountVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addAccountDialog extends JDialog {

	private FinanceAccountPanel parent;

	public addAccountDialog(FinanceAccountPanel parent) {

		this.parent = parent;
		this.setContentPane(new addAccountPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	class addAccountPanel extends JPanel {
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
		//定义用来存放用户输入信息的数组
		String[] rowContent;

		public addAccountPanel() {
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
				public void actionPerformed(ActionEvent arg0) {
					AccountVO account_vo = new AccountVO(jtf_accountName
							.getText(), jtf_balance.getText());
					rowContent = new String[]{jtf_accountName
							.getText(), jtf_balance.getText()};
					parent.addAfterConfirm(rowContent);
//					FinanceblService bl = null;
//					try {
//						bl = new FinanceController();
//					} catch (RemoteException e1) {
//						// TODO Auto-generated catch block
//						JLabel tip = new JLabel("提示：网络异常");
//						tip.setFont(font);
//						JOptionPane.showMessageDialog(null, tip);
//					}
//					try {
//						bl.addAccount(account_vo);
//					} catch (InvalidDoubleException e) {
//						// TODO Auto-generated catch block
//						JLabel tip = new JLabel(e.getMessage());
//						tip.setFont(font);
//						JOptionPane.showMessageDialog(null, tip);
//						e.printStackTrace();
//					} catch (InputNullException e) {
//						// TODO Auto-generated catch block
//						JLabel tip = new JLabel(e.getMessage());
//						tip.setFont(font);
//						JOptionPane.showMessageDialog(null, tip);
//						e.printStackTrace();
//					}
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
}
