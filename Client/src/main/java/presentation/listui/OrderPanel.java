/*
 * 输入订单界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.exception.NumExceptioin;
import util.DeliveryType;
import util.ExistException;
import vo.OrderVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

public class OrderPanel extends JPanel {

	protected int x = 10, y = 35, jl_width = 80, jtf_width = 100,jtf_width1 = 160, go_width = 60, height = 22, addx = 70,addx1 = 130,addy=45;
	
	// 定义所有label
	protected JLabel senderInfo, sender_name, sender_address, sender_workplace,
			sender_tele, sender_phone, receiverInfo, receiver_name,
			receiver_address, receiver_workplace, receiver_tele,
			receiver_phone, goodsInfo, goods_name, goods_num, goods_weight,
			goods_length, goods_width, goods_height, goods_volume, deliType,
			wrapper, transExpense, wrapperExpense, expense, ordernum,dueDate;

	// 定义所有文本框
	protected JTextField s_name, s_address, s_workplace, s_tele, s_phone, r_name,
			r_address, r_workplace, r_tele, r_phone, g_name, g_num, g_weight,
			g_length, g_width, g_height, g_volume, o_transExpense,
			o_wrapperExpense, o_expense, o_ordernum,o_dueDate;

	// 定义所有下拉框
	protected JComboBox o_type, o_wrapper;

	// 定义确认、取消按钮
	protected JButton button_1, button_2;

	// 定义所有panel
	protected JPanel sender, receiver, goods, other, button;

	// 定义所有字体
	protected Font font1 = new Font("楷体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	protected Font font3 = new Font("宋体", Font.PLAIN, 15);

	// 快递类型
	protected DeliveryType deliveryType;
	
	//定义错误提示的文字
	protected JLabel tip1,tip2,tip3,tip4,tip5;

	public OrderPanel() {
		this.setLayout(null);

		// 处理寄件人信息面板
		sender = new JPanel();
		sender.setLayout(null);
		sender.setBounds(0, 0, 325, 260);

		senderInfo = new JLabel("寄件人信息", JLabel.CENTER);
		senderInfo.setFont(font1);
		senderInfo.setBounds(35, 0, 200, 30);

		sender_name = new JLabel("姓名", JLabel.CENTER);
		sender_name.setBounds(x, y, jl_width, height);
		sender_name.setFont(font2);

		s_name = new JTextField();
		s_name.setFont(font3);
		s_name.setBounds(x + addx, y, jtf_width1, height);

		sender_address = new JLabel("住址", JLabel.CENTER);
		sender_address.setBounds(x, y+addy, jl_width, height);
		sender_address.setFont(font2);

		s_address = new JTextField();
		s_address.setFont(font3);
		s_address.setBounds(x + addx,y+addy, jtf_width1, height);

		sender_workplace = new JLabel("单位", JLabel.CENTER);
		sender_workplace.setBounds(x, y+2*addy, jl_width, height);
		sender_workplace.setFont(font2);

		s_workplace = new JTextField();
		s_workplace.setFont(font3);
		s_workplace.setBounds(x + addx, y+2*addy, jtf_width1, height);

		sender_tele = new JLabel("电话", JLabel.CENTER);
		sender_tele.setBounds(x, y+3*addy, jl_width, height);
		sender_tele.setFont(font2);

		s_tele = new JTextField();
		s_tele.setFont(font3);
		s_tele.setBounds(x + addx, y+3*addy, jtf_width1, height);
		s_tele.addFocusListener(new TextFocus());

		sender_phone = new JLabel("手机", JLabel.CENTER);
		sender_phone.setBounds(x, y+4*addy, jl_width, height);
		sender_phone.setFont(font2);

		s_phone = new JTextField();
		s_phone.setFont(font3);
		s_phone.setBounds(x + addx,y+4*addy, jtf_width1, height);
		s_phone.addFocusListener(new TextFocus());

		sender.add(BorderLayout.NORTH, senderInfo);
		sender.add(BorderLayout.NORTH, sender_name);
		sender.add(s_name);
		sender.add(sender_address);
		sender.add(s_address);
		sender.add(sender_workplace);
		sender.add(s_workplace);
		sender.add(sender_tele);
		sender.add(s_tele);
		sender.add(sender_phone);
		sender.add(s_phone);

		// 处理收件人信息面板
		receiver = new JPanel();
		receiver.setLayout(null);
		receiver.setBounds(325, 0, 325, 260);

		receiverInfo = new JLabel("收件人信息", JLabel.CENTER);
		receiverInfo.setFont(font1);
		receiverInfo.setBounds(35, 0, 200, 30);

		receiver_name = new JLabel("姓名", JLabel.CENTER);
		receiver_name.setBounds(x, y, jl_width, height);
		receiver_name.setFont(font2);

		r_name = new JTextField();
		r_name.setFont(font3);
		r_name.setBounds(x + addx, y, jtf_width1, height);

		receiver_address = new JLabel("住址", JLabel.CENTER);
		receiver_address.setBounds(x,y+addy, jl_width, height);
		receiver_address.setFont(font2);

		r_address = new JTextField();
		r_address.setFont(font3);
		r_address.setBounds(x + addx, y+addy, jtf_width1, height);

		receiver_workplace = new JLabel("单位", JLabel.CENTER);
		receiver_workplace.setBounds(x, y+2*addy, jl_width, height);
		receiver_workplace.setFont(font2);

		r_workplace = new JTextField();
		r_workplace.setFont(font3);
		r_workplace.setBounds(x + addx, y+2*addy, jtf_width1, height);

		receiver_tele = new JLabel("电话", JLabel.CENTER);
		receiver_tele.setBounds(x,y+3*addy, jl_width, height);
		receiver_tele.setFont(font2);

		r_tele = new JTextField();
		r_tele.setFont(font3);
		r_tele.setBounds(x + addx, y+3*addy, jtf_width1, height);
		r_tele.addFocusListener(new TextFocus());

		receiver_phone = new JLabel("手机", JLabel.CENTER);
		receiver_phone.setBounds(x,y+4*addy, jl_width, height);
		receiver_phone.setFont(font2);

		r_phone = new JTextField();
		r_phone.setFont(font3);
		r_phone.setBounds(x + addx, y+4*addy, jtf_width1, height);
		r_phone.addFocusListener(new TextFocus());

		receiver.add(receiverInfo);
		receiver.add(receiver_name);
		receiver.add(r_name);
		receiver.add(receiver_address);
		receiver.add(r_address);
		receiver.add(receiver_workplace);
		receiver.add(r_workplace);
		receiver.add(receiver_tele);
		receiver.add(r_tele);
		receiver.add(receiver_phone);
		receiver.add(r_phone);

		// 处理托运货物信息面板
		goods = new JPanel();
		goods.setLayout(null);
		goods.setBounds(0, 255, 650, 80);

		goodsInfo = new JLabel("托运货物信息", JLabel.CENTER);
		goodsInfo.setFont(font1);
		goodsInfo.setBounds(220, 0, 200, 30);

		goods_name = new JLabel("内件品名", JLabel.CENTER);
		goods_name.setFont(font2);
		goods_name.setBounds(0, y , jl_width, height);

		g_name = new JTextField();
		g_name.setBounds(x + addx, y, 2*go_width, height);
		g_name.setFont(font3);

		goods_num = new JLabel("原件数", JLabel.CENTER);
		goods_num.setFont(font2);
		goods_num.setBounds(x +addx+addx1, y, jl_width, height);

		g_num = new JTextField();
		g_num.setBounds(x+addx+addx1+70 , y, go_width, height);
		g_num.setFont(font3);

		goods_weight = new JLabel("实际重量", JLabel.CENTER);
		goods_weight.setFont(font2);
		goods_weight.setBounds(x+addx+2*addx1+20 , y, jl_width, height);

		g_weight = new JTextField();
		g_weight.setBounds(x+addx+2*addx1+100, y, go_width, height);
		g_weight.setFont(font3);

		goods_volume = new JLabel("体积", JLabel.CENTER);
		goods_volume.setFont(font2);
		goods_volume.setBounds(x+addx+3*addx1+40,y, jl_width, height);

		g_volume = new JTextField();
		g_volume.setBounds(x+addx+3*addx1+100, y, go_width, height);
		g_volume.setFont(font3);

		goods.add(goodsInfo);
		goods.add(goods_name);
		goods.add(g_name);
		goods.add(goods_num);
		goods.add(g_num);
		goods.add(goods_weight);
		goods.add(g_weight);
		goods.add(goods_volume);
		goods.add(g_volume);

		// 处理其他信息面板
		other = new JPanel();
		other.setBounds(0, 335, 650, 120);
		other.setLayout(null);

		deliType = new JLabel("快递类型", JLabel.CENTER);
		deliType.setFont(font2);
		deliType.setBounds(0, 0, jl_width , height);
		
		o_type = new JComboBox();
		o_type.setFont(font3);
		o_type.addItem("经济快递");
		o_type.addItem("标准快递");
		o_type.addItem("特快快递");
		o_type.setBounds(x + addx, 0, jtf_width, height);
		
		transExpense = new JLabel("运费", JLabel.CENTER);
		transExpense.setFont(font2);
		transExpense.setBounds(x + addx + addx1, 0, jl_width, height);
		
		o_transExpense = new JTextField();
		o_transExpense.setFont(font3);
		o_transExpense.setBounds(x+addx+addx1+jl_width, 0, jtf_width, height);

		ordernum = new JLabel("订单条形码号", JLabel.CENTER);
		ordernum.setFont(font2);
		ordernum.setBounds(x + 2*addx + 2*addx1, 0, jl_width+40, height);
		
		o_ordernum = new JTextField();
		o_ordernum.setFont(font3);
		o_ordernum.setBounds(x+2*addx+2*addx1+jl_width+40, 0, jtf_width, height);
		o_ordernum.addFocusListener(new TextFocus());
		
		wrapper = new JLabel("包装", JLabel.CENTER);
		wrapper.setFont(font2);
		wrapper.setBounds(0, addy, jl_width, height);

		o_wrapper = new JComboBox();
		o_wrapper.setFont(font3);
		o_wrapper.addItem("纸箱");
		o_wrapper.addItem("木箱");
		o_wrapper.addItem("快递袋");
		o_wrapper.addItem("其他");
		o_wrapper.setBounds(x+addx,addy, jtf_width, height);
		
		wrapperExpense = new JLabel("包装费",JLabel.CENTER);
		wrapperExpense.setFont(font2);
		wrapperExpense.setBounds(x + addx + addx1, addy, jl_width, height);

		o_wrapperExpense = new JTextField();
		o_wrapperExpense.setFont(font3);
		o_wrapperExpense.setBounds(x+addx+addx1+jl_width, addy, jtf_width, height);
		
		expense = new JLabel("总费用", JLabel.CENTER);
		expense.setFont(font2);
		expense.setBounds(x + 2*addx + 2*addx1,addy, jl_width+40, height);
		
		o_expense = new JTextField();
		o_expense.setFont(font3);
		o_expense.setBounds(x+2*addx+2*addx1+jl_width+40, addy, jtf_width, height);

		dueDate = new JLabel("预计到达时间",JLabel.CENTER);
		dueDate.setFont(font2);
		dueDate.setBounds(x+addx1+30, 2*addy, 2*jl_width, height);
		
		o_dueDate = new JTextField();
		o_dueDate.setFont(font3);
		o_dueDate.setBounds(x+addx1+2*jl_width+20, 2*addy, jtf_width, height);
		
		other.add(deliType);
		other.add(o_type);
		other.add(transExpense);
		other.add(o_transExpense);
		other.add(wrapper);
		other.add(o_wrapper);
		other.add(wrapperExpense);
		other.add(o_wrapperExpense);
		other.add(expense);
		other.add(o_expense);
		other.add(ordernum);
		other.add(o_ordernum);
		other.add(dueDate);
		other.add(o_dueDate);

		// 处理按钮信息面板
		button = new JPanel();
		button.setLayout(null);
		button.setBounds(0, 465, 650, 60);
		button_1 = new JButton("确定");
		button_1.setFont(font2);
		button_1.setBounds(x+addx1+50, 0, 70, 25);
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				perfomButton1();

			}

		});
		button_2 = new JButton("取消");
		button_2.setFont(font2);
		button_2.setBounds(x+2*addx1+addx, 0, 70, 25);
		button.add(button_1);
		button.add(button_2);

		this.add(sender);
		this.add(receiver);
		this.add(goods);
		this.add(other);
		this.add(button);
	}

	//错误提示信息是否已经被添加
	protected boolean isSenderTeleAdd = false;
	protected boolean isSenderPhoneAdd = false;
	protected boolean isReceiverTeleAdd = false;
	protected boolean isReceiverPhoneAdd = false;
	protected boolean isOrdernumAdd = false;
	
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
			JTextField temp = (JTextField) e.getSource();
			if(temp==s_tele){//判断寄件人电话号输入是否符合规范
				if(!NumExceptioin.isTeleValid(s_tele)){
					isSenderTeleAdd = true;
					if(tip1==null){
						tip1 = new JLabel("电话号输入不符规范");
						tip1.setBounds(x + addx, y+3*addy+height, jtf_width1, height);
						tip1.setFont(font3);
						tip1.setForeground(Color.red);
						sender.add(tip1);
						sender.repaint();
					}
				}
				else{
					if(isSenderTeleAdd&&!"".equalsIgnoreCase(s_tele.getText().trim())){
						sender.remove(tip1);
						sender.repaint();
					}
				}
			}
			
			if(temp==s_phone){//判断寄件人手机号输入是否符合规范
				if(!NumExceptioin.isPhoneValid(s_phone)){
					isSenderPhoneAdd = true;
					if(tip2==null){
						tip2 = new JLabel("手机号位数应为11位");
						tip2.setBounds(x + addx, y+4*addy+height, jtf_width1, height);
						tip2.setFont(font3);
						tip2.setForeground(Color.red);
						sender.add(tip2);
						sender.repaint();
					}
				}
				else{
					if(isSenderPhoneAdd&&!"".equalsIgnoreCase(s_phone.getText().trim())){
						sender.remove(tip2);
						sender.repaint();
					}
				}
			}
			
			if(temp==r_tele){//判断收件人电话号输入是否符合规范
				if(!NumExceptioin.isTeleValid(r_tele)){
					isReceiverTeleAdd = true;
					if(tip3==null){
						tip3 = new JLabel("电话号输入不符规范");
						tip3.setBounds(x + addx, y+3*addy+height, jtf_width1, height);
						tip3.setFont(font3);
						tip3.setForeground(Color.red);
						receiver.add(tip3);
						receiver.repaint();
					}
				}
				else{
					if(isReceiverTeleAdd&&!"".equalsIgnoreCase(r_tele.getText().trim())){
						receiver.remove(tip3);
						receiver.repaint();
					}
				}
			}
			
			if(temp==r_phone){//判断收件人手机号输入是否符合规范
				if(!NumExceptioin.isPhoneValid(r_phone)){
					isReceiverPhoneAdd = true;
					if(tip4==null){
						tip4 = new JLabel("手机号位数应为11位");
						tip4.setBounds(x + addx, y+4*addy+height, jtf_width1, height);
						tip4.setFont(font3);
						tip4.setForeground(Color.red);
						receiver.add(tip4);
						receiver.repaint();
					}
				}
				else{
					if(isReceiverPhoneAdd&&!"".equalsIgnoreCase(r_phone.getText().trim())){
						receiver.remove(tip4);
						receiver.repaint();
					}
				}
			}
			if(temp==o_ordernum){//判断订单条形码号输入是否符合规范
				if(!NumExceptioin.isOrderValid(o_ordernum)){
					isOrdernumAdd = true;
					if(tip5==null){
						tip5 = new JLabel("订单条形码号应为10位");
						tip5.setBounds(x+2*addx+2*addx1+jl_width, height, jtf_width1, height);
						tip5.setFont(font3);
						tip5.setForeground(Color.red);
						other.add(tip5);
						other.repaint();
					}
				}
				else{
					if(isOrdernumAdd&&!"".equalsIgnoreCase(o_ordernum.getText().trim())){
						other.remove(tip5);
						other.repaint();
					}
				}
			}
		}

	}
	protected void perfomButton1(){
		if (o_type.getSelectedItem().toString().equals("经济快递")) {
			deliveryType = DeliveryType.ECONOMIC;
		} else if (o_type.getSelectedItem().toString().equals("标准快递")) {
			deliveryType = DeliveryType.STANDARD;
		} else if (o_type.getSelectedItem().toString().equals("特快快递")) {
			deliveryType = DeliveryType.FAST;
		}
		OrderVO order_vo = new OrderVO(s_name.getText(), s_address
				.getText(), s_workplace.getText(), s_tele.getText(),
				s_phone.getText(), r_name.getText(), r_address
				.getText(), r_workplace.getText(), r_tele
				.getText(), r_phone.getText(), g_num.getText(),
				g_weight.getText(), g_volume.getText(), g_name
				.getText(), deliveryType, o_wrapper
				.getSelectedItem().toString(),
				o_transExpense.getText(), o_wrapperExpense.getText(), o_expense
				.getText(), o_dueDate.getText(), o_ordernum.getText(), false);

		ListblService bl;

		try {
			bl = new ListController();
			bl.save(order_vo);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			JLabel tip = new JLabel("提示：网络异常");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		} catch (ExistException e) {
			e.printStackTrace();
		}

		JLabel tip = new JLabel("提示：保存成功");
		tip.setFont(font2);
		JOptionPane.showMessageDialog(null, tip);
	}
	
}
