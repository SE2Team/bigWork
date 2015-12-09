/**
 * 中转中心库存管理人员查看库存界面
 */
package presentation.commodityui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckStockPanel extends JPanel{

	int x=40,y=180,jl_width=100,jtf_width=160,height=30,addx1=100,addy=70,addx2=180;
	
	//定义起始时间，结束时间的label
	JLabel startDate,endDate;
	//定义对应的文本框
	JTextField jtf_startDate,jtf_endDate;
	//定义查询按钮
	JButton search;
	//定义字体
	Font font = new Font("宋体",Font.PLAIN,20);
	public CheckStockPanel() {

	this.setLayout(null);
	
	startDate = new JLabel("起始时间",JLabel.CENTER);
	startDate.setFont(font);
	startDate.setBounds(x, y, jl_width, height);
	
	jtf_startDate = new JTextField();
	jtf_startDate.setFont(font);
	jtf_startDate.setBounds(x+addx1, y, jtf_width, height);
	
	endDate = new JLabel("结束时间",JLabel.CENTER);
	endDate.setFont(font);
	endDate.setBounds(x+addx1+addx2, y, jl_width, height);
	
	jtf_endDate = new JTextField();
	jtf_endDate.setFont(font);
	jtf_endDate.setBounds(x+2*addx1+addx2, y, jtf_width, height);
	
	search = new JButton("查询");
	search.setFont(font);
	search.setBounds(x+2*addx1+30, y+addy, jl_width, height);
	
	this.add(startDate);
	this.add(jtf_startDate);
	this.add(endDate);
	this.add(jtf_endDate);
	this.add(search);
	
	}

}
