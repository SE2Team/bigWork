/**
 * 中转中心库存管理人员查看库存界面
 */
package presentation.commodityui;

import presentation.commonui.DateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckStockPanel extends JPanel {

	private int x = 40, y = 180, jl_width = 100, jtf_width = 160, height = 30,
			addx1 = 100, addy = 70, addx2 = 180;

	// 定义起始时间，结束时间的label
	private JLabel startDate, endDate;
	// 定义对应的文本框
	private JTextField jtf_startDate, jtf_endDate;
	// 定义查询按钮
	private JButton search;
	// 定义字体
	private Font font = new Font("宋体", Font.PLAIN, 20);
	// 定义日期选择器
	private DateChooser datechooser1,datechooser2;

	public CheckStockPanel() {

		this.setLayout(null);

		startDate = new JLabel("起始时间", JLabel.CENTER);
		startDate.setFont(font);
		startDate.setBounds(x, y, jl_width, height);

		jtf_startDate = new JTextField();
		jtf_startDate.setFont(font);
		jtf_startDate.setEditable(false);
		jtf_startDate.setBounds(x + addx1, y, jtf_width-30, height);
		
		datechooser1 = new DateChooser("yyyy-MM-dd",jtf_startDate);
		datechooser1.setBounds(x + addx1+ jtf_width-30, y, 30, height);
		jtf_startDate.setText(datechooser1.commit());
		datechooser1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		endDate = new JLabel("结束时间", JLabel.CENTER);
		endDate.setFont(font);
		endDate.setBounds(x + addx1 + addx2, y, jl_width, height);

		jtf_endDate = new JTextField();
		jtf_endDate.setFont(font);
		jtf_endDate.setEditable(false);
		jtf_endDate.setBounds(x + 2 * addx1 + addx2, y, jtf_width-30, height);

		datechooser2 = new DateChooser("yyyy-MM-dd",jtf_endDate);
		datechooser2.setBounds(x + 2 * addx1 + addx2+ jtf_width-30, y, 30, height);
		jtf_endDate.setText(datechooser2.commit());
		datechooser2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		search = new JButton("查询");
		search.setFont(font);
		search.setBounds(x + 2 * addx1 + 30, y + addy, jl_width, height);

		this.add(startDate);
		this.add(jtf_startDate);
		this.add(datechooser1);
		this.add(endDate);
		this.add(jtf_endDate);
		this.add(datechooser2);
		this.add(search);

	}

	public JButton getButton() {
		return search;
	}
}
