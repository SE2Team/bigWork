package presentation.financeui;

import businesslogic.financebl.FinanceController;
import businesslogicservice.FinanceblService;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.MyDialog;
import presentation.exception.NumExceptioin;
import util.ExistException;
import vo.AccountVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

public class modifyAccountDialog extends MyDialog {

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
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加账户信息，账户名称，余额的label
	JLabel addInfo, accountName, balance;
	// 定义对应的文本框
	JTextField jtf_accountName, jtf_balance;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	//错误提示信息
	JLabel tip1;
	// 定义文本框的数组
	JTextField[] accJtf;
	
	class modAccountPanel extends JPanel {

		modAccountPanel() {
			this.setLayout(null);

			addInfo = new JLabel("修改账户信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			accountName = new JLabel("账户名称", JLabel.CENTER);
			accountName.setFont(font);
			accountName.setBounds(x, y, jl_width, height);

			jtf_accountName = new JTextField();
			jtf_accountName.setFont(font2);
			jtf_accountName.setBounds(x + addx, y, jtf_width, height);

			balance = new JLabel("余额", JLabel.CENTER);
			balance.setFont(font);
			balance.setBounds(x, y + addy, jl_width, height);

			jtf_balance = new JTextField();
			jtf_balance.setFont(font2);
			jtf_balance.setBounds(x + addx, y + addy, jtf_width, height);
			jtf_balance.addFocusListener(new TextFocus());
			
			final AccountVO oaccount_vo = parent.getVo();

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 2 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					accJtf = new JTextField[] { jtf_accountName, jtf_balance };
					boolean isOk = NumExceptioin.isDouble(jtf_balance);
					if (isOk && isAllEntered.isEntered(accJtf)){
						AccountVO naccount_vo = new AccountVO(jtf_accountName
								.getText(), jtf_balance.getText());
						FinanceblService bl;
						try {
							bl = new FinanceController();
							try {
								bl.EditAccount(oaccount_vo, naccount_vo);
							} catch (ExistException e1) {
								RunTip.makeTip("该账户信息已存在", false);
								return;
							}
						} catch (RemoteException e1) {
							RunTip.makeTip("网络异常", false);
							return;
						}
			
						rowContent = new String[]{jtf_accountName
								.getText(), jtf_balance.getText()};
						parent.updateAfterConfirm(rowContent);
						RunTip.makeTip("修改成功", true);
						dispose();
					} else if ((!isOk) && isAllEntered.isEntered(accJtf)) {
						RunTip.makeTip("请输入正确格式的信息", false);
					} else if (isOk && !isAllEntered.isEntered(accJtf)) {
						RunTip.makeTip("仍有信息未输入", false);
					} else if (!isOk && !isAllEntered.isEntered(accJtf)) {
						RunTip.makeTip("请输入所有正确格式的信息", false);
					}
				
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
	
	// 错误提示信息是否已经被添加
	protected boolean isBalanceAdd = false;
	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener{

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void focusLost(FocusEvent e) {
			JTextField temp = (JTextField) e.getSource();
			if(temp==jtf_balance){
				if (!NumExceptioin.isDouble(jtf_balance)) {
					isBalanceAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("请输入数据", JLabel.CENTER);
						tip1.setBounds(x + addx, y + addy+height, jtf_width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				} else {
					if (isBalanceAdd
							&& !"".equalsIgnoreCase(jtf_balance.getText()
									.trim())) {
						isBalanceAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
		}	
	}
	/**
	 * 添加错误提示信息
	 * 
	 * @param tip
	 */
	public void addTip(JLabel tip) {
		this.add(tip);
		this.repaint();
	}

	/**
	 * 移除错误提示信息
	 * 
	 * @param tip
	 */
	public void removeTip(JLabel tip) {
		this.remove(tip);
		this.repaint();
	}
}
