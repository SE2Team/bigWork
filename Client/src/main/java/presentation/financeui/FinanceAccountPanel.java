package presentation.financeui;

import businesslogic.financebl.FinanceController;
import businesslogicservice.FinanceblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import vo.AccountVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 财务人员账户管理界面
 *
 * @author WANXING 完成
 */

public class FinanceAccountPanel extends JPanel {

	private int x = 60, y = 70, width = 70, height = 30, addx = 60, addy = 70;
	private JLabel NableName;
	private JTextField jtfName;
	// 定义添加，删除，修改，查询按钮
	private JButton operation1;
	private JButton operation2;
	private JButton operation3;
	private JButton operation4;
	// 定义用来放表格的scrollPanel
	private JScrollPane jsp;
	// 定义表格
	private JTable accountTable;
	// 定义表格模型对象
	private DefaultTableModel tableModel;
	// 定义所有字体
	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	// 定义表格各列的对象
	Object c0, c1;
	// 被选中的要修改的行号
	int modRowNum;
	// 定义原来的vo
	AccountVO oaccount_vo = null;

	public FinanceAccountPanel() {
		// 初始化各组件
		this.setLayout(null);
		NableName = new JLabel("账户列表");
		NableName.setFont(font1);
		jtfName = new JTextField(16);
		jtfName.setText("请输入账户名称");
		operation1 = new JButton("添加");
		operation2 = new JButton("删除");
		operation3 = new JButton("修改");
		operation4 = new JButton("查找");

		// 界面
		NableName.setFont(font1);
		NableName.setBounds(10, 20, 200, height);
		add(NableName);

		operation1.setFont(font2);
		operation1.setBounds(190, 20, width, height);
		operation1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new addAccountDialog(FinanceAccountPanel.this).setVisible(true);
			}
		});
		add(operation1);

		operation2.setFont(font2);
		operation2.setBounds(270, 20, width, height);
		operation2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int rowNum = accountTable.getSelectedRow();
				if (rowNum != -1) {
					AccountVO vo = new AccountVO(tableModel.getValueAt(rowNum,
							0).toString(), tableModel.getValueAt(rowNum, 0)
							.toString());
					FinanceblService bl;
					try {
						bl = new FinanceController();
						bl.DelAccount(vo);
					} catch (RemoteException e) {
						RunTip.makeTip("网络异常", false);
						return;
					}

					tableModel.removeRow(rowNum);
				}
			}
		});
		add(operation2);

		operation3.setFont(font2);
		operation3.setBounds(350, 20, width, height);
		final modifyAccountDialog modAccount = new modifyAccountDialog(
				FinanceAccountPanel.this);
		operation3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				modRowNum = accountTable.getSelectedRow();
				if (modRowNum != -1) {
					modAccount.setVisible(true);
				}
			}
		});
		add(operation3);

		jtfName.setFont(font2);
		jtfName.setBounds(435, 20, 120, height);
		jtfName.setForeground(Color.GRAY);
		jtfName.addFocusListener(new TextFocus());
		add(jtfName);

		operation4.setFont(font2);
		operation4.setBounds(560, 20, width, height);
		add(operation4);

		//-------------------------------------
		Iterator<AccountVO> iterator = null;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		FinanceblService bl;
		try {
			bl = new FinanceController();
			iterator = bl.searchAccount();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		int n = list.size();
		String row[][] = new String[n][2];
		for (int j = 0; j < n; j++) {
			AccountVO vo = list.get(j);
			String[] temp = new String[2];
			temp[0] = vo.getAccountName();
			temp[1] = vo.getAccountBalance();
			row[j] = temp;
		}
		String[] column = {"账户名称", "余额"};
		accountTable = Table.getTable(column, row);
		tableModel = (DefaultTableModel) accountTable.getModel();

		//------------------------------------

		
		accountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
		accountTable.addMouseListener(new MouseAdapter() {// 鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = accountTable.getSelectedRow(); // 获得选中行索引
				c0 = tableModel.getValueAt(selectedRow, 0);
				c1 = tableModel.getValueAt(selectedRow, 1);
				modAccount.getAccountName().setText(c0.toString());
				modAccount.getAccountBalance().setText(c1.toString());
				oaccount_vo = new AccountVO(c0.toString(), c1
						.toString());
			}
		});
		accountTable.setFont(font2);
		accountTable.setRowHeight(20);
		jsp = new JScrollPane(accountTable);
		jsp.setBounds(0, y, 650, 400);
		add(jsp);
	}

	/**
	 * 获取原来的账户信息的vo
	 * 
	 * @return
	 */
	public AccountVO getVo() {
		return oaccount_vo;
	}

	/**
	 * 添加用户输入的账户信息
	 * 
	 * @param row
	 */
	public void addAfterConfirm(String[] row) {
		tableModel.addRow(row);
	}

	/**
	 * 修改账户信息
	 * 
	 * @param row
	 */
	public void updateAfterConfirm(String[] row) {
		tableModel.setValueAt(row[0], modRowNum, 0);
		tableModel.setValueAt(row[1], modRowNum, 1);
	}

	/**
	 * 焦点监听
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请输入账户名称".equalsIgnoreCase(jtfName.getText())) {
				jtfName.setText("");
				jtfName.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(jtfName.getText().trim())) {
				jtfName.setForeground(Color.GRAY);
				jtfName.setText("请输入账户名称");
			}
		}
	}
}