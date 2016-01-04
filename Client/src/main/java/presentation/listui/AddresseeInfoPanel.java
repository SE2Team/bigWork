/*
 * 快递员输入收件信息界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogic.managebl.ManageController;
import businesslogicservice.ListblService;
import businesslogicservice.ManageblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.GetDate;
import util.ListState;
import vo.AddresseeInformationVO;
import vo.OrderVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class AddresseeInfoPanel extends JPanel {
	public void paintComponent(Graphics g) {
		Image right_pic = new ImageIcon("images/右.jpg").getImage();
		g.drawImage(right_pic, 0, 0, 650, 530, this);
	}

	protected int x = 100, y = 80, width = 200, height = 30, addx = 160,
			addy = 90, jb_width = 80;

	// 定义收件单号，收件人姓名，收件时间的label
	protected JLabel receiveNum, receiver, receiveDate;

	// 定义错误提示的文字
	protected JLabel tip1, tip2, tip3;

	// 定义对应输入框
	protected JTextField jtf_receiveNum, jtf_receiver, jtf_receiveDate;

	// 定义对应单号下拉框
//	protected JComboBox jcb_num;

	// 定义确定，取消按钮
	protected JButton jb1, jb2;

	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 16);

	// 定义日期选择器
	protected DateChooser datechooser;

	// 定义文本框的数组
	protected JTextField[] addresseeJtf;

	protected OrderVO orderVO;

	public AddresseeInfoPanel() {

		this.setLayout(null);

		receiveNum = new JLabel("收件单号", JLabel.CENTER);
		receiveNum.setFont(font);
		receiveNum.setBounds(x, y, width, height);

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

//		String num = null;
//		ManageblService mbl;
//		try {
//			mbl = new ManageController();
//			num = mbl.checkOrganization(UserInfo.WORKER.getOrganization()).getNum();
//		} catch (RemoteException e2) {
//			RunTip.makeTip("网络异常", false);
//		}

//		jl_num = new JLabel(num.substring(0, 3));
//		jl_num.setFont(font2);
//		jl_num.setBounds(x + addx, y, 50, height);

		jtf_receiveNum = new JTextField();
		jtf_receiveNum.setFont(font2);
		jtf_receiveNum.setBounds(x + addx, y, width, height);
		jtf_receiveNum.addFocusListener(new TextFocus());

		receiver = new JLabel("收件人姓名", JLabel.CENTER);
		receiver.setFont(font);
		receiver.setBounds(x, y + addy, width, height);

		jtf_receiver = new JTextField();
		jtf_receiver.setFont(font2);
		jtf_receiver.setBounds(x + addx, y + addy, width, height);

		receiveDate = new JLabel("收件时间", JLabel.CENTER);
		receiveDate.setFont(font);
		receiveDate.setBounds(x, y + 2 * addy, width, height);

		jtf_receiveDate = new JTextField();
		jtf_receiveDate.setFont(font2);
		jtf_receiveDate.setEditable(false);
		jtf_receiveDate.setBounds(x + addx, y + 2 * addy, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_receiveDate);
		datechooser.setBounds(x + addx + width - 30, y + 2 * addy, 30, height);
		jtf_receiveDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		jb1 = new JButton("确定");
		jb1.setFont(font);
		jb1.setBounds(x + 80, y + 3 * addy, jb_width, height);
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performJb1();
			}

		});

		addresseeJtf = new JTextField[] { jtf_receiveNum, jtf_receiver };

		jb2 = new JButton("取消");
		jb2.setFont(font);
		jb2.setBounds(x + addx + 80, y + 3 * addy, jb_width, height);
		jb2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performJb2();
			}
		});

		this.add(receiveNum);
		this.add(jtf_receiveNum);
		this.add(receiver);
		this.add(jtf_receiver);
		this.add(receiveDate);
		this.add(jtf_receiveDate);
		this.add(datechooser);
		this.add(jb1);
		this.add(jb2);
	}

	protected void performJb2() {
		new Empty(addresseeJtf);

	}

	protected void performJb1() {
		boolean isOk = isExist;
		if (isOk && isAllEntered.isEntered(addresseeJtf)) {
			AddresseeInformationVO addressInfo_vo = new AddresseeInformationVO(
					jtf_receiveNum.getText(), jtf_receiver.getText(),
					jtf_receiveDate.getText(), ListState.UNCHECK);
			ListblService bl;
			try {
				bl = new ListController();
				bl.save(addressInfo_vo);
			} catch (RemoteException e1) {
				RunTip.makeTip("网络异常", false);
				return;
			}

			RunTip.makeTip("保存成功", true);
			orderVO.addLogistics(GetDate.getTime() + " 已经被签收");
		} else if ((!isOk) && isAllEntered.isEntered(addresseeJtf)) {
			RunTip.makeTip("请输入正确格式的信息", false);
		} else if (isOk && !isAllEntered.isEntered(addresseeJtf)) {
			RunTip.makeTip("仍有信息未输入", false);
		} else if (!isOk && !isAllEntered.isEntered(addresseeJtf)) {
			RunTip.makeTip("请输入所有正确格式的信息", false);
		}
	}

	// 错误提示信息是否已经被添加
	protected boolean isReceiveNumAdd = false;
	protected boolean isExist = false;

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_receiveNum) {
				ListblService bl;
				orderVO = null;
				try {
					bl = new ListController();
					orderVO = bl.getOrder(jtf_receiveNum.getText());
					if (orderVO == null) {
						RunTip.makeTip("不存在该订单号", false);
						return;
					} else {
						isExist = true;
					}
				} catch (RemoteException e1) {
					RunTip.makeTip("网络异常", false);
				}
//				if (!NumExceptioin.isOrderValid(jtf_receiveNum)) {
//					isReceiveNumAdd = true;
//					if (tip1 == null) {
//						tip1 = new JLabel("收件单号为10位0~9整数");
//						tip1.setBounds(x + addx, y + 30, width, height);
//						tip1.setFont(font2);
//						tip1.setForeground(Color.RED);
//						addTip(tip1);
//					}
//
//				} else {
//					if (isReceiveNumAdd
//							&& !"".equalsIgnoreCase(jtf_receiveNum.getText()
//									.trim())) {
//						isReceiveNumAdd = false;
//						removeTip(tip1);
//						tip1 = null;
//					}
//				}
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
