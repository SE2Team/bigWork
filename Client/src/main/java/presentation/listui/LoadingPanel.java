package presentation.listui;

/**
 * 营业厅业务员装车管理界面
 * 
 */
import businesslogic.listbl.ListController;
import businesslogic.managebl.ManageController;
import businesslogicservice.ListblService;
import businesslogicservice.ManageblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.UIdata.UserInfo;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.GetDate;
import presentation.exception.NumExceptioin;
import util.DeliveryType;
import util.ExistException;
import util.ListState;
import vo.ExpenseAndDateVO;
import vo.LoadingVO;
import vo.OrderVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadingPanel extends JPanel {

	protected int x = 10, y = 30, width = 180, jl_width = 120, height = 30,
			addx1 = 120, addx2 = 310, addy = 65;

	// 定义装车日期，本营业厅编号，出发地，到达地，押运员，监装员，汽运编号，车辆代号，托运单号列表，运费
	protected JLabel loadingDate, hallNum, start, end, supercargo, monitor,
			transportNum, vehicleNum, consignList, transportMoney, jl_hallnum2, jl_hallnum3;
	// 定义对应的文本框
	protected JTextField jtf_loadingDate, jtf_hallNum, jtf_start, jtf_end,
			jtf_supercargo, jtf_monitor, jtf_transportNum, jtf_vehicleNum,
			jtf_Money, jtf_ordernum;
	//定义下拉框
	protected JComboBox jcb_city1, jcb_city2;
	// 定义输入所有订单号的文本域
	protected JTextArea jta_consignList;
	// 定义放文本域的scrollPanel
	protected JScrollPane jsp;
	// 定义确定，取消按钮
	protected JButton sure, cancel, cal, jb_add;
	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 15);
	// 定义错误提示的label
	protected JLabel tip1, tip2, tip3, tip4;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] loadingJtf, loadingJtf2;
	// 定义订单号的数组
	protected ArrayList<String> ordernumList;

	protected String[] city = {"南京市", "北京市", "上海市", "广州市"};
	protected OrderVO orderVO = null;


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

		Iterator<String> ite = null;
		ArrayList<String> list1 = new ArrayList<String>();
		ManageblService bl;
		try {
			bl = new ManageController();
			ite = bl.checkCityNum();
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
		hallNum = new JLabel("本营业厅编号", JLabel.CENTER);
		hallNum.setFont(font);
		hallNum.setBounds(x + addx2, y, jl_width, height);

//		jcb_hallnum1 = new JComboBox(s);
//		jcb_hallnum1.setFont(font2);
//		jcb_hallnum1.setBounds(x + addx1 + addx2, y, 50, height);
		
		jtf_hallNum = new JTextField();
		jtf_hallNum.setFont(font2);
		jtf_hallNum.setBounds(x + addx1 + addx2, y, width, height);
		jtf_hallNum.setEditable(false);
		String num = null;
		ManageblService mbl;
		try {
			mbl = new ManageController();
			num = mbl.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
			jtf_hallNum.setText(num);
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
		}
//		jtf_hallNum.addFocusListener(new TextFocus());

		start = new JLabel("出发地", JLabel.CENTER);
		start.setFont(font);
		start.setBounds(x, y + addy, jl_width, height);

		jcb_city1 = new JComboBox(city);
		jcb_city1.setFont(font2);
		jcb_city1.setBounds(x + addx1, y + addy, 70, height);
		
		jtf_start = new JTextField();
		jtf_start.setFont(font2);
		jtf_start.setBounds(x + addx1 + 70, y + addy, width - 70, height);

		end = new JLabel("到达地", JLabel.CENTER);
		end.setFont(font);
		end.setBounds(x + addx2, y + addy, jl_width, height);

		jcb_city2 = new JComboBox(city);
		jcb_city2.setFont(font2);
		jcb_city2.setBounds(x + addx1 + addx2, y + addy, 70, height);
		
		jtf_end = new JTextField();
		jtf_end.setFont(font2);
		jtf_end.setBounds(x + addx1 + addx2 + 70, y + addy, width - 70, height);

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

		String num1 = null;
		ManageblService bl1;
		try {
			bl1 = new ManageController();
			num1 = bl1.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
		} catch (RemoteException e2) {
			RunTip.makeTip("网络异常", false);
		}

		jl_hallnum2 = new JLabel(num1.substring(0, 3));
		jl_hallnum2.setFont(font2);
		jl_hallnum2.setBounds(x + addx1, y + 3 * addy, 50, height);
		
		jtf_transportNum = new JTextField();
		jtf_transportNum.setFont(font2);
		jtf_transportNum.setBounds(x + addx1 + 50, y + 3 * addy, width - 50, height);
		jtf_transportNum.addFocusListener(new TextFocus());

		vehicleNum = new JLabel("车辆代号", JLabel.CENTER);
		vehicleNum.setFont(font);
		vehicleNum.setBounds(x + addx2, y + 3 * addy, jl_width, height);

		String num2 = null;
		ManageblService bl2;
		try {
			bl2 = new ManageController();
			num2 = bl2.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
		} catch (RemoteException e2) {
			RunTip.makeTip("网络异常", false);
		}
		jl_hallnum3 = new JLabel(num2.substring(0, 3));
		jl_hallnum3.setFont(font2);
		jl_hallnum3.setBounds(x + addx1 + addx2, y + 3 * addy, 50, height);
		
		jtf_vehicleNum = new JTextField();
		jtf_vehicleNum.setFont(font2);
		jtf_vehicleNum
				.setBounds(x + addx1 + addx2 + 50, y + 3 * addy, width - 50, height);
		jtf_vehicleNum.addFocusListener(new TextFocus());

		consignList = new JLabel("所有订单号", JLabel.CENTER);
		consignList.setFont(font);
		consignList.setBounds(x, y + 5 * addy, jl_width, height);

		jtf_ordernum = new JTextField();
		jtf_ordernum.setFont(font2);
		jtf_ordernum.setBounds(x + addx1, y + 4 * addy + 10, width - 30, height);
		jtf_ordernum.addFocusListener(new TextFocus());

		ordernumList = new ArrayList<String>();

		jb_add = new JButton(new ImageIcon("images/add.jpg"));
		jb_add.setFont(font2);
		jb_add.setBounds(x + addx1 + width - 30, y + 4 * addy + 10, 30, height);
		jb_add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performAdd();
			}
		});
		
		jta_consignList = new JTextArea();
		jta_consignList.setFont(font2);
		jta_consignList.setEditable(false);

		jsp = new JScrollPane(jta_consignList);
		jsp.setBounds(x + addx1, y + 4 * addy + 40, width, 3 * height);

		transportMoney = new JLabel("运费", JLabel.CENTER);
		transportMoney.setFont(font);
		transportMoney.setBounds(x + addx2, y + 5 * addy, jl_width, height);

		jtf_Money = new JTextField();
		jtf_Money.setFont(font2);
		jtf_Money.setBounds(x + addx1 + addx2, y + 5 * addy, width, height);
		jtf_Money.setEditable(false);

		cal = new JButton("计算");
		cal.setFont(font2);
		cal.setBounds(x + addx1 + addx2 + 60, y + 5 * addy + 50, 80, height);
		cal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				performCal();
			}
		});
		
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
                performCancel();
            }
		});

		this.add(loadingDate);
		this.add(jtf_loadingDate);
		this.add(datechooser);
		this.add(hallNum);
		this.add(jtf_hallNum);
		this.add(start);
		this.add(jcb_city1);
		this.add(jcb_city2);
		this.add(jtf_start);
		this.add(end);
		this.add(jtf_end);
		this.add(supercargo);
		this.add(jtf_supercargo);
		this.add(monitor);
		this.add(jtf_monitor);
		this.add(transportNum);
		this.add(jl_hallnum2);
		this.add(jtf_transportNum);
		this.add(vehicleNum);
		this.add(jl_hallnum3);
		this.add(jtf_vehicleNum);
		this.add(consignList);
		this.add(jb_add);
		this.add(jtf_ordernum);
		this.add(jsp);
		this.add(transportMoney);
		this.add(jtf_Money);
		this.add(cal);
		this.add(sure);
		this.add(cancel);
	}

    protected void performCancel() {
        Empty emptyLoading = new Empty(loadingJtf);
        jta_consignList.setText("");
    }

	protected void performAdd() {
		ListblService bl;
		try {
			bl = new ListController();
			orderVO = bl.getOrder(jtf_ordernum.getText());
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
			return;
		}
		if (orderVO == null) {
			RunTip.makeTip("不存在该订单号", false);
			return;
		}
		boolean flag = NumExceptioin.isOrderValid(jtf_ordernum)
				&& !"".equalsIgnoreCase(jtf_ordernum.getText().trim())
				&& !isExist(jtf_ordernum.getText().trim());
		if (flag) {
			jta_consignList.append(jtf_ordernum.getText().trim() + "\n");
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
				&& NumExceptioin.isInt(jtf_ordernum)
				&& !"".equalsIgnoreCase(jtf_ordernum.getText().trim())) {
			ordernumList.add(num);
		}
		return false;
	}

	protected void performCal() {
		ListblService bl;
		try {
			bl = new ListController();
			ExpenseAndDateVO ovo = new ExpenseAndDateVO(jcb_city1.getSelectedItem().toString(), jcb_city2.getSelectedItem().toString(), "", "", "", DeliveryType.ECONOMIC, "", "", "");
			ExpenseAndDateVO nvo;
			try {
				nvo = bl.getExpenseAndDate(ovo);
				jtf_Money.setText(nvo.getExpenseOfTransport());
			} catch (ExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
		}

	}

	// 错误提示信息是否已经被添加
	protected boolean isHallNumAdd = false;
	protected boolean isTransportNumAdd = false;
	protected boolean isVehicleNumAdd = false;
	protected boolean isOrdernumAdd = false;

	protected void performSure() {
		boolean isOk = NumExceptioin.isCarValid(jtf_transportNum, jtf_loadingDate.getText())
				&& NumExceptioin.isVehicleValid(jtf_vehicleNum);
		if (isOk && isAllEntered.isEntered(loadingJtf2)) {
			LoadingVO loading_vo = new LoadingVO(jtf_loadingDate.getText(),
					jtf_hallNum.getText(), jl_hallnum2.getText() + jtf_transportNum.getText(),
					jcb_city1.getSelectedItem().toString() + jtf_start.getText(), jcb_city2.getSelectedItem().toString() + jtf_end.getText(),
					jtf_monitor.getText(), jtf_supercargo.getText(),
					jl_hallnum3.getText() + jtf_vehicleNum.getText(), jta_consignList.getText(),
					jtf_Money.getText(), ListState.UNCHECK);
			ListblService bl;
			try {
				bl = new ListController();
				bl.save(loading_vo);
			} catch (RemoteException e1) {
                RunTip.makeTip("网络异常", false);
            }

            RunTip.makeTip("保存成功", true);
			orderVO.addLogistics(GetDate.getTime() + " 正在" + UserInfo.WORKER.getOrganization() + "进行装车运输");
		}else if((!isOk)&&isAllEntered.isEntered(loadingJtf2)){
            RunTip.makeTip("请输入正确格式的信息", false);
        }else if(isOk&&!isAllEntered.isEntered(loadingJtf2)){
            RunTip.makeTip("仍有信息未输入", false);
        }else if(!isOk&&!isAllEntered.isEntered(loadingJtf2)){
            RunTip.makeTip("请输入所有正确格式的信息", false);
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
			JTextField temp = (JTextField) e.getSource();
//			if (temp == jtf_hallNum) {
//				if (!NumExceptioin.isHallValid(jtf_hallNum)) {
//					isHallNumAdd = true;
//					if (tip1 == null) {
//						tip1 = new JLabel("本营业厅编号位数应为6位", JLabel.CENTER);
//						tip1.setBounds(x + 2 * addx1 + 100, y + 30, 2 * width,
//								height);
//						tip1.setFont(font2);
//						tip1.setForeground(Color.RED);
//						addTip(tip1);
//					}
//
//				} else {
//					if (isHallNumAdd
//							&& !"".equalsIgnoreCase(jtf_hallNum.getText()
//									.trim())) {
//						isHallNumAdd = false;
//						removeTip(tip1);
//						tip1 = null;
//					}
//				}
//			}
			if (temp == jtf_transportNum) {
				if (!NumExceptioin.isCarValid(jtf_transportNum, jtf_loadingDate.getText())) {
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
						tip3 = new JLabel("车辆代号为9位0~9整数", JLabel.CENTER);
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
			if (temp == jtf_ordernum) {
				if (!NumExceptioin.isOrderValid(jtf_ordernum)) {
					isOrdernumAdd = true;
					if (tip4 == null) {
						tip4 = new JLabel("订单号为10位0~9的整数");
						tip4.setBounds(x + addx1 + width, y + 4 * addy + 10, width, height);
						tip4.setFont(font2);
						tip4.setForeground(Color.RED);
						addTip(tip4);
					}
				} else {
					if (isOrdernumAdd
							&& !"".equalsIgnoreCase(jtf_ordernum.getText()
							.trim())) {
						isOrdernumAdd = false;
						removeTip(tip4);
						tip4 = null;
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
