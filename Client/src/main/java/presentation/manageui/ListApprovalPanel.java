package presentation.manageui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * 完成
 * @author WANXING
 *
 */
//总经理审批单据
public class ListApprovalPanel extends JPanel{
	int width=100,height=20;
	private JButton waitButton;
	private JButton doneButton;
	private JButton checkButton;
	
	private JScrollPane jsp;
	private JTable listTable;
	
	Font font1=new Font("宋体", Font.PLAIN, 15);
	Font font2 = new Font("宋体", Font.PLAIN, 12);
	
	public ListApprovalPanel(){
		//初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		waitButton=new JButton("待审批单据");
		doneButton=new JButton("已审批单据");
		checkButton=new JButton("查看");
		
		//界面
		waitButton.setFont(font2);
		waitButton.setBounds(300, 15, width, height);
		
		doneButton.setFont(font2);
		doneButton.setBounds(460, 15, width, height);
		
		add(waitButton);
		add(doneButton);
		
		String[] column = { "序号","审批状态","单据类型","详细信息"};
		String[] s1 = {"1","未审批","收款单","" };
		String row[][] = { s1 };
		listTable = new JTable(row, column);
		listTable.setFont(font1);
		listTable.setRowHeight(20);
		jsp = new JScrollPane(listTable);
		jsp.setBounds(0, 70, 650, 300);
		add(jsp);
	}
	
	public void paintComponent(java.awt.Graphics g){
		super.paintComponent(g);
		g.drawLine(0, 50, 650, 50);
	}
}