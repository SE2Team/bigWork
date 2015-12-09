/**
 * 中转中心库存管理人员出库单界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.exception.NumExceptioin;
import util.TransportType;
import vo.StockOutVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

public class StockOutPanel extends JPanel {

	protected int x = 110, y = 80, width = 200, height = 30, addx = 210, addy = 65;

	// 定义出库单，快递编号，出库日期、目的地、装运形式、中转单编号或汽运编号的label
	protected JLabel StockoutList, deliveryNum, outDate, destination, loadingWay,
			transferNum;
	// 定义对应的文本框
	protected JTextField jtf_deliveryNum, jtf_outDate, jtf_destination, jtf_transferNum;
	// 定义货物状态的下拉框
	protected JComboBox jcb_loadingWay;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义出库单的字体
	protected Font font1 = new Font("楷体", Font.PLAIN, 30);
	// 定义文本框下拉框的字体
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义其他字体
	protected Font font3 = new Font("宋体", Font.PLAIN, 20);
	// 定义错误提示信息的label
	protected JLabel tip1,tip2;

	public StockOutPanel() {

		this.setLayout(null);

		StockoutList = new JLabel("出库单", JLabel.CENTER);
		StockoutList.setFont(font1);
		StockoutList.setBounds(220, 30, width, height);

		deliveryNum = new JLabel("快递编号", JLabel.CENTER);
		deliveryNum.setFont(font3);
		deliveryNum.setBounds(x, y, width, height);

		jtf_deliveryNum = new JTextField();
		jtf_deliveryNum.setFont(font2);
		jtf_deliveryNum.setBounds(x + addx, y, width, height);
		jtf_deliveryNum.addFocusListener(new TextFocus());

		outDate = new JLabel("出库日期", JLabel.CENTER);
		outDate.setFont(font3);
		outDate.setBounds(x, y + addy, width, height);

		jtf_outDate = new JTextField();
		jtf_outDate.setFont(font2);
		jtf_outDate.setBounds(x + addx, y + addy, width, height);

		destination = new JLabel("目的地", JLabel.CENTER);
		destination.setFont(font3);
		destination.setBounds(x, y + 2 * addy, width, height);

		jtf_destination = new JTextField();
		jtf_destination.setFont(font2);
		jtf_destination.setBounds(x + addx, y + 2 * addy, width, height);

		loadingWay = new JLabel("装运形式", JLabel.CENTER);
		loadingWay.setFont(font3);
		loadingWay.setBounds(x, y + 3 * addy, width, height);

		jcb_loadingWay = new JComboBox();
		jcb_loadingWay.setFont(font2);
		jcb_loadingWay.addItem("火车");
		jcb_loadingWay.addItem("飞机");
		jcb_loadingWay.addItem("汽车");
		jcb_loadingWay.setBounds(x + addx, y + 3 * addy, width, height);

		transferNum = new JLabel("中转单编号或汽运编号", JLabel.CENTER);
		transferNum.setFont(font3);
		transferNum.setBounds(x, y + 4 * addy, width, height);

		jtf_transferNum = new JTextField();
		jtf_transferNum.setFont(font2);
		jtf_transferNum.setBounds(x + addx, y + 4 * addy, width, height);
		jtf_transferNum.addFocusListener(new TextFocus());
		
		sure = new JButton("确定");
		sure.setFont(font3);
		sure.setBounds(x + 60, y + 5 * addy + 20, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		cancel = new JButton("取消");
		cancel.setFont(font3);
		cancel.setBounds(x + addx + 60, y + 5 * addy + 20, 80, height);

		this.add(StockoutList);
		this.add(deliveryNum);
		this.add(jtf_deliveryNum);
		this.add(outDate);
		this.add(jtf_outDate);
		this.add(destination);
		this.add(jtf_destination);
		this.add(loadingWay);
		this.add(jcb_loadingWay);
		this.add(transferNum);
		this.add(jtf_transferNum);
		this.add(sure);
		this.add(cancel);
	}

	//错误提示信息是否已经被添加
	protected boolean isDelivAdd = false;
	protected boolean isTransferAdd = false;
	
	/**
	 * 监听焦点
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener{

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if(temp==jtf_deliveryNum){
				if (!NumExceptioin.isOrderValid(jtf_deliveryNum)) {
					isDelivAdd=true;
					if (tip1 == null) {
						tip1 = new JLabel("快递编号位数应为10位", JLabel.CENTER);
						tip1.setBounds(x + addx, y+height, width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				}
				else{
					if (isDelivAdd&&!"".equalsIgnoreCase(jtf_deliveryNum.getText().trim())) {
						removeTip(tip1);
					}
				}
			}
			if(temp==jtf_transferNum){
				if (!NumExceptioin.isTransListValid(jtf_transferNum)) {
					isTransferAdd=true;
					if (tip2 == null) {
						tip2 = new JLabel("中转单编号或汽运编号位数应为10位", JLabel.CENTER);
						tip2.setBounds(x + addx-50, y + 4 * addy+height, width+100, height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}
				}
				else{
					if (isTransferAdd&&!"".equalsIgnoreCase(jtf_deliveryNum.getText().trim())) {
						removeTip(tip2);
					}
				}
			}
		}
		
	}

	protected void performSure(){
        // jcb_loadingWay.getSelectedItem().toString()
        StockOutVO out_vo = new StockOutVO(jtf_deliveryNum.getText(),
                jtf_outDate.getText(), jtf_destination.getText(),
                TransportType.TRAIN, jtf_transferNum.getText(),false);
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
        tip.setFont(font2);
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
