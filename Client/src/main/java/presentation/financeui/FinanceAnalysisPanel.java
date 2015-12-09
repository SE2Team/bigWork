package presentation.financeui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 财务人员查看统计分析界面
 * @author WANXING
 *完成2
 */
public class FinanceAnalysisPanel extends JPanel{
	int width=70,height=30;
	private JTabbedPane tab;
	private JPanel bussingPanel;//经营情况
	private JPanel costPanel;//成本收益
	//经营情况表
	private JLabel t1Label;
	private JLabel startLabel;
	private JLabel endLabel;
	private JTextField startField;
	private JTextField endField;
	private JScrollPane jsp1;
	private JTable bussingTable;
	private JButton gotButton;
	//成本收益表
	private JLabel t2Label;
	private JButton getButton;
	private JScrollPane jsp2;
	private JTable costTable;
	
	Font font1=new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	
	public FinanceAnalysisPanel(){
		//初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		//经营情况表
		bussingPanel=new JPanel();
		bussingPanel.setLayout(null);
		t1Label=new JLabel("经营情况表");
		startLabel=new JLabel("起始日期");
		endLabel=new JLabel("结束日期");
		startField=new JTextField();
		endField=new JTextField();
		gotButton=new JButton("导出");
		
		t1Label.setFont(font1);
		t1Label.setBounds(5, 0, 150, 40);
		
		startLabel.setFont(font2);
		startLabel.setBounds(60, 45, width, height);
		
		startField.setBounds(130, 45, 150, height);
		
		endLabel.setFont(font2);
		endLabel.setBounds(310, 45, width, height);
		
		endField.setBounds(380, 45, 150, height);
		
		gotButton.setFont(font2);
		gotButton.setBounds(550, 45, width, height);
		
		bussingPanel.add(t1Label);
		bussingPanel.add(startLabel);
		bussingPanel.add(startField);
		bussingPanel.add(endLabel);
		bussingPanel.add(endField);
		bussingPanel.add(gotButton);
		
		
		String[] column1 = { "序号","单据类型","详细信息"};
		String[] s1 = {"1","收款单","" };
		String row1[][] = { s1 };
		bussingTable = new JTable(row1, column1);
		bussingTable.setFont(font2);
		bussingTable.setRowHeight(20);
		jsp1 = new JScrollPane(bussingTable);
		jsp1.setBounds(0, 110, 650, 355);
		bussingPanel.add(jsp1);
		
		//成本收益表
		costPanel=new JPanel();
		costPanel.setLayout(null);
		t2Label=new JLabel("截至当前的成本收益表");
		getButton=new JButton("导出");
		
		t2Label.setFont(font1);
		t2Label.setBounds(5, 0, 250, 40);
		
		getButton.setFont(font2);
		getButton.setBounds(500, 0, width, height);
		
		costPanel.add(t2Label);
		costPanel.add(getButton);
		
		String[] column2 = { "序号","账户名称","余额"};
		String[] t1 = {"000x1","张XX","50" };
		String row2[][] = { t1 };
		costTable = new JTable(row2, column2);
		costTable.setFont(font2);
		costTable.setRowHeight(20);
		jsp2 = new JScrollPane(costTable);
		jsp2.setBounds(0, 50, 650, 400);
		costPanel.add(jsp2);
		
		tab.add(bussingPanel,"经营情况表");
		tab.add(costPanel,"成本收益表");
		
		tab.setBounds(0, 0, 650, 530);
		add(tab);
	}
}
