/*
 * 快递员输入收件信息界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.exception.NumExceptioin;
import vo.AddresseeInformationVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

public class AddresseeInfoPanel extends JPanel {

	protected int x = 100, y = 80, width = 200, height = 30, addx = 160, addy = 90,
			jb_width = 80;

	// 定义收件单号，收件人姓名，收件时间的label
	protected JLabel receiveNum, receiver, receiveDate;

	// 定义错误提示的文字
	protected JLabel tip1, tip2, tip3;

	// 定义对应输入框
	protected JTextField jtf_receiveNum, jtf_receiver, jtf_receiveDate;

	// 定义确定，取消按钮
	protected JButton jb1, jb2;

	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);

	public AddresseeInfoPanel() {

		this.setLayout(null);

		receiveNum = new JLabel("收件单号", JLabel.CENTER);
		receiveNum.setFont(font);
		receiveNum.setBounds(x, y, width, height);

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
		jtf_receiveDate.setBounds(x + addx, y + 2 * addy, width, height);

		jb1 = new JButton("确定");
		jb1.setFont(font);
		jb1.setBounds(x + 80, y + 3 * addy, jb_width, height);
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performJb1();
			}

		});

		jb2 = new JButton("取消");
		jb2.setFont(font);
		jb2.setBounds(x + addx + 80, y + 3 * addy, jb_width, height);

		this.add(receiveNum);
		this.add(jtf_receiveNum);
		this.add(receiver);
		this.add(jtf_receiver);
		this.add(receiveDate);
		this.add(jtf_receiveDate);
		this.add(jb1);
		this.add(jb2);
	}

	// 错误提示信息是否已经被添加
	protected boolean isReceiveNumAdd = false;

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
				if (!NumExceptioin.isOrderValid(jtf_receiveNum)) {
					isReceiveNumAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("收件单号位数应为10位");
						tip1.setBounds(x + addx, y + 30, width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				} else {
					if (isReceiveNumAdd
							&& !"".equalsIgnoreCase(jtf_receiveNum.getText()
									.trim())) {
						removeTip(tip1);
					}
				}
			}
		}

	}

	protected void performJb1(){
        AddresseeInformationVO addressInfo_vo = new AddresseeInformationVO(
                jtf_receiveNum.getText(), jtf_receiver.getText(),
                jtf_receiveDate.getText(), false);
        ListblService bl;
        try {
            bl = new ListController();
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font);
        JOptionPane.showMessageDialog(null, tip);
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
