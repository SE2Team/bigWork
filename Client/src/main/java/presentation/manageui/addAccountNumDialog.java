/**
 * 添加账号信息界面
 */
package presentation.manageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.userui.UserAdminPanel;

public class addAccountNumDialog extends JDialog {

	private UserAdminPanel parent;

	public addAccountNumDialog(UserAdminPanel parent) {

		this.parent = parent;
		this.setContentPane(new adduserPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	class adduserPanel extends JPanel {
		
		int x = 20, y = 60, addx = 120, addy = 65,  jl_width = 100,
				jtf_width = 200, height = 25;
		
		// 设置所有文字的字体
		Font font = new Font("宋体", Font.PLAIN, 20);
		// 定义添加账号信息，用户名，密码，权限的label
		JLabel addInfo, userName, password, limit;
		// 定义对应的文本框
		JTextField jtf_userName, jtf_password, jtf_limit;
		// 定义确定，取消按钮
		JButton sure, cancel;
		
		adduserPanel(){
			this.setLayout(null);

			addInfo = new JLabel("添加账号信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			userName = new JLabel("用户名", JLabel.CENTER);
			userName.setFont(font);
			userName.setBounds(x, y, jl_width, height);

			jtf_userName = new JTextField();
			jtf_userName.setFont(font);
			jtf_userName.setBounds(x + addx, y, jtf_width, height);
			
			password = new JLabel("密码", JLabel.CENTER);
			password.setFont(font);
			password.setBounds(x, y+addy, jl_width, height);

			jtf_password = new JTextField();
			jtf_password.setFont(font);
			jtf_password.setBounds(x + addx, y+addy, jtf_width, height);
			
			limit = new JLabel("权限", JLabel.CENTER);
			limit.setFont(font);
			limit.setBounds(x, y+2*addy, jl_width, height);

			jtf_limit = new JTextField();
			jtf_limit.setFont(font);
			jtf_limit.setBounds(x + addx, y+2*addy, jtf_width, height);
			
			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+3*addy+10, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx, y+3*addy+10, 80, height);
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
			this.add(limit);
			this.add(jtf_limit);
			this.add(sure);
			this.add(cancel);
		}
	}
}
