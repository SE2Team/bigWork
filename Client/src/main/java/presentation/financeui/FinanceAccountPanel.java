package presentation.financeui;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * 财务人员账户管理界面
 * @author WANXING
 *完成
 */

public class FinanceAccountPanel extends JPanel{

	private int x=60,y=70,width=70,height=30,addx=60,addy=70;
	private JLabel NableName;
	private JTextField jtfName;
	//定义添加，删除，修改，查询按钮
	private JButton operation1;
	private JButton operation2;
	private JButton operation3;
	private JButton operation4;
	//定义用来放表格的scrollPanel
	private JScrollPane jsp;
	//定义表格
	private JTable accountTable;
	// 定义表格模型对象
	private DefaultTableModel tableModel;
	//定义所有字体
	Font font1=new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	// 定义表格各列的对象
	Object c0, c1;
	//被选中的要修改的行号
	int modRowNum;
	public FinanceAccountPanel(){
		//初始化各组件
		this.setLayout(null);
		NableName=new JLabel("账户列表");
		NableName.setFont(font1);
		jtfName=new JTextField(16);
		jtfName.setText("请输入账户名称");
		operation1=new JButton("添加");
		operation2=new JButton("删除");
		operation3=new JButton("修改");
		operation4=new JButton("查找");
		
		//界面
		NableName.setFont(font1);
		NableName.setBounds(10, 20, 200, height);
		add(NableName);
		
		operation1.setFont(font2);
		operation1.setBounds(190, 20, width, height);
		operation1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new addAccountDialog(FinanceAccountPanel.this).setVisible(true);
			}
		});
		add(operation1);
		
		operation2.setFont(font2);
		operation2.setBounds(270, 20, width, height);
		operation2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int rowNum = accountTable.getSelectedRow();
				tableModel.removeRow(rowNum);
			}
		});
		add(operation2);
		
		operation3.setFont(font2);
		operation3.setBounds(350, 20, width, height);
		final modifyAccountDialog modAccount = new modifyAccountDialog(FinanceAccountPanel.this);
		operation3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				modRowNum = accountTable.getSelectedRow();
				if (modRowNum != -1) {				
					modAccount.setVisible(true);
				}
			}
		});
		add(operation3);
		
		jtfName.setFont(font2);
		jtfName.setBounds(435, 20, 120, height);
		jtfName.setForeground(Color.GRAY);
		jtfName.addFocusListener(new TextFocus());
		add(jtfName);
		
		operation4.setFont(font2);
		operation4.setBounds(560, 20, width, height);
		add(operation4);
		
		String[] column = {"账户名称","余额"};
		String[] s1 = {"张XX","50" };
		String row[][] = { s1 };
		tableModel = new DefaultTableModel(row, column);
        accountTable = new JTable(tableModel);
        accountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        accountTable.addMouseListener(new MouseAdapter() {//鼠标事件
        	public void mouseClicked(MouseEvent e) {
				int selectedRow = accountTable.getSelectedRow(); // 获得选中行索引
				c0 = tableModel.getValueAt(selectedRow, 0);
				c1 = tableModel.getValueAt(selectedRow, 1);
				modAccount.getAccountName().setText(c0.toString());
				modAccount.getAccountBalance().setText(c1.toString());
        	}
		});
		accountTable.setFont(font2);
		accountTable.setRowHeight(20);
		jsp = new JScrollPane(accountTable);
		jsp.setBounds(0, y , 650, 400);
		add(jsp);	
	}
	
	/**
	 * 添加用户输入的账户信息
	 * 
	 * @param row
	 */
	public void addAfterConfirm(String[] row) {
		tableModel.addRow(row);
	}

	/**
	 * 修改账户信息
	 * @param row
	 */
	public void updateAfterConfirm(String[] row) {
		tableModel.setValueAt(row[0], modRowNum, 0);
		tableModel.setValueAt(row[1], modRowNum, 1);
	}

	
	/**
	 * 焦点监听
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请输入账户名称".equalsIgnoreCase(jtfName.getText())) {
				jtfName.setText("");
				jtfName.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(jtfName.getText().trim())) {
				jtfName.setForeground(Color.GRAY);
				jtfName.setText("请输入账户名称");
			}
		}
	}
}