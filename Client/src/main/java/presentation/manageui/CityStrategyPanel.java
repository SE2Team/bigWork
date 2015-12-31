package presentation.manageui;

import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import vo.ConstantVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

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
	private DefaultTableModel tableModel;

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

		//-----------------------------------------------------------
		Iterator<ConstantVO> ite1 = null;
		ArrayList<ConstantVO> list1 = new ArrayList<ConstantVO>();
		ManageblService bl;
		ConstantVO vo;

		try {
			bl = new ManageController();
			ite1 = bl.checkConstant();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			RunTip.makeTip("网络异常", false);
		}

		if (ite1 != null) {
			while (ite1.hasNext()) {
				list1.add(ite1.next());
			}

		}
		int n = list1.size();
		String row[][] = new String[n][4];
		for (int j = 0; j < n; j++) {
			vo = list1.get(j);
			String[] strings = {vo.getCity1(), vo.getCity2(), vo.getDistance(), vo.getPrice()};
			row[j] = strings;
		}
		String[] column = {"城市1", "城市2", "距离", "价格（元/公里）"};
		cityTable = Table.getTable(column, row);
		tableModel = (DefaultTableModel) cityTable.getModel();


		//-----------------------------------------------------------


		cityTable.setFont(font1);
		cityTable.setRowHeight(20);
		jsp = new JScrollPane(cityTable);
		jsp.setBounds(0, 0, 650, 400);
		add(jsp);
	}

	/**
	 * 添加用户输入的城市信息
	 *
	 * @param row
	 */
	public void addCityInfo(String[] row) {
		tableModel.addRow(row);
	}
}
