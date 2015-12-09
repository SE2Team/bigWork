package presentation.financeui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 财务人员查看操作日志界面
 * 
 * @author WANXING 完成
 */
public class FinanceOperationLogPanel extends JPanel {

	private JScrollPane jsp;
	private JTable operationTable;
	Font font = new Font("宋体", Font.PLAIN, 15);

	public FinanceOperationLogPanel() {
		// 初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		String[] column = { "序号", "操作类型", "操作人员", "操作时间" };
		String[] s1 = { "1", "期初建账", "总经理", "2015-11-2 8:30:30" };
		String row[][] = { s1 };
		operationTable = new JTable(row, column);
		operationTable.setFont(font);
		operationTable.setRowHeight(20);
		jsp = new JScrollPane(operationTable);
		jsp.setBounds(0, 0, 650, 530);
		add(jsp);

	}
}
