package presentation.manageui;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import presentation.commonui.isAllEntered;
import presentation.commonui.swing.MyDialog;
import presentation.exception.NumExceptioin;
import util.ExistException;
import vo.ConstantVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

/**
 * 总经理添加城市价格距离界面
 * 
 * @author Administrator
 *
 */

public class addCityStrategyDialog extends MyDialog {

	private CityStrategyPanel parent;

	public addCityStrategyDialog(CityStrategyPanel parent) {
		super();
		this.parent = parent;
		this.setContentPane(new addCityStrategyPanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 20, y = 60, addx = 140, addy = 50, jl_width = 150, jtf_width = 180,
			height = 25;

	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加常量信息，城市1，城市2，距离，价格的label
	JLabel addConstant, city1, city2, distance, price;
	// 定义对应的文本框
	JTextField jtf_city1, jtf_city2, jtf_distance, jtf_price;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	// 定义文本框的数组
	JTextField[] CityJtf;
	// 定义错误提示的label
	JLabel tip1, tip2;

	class addCityStrategyPanel extends JPanel {

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
			jtf_distance.addFocusListener(new TextFocus());

			price = new JLabel("价格(元/千米)", JLabel.CENTER);
			price.setFont(font);
			price.setBounds(x, y + 3 * addy, jl_width, height);

			jtf_price = new JTextField();
			jtf_price.setFont(font);
			jtf_price.setBounds(x + addx, y + 3 * addy, jtf_width, height);
			jtf_price.addFocusListener(new TextFocus());

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 4 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					CityJtf = new JTextField[] { jtf_city1, jtf_city2,
							jtf_distance, jtf_price };
					boolean isOk = NumExceptioin.isDouble(jtf_distance)
							&& NumExceptioin.isDouble(jtf_price);
					if (isOk && isAllEntered.isEntered(CityJtf)) {
						ConstantVO vo = new ConstantVO(jtf_city1.getText(),
								jtf_city2.getText(), jtf_price.getText(),
								jtf_distance.getText());
						ManageblService bl;
						try {
							bl = new ManageController();
							try {
								bl.updateConstant(vo);
							} catch (ExistException e) {
								JLabel tip = new JLabel("提示：信息已存在");
								tip.setFont(font2);
								JOptionPane.showMessageDialog(null, tip);
								return;
							}
						} catch (RemoteException e) {
							JLabel tip = new JLabel("提示：网络异常");
							tip.setFont(font2);
							JOptionPane.showMessageDialog(null, tip);
							return;
						}

						rowContent = new String[] { jtf_city1.getText(),
								jtf_city2.getText(), jtf_distance.getText(),
								jtf_price.getText() };
						parent.addCityInfo(rowContent);
						dispose();
						JLabel tip = new JLabel("提示：添加成功");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if ((!isOk) && isAllEntered.isEntered(CityJtf)) {
						JLabel tip = new JLabel("提示：请输入正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (isOk && !isAllEntered.isEntered(CityJtf)) {
						JLabel tip = new JLabel("提示：仍有信息未输入");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					} else if (!isOk && !isAllEntered.isEntered(CityJtf)) {
						JLabel tip = new JLabel("请输入所有正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}

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

	// 错误提示信息是否已经被添加
	boolean isDistanceAdd = false;
	boolean isPriceAdd = false;

	/**
	 * 监听焦点
	 *
	 * @author Administrator
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_distance) {
				if (!NumExceptioin.isDouble(jtf_distance)) {
					isDistanceAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("请输入数据", JLabel.CENTER);
						tip1.setBounds(x + addx, y + 2 * addy + height,
								jtf_width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}

				} else {
					if (isDistanceAdd
							&& !"".equalsIgnoreCase(jtf_distance.getText()
							.trim())) {
						isDistanceAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
				}
			}
			if (temp == jtf_price) {
				if (!NumExceptioin.isDouble(jtf_price)) {
					isPriceAdd = true;
					if (tip2 == null) {
						tip2 = new JLabel("请输入数据", JLabel.CENTER);
						tip2.setBounds(x + addx, y + 3 * addy + height,
								jtf_width, height);
						tip2.setFont(font2);
						tip2.setForeground(Color.RED);
						addTip(tip2);
					}

				} else {
					if (isPriceAdd
							&& !"".equalsIgnoreCase(jtf_price.getText().trim())) {
						isPriceAdd = false;
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
