package presentation.manageui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addInstituInfoDialog extends JDialog {

	private EmpAndInsPanel parent;

	public addInstituInfoDialog(EmpAndInsPanel parent) {
		this.parent = parent;
		this.setContentPane(new addInstituInfoPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	class addInstituInfoPanel extends JPanel {

		int x = 20, y = 100, addx = 120, addy = 65, jl_width = 100,
				jtf_width = 200, height = 25;

		// 设置所有文字的字体
		Font font = new Font("宋体", Font.PLAIN, 20);
		// 定义添加人员信息，姓名，年龄，职位，账号的label
		JLabel addInfo, institution, institutionNum;
		// 定义对应的文本框
		JTextField jtf_institution, jtf_institutionNum;
		// 定义确定，取消按钮
		JButton sure, cancel;

		addInstituInfoPanel() {
			this.setLayout(null);

			addInfo = new JLabel("添加机构信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 20, jtf_width, height);

			institution = new JLabel("机构名称", JLabel.CENTER);
			institution.setFont(font);
			institution.setBounds(x, y, jl_width, height);

			jtf_institution = new JTextField();
			jtf_institution.setFont(font);
			jtf_institution.setBounds(x + addx, y, jtf_width, height);

			institutionNum = new JLabel("机构编号", JLabel.CENTER);
			institutionNum.setFont(font);
			institutionNum.setBounds(x, y + addy, jl_width, height);

			jtf_institutionNum = new JTextField();
			jtf_institutionNum.setFont(font);
			jtf_institutionNum.setBounds(x + addx, y + addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+2*addy+10, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx, y+2*addy+10, 80, height);
			cancel.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			this.add(addInfo);
			this.add(institution);
			this.add(jtf_institution);
			this.add(institutionNum);
			this.add(jtf_institutionNum);
			this.add(sure);
			this.add(cancel);
		}
	}
}
