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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


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
	
	// 定义表格模型对象
	private DefaultTableModel tableModel;
	
	// 定义表格各列的对象
	Object c0, c1, c2;
	
	//被选中的要修改的行号
	int modRowNum;
	
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
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int rowNum = userTable.getSelectedRow();
				if(rowNum!=-1){
					tableModel.removeRow(rowNum);
				}
			}
		});
		this.add(deleteButton);
		
		modifyButton=new JButton("修改");
		modifyButton.setFont(font2);
		modifyButton.setBounds(350, 20, width, height);
		final modifyAccountNumDialog modAccount = new modifyAccountNumDialog(UserAdminPanel.this);
		modifyButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				modRowNum = userTable.getSelectedRow();
				if(modRowNum!=-1){
					modAccount.setVisible(true);
				}
			}
		});
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
		
		String[] column = { "用户名","密码","权限"};
		String[] s1 = {"admin","12345","高"};
		String row[][] = { s1 };
		tableModel = new DefaultTableModel(row, column);
		userTable = new JTable(tableModel);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
		userTable.addMouseListener(new MouseAdapter() {//鼠标事件
			public void mouseClicked(MouseEvent e){
				int seletedRow = userTable.getSelectedRow();// 获得选中行索引
				c0 = tableModel.getValueAt(seletedRow, 0);
				c1 = tableModel.getValueAt(seletedRow, 1);
				c2 = tableModel.getValueAt(seletedRow, 2);
				modAccount.getUserName().setText(c0.toString());
				modAccount.getPassword().setText(c1.toString());
				modAccount.getLimit().setText(c2.toString());
			}
		});
		userTable.setFont(font2);
		userTable.setRowHeight(20);
		jsp = new JScrollPane(userTable);
		jsp.setBounds(0, 70, 650, 400);
		add(jsp);
		
	}
	
	/**
	 * 添加输入的用户信息
	 * @param row
	 */
	public void addAfterConfirm(String[] row) {
		tableModel.addRow(row);
	}

	/**
	 * 修改用户信息
	 * @param row
	 */
	public void updateAfterConfirm(String[] row){
		tableModel.setValueAt(row[0], modRowNum, 0);
		tableModel.setValueAt(row[1], modRowNum, 1);
		tableModel.setValueAt(row[2], modRowNum, 2);
	}
	
	/**
	 * 焦点监听
	 * @author Administrator
	 *
	 */
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
