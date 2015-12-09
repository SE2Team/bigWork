/**
 * 添加人员信息界面
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

import presentation.manageui.addAccountNumDialog.adduserPanel;
import presentation.userui.UserAdminPanel;

public class addEmployeeInfoDialog extends JDialog{
	
	private EmpAndInsPanel parent;

	public addEmployeeInfoDialog(EmpAndInsPanel parent) {

		this.parent = parent;
		this.setContentPane(new addUserInfoPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	class addUserInfoPanel extends JPanel{
		int x = 20, y = 60, addx = 120, addy = 50,  jl_width = 100,
				jtf_width = 200, height = 25;
		
		// 设置所有文字的字体
		Font font = new Font("宋体", Font.PLAIN, 20);
		// 定义添加人员信息，姓名，年龄，职位，账号的label
		JLabel addInfo, name, age, position,accountNum;
		// 定义对应的文本框
		JTextField jtf_name, jtf_age, jtf_position,jtf_accountNum;
		// 定义确定，取消按钮
		JButton sure, cancel;
		
		addUserInfoPanel(){
			this.setLayout(null);

			addInfo = new JLabel("添加人员信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);
			
			name = new JLabel("姓名", JLabel.CENTER);
			name.setFont(font);
			name.setBounds(x, y, jl_width, height);

			jtf_name = new JTextField();
			jtf_name.setFont(font);
			jtf_name.setBounds(x + addx, y, jtf_width, height);
			
			age = new JLabel("年龄", JLabel.CENTER);
			age.setFont(font);
			age.setBounds(x, y+addy, jl_width, height);

			jtf_age = new JTextField();
			jtf_age.setFont(font);
			jtf_age.setBounds(x + addx, y+addy, jtf_width, height);
			
			position = new JLabel("职位", JLabel.CENTER);
			position.setFont(font);
			position.setBounds(x, y+2*addy, jl_width, height);

			jtf_position = new JTextField();
			jtf_position.setFont(font);
			jtf_position.setBounds(x + addx, y+2*addy, jtf_width, height);
			
			accountNum = new JLabel("账号", JLabel.CENTER);
			accountNum.setFont(font);
			accountNum.setBounds(x, y+3*addy, jl_width, height);

			jtf_accountNum = new JTextField();
			jtf_accountNum.setFont(font);
			jtf_accountNum.setBounds(x + addx, y+3*addy, jtf_width, height);
			
			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+4*addy+10, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx, y+4*addy+10, 80, height);
			cancel.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			this.add(addInfo);
			this.add(name);
			this.add(jtf_name);
			this.add(age);
			this.add(jtf_age);
			this.add(position);
			this.add(jtf_position);
			this.add(accountNum);
			this.add(jtf_accountNum);
			this.add(sure);
			this.add(cancel);
		}
	}
	
}
