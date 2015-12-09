package presentation.financeui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 财务人员账户管理界面
 * @author WANXING
 *完成
 */

public class FinanceAccountPanel extends JPanel{

	private int x=60,y=70,width=70,height=30,addx=60,addy=70;
	private JLabel NableName;
	private JTextField jtfName;
	private JButton operation1;
	private JButton operation2;
	private JButton operation3;
	private JButton operation4;
	
	private JScrollPane jsp;
	private JTable accountTable;
	
	Font font1=new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	
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
		add(operation2);
		
		operation3.setFont(font2);
		operation3.setBounds(350, 20, width, height);
		add(operation3);
		
		jtfName.setFont(font2);
		jtfName.setBounds(435, 20, 120, height);
		jtfName.setForeground(Color.GRAY);
		jtfName.addFocusListener(new TextFocus());
		add(jtfName);
		
		operation4.setFont(font2);
		operation4.setBounds(560, 20, width, height);
		add(operation4);
		
		String[] column = { "序号","账户名称","余额"};
		String[] s1 = {"000x1","张XX","50" };
		String row[][] = { s1 };
		accountTable = new JTable(row, column);
		accountTable.setFont(font2);
		accountTable.setRowHeight(20);
		jsp = new JScrollPane(accountTable);
		jsp.setBounds(0, y , 650, 400);
		add(jsp);	
	}
	
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