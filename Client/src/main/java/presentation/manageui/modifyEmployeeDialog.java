package presentation.manageui;

import presentation.commonui.swing.MyDialog;
import presentation.exception.NumExceptioin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class modifyEmployeeDialog extends MyDialog {

	private EmpAndInsPanel parent;
	String saveValue = null;//选中按钮的String值
	
	public modifyEmployeeDialog(EmpAndInsPanel parent) {
		super();

		this.parent = parent;
		this.setContentPane(new modUserInfoPanel());
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 10, y = 40, addx1 = 80, addx2=100,addy = 56,  jl_width = 100,
			jtf_width = 100, height = 25;
	
	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加人员信息，姓名，性别，年龄，身份证号，职位，所属机构，账号的label
	JLabel addInfo, name, gender,age, idNum,position,institution,accountNum;
	// 定义对应的文本框
	JTextField jtf_name,jtf_age, jtf_idNum,jtf_position,jtf_institution,jtf_accountNum;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义单选按钮
	JRadioButton jrb_male, jrb_female;
	ButtonGroup group;
	// 定义错误提示的label
	JLabel tip1, tip2, tip3;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	
	class modUserInfoPanel extends JPanel{
		
		RadioButtonListener radioButtonListener = new RadioButtonListener();
		
		modUserInfoPanel(){
			this.setLayout(null);

			addInfo = new JLabel("修改人员信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, 2*jl_width, height);
			
			name = new JLabel("姓名", JLabel.CENTER);
			name.setFont(font);
			name.setBounds(x, y, jl_width, height);

			jtf_name = new JTextField();
			jtf_name.setFont(font2);
			jtf_name.setBounds(x + addx1, y, jtf_width, height);
			
			gender = new JLabel("性别", JLabel.CENTER);
			gender.setFont(font);
			gender.setBounds(x + addx2 + addx1, y, jl_width, height);

			jrb_male = new JRadioButton("男");
			jrb_male.setFont(font2);
			jrb_male.addActionListener(radioButtonListener);
			jrb_male.setBounds(x + addx1 + addx2+80, y, jtf_width / 2, height);

			jrb_female = new JRadioButton("女");
			jrb_female.setFont(font2);
			jrb_female.addActionListener(radioButtonListener);
			jrb_female.setBounds(x + addx1 + addx2 + 130, y, jtf_width / 2,
					height);

			group = new ButtonGroup();
			group.add(jrb_male);
			group.add(jrb_female);
			
			age = new JLabel("年龄", JLabel.CENTER);
			age.setFont(font);
			age.setBounds(x, y+addy, jl_width, height);

			jtf_age = new JTextField();
			jtf_age.setFont(font2);
			jtf_age.setBounds(x + addx1, y+addy, jtf_width, height);
			
			idNum = new JLabel("身份证号",JLabel.CENTER);
			idNum.setFont(font);
			idNum.setBounds(x, y+2*addy, jl_width, height);
			
			jtf_idNum = new JTextField();
			jtf_idNum.setFont(font2);
			jtf_idNum.setBounds(x + addx1+30, y+2*addy, 2*jtf_width, height);
			jtf_idNum.addFocusListener(new TextFocus());
			
			institution = new JLabel("所属机构",JLabel.CENTER);
			institution.setFont(font);
			institution.setBounds(x, y+3*addy, jl_width, height);
			
			jtf_institution = new JTextField();
			jtf_institution.setFont(font2);
			jtf_institution.setBounds(x + addx1+30, y+3*addy, 2*jtf_width, height);
			
			position = new JLabel("职位", JLabel.CENTER);
			position.setFont(font);
			position.setBounds(x, y+4*addy, jl_width, height);

			jtf_position = new JTextField();
			jtf_position.setFont(font2);
			jtf_position.setBounds(x + addx1+30, y+4*addy, 2*jtf_width, height);
			
			accountNum = new JLabel("账号", JLabel.CENTER);
			accountNum.setFont(font);
			accountNum.setBounds(x + addx2 + addx1, y+addy, jl_width, height);

			jtf_accountNum = new JTextField();
			jtf_accountNum.setFont(font2);
			jtf_accountNum.setBounds(x + 2*addx1+addx2, y+addy, jtf_width, height);
			jtf_accountNum.addFocusListener(new TextFocus());
			
			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+5*addy, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {	
					rowContent = new String[] { jtf_name.getText(), saveValue,
							jtf_age.getText(), jtf_idNum.getText(),
							jtf_position.getText(), jtf_institution.getText(),
							jtf_accountNum.getText() };
					parent.updateEmpInfo(rowContent);
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx1, y+5*addy, 80, height);
			cancel.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			this.add(addInfo);
			this.add(name);
			this.add(jtf_name);
			this.add(gender);
			this.add(jrb_male);
			this.add(jrb_female);
			this.add(age);
			this.add(jtf_age);
			this.add(idNum);
			this.add(jtf_idNum);
			this.add(institution);
			this.add(jtf_institution);
			this.add(position);
			this.add(jtf_position);
			this.add(accountNum);
			this.add(jtf_accountNum);
			this.add(sure);
			this.add(cancel);
		}
	}
	
	/**
	 * 获取人员姓名的文本框
	 * @return
	 */
	public JTextField getEmployeeName(){
		return jtf_name;
	}
	
	/**
	 * 获取单选按钮男
	 * @return
	 */
	public JRadioButton getMale(){
		return jrb_male;
	}
	
	/**
	 * 获取单选按钮女
	 * @return
	 */
	public JRadioButton getFemale(){
		return jrb_female;
	}
	
	/**
	 * 获取人员年龄的文本框
	 * @return
	 */
	public JTextField getAge(){
		return jtf_age;
	}
	
	/**
	 * 获取人员身份证号的文本框
	 * @return
	 */
	public JTextField getIdNum(){
		return jtf_idNum;
	}
	
	/**
	 * 获取人员所属机构的文本框
	 * @return
	 */
	public JTextField getInstitution(){
		return jtf_institution;
	}
	
	/**
	 * 获取人员职位的文本框
	 * @return
	 */
	public JTextField getPosition(){
		return jtf_position;
	}
	
	/**
	 * 获取人员用户名的文本框
	 * @return
	 */
	public JTextField getAccountNum(){
		return jtf_accountNum;
	}
	/**
	 * 单选按钮的监听
	 * @author Administrator
	 *
	 */
	class RadioButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JRadioButton temp = (JRadioButton) e.getSource();

			if (temp.isSelected()) {
				saveValue = temp.getText();
			}
		}

	}
	

	//错误提示信息是否已经被添加
	boolean isAccountNumAdd = false;
	boolean isIdNumAdd = false;
	
	/**
	 * 监听焦点
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener{

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if(temp==jtf_accountNum){
				if(!NumExceptioin.isAccountNumValid(jtf_accountNum)){
					isAccountNumAdd = true;
					if(tip1==null){
						tip1 = new JLabel("账号位数不符规范", JLabel.CENTER);
						tip1.setBounds(x + addx1+addx2+35, y+addy+height, jtf_width+60, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				}
				else{
					if (isAccountNumAdd&&!"".equalsIgnoreCase(jtf_accountNum.getText().trim())) {
						isAccountNumAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if(temp==jtf_idNum){
				if (!NumExceptioin.isIdValid(jtf_idNum)) {
					isIdNumAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("身份证号位数应为18位", JLabel.CENTER);
						tip2.setBounds(x + addx1+30, y+2*addy+height, 2*jtf_width, height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}

				} else {
					if (isIdNumAdd&&!"".equalsIgnoreCase(jtf_idNum.getText().trim())) {
						isIdNumAdd = false;
						removeTip(tip2);
						tip2 = null;
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
