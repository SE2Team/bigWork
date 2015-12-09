/**
 * 中转中心库存管理人员库存盘点界面
 */

package presentation.commodityui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StockInfoPanel extends JPanel{

	//定义库存查看的label
	JLabel stockInfo;
	//定义导出Excel的按钮
	JButton excel;
	//定义表格
	JTable stockTable;
	//定义scrollPanel
	JScrollPane jsp;
	//定义字体
	Font font1 = new Font("宋体",Font.PLAIN,20);
	Font font2 = new Font("宋体",Font.PLAIN,15);
	
	public StockInfoPanel() {

		this.setLayout(null);
		
		stockInfo = new JLabel("当日库存信息表");
		stockInfo.setFont(font1);
		stockInfo.setBounds(20, 10, 200, 30);
		
		String[] column={"批次","批号","快递编号","入库日期","目的地","区号","排号","架号","位号"};
		String[][] row={};
		
		stockTable = new JTable(row,column);
		stockTable.setFont(font1);
		stockTable.setRowHeight(20);
		
		excel = new JButton("导出");
		excel.setFont(font2);
		excel.setBounds(550, 10, 70, 30);;
		
		jsp = new JScrollPane(stockTable);
		jsp.setBounds(0, 50, 650, 530);
		
		this.add(stockInfo);		
		this.add(excel);
		this.add(jsp);
	}

}
