package presentation.manageui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.commonui.DateChooser;
import presentation.exception.NumExceptioin;

public class modifyVehicleDialog extends JDialog {

	private VehiclePanel parent;

	public modifyVehicleDialog(VehiclePanel parent) {
		this.parent = parent;
		this.setContentPane(new modifyVehiclePanel());
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private int x = 40, y = 60, addx = 110, addy = 55, jl_width = 100, jtf_width = 200,
			height = 25;

	// 设置所有文字的字体
	private Font font = new Font("宋体", Font.PLAIN, 20);
	private Font font2 = new Font("宋体", Font.PLAIN, 18);

	// 定义添加车辆信息，车辆代号，车牌号，购买时间，服役时间的label
	private JLabel addInfo, vehicleNum, licensePlate, buyDate, useTime;

	// 定义对应的文本框
	private JTextField jtf_vehicleNum, jtf_licensePlate, jtf_buyDate, jtf_useTime;

	// 定义确定，取消按钮
	private JButton sure, cancel;

	// 定义错误提示信息的label
	private JLabel tip1, tip2;

	// 定义用来存放用户输入信息的数组
	private String[] rowContent;
	
	//定义日期选择器
	private DateChooser datechooser;

	class modifyVehiclePanel extends JPanel {

		modifyVehiclePanel() {
			this.setLayout(null);

			addInfo = new JLabel("修改车辆信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 10, jtf_width, height);

			vehicleNum = new JLabel("车辆代号", JLabel.CENTER);
			vehicleNum.setFont(font);
			vehicleNum.setBounds(x, y, jl_width, height);

			jtf_vehicleNum = new JTextField();
			jtf_vehicleNum.setFont(font);
			jtf_vehicleNum.setBounds(x + addx, y, jtf_width, height);
			jtf_vehicleNum.addFocusListener(new TextFocus());

			licensePlate = new JLabel("车牌号", JLabel.CENTER);
			licensePlate.setFont(font);
			licensePlate.setBounds(x, y + addy, jl_width, height);

			jtf_licensePlate = new JTextField();
			jtf_licensePlate.setFont(font);
			jtf_licensePlate.setBounds(x + addx, y + addy, jtf_width, height);
			jtf_licensePlate.addFocusListener(new TextFocus());

			buyDate = new JLabel("购买时间", JLabel.CENTER);
			buyDate.setFont(font);
			buyDate.setBounds(x, y + 2 * addy, jl_width, height);

			jtf_buyDate = new JTextField();
			jtf_buyDate.setFont(font);
			jtf_buyDate.setEditable(false);
			jtf_buyDate.setBounds(x + addx, y + 2 * addy, jtf_width-30, height);

			datechooser = new DateChooser("yyyy-MM-dd",jtf_buyDate);
			datechooser.setBounds(x + addx+ jtf_width-30, y+ 2 * addy, 30, height);
			jtf_buyDate.setText(datechooser.commit());
			datechooser.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me){
					datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			});
			
			useTime = new JLabel("服役时间", JLabel.CENTER);
			useTime.setFont(font);
			useTime.setBounds(x, y + 3 * addy, jl_width, height);

			jtf_useTime = new JTextField();
			jtf_useTime.setFont(font);
			jtf_useTime.setBounds(x + addx, y + 3 * addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 4 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rowContent = new String[] { jtf_vehicleNum.getText(),
							jtf_licensePlate.getText(), jtf_buyDate.getText(),
							jtf_useTime.getText() };
					parent.updateAfterConfirm(rowContent);
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
			this.add(datechooser);
			this.add(useTime);
			this.add(jtf_useTime);
			this.add(sure);
			this.add(cancel);
		}
	}

	/**
	 * 获取车辆代号的文本框
	 * 
	 * @return
	 */
	public JTextField getVehicleNum() {
		return jtf_vehicleNum;
	}

	/**
	 * 获取车牌号的文本框
	 * 
	 * @return
	 */
	public JTextField getLicensePlate() {
		return jtf_licensePlate;
	}

	/**
	 * 获取购买时间的文本框
	 * 
	 * @return
	 */
	public JTextField getBuyDate() {
		return jtf_buyDate;
	}

	/**
	 * 获取服役时间的文本框
	 * 
	 * @return
	 */
	public JTextField getUseTime() {
		return jtf_useTime;
	}

	// 错误提示信息是否已经被添加
	boolean isVehicleNumAdd = false;
	boolean isLicenseAdd = false;

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();

			if (temp == jtf_vehicleNum) {
				// boolean isAdd=false;
				if (!NumExceptioin.isVehicleValid(jtf_vehicleNum)) {
					isVehicleNumAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("车辆代号应为9位", JLabel.CENTER);
						tip1.setBounds(x + addx, y + height, jtf_width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				} else {
					if (isVehicleNumAdd
							&& !"".equalsIgnoreCase(jtf_vehicleNum.getText()
									.trim())) {
						removeTip(tip1);
					}
				}
			}
			if (temp == jtf_licensePlate) {
				String s = jtf_licensePlate.getText();
				jtf_licensePlate.setText(s.toUpperCase());
				if (!NumExceptioin.islicensePlateValid(jtf_licensePlate)) {
					isLicenseAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("请输入如 苏A00000 格式的车牌号", JLabel.CENTER);
						tip2.setBounds(x, y + addy + height, 2 * jtf_width,
								height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}

				} else {
					if (isLicenseAdd
							&& !"".equalsIgnoreCase(jtf_licensePlate.getText()
									.trim())) {
						removeTip(tip2);
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
