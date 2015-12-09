/*
 * 营业厅业务员管理车辆信息界面
 */
package presentation.manageui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

public class VehiclePanel extends JPanel{

	int x=60,y=60,width=70,height=30,addx=100,addy=70;
	
	//定义车辆信息的label
	JLabel vehicleInfo;
	//定义添加，删除，修改，查询按钮
	JButton add, delete,modify,search;
	//定义表格
	JTable vehicleTable = null;
	//定义输入车辆代号文本框
	JTextField inputInfo;
//	Vector row,column;
	JScrollPane vehiclepane = null;
	
	Font font1 = new Font("楷体",Font.PLAIN,30);
	Font font2 = new Font("宋体",Font.PLAIN,15);
	
	public VehiclePanel(){
		
		this.setLayout(null);
		
		vehicleInfo = new JLabel("车辆信息",JLabel.CENTER);
		vehicleInfo.setFont(font1);
		vehicleInfo.setBounds(220, 10, 200, height);
		
		add = new JButton("添加");
		add.setFont(font2);
		add.setBounds(x, y, width, height);
		
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new addVehicleDialog(VehiclePanel.this).setVisible(true);
			
			}
		});
		
		delete = new JButton("删除");
		delete.setFont(font2);
		delete.setBounds(x+addx, y, width, height);
		
		modify = new JButton("修改");
		modify.setFont(font2);
		modify.setBounds(x+2*addx, y, width, height);
		
		modify.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new modifyVehicleDialog(VehiclePanel.this).setVisible(true);
			
			}
		});

		inputInfo = new JTextField();
		inputInfo.setFont(font2);
		inputInfo.setText("请输入车辆代号");
		inputInfo.setForeground(Color.GRAY);
		inputInfo.addFocusListener(new TextFocus());
		inputInfo.setBounds(x+3*addx+20, y, 120, height);
		
		search = new JButton("查找");
		search.setFont(font2);
		search.setBounds(x+4*addx+50, y, width, height);
		
		String[] column={"车辆代号","车牌号","购买时间","服役时间"};
        String[] s1 = { "025000000", "苏A 00000","2008-8-8","3"};
        String row[][] = { s1 };
		vehicleTable = new JTable(row,column);
		vehicleTable.setFont(font2);
		vehicleTable.setRowHeight(20);
		vehiclepane = new JScrollPane(vehicleTable);
		vehiclepane.setBounds(0, y+addy, 650, 400);
		
		this.add(vehicleInfo);
		this.add(add);
		this.add(delete);
		this.add(modify);
		this.add(inputInfo);
		this.add(search);
		this.add(vehiclepane);
	}
	
	class TextFocus implements FocusListener{

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if("请输入车辆代号".equalsIgnoreCase(inputInfo.getText())){
				inputInfo.setText("");
				inputInfo.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			if("".equalsIgnoreCase(inputInfo.getText().trim())){
				inputInfo.setForeground(Color.GRAY);
				inputInfo.setText("请输入车辆代号");
			}
		}
		
	}
}
