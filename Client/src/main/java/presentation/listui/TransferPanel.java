/**
 * 中转中心库存管理人员装运管理界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogic.managebl.ManageController;
import businesslogicservice.ListblService;
import businesslogicservice.ManageblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.UIdata.UserInfo;
import presentation.commonui.swing.GetDate;
import presentation.exception.NumExceptioin;
import util.DeliveryType;
import util.ExistException;
import util.ListState;
import vo.ExpenseAndDateVO;
import vo.OrderVO;
import vo.TransferVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class TransferPanel extends JPanel {

	protected int x = 10, y = 10, width1 = 100, width2 = 200, jtf_width = 150,
			height = 30, addx1 = 120, addx2 = 220, addy = 60;
	/*
	 * 定义装运方式，装运日期、本中转中心航/货/汽运编号、航班号/车次号、货柜号/车厢号、
	 * 出发地、到达地、运费、监装员、押运员（仅汽运有）、本次装箱所有托运单号
	 */
	protected JLabel loadingWay, loadingDate, transferNum, vehicleNum,
			containerNum, start, end, money, monitor, supercargo, orderNums, jl_num;
	// 定义对应的文本框
	protected JTextField jtf_loadingDate, jtf_transferNum, jtf_vehicleNum,
			jtf_containerNum, jtf_start, jtf_end, jtf_money, jtf_monitor,
			jtf_supercargo, jtf_ordernum;
	// 定义装运方式下拉框
	protected JComboBox jcb_way, jcb_city1, jcb_city2;
	// 定义所有托运单号文本域
	protected JTextArea jta_orderNums;
	// 定义装文本域的scrollPanel
	protected JScrollPane jsp;
	// 定义确定，取消按钮
	protected JButton sure, cancel, jb_add, jb_cal;
	// 定义文本框下拉框按钮的字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 16);
	// 定义错误提示信息的label
	protected JLabel tip1, tip2;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] transferJtf, transferJtf2;
	// 定义订单号的数组
	protected ArrayList<String> ordernumList;
	protected OrderVO orderVO = null;

	String[] city = {"南京市", "北京市", "上海市", "广州市"};

	public TransferPanel() {

		this.setLayout(null);

		loadingWay = new JLabel("装运方式", JLabel.CENTER);
		loadingWay.setFont(font);
		loadingWay.setBounds(x, y, width1, height);

		jcb_way = new JComboBox();
		jcb_way.setFont(font2);
		jcb_way.addItem("飞机");
		jcb_way.addItem("火车");
		jcb_way.addItem("汽车");
		jcb_way.setBounds(x + addx1, y, jtf_width, height);

		loadingDate = new JLabel("装运日期", JLabel.CENTER);
		loadingDate.setFont(font);
		loadingDate.setBounds(x + addx1 + addx2, y, width1, height);

		jtf_loadingDate = new JTextField();
		jtf_loadingDate.setFont(font2);
		jtf_loadingDate.setEditable(false);
		jtf_loadingDate.setBounds(x + 2 * addx1 + addx2, y, jtf_width - 30,
				height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_loadingDate);
		datechooser.setBounds(x + 2 * addx1 + addx2 + jtf_width - 30, y, 30,
				height);
		jtf_loadingDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		transferNum = new JLabel("本中转中心航/货/汽运编号", JLabel.CENTER);
		transferNum.setFont(font);
		transferNum.setBounds(x, y + addy, width2 + 50, height);

		Iterator<String> ite = null;
		ArrayList<String> list1 = new ArrayList<String>();
		ManageblService mbl;
		try {
			mbl = new ManageController();
			ite = mbl.checkCityNum();
		} catch (RemoteException e1) {
			RunTip.makeTip("网络异常", false);
		}

		if (ite != null) {
			while (ite.hasNext()) {
				list1.add(ite.next());
			}
		}

		int n = list1.size();
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = list1.get(i);
		}

		String num = null;
		ManageblService bl1;
		try {
			bl1 = new ManageController();
			num = bl1.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
		} catch (RemoteException e2) {
			RunTip.makeTip("网络异常", false);
		}

		jl_num = new JLabel(num.substring(0, 3));
		jl_num.setFont(font2);
		jl_num.setBounds(x + addx2 + 50, y + addy, 50, height);

		jtf_transferNum = new JTextField();
		jtf_transferNum.setFont(font2);
		jtf_transferNum.setBounds(x + addx2 + 100, y + addy,
				2 * jtf_width - 50, height);
		jtf_transferNum.addFocusListener(new TextFocus());

		vehicleNum = new JLabel("航班号/车次号", JLabel.CENTER);
		vehicleNum.setFont(font);
		vehicleNum.setBounds(x, y + 2 * addy, width2, height);

		jtf_vehicleNum = new JTextField();
		jtf_vehicleNum.setFont(font2);
		jtf_vehicleNum.setBounds(x + addx2 + 50, y + 2 * addy, 2 * jtf_width,
				height);

		containerNum = new JLabel("货柜号/车厢号", JLabel.CENTER);
		containerNum.setFont(font);
		containerNum.setBounds(x, y + 3 * addy, width2, height);

		jtf_containerNum = new JTextField();
		jtf_containerNum.setFont(font2);
		jtf_containerNum.setBounds(x + addx2 + 50, y + 3 * addy, 2 * jtf_width,
				height);

		start = new JLabel("出发地", JLabel.CENTER);
		start.setFont(font);
		start.setBounds(x, y + 4 * addy, width1, height);

		jcb_city1 = new JComboBox(city);
		jcb_city1.setFont(font2);
		jcb_city1.setBounds(x + addx1 - 30, y + 4 * addy, width1, height);

		// jtf_start = new JTextField();
		// jtf_start.setFont(font2);
		// jtf_start.setBounds(x + addx1 - 30, y + 4 * addy, width1, height);

		end = new JLabel("到达地", JLabel.CENTER);
		end.setFont(font);
		end.setBounds(x + addx2, y + 4 * addy, width1, height);

		jcb_city2 = new JComboBox(city);
		jcb_city2.setFont(font2);
		jcb_city2.setBounds(x + addx2 + addx1 - 30, y + 4 * addy, width1,
				height);

		// jtf_end = new JTextField();
		// jtf_end.setFont(font2);
		// jtf_end.setBounds(x + addx2 + addx1 - 30, y + 4 * addy, width1,
		// height);

		money = new JLabel("运费", JLabel.CENTER);
		money.setFont(font);
		money.setBounds(x + 2 * addx2 - 20, y + 4 * addy, width1, height);

		jtf_money = new JTextField();
		jtf_money.setFont(font2);
		jtf_money.setEditable(false);
		jtf_money.setBounds(x + 2 * addx2 + addx1 - 50, y + 4 * addy, width1,
				height);

		monitor = new JLabel("监装员", JLabel.CENTER);
		monitor.setFont(font);
		monitor.setBounds(x, y + 5 * addy, width1, height);

		jtf_monitor = new JTextField();
		jtf_monitor.setFont(font2);
		jtf_monitor.setBounds(x + addx1, y + 5 * addy, jtf_width, height);

		supercargo = new JLabel("押运员", JLabel.CENTER);
		supercargo.setFont(font);
		supercargo.setBounds(x + addx1 + addx2, y + 5 * addy, width1, height);

		jtf_supercargo = new JTextField();
		jtf_supercargo.setFont(font2);
		jtf_supercargo.setBounds(x + 2 * addx1 + addx2, y + 5 * addy,
				jtf_width, height);

		orderNums = new JLabel("本次装箱所有托运单号", JLabel.CENTER);
		orderNums.setFont(font);
		orderNums.setBounds(x, y + 6 * addy, width2, height);

		ordernumList = new ArrayList<String>();

		jtf_ordernum = new JTextField();
		jtf_ordernum.setFont(font2);
		jtf_ordernum.setBounds(x + addx2 + 60, y + 6 * addy - 20, width2 - 30,
				height);
		jtf_ordernum.addFocusListener(new TextFocus());

		jb_add = new JButton(new ImageIcon("images/add.jpg"));
		jb_add.setFont(font2);
		jb_add.setBounds(x + addx2 + 30 + width2, y + 6 * addy - 20, 30, height);
		jb_add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performAdd();
			}
		});

		jta_orderNums = new JTextArea();
		jta_orderNums.setFont(font2);
		jta_orderNums.setEditable(false);

		jsp = new JScrollPane(jta_orderNums);
		jsp.setBounds(x + addx2 + 60, y + 6 * addy + 10, width2, 3 * height);

		jb_cal = new JButton("计算");
		jb_cal.setFont(font2);
		jb_cal.setBounds(x + addx2 + 80 + width2, y + 6 * addy + 10,
				width1 - 20, height);
		jb_cal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				performCal();
			}
		});

		sure = new JButton("确定");
		sure.setFont(font);
		sure.setBounds(x + addx1, y + 7 * addy + 50, width1 - 10, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		transferJtf = new JTextField[] { jtf_transferNum, jtf_vehicleNum,
				jtf_containerNum, jtf_start, jtf_end, jtf_money, jtf_monitor,
				jtf_supercargo };

		cancel = new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(x + 2 * addx2, y + 7 * addy + 50, width1 - 10, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performCancel();
			}
		});

		this.add(loadingWay);
		this.add(jcb_way);
		this.add(loadingDate);
		this.add(jtf_loadingDate);
		this.add(datechooser);
		this.add(transferNum);
		this.add(jtf_transferNum);
		this.add(vehicleNum);
		this.add(jtf_vehicleNum);
		this.add(containerNum);
		this.add(jtf_containerNum);
		this.add(start);
		// this.add(jtf_start);
		this.add(end);
		// this.add(jtf_end);
		this.add(money);
		this.add(jtf_money);
		this.add(monitor);
		this.add(jtf_monitor);
		this.add(supercargo);
		this.add(jtf_supercargo);
		this.add(orderNums);
		this.add(jb_add);
		this.add(jtf_ordernum);
		this.add(jsp);
		this.add(sure);
		this.add(cancel);
		this.add(jb_cal);
		this.add(jcb_city1);
		this.add(jcb_city2);
		this.add(jl_num);
	}

	protected void performCancel() {
		Empty emptyLoading = new Empty(transferJtf);
		jta_orderNums.setText("");
	}

	protected void performCal() {
		ListblService bl;
		try {
			bl = new ListController();
			ExpenseAndDateVO ovo = new ExpenseAndDateVO(jcb_city1
					.getSelectedItem().toString(), jcb_city2.getSelectedItem()
					.toString(), "", "", "", DeliveryType.ECONOMIC, "", "", "");
			ExpenseAndDateVO nvo;
			try {
				nvo = bl.getExpenseAndDate(ovo);
				jtf_money.setText(nvo.getExpenseOfTransport());
			} catch (ExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
		}
	}

	/**
	 * 添加订单号
	 */
	protected void performAdd() {
		ListblService bl;
		try {
			bl = new ListController();
			orderVO = bl.getOrder(jtf_ordernum.getText());
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
		}
		if (orderVO == null) {
			RunTip.makeTip("不存在该订单号", false);
			return;
		}
		boolean flag = NumExceptioin.isOrderValid(jtf_ordernum)
				&& !"".equalsIgnoreCase(jtf_ordernum.getText().trim())
				&& !isExist(jtf_ordernum.getText().trim());
		flag = true;
		if (flag) {
			jta_orderNums.append(jtf_ordernum.getText().trim());
			jtf_ordernum.setText("");
		} else if (isExist(jtf_ordernum.getText().trim())) {
			RunTip.makeTip("该订单号已存在", false);
		}

	}

	/**
	 * 判断订单号是否已存在
	 */
	protected boolean isExist(String num) {

		for (String list : ordernumList) {
			if (num.equals(list)) {
				return true;
			}
		}
		if (NumExceptioin.isOrderValid(jtf_ordernum)
				&& !"".equalsIgnoreCase(jtf_ordernum.getText().trim())) {
			ordernumList.add(num);
		}
		return false;
	}

	// 错误提示信息是否已经被添加
	protected boolean isTransAdd = false;
	protected boolean isOrdernumAdd = false;

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
			if (temp == jtf_transferNum) {
				if (!NumExceptioin.isTransListValid(jtf_transferNum,
						jtf_loadingDate.getText())) {
					isTransAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("中转中心航/货/汽运编号位数应为19位", JLabel.CENTER);
						tip1.setBounds(x + addx2 + 40, y + addy + 25,
								2 * jtf_width + 10, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				} else {
					if (isTransAdd
							&& !"".equalsIgnoreCase(jtf_transferNum.getText()
									.trim())) {
						isTransAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if (temp == jtf_ordernum) {
				if (false) {
					isOrdernumAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("订单号为10位0~9的整数");
						tip2.setBounds(x + addx2 + 60 + width2, y + 6 * addy
								- 20, width2 - 30, height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}
				} else {
					if (isOrdernumAdd
							&& !"".equalsIgnoreCase(jtf_ordernum.getText()
							.trim())) {
						isOrdernumAdd = false;
						removeTip(tip2);
						tip2 = null;
					}

				}
			}
		}

	}

	protected void performSure() {
		transferJtf2 = new JTextField[] { jtf_transferNum, jtf_vehicleNum,
				jtf_containerNum, jtf_start, jtf_end, jtf_monitor,
				jtf_supercargo};
		boolean isOk = NumExceptioin.isTransListValid(jtf_transferNum,
				jtf_loadingDate.getText());
//		boolean isenter = isAllEntered.isEntered(transferJtf2)
//				&& !"".equalsIgnoreCase(jta_orderNums.getText().trim());
		boolean isenter = true;
		if (isOk && isenter) {
			TransferVO transfervo = new TransferVO(jcb_way.getSelectedItem()
					.toString(), jtf_loadingDate.getText(), jl_num
					.getText() + jtf_transferNum.getText(),
					jtf_vehicleNum.getText(), jcb_city1.getSelectedItem().toString(),
					jcb_city1.getSelectedItem().toString(), jtf_containerNum.getText(),
					jtf_monitor.getText(), jtf_supercargo.getText(),
					jta_orderNums.getText(), jtf_money.getText(),
					ListState.UNCHECK);

			ListblService bl;
			try {
				bl = new ListController();
				bl.save(transfervo);
			} catch (RemoteException e1) {
				RunTip.makeTip("网络异常", false);
			}

			RunTip.makeTip("保存成功", true);
			orderVO.addLogistics(GetDate.getTime() + "到达" + UserInfo.WORKER.getOrganization());

		} else if ((!isOk) && isenter) {
			RunTip.makeTip("请输入正确格式的信息", false);
		} else if (isOk && !isenter) {
			RunTip.makeTip("仍有信息未输入", false);
		} else if (!isOk && !isenter) {
			RunTip.makeTip("请输入所有正确格式的信息", false);
		}
		RunTip.makeTip("保存失败",false);
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
