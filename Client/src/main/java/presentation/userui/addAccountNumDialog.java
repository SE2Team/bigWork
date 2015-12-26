/**
 * 添加账号信息界面
 */
package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.UserblService;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ExistException;
import util.UserType;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

public class addAccountNumDialog extends JDialog {

	private UserAdminPanel parent;

	public addAccountNumDialog(UserAdminPanel parent) {

		this.parent = parent;
		this.setContentPane(new adduserPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 20, y = 60, addx = 120, addy = 55, jl_width = 100, jtf_width = 200,
			height = 25;

	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加账号信息，用户名，密码，姓名，权限的label
	JLabel addInfo, userName, password, name, limit;
	// 定义对应的文本框
	JTextField jtf_userName, jtf_password, jtf_name;
	// 定义下拉框
	JComboBox jcb_limit;
	//定义人员类型
	UserType userType;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义错误提示的label
	JLabel tip1;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	// 定义文本框的数组
	JTextField[] userJtf;

	class adduserPanel extends JPanel {

		adduserPanel() {
			this.setLayout(null);

			addInfo = new JLabel("添加账号信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			userName = new JLabel("用户名", JLabel.CENTER);
			userName.setFont(font);
			userName.setBounds(x, y, jl_width, height);

			jtf_userName = new JTextField();
			jtf_userName.setFont(font2);
			jtf_userName.setBounds(x + addx, y, jtf_width, height);
			jtf_userName.addFocusListener(new TextFocus());

			password = new JLabel("密码", JLabel.CENTER);
			password.setFont(font);
			password.setBounds(x, y + addy, jl_width, height);

			jtf_password = new JTextField();
			jtf_password.setFont(font2);
			jtf_password.setBounds(x + addx, y + addy, jtf_width, height);

			name = new JLabel("姓名", JLabel.CENTER);
			name.setFont(font);
			name.setBounds(x, y + 2 * addy, jl_width, height);

			jtf_name = new JTextField();
			jtf_name.setFont(font2);
			jtf_name.setBounds(x + addx, y + 2 * addy, jtf_width, height);

			limit = new JLabel("权限", JLabel.CENTER);
			limit.setFont(font);
			limit.setBounds(x, y + 3 * addy, jl_width, height);


			jcb_limit = new JComboBox();
			jcb_limit.addItem("快递员");
			jcb_limit.addItem("营业厅业务员");
			jcb_limit.addItem("中转中心业务员");
			jcb_limit.addItem("中转中心库存管理人员");
			jcb_limit.addItem("财务人员");
			jcb_limit.addItem("总经理");
			jcb_limit.addItem("管理员");
			jcb_limit.setFont(font2);
			jcb_limit.setBounds(x + addx, y + 3 * addy, jtf_width, height);


			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 4 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					userJtf = new JTextField[] { jtf_userName, jtf_password,
							jtf_name};
					boolean isOk = NumExceptioin
							.isAccountNumValid(jtf_userName);
					if (isOk && isAllEntered.isEntered(userJtf)) {
						//TODO 权限、
						if ("快递员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.COURIER;
						}
						if ("营业厅业务员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.SALESMAN;
						}
						if ("中转中心业务员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.TRANSFERMAN;
						}
						if ("中转中心库存管理人员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.STOCKMANAGER;
						}
						if ("财务人员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.FINANCIAL;
						}
						if ("总经理".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.MANAGER;
						}
						if ("管理员".equalsIgnoreCase(jcb_limit.getSelectedItem().toString())) {
							userType = UserType.ADMIN;
						}
						UserVO vo = new UserVO(jtf_userName.getText(),
								jtf_password.getText(), jtf_name.getText(),
								userType);
						UserblService bl;
						
						try {
							bl = new UserController();
							bl.add(vo);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							JLabel tip = new JLabel("提示：网络异常");
							tip.setFont(font2);
							JOptionPane.showMessageDialog(null, tip);
							return;
						} catch (ExistException e) {
							// TODO Auto-generated catch block
							JLabel tip = new JLabel("提示：用户信息已存在");
							tip.setFont(font2);
							JOptionPane.showMessageDialog(null, tip);
							return;
						}

						rowContent = new String[] { jtf_userName.getText(),
								jtf_password.getText(), jtf_name.getText(),
								jcb_limit.getSelectedItem().toString()};
						parent.addAfterConfirm(rowContent);
						dispose();
						JLabel tip = new JLabel("提示：添加成功");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}else if ((!isOk) && isAllEntered.isEntered(userJtf)) {
						JLabel tip = new JLabel("提示：请输入正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (isOk && !isAllEntered.isEntered(userJtf)) {
						JLabel tip = new JLabel("提示：仍有信息未输入");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (!isOk && !isAllEntered.isEntered(userJtf)) {
						JLabel tip = new JLabel("请输入所有正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}

				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 4 * addy + 10, 80, height);
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});

			this.add(addInfo);
			this.add(userName);
			this.add(jtf_userName);
			this.add(password);
			this.add(jtf_password);
			this.add(name);
			this.add(jtf_name);
			this.add(limit);
			this.add(jcb_limit);
			this.add(sure);
			this.add(cancel);
		}
	}

	// 错误提示信息是否已经被添加
	boolean isUsernameAdd = false;
		
	/**
	 * 焦点监听
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_userName) {
				if (!NumExceptioin.isAccountNumValid(jtf_userName)) {
					isUsernameAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("账号位数不符规范", JLabel.CENTER);
						tip1.setBounds(x + addx, y + height, jtf_width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				} else {
					if (isUsernameAdd&&!"".equalsIgnoreCase(jtf_userName.getText().trim())) {
						isUsernameAdd = false;
						removeTip(tip1);
						tip1=null;
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
