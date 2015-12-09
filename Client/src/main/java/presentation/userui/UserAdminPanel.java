/**
 * 管理员用户管理界面
 */
package presentation.userui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.manageui.addAccountNumDialog;


/**
 * 
 * @author WANXING
 *完成
 */

public class UserAdminPanel extends JPanel{
	int width=70,height=30;
	
	//定义用户列表的label
	private JLabel titleLabel;
	
	//定义添加，删除，修改，查找按钮
	private JButton addButton;
	private JButton deleteButton;
	private JButton modifyButton;
	private JButton checkButton;
	
	//定义输入用户名的文本框
	private JTextField checkField;
	
	//定义放表格的scrollPane
	private JScrollPane jsp;
	
	//定义用户列表的表格
	private JTable userTable;
	
	Font font1=new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	
	public UserAdminPanel(){

		this.setLayout(null);

		titleLabel=new JLabel("用户列表");
		titleLabel.setFont(font1);
		titleLabel.setBounds(10, 20, 200, height);
		this.add(titleLabel);
		
		addButton=new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(190, 20, width, height);
		this.add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new addAccountNumDialog(UserAdminPanel.this).setVisible(true);
			}
		});
		
		deleteButton=new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(270, 20, width, height);
		this.add(deleteButton);
		
		modifyButton=new JButton("修改");
		modifyButton.setFont(font2);
		modifyButton.setBounds(350, 20, width, height);
		this.add(modifyButton);
		
		checkField=new JTextField(16);
		checkField.setFont(font2);
		checkField.setForeground(Color.GRAY);
		checkField.setText("请输入用户名");
		checkField.addFocusListener(new TextFocus());
		checkField.setBounds(435, 20, 120, height);
		this.add(checkField);
		
		checkButton=new JButton("查找");
		checkButton.setFont(font2);
		checkButton.setBounds(560, 20, width, height);
		this.add(checkButton);
		
		String[] column = { "序号","用户名","密码","权限"};
		String[] s1 = {"1","admin","12345","高"};
		String row[][] = { s1 };
		userTable = new JTable(row, column);
		userTable.setFont(font2);
		userTable.setRowHeight(20);
		jsp = new JScrollPane(userTable);
		jsp.setBounds(0, 70, 650, 400);
		add(jsp);
		
	}
	
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请输入用户名".equalsIgnoreCase(checkField.getText())) {
				checkField.setText("");
				checkField.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(checkField.getText().trim())) {
				checkField.setForeground(Color.GRAY);
				checkField.setText("请输入用户名");
			}
		}

	}
}
