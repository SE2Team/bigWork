/*
 * 营业厅业务员接收与派件界面
 */
package presentation.listui;

import javax.swing.*;
import java.awt.*;

public class ReceiveAndDistribute extends JPanel{
	//定义接受与派件按钮
	JButton receive,distribute;
	//定义字体
	Font font = new Font("楷体",Font.PLAIN,25);
	
	int x=200, y=150, addy=100,width=250,height=60;
	
	public ReceiveAndDistribute(){
		this.setLayout(null);
		
		receive = new JButton("输入接收单信息");
		receive.setFont(font);
		receive.setBounds(x, y, width, height);
		
		distribute = new JButton("输入派件单信息");
		distribute.setFont(font);
		distribute.setBounds(x, y+addy, width, height);

		this.add(receive);
		this.add(distribute);
	}
	
	/*
	 * 获取输入接收单按钮
	 */
	public JButton getReceive() {
		return receive;
	}
	
	/*
	 * 获取输入派件单按钮
	 */
	public JButton getDistribute() {
		return distribute;
	}
}
