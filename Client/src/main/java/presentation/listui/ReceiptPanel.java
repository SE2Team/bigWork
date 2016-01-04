/*
 * 营业厅业务员记录收款界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ListState;
import vo.OrderVO;
import vo.ReceiptVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReceiptPanel extends JPanel {
	protected int x = 100, y = 70, width = 200, height = 30, addx = 160,
			addy = 80;

	// 定义快递员收款单，收款日期，收款金额，收款快递员，订单号的label
	protected JLabel CourierReceipt, receiptDate, receiptMoney, receiptCourier,
			orderNum;
	// 定义收款日期、金额、快递员的文本框
	protected JTextField jtf_date, jtf_money, jtf_courier, jtf_ordernum;
	// 定义快递单号的文本域
	protected JTextArea jta_ordernum;
	// 定义确定，取消按钮
	protected JButton sure, cancel, jb_add;
	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 16);
	// 定义错误提示的文字
	protected JLabel tip1, tip2;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] receiptJtf;
	// 定义订单号的数组
	protected ArrayList<String> ordernumList;

	public ReceiptPanel() {
		this.setLayout(null);

		CourierReceipt = new JLabel("快递员收款单", JLabel.CENTER);
		CourierReceipt.setFont(new Font("楷体", Font.PLAIN, 30));
		CourierReceipt.setBounds(220, 20, 200, 30);

		receiptDate = new JLabel("收款日期", JLabel.CENTER);
		receiptDate.setFont(font);
		receiptDate.setBounds(x, y, width, height);

		jtf_date = new JTextField();
		jtf_date.setFont(font2);
		jtf_date.setEditable(false);
		jtf_date.setBounds(x + addx, y, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_date);
		datechooser.setBounds(x + addx + width - 30, y, 30, height);
		jtf_date.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		receiptMoney = new JLabel("收款金额", JLabel.CENTER);
		receiptMoney.setFont(font);
		receiptMoney.setBounds(x, y + addy, width, height);

		jtf_money = new JTextField();
		jtf_money.setFont(font2);
		jtf_money.setBounds(x + addx, y + addy, width, height);
		jtf_money.addFocusListener(new TextFocus());

		receiptCourier = new JLabel("收款快递员", JLabel.CENTER);
		receiptCourier.setFont(font);
		receiptCourier.setBounds(x, y + 2 * addy, width, height);

		jtf_courier = new JTextField();
		jtf_courier.setFont(font2);
		jtf_courier.setBounds(x + addx, y + 2 * addy, width, height);

		orderNum = new JLabel("订单号", JLabel.CENTER);
		orderNum.setFont(font);
		orderNum.setBounds(x, y + 3 * addy, width, height);

		ordernumList = new ArrayList<String>();

		jtf_ordernum = new JTextField();
		jtf_ordernum.setFont(font2);
		jtf_ordernum.setBounds(x + addx, y + 3 * addy, width - 30, height);
		jtf_ordernum.addFocusListener(new TextFocus());

		jb_add = new JButton(new ImageIcon("images/add.jpg"));
		jb_add.setFont(font2);
		jb_add.setBounds(x + addx + width - 30, y + 3 * addy, 30, height);
		jb_add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performAdd();
			}
		});

		jta_ordernum = new JTextArea();
		jta_ordernum.setFont(font2);
		jta_ordernum.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta_ordernum);
		jsp.setBounds(x + addx, y + 3 * addy + height, width, 3 * height);

		sure = new JButton("确定");
		sure.setFont(font);
		sure.setBounds(x + 80, 450, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		receiptJtf = new JTextField[] { jtf_money, jtf_courier };

		cancel = new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(x + addx + 100, 450, 80, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
                performCancel();
            }
		});

		this.add(CourierReceipt);
		this.add(receiptDate);
		this.add(jtf_date);
		this.add(datechooser);
		this.add(receiptMoney);
		this.add(jtf_money);
		this.add(receiptCourier);
		this.add(jtf_courier);
		this.add(orderNum);
		this.add(jtf_ordernum);
		this.add(jb_add);
		this.add(jsp);
		this.add(sure);
		this.add(cancel);
	}

    protected void performCancel() {
        Empty emptyLoading = new Empty(receiptJtf);
        jta_ordernum.setText("");
    }

	/**
	 * 添加订单号
	 */
	protected void performAdd() {
		OrderVO vo = null;
		ListblService bl;
		try {
			bl = new ListController();
			vo = bl.getOrder(jtf_ordernum.getText());
		} catch (RemoteException e) {
			RunTip.makeTip("网络异常", false);
		}
		if (vo == null) {
			RunTip.makeTip("不存在该订单号", false);
			return;
		}
		boolean flag = NumExceptioin.isOrderValid(jtf_ordernum)
				&& !"".equalsIgnoreCase(jtf_ordernum.getText().trim())
				&& !isExist(jtf_ordernum.getText().trim());
		if (flag) {
			jta_ordernum.append(jtf_ordernum.getText().trim() + "\n");
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

	/**
	 * 确认按钮的action
	 */
	protected void performSure() {
		boolean isOk = NumExceptioin.isDouble(jtf_money)
				&& NumExceptioin.isOrderValid(jtf_ordernum);
		if (isOk && isAllEntered.isEntered(receiptJtf)) {
			ReceiptVO receipt_vo = new ReceiptVO(jtf_date.getText(),
					jtf_money.getText(), jtf_courier.getText(),
					ordernumList, ListState.UNCHECK);
			try {
				ListblService bl = new ListController();
				bl.save(receipt_vo);
			} catch (RemoteException e) {
                RunTip.makeTip("网络异常", false);
				return;
			}

            RunTip.makeTip("保存成功", true);
        } else if ((!isOk) && isAllEntered.isEntered(receiptJtf)) {
            RunTip.makeTip("请输入正确格式的信息", false);
        } else if (isOk && !isAllEntered.isEntered(receiptJtf)) {
            RunTip.makeTip("仍有信息未输入", false);
        } else if (!isOk && !isAllEntered.isEntered(receiptJtf)) {
            RunTip.makeTip("请输入所有正确格式的信息", false);
        }

	}

	// 错误提示信息是否已经被添加
	protected boolean isMoneyAdd = false;
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
			String[] o = new String[2];
			Iterator<String> itr;
			ArrayList<String> list = new ArrayList<String>();
			list.iterator();
			itr = list.iterator();
			while (itr.hasNext()) {
				itr.next();
			}

		}

		public void focusLost(FocusEvent e) {
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_money) {
				if (!NumExceptioin.isDouble(jtf_money)) {
					isMoneyAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("请输入数据");
						tip1.setBounds(x + addx, y + addy + height, width,
								height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				} else {
					if (isMoneyAdd
							&& !"".equalsIgnoreCase(jtf_money.getText().trim())) {
						isMoneyAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if (temp == jtf_ordernum) {
				if (!NumExceptioin.isOrderValid(jtf_ordernum)) {
					isOrdernumAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("订单号为10位0~9的整数");
						tip2.setBounds(x + addx + width, y + 3 * addy, width,
								height);
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
