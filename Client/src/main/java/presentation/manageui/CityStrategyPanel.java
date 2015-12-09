package presentation.manageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author WANXING 完成
 */
// 总经理城市价格界面
public class CityStrategyPanel extends JPanel {
	int width = 70, height = 30;
	private JButton addButton;
	private JScrollPane jsp;
	private JTable cityTable;

	Font font1 = new Font("楷体", Font.PLAIN, 15);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

	public CityStrategyPanel() {
		// 初始化各组件
		this.setLayout(null);
		addButton = new JButton("添加");

		// 界面
		addButton.setFont(font2);
		addButton.setBounds(280, 420, width, height);
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new addCityStrategyDialog(CityStrategyPanel.this)
						.setVisible(true);
			}
		});
		add(addButton);

		String[] column = { "城市1", "城市2", "距离", "价格（元/公里）" };
		String[] s1 = { "北京", "上海", "1064.7", "" };
		String row[][] = { s1 };
		cityTable = new JTable(row, column);
		cityTable.setFont(font1);
		cityTable.setRowHeight(20);
		jsp = new JScrollPane(cityTable);
		jsp.setBounds(0, 0, 650, 400);
		add(jsp);
	}
}
