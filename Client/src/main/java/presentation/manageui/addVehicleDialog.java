/*
 * 营业厅业务员添加车辆信息
 */
package presentation.manageui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import presentation.exception.NumExceptioin;
import businesslogic.listbl.ListController;
import businesslogic.managebl.ManageController;
import businesslogicservice.ListblService;
import businesslogicservice.ManageblService;
import vo.VehicleVO;

public class addVehicleDialog extends JDialog {
	private VehiclePanel parent;

	public addVehicleDialog(VehiclePanel parent) {
		this.parent = parent;
		this.setContentPane(new addVehiclePanel());
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 40, y = 60, addx = 110, addy = 55, jl_width = 100,
			jtf_width = 200, height = 25;

	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加车辆信息，车辆代号，车牌号，购买时间，服役时间的label
	JLabel addInfo, vehicleNum, licensePlate, buyDate, useTime;

	// 定义对应的文本框
	JTextField jtf_vehicleNum, jtf_licensePlate, jtf_buyDate, jtf_useTime;

	// 定义确定，取消按钮
	JButton sure, cancel;

	//定义错误提示信息的label
	JLabel tip1,tip2;

	class addVehiclePanel extends JPanel {


		addVehiclePanel() {
			this.setLayout(null);

			addInfo = new JLabel("添加车辆信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 10, jtf_width, height);

			vehicleNum = new JLabel("车辆代号", JLabel.CENTER);
			vehicleNum.setFont(font);
			vehicleNum.setBounds(x, y, jl_width, height);

			jtf_vehicleNum = new JTextField();
			jtf_vehicleNum.setFont(font2);
			jtf_vehicleNum.setBounds(x + addx, y, jtf_width, height);
			jtf_vehicleNum.addFocusListener(new TextFocus());

			licensePlate = new JLabel("车牌号", JLabel.CENTER);
			licensePlate.setFont(font);
			licensePlate.setBounds(x, y + addy, jl_width, height);

			jtf_licensePlate = new JTextField();
			jtf_licensePlate.setFont(font2);
			jtf_licensePlate.setBounds(x + addx, y + addy, jtf_width, height);
			jtf_licensePlate.addFocusListener(new TextFocus());

			buyDate = new JLabel("购买时间", JLabel.CENTER);
			buyDate.setFont(font);
			buyDate.setBounds(x, y + 2 * addy, jl_width, height);

			jtf_buyDate = new JTextField();
			jtf_buyDate.setFont(font2);
			jtf_buyDate.setBounds(x + addx, y + 2 * addy, jtf_width, height);

			useTime = new JLabel("服役时间", JLabel.CENTER);
			useTime.setFont(font);
			useTime.setBounds(x, y + 3 * addy, jl_width, height);

			jtf_useTime = new JTextField();
			jtf_useTime.setFont(font2);
			jtf_useTime.setBounds(x + addx, y + 3 * addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 4 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VehicleVO vehicle_vo = new VehicleVO(jtf_vehicleNum
							.getText(), jtf_licensePlate.getText(), jtf_buyDate
							.getText(), jtf_useTime.getText());
					ManageblService bl = new ManageController();
					try {
						bl.addVehicle(vehicle_vo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 4 * addy + 10, 80, height);
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

	class TextFocus implements FocusListener{

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if(temp==jtf_vehicleNum){
				if(!NumExceptioin.isVehicleValid(jtf_vehicleNum)){
					if(tip1==null){
						tip1 = new JLabel("车辆代号应为9位",JLabel.CENTER);
						tip1.setBounds(x + addx, y+height, jtf_width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				}
				else{
					if(!"".equalsIgnoreCase(jtf_vehicleNum.getText().trim())){
						removeTip(tip1);
					}
				}
			}
			if(temp==jtf_licensePlate){
				String s = jtf_licensePlate.getText();
				jtf_licensePlate.setText(s.toUpperCase());
				if(!NumExceptioin.islicensePlateValid(jtf_licensePlate)){
					if(tip2==null){
						tip2 = new JLabel("请输入如 苏A00000 格式的车牌号",JLabel.CENTER);
						tip2.setBounds(x + addx, y+addy+height, 2*jtf_width, height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}
					else{
						if(!"".equalsIgnoreCase(jtf_licensePlate.getText().trim())){
							removeTip(tip2);
						}
					}	
				}
			}

		}
	}

		/**
		 * 添加错误提示信息
		 * 
		 * @param tip
		 */
		public void addTip(JLabel tip) {
			this.add(tip);
			this.repaint();
		}

		/**
		 * 移除错误提示信息
		 * 
		 * @param tip
		 */
		public void removeTip(JLabel tip) {
			this.remove(tip);
			this.repaint();
		}

	}
