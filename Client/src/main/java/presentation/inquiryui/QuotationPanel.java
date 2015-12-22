/*
 * 查询报价和时间界面
 */
package presentation.inquiryui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import presentation.exception.NumExceptioin;
import presentation.listui.AddresseeInfoPanel;
public class QuotationPanel extends JPanel{

	int x=150,y=120,addx=170,addy1=50,addy2=80,width=200,height=30;
	//定义订单号，报价，到达时间的label
	JLabel ordernum,quotation,arriveTime;
	//定义对应的文本框
	JTextField jtf_ordernum,jtf_quotation,jtf_arriveTime;
	//定义查询按钮
	JButton search;
	//定义字体
	Font font1 = new Font("楷体",Font.PLAIN,25);
	Font font2 = new Font("宋体",Font.PLAIN,18);
	//定义错误提示的label
	JLabel tip;
	//错误提示信息是否已经被添加
	boolean isOrderAdd = false;
	
	public QuotationPanel(){

		this.setLayout(null);

		JLabel ordernum = new JLabel("请输入订单号");
		ordernum.setBounds(x,y, width, height);
		ordernum.setFont(font1);
		
		jtf_ordernum = new JTextField(10);
		jtf_ordernum.setFont(font2);
		jtf_ordernum.setBounds(x+addx,y,width, height);
		
		search = new JButton("查询");
		search.setBounds(x+140,y+addy2-15, width/2, height);
		search.setFont(font2);
		search.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(!NumExceptioin.isOrderValid(jtf_ordernum)){
					isOrderAdd=true;
					tip=new JLabel("订单号位数应为10位",JLabel.CENTER);
					tip.setBounds(x+addx, y+30, width, height);
					tip.setFont(font2);
					tip.setForeground(Color.RED);
					addTip(tip);
				}
				else{
					if(isOrderAdd&&!"".equalsIgnoreCase(jtf_ordernum.getText().trim())){
						isOrderAdd = false;
						removeTip(tip);
						tip=null;
					}
				}
			}
		});
		
		quotation = new JLabel("报        价");
		quotation.setFont(font1);
		quotation.setBounds(x, y+addy1+addy2,width, height);
		
		jtf_quotation = new JTextField(20);
		jtf_quotation.setFont(font2);
		jtf_quotation.setText("0");
		jtf_quotation.setEditable(false);
		jtf_quotation.setBounds(x+addx,y+addy1+addy2,width, height);
		
		arriveTime = new JLabel("预计到达时间");
		arriveTime.setFont(font1);	
		arriveTime.setBounds(x, y+2*addy1+addy2, width, height);
		
		jtf_arriveTime = new JTextField();
		jtf_arriveTime.setBounds(x+addx, y+2*addy1+addy2, width, height);
		jtf_arriveTime.setFont(font2);
		jtf_arriveTime.setText("0");
		jtf_arriveTime.setEditable(false);
		
		this.add(ordernum);
		this.add(jtf_ordernum);
		this.add(search);
		this.add(quotation);
		this.add(jtf_quotation);
		this.add(arriveTime);
		this.add(jtf_arriveTime);

	}
	
	/**
	 * 添加错误提示信息
	 * @param tip
	 */
	private void addTip(JLabel tip){
		this.add(tip);
		this.repaint();
	}
	
	/**
	 * 移除错误提示信息
	 * @param tip
	 */
	private void removeTip(JLabel tip){
		this.remove(tip);
		this.repaint();
	}
	
}
