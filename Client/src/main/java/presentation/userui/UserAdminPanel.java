/**
 * 管理员用户管理界面
 */
package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.UserblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import util.UserType;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 管理员用户管理界面
 * @author Administrator
 *
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

	//定义原来的vo
	UserVO oUservo = null;
	
	// 定义表格模型对象
	private DefaultTableModel tableModel;
	
	// 定义表格各列的对象
	Object c0, c1, c2,c3;

	//定义人员类型
	UserType userType;
	
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
				Object t0 = tableModel.getValueAt(rowNum, 0);
				Object t1 = tableModel.getValueAt(rowNum, 1);
				Object t2 = tableModel.getValueAt(rowNum, 2);
				Object t3 = tableModel.getValueAt(rowNum, 3);
				String type = t3.toString();
				if ("快递员".equalsIgnoreCase(type)) {
					userType = UserType.COURIER;
				}
				if ("营业厅业务员".equalsIgnoreCase(type)) {
					userType = UserType.SALESMAN;
				}
				if ("中转中心业务员".equalsIgnoreCase(type)) {
					userType = UserType.TRANSFERMAN;
				}
				if ("中转中心库存管理人员".equalsIgnoreCase(type)) {
					userType = UserType.STOCKMANAGER;
				}
				if ("财务人员".equalsIgnoreCase(type)) {
					userType = UserType.FINANCIAL;
				}
				if ("总经理".equalsIgnoreCase(type)) {
					userType = UserType.MANAGER;
				}
				if ("管理员".equalsIgnoreCase(type)) {
					userType = UserType.ADMIN;
				}
				if(rowNum!=-1){
					UserVO vo = new UserVO(t0.toString(), t1.toString(), t2.toString(), userType);
					UserblService bl;
					try {
						bl = new UserController();
						bl.delete(vo);
					} catch (RemoteException e) {
						RunTip.makeTip("网络异常", false);
						return;
					}
					
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
		//---------------------------------
		Iterator<UserVO> iterator = null;
		UserblService userblService;
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			userblService = new UserController();
			iterator = userblService.getUser();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			RunTip.makeTip("网络异常", false);
		}
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		int n = list.size();
		final String row[][] = new String[n][4];
		for (int j = 0; j < n; j++) {
			String[] str = new String[4];
			UserVO vo = list.get(j);
			str[0] = vo.getId();
			str[1] = vo.getPassword();
			str[2] = vo.getName();
			str[3] = vo.getPermission().toString();
			row[j] = str;
		}
		String[] column = { "用户名","密码","姓名","权限"};
		userTable = Table.getTable(column, row);
		tableModel = (DefaultTableModel) userTable.getModel();


		//----------------------------------------------------------------

		checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = checkField.getText();
                for (int j = 0; j < row.length; j++) {
                    if (row[j][0].equals(name)) {
                        userTable.setRowSelectionInterval(j, j);
                    }
                }
            }
        });


		//	userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
		userTable.addMouseListener(new MouseAdapter() {//鼠标事件
			public void mouseClicked(MouseEvent e){
				int seletedRow = userTable.getSelectedRow();// 获得选中行索引
				c0 = tableModel.getValueAt(seletedRow, 0);
				c1 = tableModel.getValueAt(seletedRow, 1);
				c2 = tableModel.getValueAt(seletedRow, 2);
				c3 = tableModel.getValueAt(seletedRow, 3);
				modAccount.getUserName().setText(c0.toString());
				modAccount.getPassword().setText(c1.toString());
				modAccount.getname().setText(c2.toString());
				modAccount.getLimit().setSelectedItem(c3.toString());
				oUservo = new UserVO(c0.toString(), c1.toString(), c2.toString(), userType);
			}
		});
		userTable.setFont(font2);
		userTable.setRowHeight(20);
		jsp = new JScrollPane(userTable);
		jsp.setBounds(0, 70, 650, 400);
		add(jsp);
		
	}

	/**
	 * 获取原来的账户信息的vo
	 *
	 * @return
	 */
	public UserVO getVo() {
		return oUservo;
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
		tableModel.setValueAt(row[3], modRowNum, 3);
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
