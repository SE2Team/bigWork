package presentation.manageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class modifyVehicleDialog extends JDialog{

private VehiclePanel parent;
	
	public modifyVehicleDialog(VehiclePanel parent) {
		this.parent = parent;
		this.setContentPane(new modifyVehiclePanel());
		this.setSize(400, 350);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
	}

	class modifyVehiclePanel extends JPanel{
		
		//设置所有文字的字体
		Font font = new Font("宋体",Font.PLAIN,20);
		//定义车辆代号，车牌号，购买时间，服役时间的label
		JLabel addInfo,vehicleNum,licensePlate,buyDate,useTime;
		
		//定义对应的文本框
		JTextField jtf_vehicleNum,jtf_licensePlate,jtf_buyDate,jtf_useTime;
		
		//定义确定，取消按钮
		JButton sure,cancel;
		
		modifyVehiclePanel(){
			this.setLayout(null);
			int x=40,y=60,addx=110,addy=40,jl_width=100,jtf_width=200,height=30;
			
			addInfo = new JLabel("修改车辆信息",JLabel.CENTER);
			addInfo.setFont(new Font("楷体",Font.PLAIN,25));
			addInfo.setBounds(100, 10, jtf_width, height);
			
			vehicleNum = new JLabel("车辆代号",JLabel.CENTER);
			vehicleNum.setFont(font);
			vehicleNum.setBounds(x, y, jl_width, height);
			
			jtf_vehicleNum = new JTextField();
			jtf_vehicleNum.setFont(font);
			jtf_vehicleNum.setBounds(x+addx, y, jtf_width, height);
			
			licensePlate = new JLabel("车牌号",JLabel.CENTER);
			licensePlate.setFont(font);
			licensePlate.setBounds(x, y+addy, jl_width, height);
			
			jtf_licensePlate = new JTextField();
			jtf_licensePlate.setFont(font);
			jtf_licensePlate.setBounds(x+addx, y+addy, jtf_width, height);
			
			buyDate = new JLabel("购买时间",JLabel.CENTER);
			buyDate.setFont(font);
			buyDate.setBounds(x, y+2*addy, jl_width, height);
			
			jtf_buyDate = new JTextField();
			jtf_buyDate.setFont(font);
			jtf_buyDate.setBounds(x+addx, y+2*addy, jtf_width, height);
			
			useTime = new JLabel("服役时间",JLabel.CENTER);
			useTime.setFont(font);
			useTime.setBounds(x, y+3*addy, jl_width, height);
			
			jtf_useTime = new JTextField();
			jtf_useTime.setFont(font);
			jtf_useTime.setBounds(x+addx, y+3*addy, jtf_width, height);
			
			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+4*addy+10, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx, y+4*addy+10, 80, height);
			cancel.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			this.add(addInfo);
			this.add(vehicleNum);
			this.add(jtf_vehicleNum);
			this.add(licensePlate);
			this.add(jtf_licensePlate);
			this.add(vehicleNum);
			this.add(jtf_vehicleNum);
			this.add(buyDate);
			this.add(jtf_buyDate);
			this.add(useTime);
			this.add(jtf_useTime);
			this.add(sure);
			this.add(cancel);
		}
	}
}
