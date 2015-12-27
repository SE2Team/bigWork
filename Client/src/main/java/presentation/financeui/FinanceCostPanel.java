package presentation.financeui;

import businesslogic.financebl.FinanceController;
import businesslogicservice.FinanceblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ListState;
import vo.PaymentVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

/**
 * 财务人员成本管理界面
 * 
 * @author WANXING 完成
 */
public class FinanceCostPanel extends JPanel {
	int x = 40, y = 70, addx1 = 120, addx2 = 160, addy = 100, width = 160,
			height = 30;
	// 定义确定取消按钮
	private JButton sure, cancel;
	// 定义付款单，付款日期，付款人，付款金额，付款账号，条目，备注的label
	private JLabel titleLabel, dateLabel, payer, amount, num, clause, remark;
	// 定义付款日期，付款人，付款金额，付款账号对应的文本框
	private JTextField dateTextField, nameTextField, sumTextField,
			numTextField;
	// 定义条目，备注对应的文本域
	private JTextArea reasonTextArea, otherTextArea;
	// 定义scrollPane
	private JScrollPane jsp1, jsp2;
	// 定义字体
	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 16);
	// 定义错误提示的文字
	protected JLabel tip1, tip2;
	// 定义文本框的数组
	protected JTextField[] costJtf;
	// 定义日期选择器
	protected DateChooser datechooser;

	public FinanceCostPanel() {

		// 初始化组件
		this.setSize(650, 530);
		this.setLayout(null);

		sure = new JButton("确定");
		cancel = new JButton("取消");
		titleLabel = new JLabel("付款单", JLabel.CENTER);
		dateLabel = new JLabel("付款日期", JLabel.CENTER);
		payer = new JLabel("付款人 ", JLabel.CENTER);
		amount = new JLabel("付款金额", JLabel.CENTER);
		num = new JLabel("付款账号", JLabel.CENTER);
		clause = new JLabel("条目 ", JLabel.CENTER);
		remark = new JLabel("备注", JLabel.CENTER);
		dateTextField = new JTextField();
		nameTextField = new JTextField();
		sumTextField = new JTextField();
		numTextField = new JTextField();
		reasonTextArea = new JTextArea();
		otherTextArea = new JTextArea();

		// 界面
		titleLabel.setFont(font1);
		titleLabel.setBounds(250, 10, width, height);

		dateLabel.setFont(font2);
		dateLabel.setBounds(x, y, width, height);

		dateTextField.setFont(font2);
		dateTextField.setEditable(false);
		dateTextField.setBounds(x + addx1, y, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", dateTextField);
		datechooser.setBounds(x + addx1 + width - 30, y, 30, height);
		dateTextField.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		payer.setFont(font2);
		payer.setBounds(x + addx1 + addx2, y, width, height);

		nameTextField.setFont(font2);
		nameTextField.setBounds(x + 2 * addx1 + addx2, y, width, height);

		amount.setFont(font2);
		amount.setBounds(x, y + addy, width, height);

		sumTextField.setFont(font2);
		sumTextField.setBounds(x + addx1, y + addy, width, height);
		sumTextField.addFocusListener(new TextFocus());

		num.setFont(font2);
		num.setBounds(x + addx1 + addx2, y + addy, width, height);

		numTextField.setFont(font2);
		numTextField.setBounds(x + 2 * addx1 + addx2, y + addy, width, height);
		numTextField.addFocusListener(new TextFocus());

		clause.setFont(font2);
		clause.setBounds(x, y + 2 * addy + 30, width, height);

		reasonTextArea.setFont(font2);

		jsp1 = new JScrollPane(reasonTextArea);
		jsp1.setBounds(x + addx1, y + 2 * addy, width, 3 * height);

		remark.setFont(font2);
		remark.setBounds(x + addx1 + addx2, y + 2 * addy + 30, width, height);

		otherTextArea.setFont(font2);

		jsp2 = new JScrollPane(otherTextArea);
		jsp2.setBounds(x + 2 * addx1 + addx2, y + 2 * addy, width, 3 * height);

		sure.setFont(font2);
		sure.setBounds(2 * x + addx1, y + 3 * addy + 50, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				performSure();
			}
		});

		costJtf = new JTextField[] { nameTextField, sumTextField, numTextField };

		cancel.setFont(font2);
		cancel.setBounds(2 * x + addx1 + addx2 + 20, y + 3 * addy + 50, 80,
				height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Empty(costJtf);
				reasonTextArea.setText("");
				otherTextArea.setText("");
				if(tip1==null){
					isBankNumAdd = false;
					removeTip(tip1);
					tip1 = null;
				}
				if(tip2==null){
					isMoneyAdd = false;
					removeTip(tip2);
					tip2 = null;
				}
			}
		});

		add(titleLabel);
		add(dateLabel);
		add(dateTextField);
		add(datechooser);
		add(amount);
		add(sumTextField);
		add(payer);
		add(nameTextField);
		add(num);
		add(numTextField);
		add(clause);
		add(jsp1);
		add(remark);
		add(jsp2);
		add(sure);
		add(cancel);
	}

	/**
	 * 确认按钮监听动作
	 */
	protected void performSure() {
		boolean isOk = NumExceptioin.isBankNumValid(numTextField)
				&& NumExceptioin.isDouble(sumTextField);
		if (isOk && isAllEntered.isEntered(costJtf)) {
			PaymentVO vo = new PaymentVO(dateTextField.getText().trim(),
					sumTextField.getText().trim(), nameTextField.getText()
							.trim(), numTextField.getText().trim(),
					reasonTextArea.getText().trim(), otherTextArea.getText()
					.trim(), ListState.UNCHECK);
			FinanceblService bl;
			try {
				bl = new FinanceController();
				bl.payment(vo);
			} catch (RemoteException e) {
				JLabel tip = new JLabel("提示：网络异常");
				tip.setFont(font2);
				JOptionPane.showMessageDialog(null, tip);
				return;
			}
			JLabel tip = new JLabel("提示：保存成功");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} else if ((!isOk) && isAllEntered.isEntered(costJtf)) {
			JLabel tip = new JLabel("提示：请输入正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} else if (isOk && !isAllEntered.isEntered(costJtf)) {
			JLabel tip = new JLabel("提示：仍有信息未输入");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} else if (!isOk && !isAllEntered.isEntered(costJtf)) {
			JLabel tip = new JLabel("请输入所有正确格式的信息");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}
	}

	// 错误提示信息是否已经被添加
	protected boolean isBankNumAdd = false;
	protected boolean isMoneyAdd = false;

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
			if (temp == numTextField) {
				if (!NumExceptioin.isBankNumValid(numTextField)) {
					isBankNumAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("账号位数不符规范", JLabel.CENTER);
						tip1.setBounds(x + 2 * addx1 + addx2,
								y + addy + height, width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				} else {
					if (isBankNumAdd
							&& !"".equalsIgnoreCase(numTextField.getText()
									.trim())) {
						isBankNumAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if (temp == sumTextField) {
				if (!NumExceptioin.isDouble(sumTextField)) {
					isMoneyAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("请输入数据", JLabel.CENTER);
						tip2.setBounds(x + addx1, y + addy + height, width,
								height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}

				} else {
					if (isMoneyAdd
							&& !"".equalsIgnoreCase(sumTextField.getText()
									.trim())) {
						isMoneyAdd = false;
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
