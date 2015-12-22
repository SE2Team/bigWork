package presentation.listui;

/**
 * 营业厅业务员装车管理界面
 * 
 */
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ExistException;
import vo.LoadingVO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class LoadingPanel extends JPanel {

	protected int x = 10, y = 30, width = 180, jl_width = 120, height = 30,
			addx1 = 120, addx2 = 310, addy = 65;

	// 定义装车日期，本营业厅编号，出发地，到达地，押运员，监装员，汽运编号，车辆代号，托运单号列表，运费
	protected JLabel loadingDate, hallNum, start, end, supercargo, monitor,
			transportNum, vehicleNum, consignList, transportMoney;
	// 定义对应的文本框
	protected JTextField jtf_loadingDate, jtf_hallNum, jtf_start, jtf_end,
			jtf_supercargo, jtf_monitor, jtf_transportNum, jtf_vehicleNum,
			jtf_Money;
	// 定义输入所有订单号的文本域
	protected JTextArea jta_consignList;
	// 定义放文本域的scrollPanel
	protected JScrollPane jsp;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义错误提示的label
	protected JLabel tip1, tip2, tip3;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] loadingJtf, loadingJtf2;

	public LoadingPanel() {

		this.setLayout(null);

		loadingDate = new JLabel("装车日期", JLabel.CENTER);
		loadingDate.setFont(font);
		loadingDate.setBounds(x, y, jl_width, height);

		jtf_loadingDate = new JTextField();
		jtf_loadingDate.setFont(font2);
		jtf_loadingDate.setEditable(false);
		jtf_loadingDate.setBounds(x + addx1, y, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_loadingDate);
		datechooser.setBounds(x + addx1 + width - 30, y, 30, height);
		jtf_loadingDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		hallNum = new JLabel("本营业厅编号", JLabel.CENTER);
		hallNum.setFont(font);
		hallNum.setBounds(x + addx2, y, jl_width, height);

		jtf_hallNum = new JTextField();
		jtf_hallNum.setFont(font2);
		jtf_hallNum.setBounds(x + addx1 + addx2, y, width, height);
		jtf_hallNum.addFocusListener(new TextFocus());

		start = new JLabel("出发地", JLabel.CENTER);
		start.setFont(font);
		start.setBounds(x, y + addy, jl_width, height);

		jtf_start = new JTextField();
		jtf_start.setFont(font2);
		jtf_start.setBounds(x + addx1, y + addy, width, height);

		end = new JLabel("到达地", JLabel.CENTER);
		end.setFont(font);
		end.setBounds(x + addx2, y + addy, jl_width, height);

		jtf_end = new JTextField();
		jtf_end.setFont(font2);
		jtf_end.setBounds(x + addx1 + addx2, y + addy, width, height);

		supercargo = new JLabel("押运员", JLabel.CENTER);
		supercargo.setFont(font);
		supercargo.setBounds(x, y + 2 * addy, jl_width, height);

		jtf_supercargo = new JTextField();
		jtf_supercargo.setFont(font2);
		jtf_supercargo.setBounds(x + addx1, y + 2 * addy, width, height);

		monitor = new JLabel("监装员", JLabel.CENTER);
		monitor.setFont(font);
		monitor.setBounds(x + addx2, y + 2 * addy, jl_width, height);

		jtf_monitor = new JTextField();
		jtf_monitor.setFont(font2);
		jtf_monitor.setBounds(x + addx1 + addx2, y + 2 * addy, width, height);

		transportNum = new JLabel("汽运编号", JLabel.CENTER);
		transportNum.setFont(font);
		transportNum.setBounds(x, y + 3 * addy, jl_width, height);

		jtf_transportNum = new JTextField();
		jtf_transportNum.setFont(font2);
		jtf_transportNum.setBounds(x + addx1, y + 3 * addy, width, height);
		jtf_transportNum.addFocusListener(new TextFocus());

		vehicleNum = new JLabel("车辆代号", JLabel.CENTER);
		vehicleNum.setFont(font);
		vehicleNum.setBounds(x + addx2, y + 3 * addy, jl_width, height);

		jtf_vehicleNum = new JTextField();
		jtf_vehicleNum.setFont(font2);
		jtf_vehicleNum
				.setBounds(x + addx1 + addx2, y + 3 * addy, width, height);
		jtf_vehicleNum.addFocusListener(new TextFocus());

		consignList = new JLabel("所有订单号", JLabel.CENTER);
		consignList.setFont(font);
		consignList.setBounds(x, y + 5 * addy, jl_width, height);

		jta_consignList = new JTextArea();
		jta_consignList.setFont(font2);

		jsp = new JScrollPane(jta_consignList);
		jsp.setBounds(x + addx1, y + 4 * addy + 10, width, 4 * height);

		transportMoney = new JLabel("运费", JLabel.CENTER);
		transportMoney.setFont(font);
		transportMoney.setBounds(x + addx2, y + 5 * addy, jl_width, height);

		jtf_Money = new JTextField();
		jtf_Money.setFont(font2);
		jtf_Money.setBounds(x + addx1 + addx2, y + 5 * addy, width, height);
		jtf_Money.setEditable(false);

		sure = new JButton("确定");
		sure.setFont(font);
		sure.setBounds(x + 160, 450, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		loadingJtf = new JTextField[] { jtf_hallNum, jtf_start, jtf_end,
				jtf_supercargo, jtf_monitor, jtf_transportNum, jtf_vehicleNum,
				jtf_Money };
		loadingJtf2 = new JTextField[] { jtf_hallNum, jtf_start, jtf_end,
				jtf_supercargo, jtf_monitor, jtf_transportNum, jtf_vehicleNum };

		cancel = new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(x + addx2 + 20, 450, 80, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Empty emptyLoading = new Empty(loadingJtf);
				jta_consignList.setText("");
			}
		});

		this.add(loadingDate);
		this.add(jtf_loadingDate);
		this.add(datechooser);
		this.add(hallNum);
		this.add(jtf_hallNum);
		this.add(start);
		this.add(jtf_start);
		this.add(end);
		this.add(jtf_end);
		this.add(supercargo);
		this.add(jtf_supercargo);
		this.add(monitor);
		this.add(jtf_monitor);
		this.add(transportNum);
		this.add(jtf_transportNum);
		this.add(vehicleNum);
		this.add(jtf_vehicleNum);
		this.add(consignList);
		this.add(jsp);
		this.add(transportMoney);
		this.add(jtf_Money);
		this.add(sure);
		this.add(cancel);
	}

	// 错误提示信息是否已经被添加
	protected boolean isHallNumAdd = false;
	protected boolean isTransportNumAdd = false;
	protected boolean isVehicleNumAdd = false;

	protected void performSure() {
		boolean isOk = NumExceptioin.isHallValid(jtf_hallNum)
				&& NumExceptioin.isCarValid(jtf_transportNum)
				&& NumExceptioin.isVehicleValid(jtf_vehicleNum);
		if (isOk && isAllEntered.isEntered(loadingJtf2)) {
			LoadingVO loading_vo = new LoadingVO(jtf_loadingDate.getText(),
					jtf_hallNum.getText(), jtf_transportNum.getText(),
					jtf_start.getText(), jtf_end.getText(),
					jtf_monitor.getText(), jtf_supercargo.getText(),
					jtf_vehicleNum.getText(), jta_consignList.getText(),
					jtf_Money.getText(), false);
			ListblService bl;
			try {
				bl = new ListController();
				try {
					bl.save(loading_vo);
				} catch (ExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block

				JLabel tip = new JLabel("提示：网络异常");
				tip.setFont(font2);
				JOptionPane.showMessageDialog(null, tip);
			}

			JLabel tip = new JLabel("提示：保存成功");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}else if((!isOk)&&isAllEntered.isEntered(loadingJtf2)){
			JLabel tip = new JLabel("提示：请输入正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}else if(isOk&&!isAllEntered.isEntered(loadingJtf2)){
			JLabel tip = new JLabel("提示：仍有信息未输入");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}else if(!isOk&&!isAllEntered.isEntered(loadingJtf2)){
			JLabel tip = new JLabel("请输入所有正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}

		
	}

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		NumExceptioin numEx = new NumExceptioin();

		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_hallNum) {
				if (!NumExceptioin.isHallValid(jtf_hallNum)) {
					isHallNumAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("本营业厅编号位数应为6位", JLabel.CENTER);
						tip1.setBounds(x + 2 * addx1 + 100, y + 30, 2 * width,
								height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				} else {
					if (isHallNumAdd
							&& !"".equalsIgnoreCase(jtf_hallNum.getText()
									.trim())) {
						isHallNumAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if (temp == jtf_transportNum) {
				if (!NumExceptioin.isCarValid(jtf_transportNum)) {
					isTransportNumAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("汽运编号位数应为19位", JLabel.CENTER);
						tip2.setBounds(x + addx1, y + 3 * addy + 30, width,
								height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}

				} else {
					if (isTransportNumAdd
							&& !"".equalsIgnoreCase(jtf_transportNum.getText()
									.trim())) {
						isTransportNumAdd = false;
						removeTip(tip2);
						tip2 = null;
					}
				}
			}
			if (temp == jtf_vehicleNum) {
				if (!NumExceptioin.isVehicleValid(jtf_vehicleNum)) {
					isVehicleNumAdd = true;
					if (tip3 == null) {
						tip3 = new JLabel("车辆代号位数应为9位", JLabel.CENTER);
						tip3.setBounds(x + addx1 + addx2, y + 3 * addy + 30,
								width, height);
						tip3.setFont(font2);
						tip3.setForeground(Color.RED);
						addTip(tip3);
					}

				} else {
					if (isVehicleNumAdd
							&& !"".equalsIgnoreCase(jtf_vehicleNum.getText()
									.trim())) {
						isVehicleNumAdd = false;
						removeTip(tip3);
						tip3 = null;
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
	private void addTip(JLabel tip) {
		this.add(tip);
		this.repaint();
	}

	/**
	 * 移除错误提示信息
	 * 
	 * @param tip
	 */
	private void removeTip(JLabel tip) {
		this.remove(tip);
		this.repaint();
	}

}
