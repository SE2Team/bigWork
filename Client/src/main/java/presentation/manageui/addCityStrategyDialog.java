package presentation.manageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import vo.ConstantVO;

public class addCityStrategyDialog extends JDialog {

	private CityStrategyPanel parent;

	public addCityStrategyDialog(CityStrategyPanel parent) {
		this.parent = parent;
		this.setContentPane(new addCityStrategyPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	class addCityStrategyPanel extends JPanel {
		int x = 20, y = 60, addx = 140, addy = 50, jl_width = 150,
				jtf_width = 180, height = 25;

		// 设置所有文字的字体
		Font font = new Font("宋体", Font.PLAIN, 20);
		// 定义添加常量信息，城市1，城市2，距离，价格的label
		JLabel addConstant, city1, city2, distance, price;
		// 定义对应的文本框
		JTextField jtf_city1, jtf_city2, jtf_distance, jtf_price;
		// 定义确定，取消按钮
		JButton sure, cancel;

		addCityStrategyPanel() {
			this.setLayout(null);

			addConstant = new JLabel("添加常量信息", JLabel.CENTER);
			addConstant.setFont(new Font("楷体", Font.PLAIN, 25));
			addConstant.setBounds(100, 5, jtf_width, height);

			city1 = new JLabel("城市1", JLabel.CENTER);
			city1.setFont(font);
			city1.setBounds(x, y, jl_width, height);

			jtf_city1 = new JTextField();
			jtf_city1.setFont(font);
			jtf_city1.setBounds(x + addx, y, jtf_width, height);

			city2 = new JLabel("城市2", JLabel.CENTER);
			city2.setFont(font);
			city2.setBounds(x, y + addy, jl_width, height);

			jtf_city2 = new JTextField();
			jtf_city2.setFont(font);
			jtf_city2.setBounds(x + addx, y + addy, jtf_width, height);

			distance = new JLabel("距离", JLabel.CENTER);
			distance.setFont(font);
			distance.setBounds(x, y + 2 * addy, jl_width, height);

			jtf_distance = new JTextField();
			jtf_distance.setFont(font);
			jtf_distance.setBounds(x + addx, y + 2 * addy, jtf_width, height);

			price = new JLabel("价格(元/千米)", JLabel.CENTER);
			price.setFont(font);
			price.setBounds(x, y + 3 * addy, jl_width, height);

			jtf_price = new JTextField();
			jtf_price.setFont(font);
			jtf_price.setBounds(x + addx, y + 3 * addy, jtf_width, height);

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 4 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 4 * addy + 10, 80, height);
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			this.add(addConstant);
			this.add(city1);
			this.add(jtf_city1);
			this.add(city2);
			this.add(jtf_city2);
			this.add(distance);
			this.add(jtf_distance);
			this.add(price);
			this.add(jtf_price);
			this.add(sure);
			this.add(cancel);
		}

	}
}
