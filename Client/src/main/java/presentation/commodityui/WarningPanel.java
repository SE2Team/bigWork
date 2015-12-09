/**
 * 中转中心库存管理人员库存报警界面
 */
package presentation.commodityui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WarningPanel extends JPanel{

	//定义表格
	JTable warning;
	//定义ScrollPane
	JScrollPane jsp;	
	//定义字体
	Font font = new Font("宋体",Font.PLAIN,15);
	
	public WarningPanel() {
		this.setLayout(null);
		
		String[] column={"区号","排号","架号","位号","当前库存数量","警戒库存数量","是否报警"};
//      String[] s1 = { "025000000", "苏A 00000","2008-8-8","3"};
        String row[][] = { };
		warning = new JTable(row,column);
		warning.setFont(font);
		warning.setRowHeight(20);
		
		jsp = new JScrollPane(warning);
		jsp.setBounds(0, 0, 650, 530);
		
		this.add(jsp);
	}

}
