/*
 * 营业厅业务员输入接收单界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ExistException;
import vo.ReceiveVO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class ReceivePanel extends JPanel {

	protected int x = 120, y = 100, width = 200, height = 30, addx = 200,
			addy = 70;

	// 定义接收单，到达日期，出发地，货物到达状态的label
	protected JLabel receiveList, arriveDate, transferNum, departure,
			arriveState;
	// 定义对应的文本框
	protected JTextField jtf_arriveDate, jtf_transferNum, jtf_departure;
	// 定义货物状态的下拉框
	protected JComboBox jcb_arrivestate;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义接收单的字体
	protected Font font1 = new Font("楷体", Font.PLAIN, 30);
	// 定义文本框下拉框的字体
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义其他Label的字体
	protected Font font3 = new Font("宋体", Font.PLAIN, 20);
	// 定义错误提示的label
	protected JLabel tip;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] receiveJtf;

	public ReceivePanel() {

		this.setLayout(null);

		receiveList = new JLabel("接收单", JLabel.CENTER);
		receiveList.setFont(font1);
		receiveList.setBounds(220, 30, width, height);

		arriveDate = new JLabel("到达日期", JLabel.CENTER);
		arriveDate.setFont(font3);
		arriveDate.setBounds(x, y, width, height);

		jtf_arriveDate = new JTextField();
		jtf_arriveDate.setFont(font2);
		jtf_arriveDate.setEditable(false);
		jtf_arriveDate.setBounds(x + addx, y, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_arriveDate);
		datechooser.setBounds(x + addx + width - 30, y, 30, height);
		jtf_arriveDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		transferNum = new JLabel("中转单编号", JLabel.CENTER);
		transferNum.setFont(font3);
		transferNum.setBounds(x, y + addy, width, height);

		jtf_transferNum = new JTextField();
		jtf_transferNum.setFont(font2);
		jtf_transferNum.setBounds(x + addx, y + addy, width, height);
		jtf_transferNum.addFocusListener(new TextFocus());

		departure = new JLabel("出发地", JLabel.CENTER);
		departure.setFont(font3);
		departure.setBounds(x, y + 2 * addy, width, height);

		jtf_departure = new JTextField();
		jtf_departure.setFont(font2);
		jtf_departure.setBounds(x + addx, y + 2 * addy, width, height);

		arriveState = new JLabel("货物到达状态", JLabel.CENTER);
		arriveState.setFont(font3);
		arriveState.setBounds(x, y + 3 * addy, width, height);

		jcb_arrivestate = new JComboBox();
		jcb_arrivestate.setFont(font2);
		jcb_arrivestate.addItem("完整");
		jcb_arrivestate.addItem("损坏");
		jcb_arrivestate.addItem("丢失");
		jcb_arrivestate.setBounds(x + addx, y + 3 * addy, width, height);

		sure = new JButton("确定");
		sure.setFont(font2);
		sure.setBounds(x + 80, y + 4 * addy + 20, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		receiveJtf = new JTextField[] { jtf_transferNum, jtf_departure };

		cancel = new JButton("取消");
		cancel.setFont(font2);
		cancel.setBounds(x + addx + 60, y + 4 * addy + 20, 80, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Empty emptyLoading = new Empty(receiveJtf);
			}
		});

		this.add(receiveList);
		this.add(arriveDate);
		this.add(jtf_arriveDate);
		this.add(datechooser);
		this.add(transferNum);
		this.add(jtf_transferNum);
		this.add(departure);
		this.add(jtf_departure);
		this.add(arriveState);
		this.add(jcb_arrivestate);
		this.add(sure);
		this.add(cancel);
	}

	// 错误提示信息是否已经被添加
	boolean isTransferNumAdd = false;

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

			if (!NumExceptioin.isTransListValid(jtf_transferNum)) {
				isTransferNumAdd = true;
				if (tip == null) {
					tip = new JLabel("中转单编号位数应为19位");
					tip.setBounds(x + addx, y + addy + 30, width, height);
					tip.setFont(font2);
					tip.setForeground(Color.red);
					addTip(tip);
				}

			} else {
				if (isTransferNumAdd
						&& !"".equalsIgnoreCase(jtf_transferNum.getText()
								.trim())) {
					isTransferNumAdd = false;
					removeTip(tip);
					tip = null;
				}
			}
		}

	}

	protected void performSure() {
		boolean isOk = NumExceptioin.isTransListValid(jtf_transferNum);
		if (isOk && isAllEntered.isEntered(receiveJtf)) {
			ReceiveVO receive_vo = new ReceiveVO(jtf_arriveDate.getText(),
					jtf_transferNum.getText(), jtf_departure.getText(),
					jcb_arrivestate.getSelectedItem().toString(), false);
			ListblService bl;
			try {
				bl = new ListController();
				try {
					bl.save(receive_vo);
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
		} else if ((!isOk) && isAllEntered.isEntered(receiveJtf)) {
			JLabel tip = new JLabel("提示：请输入正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} else if (isOk && !isAllEntered.isEntered(receiveJtf)) {
			JLabel tip = new JLabel("提示：仍有信息未输入");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} else if (!isOk && !isAllEntered.isEntered(receiveJtf)) {
			JLabel tip = new JLabel("请输入所有正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
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
