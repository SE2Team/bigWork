/**
 * 财务人员添加收款信息界面
 */
package presentation.financeui;

import businesslogic.financebl.FinanceController;
import businesslogicservice.FinanceblService;
import presentation.commonui.DateChooser;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.MyDialog;
import presentation.exception.NumExceptioin;
import vo.GatheringVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class addSettleDialog extends MyDialog {

	private FinanceSettlePanel parent;

	public addSettleDialog(FinanceSettlePanel parent) {
		super();
		this.parent = parent;
		this.setContentPane(new addSettlePanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private int x = 20, y = 50, addx = 120, addy = 50, jl_width = 100,
			jtf_width = 200, height = 25;

	// 设置所有文字的字体
	private Font font = new Font("宋体", Font.PLAIN, 20);
	private Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加收款信息，收款日期，收款单位，收款人，收款金额，收款地点的label
	private JLabel addInfo, gatheringDate, gatheringOrg, payee, amount, place;
	// 定义对应的文本框
	private JTextField jtf_date, jtf_org, jtf_payee, jtf_amount, jtf_place;
	// 定义确定，取消按钮
	private JButton sure, cancel;
	// 定义用来存放用户输入信息的数组
	private String[] rowContent;
	// 定义文本框的数组
	private JTextField[] settleJtf;
	// 定义日期选择器
	private DateChooser datechooser;
	// 定义错误提示信息
	private JLabel tip;

	class addSettlePanel extends JPanel {

		addSettlePanel() {
			this.setLayout(null);

			addInfo = new JLabel("添加收款信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			gatheringDate = new JLabel("收款日期", JLabel.CENTER);
			gatheringDate.setFont(font);
			gatheringDate.setBounds(x, y, jl_width, height);

			jtf_date = new JTextField();
			jtf_date.setFont(font);
			jtf_date.setEditable(false);
			jtf_date.setBounds(x + addx, y, jtf_width - 30, height);

			datechooser = new DateChooser("yyyy-MM-dd", jtf_date);
			datechooser.setBounds(x + addx + jtf_width - 30, y, 30, height);
			jtf_date.setText(datechooser.commit());
			datechooser.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			});

			gatheringOrg = new JLabel("收款单位", JLabel.CENTER);
			gatheringOrg.setFont(font);
			gatheringOrg.setBounds(x, y + addy, jl_width, height);

			jtf_org = new JTextField();
			jtf_org.setFont(font);
			jtf_org.setBounds(x + addx, y + addy, jtf_width, height);

			payee = new JLabel("收款人", JLabel.CENTER);
			payee.setFont(font);
			payee.setBounds(x, y + 2 * addy, jl_width, height);

			jtf_payee = new JTextField();
			jtf_payee.setFont(font);
			jtf_payee.setBounds(x + addx, y + 2 * addy, jtf_width, height);

			amount = new JLabel("收款金额", JLabel.CENTER);
			amount.setFont(font);
			amount.setBounds(x, y + 3 * addy, jl_width, height);

			jtf_amount = new JTextField();
			jtf_amount.setFont(font);
			jtf_amount.setBounds(x + addx, y + 3 * addy, jtf_width, height);
			jtf_amount.addFocusListener(new TextFocus());

			place = new JLabel("收款地点", JLabel.CENTER);
			place.setFont(font);
			place.setBounds(x, y + 4 * addy, jl_width, height);

			jtf_place = new JTextField();
			jtf_place.setFont(font);
			jtf_place.setBounds(x + addx, y + 4 * addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 5 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					settleJtf = new JTextField[] { jtf_org, jtf_payee,
							jtf_amount, jtf_place };
					boolean isOk = NumExceptioin.isDouble(jtf_amount);
					if (isOk && isAllEntered.isEntered(settleJtf)) {
						GatheringVO vo = new GatheringVO(jtf_date.getText()
								.trim(), jtf_org.getText().trim(), jtf_payee
								.getText().trim(), jtf_amount.getText().trim(),
								jtf_place.getText().trim(), false);
						FinanceblService bl;
						try {
							bl = new FinanceController();
							bl.gathering(vo);
						} catch (RemoteException e) {
							JLabel tip = new JLabel("提示：网络异常");
							tip.setFont(font2);
							JOptionPane.showMessageDialog(null, tip);
							return;
						}
						
						rowContent = new String[] { jtf_date.getText(),
								jtf_org.getText(), jtf_payee.getText(),
								jtf_amount.getText(), jtf_place.getText() };
						parent.addAfterConfirm(rowContent);

						dispose();
						JLabel tip = new JLabel("提示：添加成功");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if ((!isOk) && isAllEntered.isEntered(settleJtf)) {
						JLabel tip = new JLabel("提示：请输入正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (isOk && !isAllEntered.isEntered(settleJtf)) {
						JLabel tip = new JLabel("提示：仍有信息未输入");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (!isOk && !isAllEntered.isEntered(settleJtf)) {
						JLabel tip = new JLabel("请输入所有正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}

				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 5 * addy + 10, 80, height);
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});

			this.add(addInfo);
			this.add(gatheringDate);
			this.add(jtf_date);
			this.add(datechooser);
			this.add(gatheringOrg);
			this.add(jtf_org);
			this.add(payee);
			this.add(jtf_payee);
			this.add(amount);
			this.add(jtf_amount);
			this.add(place);
			this.add(jtf_place);
			this.add(sure);
			this.add(cancel);
		}
	}

	// 错误提示信息是否已经被添加
	boolean isMoneyAdd = false;

	/**
	 * 焦点监听
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
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_amount) {
				if (!NumExceptioin.isDouble(jtf_amount)) {
					isMoneyAdd = true;
					if (tip == null) {
						tip = new JLabel("请输入数据", JLabel.CENTER);
						tip.setBounds(x + addx, y + 3 * addy + height,
								jtf_width, height);
						tip.setFont(font2);
						tip.setForeground(Color.RED);
						addTip(tip);
					}
				} else {
					if (isMoneyAdd
							&& !"".equalsIgnoreCase(jtf_amount.getText().trim())) {
						isMoneyAdd = false;
						removeTip(tip);
						tip = null;
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
