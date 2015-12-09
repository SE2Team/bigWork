/**
 * 中转中心库存管理人员库存查看时的界面
 */
package presentation.commodityui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CheckingPanel extends JPanel {

	int x = 200, y = 10, width = 200, heigth = 30;

	// 定义库存查看的label
	JLabel checking;
	// 定义表格
	JTable stock;
	// 定义ScrollPane
	JScrollPane jsp;
	// 定义字体
	Font font = new Font("楷体", Font.PLAIN, 30);

	public CheckingPanel() {

		this.setLayout(null);

		checking = new JLabel("库存查看", JLabel.CENTER);
		checking.setFont(font);
		checking.setBounds(x, y, width, heigth);
		
		String[] column={"存储位置","入库数量","出库数量","金额","合计库存"};
		String[][] row={};
		
		stock = new JTable(row,column);
		stock.setFont(font);
		stock.setRowHeight(20);
		
		jsp = new JScrollPane(stock);
		jsp.setBounds(0, 60, 650, 530);
		
		this.add(checking);
		this.add(jsp);
	}

}
